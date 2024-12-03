package component;

import presentation.component.PlaceHolder;
import dto.*;
import bus.*;
import java.awt.*;
import javax.swing.*;

public class groupChatSection extends JPanel {
    private JPanel navigator;
    private final int gid;
    private JPanel send_message_panel;
    private static int uid;
    private static boolean isAdmin;
    private JScrollPane chat_scroll;
    private JPanel chat_side;

    public groupChatSection(GroupChatDTO group, int id) {
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(593, 450));
        setVerifyInputWhenFocusTarget(false);
        gid = group.getGID();
        uid = id;

        setupNavigatorLayout(group.getName(), group.getNumMember());
        setupSendMessageLayout();
        createChatSide();

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
    }

    private void setupNavigatorLayout(String name, int member) {
        navigator = new JPanel();
        navigator.setBackground(new java.awt.Color(153, 204, 255));
        navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        JButton report_button = new JButton("Out Group!");
        report_button.setBackground(new java.awt.Color(255, 102, 102));
        report_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        report_button.setForeground(new java.awt.Color(255, 255, 255));
        report_button.addActionListener(e -> reportGroup());

        JLabel name_label = new JLabel( name);
        name_label.setFont(new java.awt.Font("Segoe UI", 1, 18));
        name_label.setForeground(Color.WHITE);

        JButton manage_button = new JButton("Manage");
        manage_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        manage_button.addActionListener(e -> manageGroup());

        JButton change_name_button = new JButton("Change");
        change_name_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        change_name_button.addActionListener(e -> changeGroupName());

        JLabel number_member_label = new JLabel("<html> Member: <span style='color: black'>" + member +"</span></html>");
        number_member_label.setFont(new java.awt.Font("Segoe UI", 1, 16));
        number_member_label.setForeground(Color.WHITE);

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(number_member_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name_label, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(change_name_button)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manage_button)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(report_button)
                .addContainerGap())
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(manage_button)
                        .addComponent(report_button))
                    .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(name_label)
                        .addComponent(change_name_button)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(number_member_label)
                .addGap(32, 32, 32))
        );
    }

    private void setupSendMessageLayout() {
        send_message_panel = new JPanel();
        send_message_panel.setBackground(new java.awt.Color(204, 204, 204));

        PlaceHolder input_message = new PlaceHolder("Text....");
        input_message.addActionListener(e -> inputMessage());

        JButton send_button = new JButton("Send");
        send_button.setBackground(new java.awt.Color(153, 204, 255));
        send_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        send_button.setForeground(new java.awt.Color(255, 255, 255));
        send_button.addActionListener(e -> sendMessage());

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
    
    private void createChatSide() {
        chat_side = new JPanel();
        chat_side.setLayout(new BoxLayout(chat_side, BoxLayout.Y_AXIS));
        chat_side.setBackground(Color.WHITE);

        chat_scroll = new JScrollPane(chat_side);
        chat_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        chat_scroll.setBorder(null);
        
        addMessage("Hello there", false);
        addMessage("How are you doing?", false);
        addMessage("I'm doing great, thanks!", true);
        addMessage("That's wonderful to hear!", false);
        addMessage("How about you", true);
        addMessage("Not so great", false);
    }

    private void addMessage(String message, boolean isYou) {
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout(isYou ? FlowLayout.RIGHT : FlowLayout.LEFT));
        messagePanel.setOpaque(false);

        JPanel messageBox = new JPanel();
        messageBox.setLayout(new BorderLayout());
        messageBox.setBackground(isYou ? new Color(200, 255, 200) : new Color(200, 200, 255));
        messageBox.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Padding inside the box

        JLabel messageLabel = new JLabel(message);
        messageBox.add(messageLabel, BorderLayout.CENTER);

        // Add the message box to the message panel
        messagePanel.add(messageBox);

        // Add gap between messages
        chat_side.add(messagePanel);
        chat_side.add(Box.createVerticalStrut(10)); // Adds vertical spacing

        chat_side.revalidate();
        chat_side.repaint();

        // Scroll to the bottom
        SwingUtilities.invokeLater(() -> {
            JScrollBar verticalBar = chat_scroll.getVerticalScrollBar();
            verticalBar.setValue(verticalBar.getMaximum());
        });
    }

    private void reportGroup() {}                                                        

    private void manageGroup() {
        System.out.println(gid);
        java.awt.EventQueue.invokeLater(() -> new component.groupManageWindow(gid, uid).setVisible(true));
    }                                                 

    private void changeGroupName() {}                                                             

    private void inputMessage() {}                                                        

    private void sendMessage() {}

}