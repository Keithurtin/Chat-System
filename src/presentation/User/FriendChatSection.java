package presentation.User;
import dao.BlockDAO;
import dao.FriendListDAO;
import dto.*;
import bus.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

public class FriendChatSection extends JPanel {
    //id
    private static int uid;
    private final int uid2;
    // component
    private JPanel navigator;
    private int block;
    private final BlockBUS blockBUS;
    private JPanel send_message_panel;
    private PlaceHolder input_message;
    private JButton send_button;
    private JScrollPane chat_scroll;
    private JPanel chat_side;
    private DeletionListener listener;
    // data
    private final ChatDMBUS chatDMBUS;
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
            out.println(uid + "to" + uid2);
            new Thread(new FriendChatSection.MessageReader(in)).start();
        } catch (IOException e) {
            System.out.println("Unable to connect to the server: " + e.getMessage());
        }
    }

    private void sendMessage(String message) {
        if (out != null) {
            String formattedMessage = String.format("/private %s %s", uid2 + "to" + uid, message);
            out.println(formattedMessage);
            chatDMBUS.addChat(uid, uid2, message);
            addMessage(new ChatDMDTO(0, uid, uid2, message, LocalDateTime.now()));
            input_message.setText("");
        } else {
            System.out.println("Unable to send message. Not connected to server.");
        }
    }

    private void showServerMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            addMessage(new ChatDMDTO(0, uid2, uid, message));
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
    // friend chat
    public FriendChatSection(int id, UsersDTO user) {
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(593, 450));
        setVerifyInputWhenFocusTarget(false);
        uid = id;
        uid2 = user.getuID();
        blockBUS = new BlockBUS();
        BlockDAO dao = new BlockDAO();
        block = dao.getRelationship(uid, uid2);
        chatDMBUS = new ChatDMBUS();

        setupSendMessageLayout();
        setupNavigatorLayout(user.getuName(), (user.getStatus()).equals("online"));
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

    public void setDeletionListener(DeletionListener listener) {
        this.listener = listener;
    }

    private void setupNavigatorLayout(String name, boolean isOn) {
        navigator = new JPanel();
        navigator.setBackground(new java.awt.Color(153, 204, 255));
        navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        JButton report_user_button = new JButton("Report!");
        report_user_button.setBackground(new java.awt.Color(255, 102, 102));
        report_user_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        report_user_button.setForeground(new java.awt.Color(255, 255, 255));
        report_user_button.addActionListener(_ -> {
            SpamBUS spamBUS = new SpamBUS();
            spamBUS.addSpamReport(uid2);
        });

        JLabel name_label = new JLabel(name);
        name_label.setFont(new java.awt.Font("Segoe UI", 1, 20));
        name_label.setForeground(new java.awt.Color(255, 255, 255));

        JLabel status_label = new JLabel("<html> Status: " + (isOn ? "<span style='color: green; font-weight: bold;'>Online" : "<span style='color: red; font-weight: bold;'>Offline") + "</span></html>");
        status_label.setFont(new java.awt.Font("Segoe UI", 1, 14));
        status_label.setForeground(new java.awt.Color(255, 255, 255));

        JButton more_button = new JButton("...");
        more_button.setBackground(new java.awt.Color(153, 204, 255));
        more_button.setFont(new java.awt.Font("Segoe UI", 1, 18));
        more_button.setForeground(new java.awt.Color(255, 255, 255));
        more_button.setBorder(null);
        
        JPopupMenu dropdownMenu = new JPopupMenu();

        JMenuItem unfriend_button = new JMenuItem();
        JMenuItem block_button = new JMenuItem(block == 1 ? "Unblock" : "Block");
        JMenuItem add_to_group_button = new JMenuItem("Add Group");
        JMenuItem del_button = new JMenuItem("Delete Chat");
        del_button.addActionListener(_ -> {
            chatDMBUS.deleteAllChat(uid, uid2);
            chat_side.removeAll();
            chat_side.validate();
            chat_side.repaint();
        });

        if(block == 0 && FriendListDAO.getRelationship(uid, uid2) == 2) {
            unfriend_button.setText("Unfriend");
            dropdownMenu.add(unfriend_button);

            unfriend_button.addActionListener(_ -> {
                dropdownMenu.remove(unfriend_button);
                FriendListBUS friendListBUS = new FriendListBUS();
                delete();
                if(friendListBUS.rejectFriend(uid, uid2)){
                    System.out.println("User " + uid + " Unfriend user " + uid2);
                }
            });
        }

        block_button.addActionListener(_ -> {
            if (block_button.getText().equals("Block")) {
                dropdownMenu.remove(unfriend_button);
                blockBUS.blockFriend(uid, uid2);
                input_message.setEnabled(false);
                send_button.setEnabled(false);
                input_message.setText("You can't send message due to block!");
                block = 1;
                block_button.setText("Unblock");
                delete();
            } else{
                block_button.setText("Block");
                input_message.setEnabled(true);
                send_button.setEnabled(true);
                input_message.setText("Text...");
                block = 0;
                blockBUS.unblockFriend(uid, uid2);
            }
        });
        add_to_group_button.addActionListener(_ -> addToGroup());

        dropdownMenu.add(block_button);
        dropdownMenu.add(add_to_group_button);
        dropdownMenu.add(del_button);

        more_button.addActionListener(_ -> dropdownMenu.show(more_button, 0, more_button.getHeight()));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(name_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status_label, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(more_button)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(report_user_button)
                .addContainerGap())
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label)
                    .addComponent(more_button)
                    .addComponent(report_user_button))
                .addGap(2, 2, 2)
                .addComponent(status_label)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }
    
    private void loadChatSide() {
        chat_side = new JPanel();
        chat_side.setLayout(new BoxLayout(chat_side, BoxLayout.Y_AXIS));
        chat_side.setBackground(Color.WHITE);

        chat_scroll = new JScrollPane(chat_side);
        chat_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        chat_scroll.setBorder(null);

        List<ChatDMDTO> chat = chatDMBUS.getAll(uid, uid2);

        for(ChatDMDTO msg : chat) {
            addMessage(msg);
        }
    }

    private void setupSendMessageLayout() {
        send_message_panel = new JPanel();
        send_message_panel.setBackground(new java.awt.Color(204, 204, 204));

        input_message = new PlaceHolder("Text....");

        send_button = new JButton("Send");
        send_button.addActionListener(_ -> sendMessage(input_message.getText()));
        send_button.setBackground(new java.awt.Color(153, 204, 255));
        send_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        send_button.setForeground(new java.awt.Color(255, 255, 255));

        if(block == 1) {
            input_message.setEnabled(false);
            send_button.setEnabled(false);
            input_message.setText("You can't send message due to block!");
        }

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
    }
    
    private void addMessage(ChatDMDTO msg) {
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout(msg.getSenderID() == uid ? FlowLayout.RIGHT : FlowLayout.LEFT));
        messagePanel.setOpaque(false);


        JLabel messageLabel = new JLabel(msg.getMessage());
        messageLabel.setBackground(msg.getSenderID() == uid ? new Color(200, 255, 200) : new Color(200, 200, 255));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Padding inside the box

        messageLabel.setToolTipText(msg.getTime());

        messageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem del = new JMenuItem("Delete Message");
                    del.addActionListener(_ -> {
                        chatDMBUS.deleteChat(msg.getID());
                        chat_side.remove(messagePanel);
                        chat_side.revalidate();
                        chat_side.repaint();
                    });
                    menu.add(del);
                    menu.show(messageLabel, e.getX(), e.getY());
                }
            }
        });
        messageLabel.setOpaque(true);

        messagePanel.add(messageLabel);

        chat_side.add(messagePanel);
        chat_side.add(Box.createVerticalStrut(1));

        chat_side.revalidate();
        chat_side.repaint();

        SwingUtilities.invokeLater(() -> {
            JScrollBar verticalBar = chat_scroll.getVerticalScrollBar();
            verticalBar.setValue(verticalBar.getMaximum());
        });
    }

    private void addToGroup() {
        JFrame newWindow = new createOrAddGroupToWindow(uid, uid2);
        newWindow.setVisible(true);
    }

    public void delete() {
        closeConnection();

        if (listener != null) {
            listener.onDeleted(); // Notify listener
        }
    }
}