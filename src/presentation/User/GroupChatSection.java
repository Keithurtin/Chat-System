package presentation.User;

import bus.ChatGroupBUS;
import bus.GroupChatBUS;
import bus.GroupMembersBUS;
import bus.UsersBUS;
import dto.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GroupChatSection extends JPanel {
    //id
    private final int gid;
    private static int uid;
    private boolean isIsAdmin;
    //component
    private static boolean isAdmin;
    private JScrollPane chat_scroll;
    private JPanel chat_side;
    private DeletionListener listener;
    private PlaceHolder input_message;
    private final List<JLabel> searchResults = new ArrayList<>();
    private int currentSearchIndex = -1;
    // data
    private final ChatGroupBUS chatGroupBUS;
    private final GroupMembersBUS groupMembersBUS;
    private List<GroupMembersDTO> memberList;
    private final UsersBUS usersBUS;
    //socket component
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 12345;
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    //socket
    private void connectToServer() {
        try {
            socket = new Socket(SERVER_ADDRESS, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(uid + "group" + gid);
            new Thread(new GroupChatSection.MessageReader(in)).start();
        } catch (IOException e) {
            System.out.println("Unable to connect to the server: " + e.getMessage());
        }
    }

    private void sendMessage(String message) {
        if (out != null) {
            executorService.submit(() -> {
                for (GroupMembersDTO member : memberList) {
                    if (member.getUID() != uid) {
                        String formattedMessage = String.format("/private %s %s",
                                member.getUID() + "group" + gid, uid + "/" + message);
                        out.println(formattedMessage);
                    }
                }
            });
            SwingUtilities.invokeLater(() -> {
                input_message.setText("");
                chatGroupBUS.addChat(uid, gid, message);
                addMessage(new ChatGroupDTO(uid, gid, message));
            });
        } else {
            System.out.println("Unable to send message. Not connected to server.");
        }
    }

    private void showServerMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            String[] parts = message.split("/", 2);
            int sender_id = Integer.parseInt(parts[0].trim());
            addMessage(new ChatGroupDTO(sender_id, gid, parts[1]));
        });
    }

    private class MessageReader implements Runnable {
        private final BufferedReader in;

        public MessageReader(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    String finalMessage = message;
                    SwingUtilities.invokeLater(() -> showServerMessage(finalMessage));
                }
            } catch (IOException e) {
                System.out.println("Server connection lost.");
            }
        }
    }

    private void closeConnection() {
        try {
            if (out != null) {
                out.println("exit"); // Optionally, notify the server that the client is disconnecting
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (socket != null) {
                socket.close();
            }
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            System.out.println("Error while disconnecting: " + e.getMessage());
        }
    }
    //group chat
    public GroupChatSection(int id, GroupChatDTO group) {
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(593, 450));
        setVerifyInputWhenFocusTarget(false);
        gid = group.getGID();
        uid = id;
        chatGroupBUS = new ChatGroupBUS();
        groupMembersBUS = new GroupMembersBUS();
        usersBUS = new UsersBUS();
        memberList = groupMembersBUS.getAll(gid);

        JPanel navigator = setupNavigatorLayout(group.getName(), group.getNumMember());
        JPanel send_message_panel = setupSendMessageLayout();
        loadChatSide();

        GroupLayout chat_panelLayout = new GroupLayout(this);
        this.setLayout(chat_panelLayout);
        chat_panelLayout.setHorizontalGroup(
            chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(navigator, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addComponent(send_message_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chat_scroll)
        );
        chat_panelLayout.setVerticalGroup(
            chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(chat_panelLayout.createSequentialGroup()
                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chat_scroll, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send_message_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        new Thread(this::connectToServer).start();
    }

    private JPanel setupNavigatorLayout(String name, int member) {
        JPanel navigator = new JPanel();
        navigator.setBackground(new java.awt.Color(153, 204, 255));
        navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        CardLayout cardLayout = new CardLayout();
        JPanel name_panel = new JPanel(cardLayout);
        name_panel.setBackground(new java.awt.Color(153, 204, 255));

        PlaceHolder search_msg = new PlaceHolder("...");
        JButton search_msg_btn = new JButton("Search");

        search_msg_btn.addActionListener(_ -> findMessages(search_msg.getText().trim()));

        JButton prev_btn = new JButton("<");
        JButton next_btn = new JButton(">");

        next_btn.addActionListener(_ -> {
            if (!searchResults.isEmpty()) {
                int nextIndex = (currentSearchIndex + 1) % searchResults.size();
                navigateToMessage(nextIndex);
            }
        });

        prev_btn.addActionListener(_ -> {
            if (!searchResults.isEmpty()) {
                int prevIndex = (currentSearchIndex - 1 + searchResults.size()) % searchResults.size();
                navigateToMessage(prevIndex);
            }
        });

        JButton out_group_btn = new JButton("Out Group");
        out_group_btn.setBackground(new java.awt.Color(255, 102, 102));
        out_group_btn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        out_group_btn.setForeground(new java.awt.Color(255, 255, 255));
        out_group_btn.addActionListener(e -> {
            GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
            groupMembersBUS.deleteMember(gid, uid);
            Container parent = GroupChatSection.this.getParent();
            if (parent != null) {
                parent.remove(GroupChatSection.this);
                parent.revalidate();
                parent.repaint();
            }
            delete();
        });

        JLabel name_label = new JLabel( name);
        name_label.setFont(new java.awt.Font("Segoe UI", 1, 18));
        name_label.setForeground(Color.WHITE);

        JTextField name_input = new JTextField(name);
        name_input.setFont(new java.awt.Font("Segoe UI", 0, 16));

        name_panel.add(name_label, "label");
        name_panel.add(name_input, "input");

        cardLayout.show(name_panel, "Label");

        JButton manage_button = new JButton("Manage");
        manage_button.setFont(new java.awt.Font("Segoe UI", 1, 12));
        manage_button.addActionListener(e -> manageGroup());

        JButton change_name_button = new JButton("Change");
        change_name_button.setFont(new java.awt.Font("Segoe UI", 1, 12));
        change_name_button.addActionListener(e -> {
            if(change_name_button.getText().equals("Change")){
                change_name_button.setText("Save");
                cardLayout.show(name_panel, "input");
            } else {
                GroupChatBUS groupChatBUS = new GroupChatBUS();
                GroupChatDTO groupChatDTO = groupChatBUS.getById(gid);
                String new_name = name_input.getText();
                if(!(groupChatDTO.getName().equals(new_name))){
                    groupChatDTO.setName(new_name);
                    groupChatBUS.updateName(groupChatDTO);
                    name_label.setText(new_name);
                }
                change_name_button.setText("Change");
                cardLayout.show(name_panel, "label");
            }
        });

        JLabel number_member_label = new JLabel("<html> Member: <span style='color: black'>" + member +"</span></html>");
        number_member_label.setFont(new java.awt.Font("Segoe UI", 1, 16));
        number_member_label.setForeground(Color.WHITE);

        GroupLayout otherLayout = new GroupLayout(navigator);
        navigator.setLayout(otherLayout);
        otherLayout.setHorizontalGroup(
            otherLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(otherLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                    .addGroup(otherLayout.createParallelGroup()
                            .addGroup(otherLayout.createSequentialGroup()
                                    .addComponent(name_panel, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(change_name_button)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(number_member_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(manage_button)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(out_group_btn))
                            .addGroup(otherLayout.createSequentialGroup()
                                    .addComponent(search_msg, 180, 180, 180)
                                    .addComponent(search_msg_btn, 76,76,76)
                                    .addGap(10,10,10)
                                    .addComponent(prev_btn, 50, 50, 50)
                                    .addComponent(next_btn, 50, 50,50)))
                .addContainerGap())
        );
        otherLayout.setVerticalGroup(
            otherLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, otherLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(otherLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, otherLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(name_panel)
                        .addComponent(change_name_button)
                        .addComponent(number_member_label)
                        .addComponent(manage_button)
                        .addComponent(out_group_btn)))
                .addGap(6,6,6)
                .addGroup(otherLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(search_msg)
                        .addComponent(search_msg_btn)
                        .addComponent(prev_btn)
                        .addComponent(next_btn))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGap(32, 32, 32))
        );
        return navigator;
    }

    private void loadChatSide() {
        chat_side = new JPanel();
        chat_side.setLayout(new BoxLayout(chat_side, BoxLayout.Y_AXIS));
        chat_side.setBackground(Color.WHITE);

        chat_scroll = new JScrollPane(chat_side);
        chat_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        chat_scroll.setBorder(null);

        List<ChatGroupDTO> chatGroupDTO = chatGroupBUS.getAll(gid);

        for(ChatGroupDTO chat : chatGroupDTO) {
            addMessage(chat);
        }
    }

    private JPanel setupSendMessageLayout() {
        JPanel send_message_panel = new JPanel();
        send_message_panel.setBackground(new java.awt.Color(204, 204, 204));

        input_message = new PlaceHolder("Text....");

        JButton send_button = new JButton("Send");
        send_button.setBackground(new java.awt.Color(153, 204, 255));
        send_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        send_button.setForeground(new java.awt.Color(255, 255, 255));
        send_button.addActionListener(e -> sendMessage(input_message.getText()));

        GroupLayout send_message_panelLayout = new GroupLayout(send_message_panel);
        send_message_panel.setLayout(send_message_panelLayout);
        send_message_panelLayout.setHorizontalGroup(
            send_message_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(send_message_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(input_message, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send_button, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        send_message_panelLayout.setVerticalGroup(
            send_message_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(send_message_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(send_message_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(input_message, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_button, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        return send_message_panel;
    }

    private void addMessage(ChatGroupDTO msg) {
        boolean isMe = msg.getSenderID() == uid;
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout(isMe ? FlowLayout.RIGHT : FlowLayout.LEFT));
        messagePanel.setOpaque(false);


        JLabel messageLabel = new JLabel(msg.getMessage());
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        messageLabel.setBackground(isMe ? new Color(200, 255, 200) : new Color(200, 200, 255));
        messageLabel.setToolTipText(msg.getTime());

        if(isMe) {
            messagePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            messagePanel.add(messageLabel);
        } else{  //add name for sender
            UsersDTO user = usersBUS.getById(msg.getSenderID());
            JLabel name = new JLabel(user.getuName());
            name.setBackground(Color.white);
            name.setFont(new java.awt.Font("Segoe UI", 1, 14));
            GroupLayout otherLayout = new GroupLayout(messagePanel);
            messagePanel.setLayout(otherLayout);
            otherLayout.setHorizontalGroup(
                    otherLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(name)
                            .addGroup(otherLayout.createSequentialGroup()
                                    .addComponent(messageLabel)
                                    .addContainerGap(112, Short.MAX_VALUE))
            );
            otherLayout.setVerticalGroup(
                    otherLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(otherLayout.createSequentialGroup()
                                    .addComponent(name)
                                    .addComponent(messageLabel)
                                    .addContainerGap(8, Short.MAX_VALUE))
            );
        }
        messageLabel.setOpaque(true);

        messageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem del = new JMenuItem("Delete Message");
                    del.addActionListener(_ -> {
                        chatGroupBUS.deleteChat(msg.getGroupID());
                        chat_side.remove(messagePanel);
                        chat_side.revalidate();
                        chat_side.repaint();
                    });
                    menu.add(del);
                    menu.show(messageLabel, e.getX(), e.getY());
                }
            }
        });

        chat_side.add(messagePanel);
        chat_side.add(Box.createVerticalStrut(1));

        chat_side.revalidate();
        chat_side.repaint();

        // Scroll to the bottom
        SwingUtilities.invokeLater(() -> {
            JScrollBar verticalBar = chat_scroll.getVerticalScrollBar();
            verticalBar.setValue(verticalBar.getMaximum());
        });
    }
    
    private void findMessages(String messageText) {
        searchResults.clear();
        currentSearchIndex = -1;
        if(messageText.isBlank()){
            return;
        }
        for (Component component : chat_side.getComponents()) {
            if (component instanceof JPanel panel) {
                for (Component innerComponent : panel.getComponents()) {
                    if (innerComponent instanceof JLabel label) {
                        if (label.getText().contains(messageText)) {
                            searchResults.add(label);
                        }
                    }
                }
            }
        }

        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages found!", "Search", JOptionPane.INFORMATION_MESSAGE);
        } else {
            navigateToMessage(0);
        }
    }

    private void navigateToMessage(int index) {
        if (index < 0 || index >= searchResults.size()) {
            return;
        }
        currentSearchIndex = index;
        JLabel currentLabel = searchResults.get(currentSearchIndex);
        Color panelColor = currentLabel.getBackground();
        currentLabel.setBackground(new Color(255, 255, 150)); // Yellow highlight
        currentLabel.setOpaque(true);
        currentLabel.repaint();
        JPanel parent = (JPanel) currentLabel.getParent();
        SwingUtilities.invokeLater(() -> parent.scrollRectToVisible(parent.getBounds()));
        Timer timer = new Timer(1000, _ -> {
            currentLabel.setBackground(panelColor);
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void manageGroup() {
        java.awt.EventQueue.invokeLater(() -> new GroupManageWindow(gid, uid).setVisible(true));
    }

    public void setDeletionListener(DeletionListener listener) {
        this.listener = listener;
    }

    public void delete() {
        closeConnection();
        if (listener != null) {
            listener.onDeleted(); // Notify listener
        }
    }
}