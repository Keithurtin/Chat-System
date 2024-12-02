package component;
import dto.*;
import bus.*;
import presentation.component.PlaceHolder;

import java.awt.*;
import javax.swing.*;

public class friendChatSection extends JPanel {
    private JPanel navigator;
    private static int uid;
    private int uid2;

    private JPanel send_message_panel;

    private JScrollPane chat_scroll;
    private JPanel chat_side;

    public friendChatSection(UsersDTO user, int id) {
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(593, 450));
        setVerifyInputWhenFocusTarget(false);
        uid = id;
        uid2 = user.getuID();

        setupNavigatorLayout(user.getuName(), (user.getStatus()).equals("online"));
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

    private void setupNavigatorLayout(String name, boolean isOn) {
        navigator = new JPanel();
        navigator.setBackground(new java.awt.Color(153, 204, 255));
        navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        JButton report_user_button = new JButton("Report!");
        report_user_button.setBackground(new java.awt.Color(255, 102, 102));
        report_user_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        report_user_button.setForeground(new java.awt.Color(255, 255, 255));
        report_user_button.addActionListener(e -> reportUser());

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

        JMenuItem unfriend_button = new JMenuItem("Unfriend");
        JMenuItem block_button = new JMenuItem("Block");
        JMenuItem add_to_group_button = new JMenuItem("Add Group");

        unfriend_button.addActionListener(e -> unfriend());
        block_button.addActionListener(e -> blockFriend());
        add_to_group_button.addActionListener(e -> addToGroup());

        dropdownMenu.add(unfriend_button);
        dropdownMenu.add(block_button);
        dropdownMenu.add(add_to_group_button);

        more_button.addActionListener(e -> dropdownMenu.show(more_button, 0, more_button.getHeight()));

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

    private void setupSendMessageLayout() {
        send_message_panel = new JPanel();
        send_message_panel.setBackground(new java.awt.Color(204, 204, 204));

        PlaceHolder input_message = new PlaceHolder("Text....");

        JButton send_button = new JButton("Send");
        send_button.setBackground(new java.awt.Color(153, 204, 255));
        send_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        send_button.setForeground(new java.awt.Color(255, 255, 255));

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

        messagePanel.add(messageBox);

        chat_side.add(messagePanel);
        chat_side.add(Box.createVerticalStrut(10));

        chat_side.revalidate();
        chat_side.repaint();

        SwingUtilities.invokeLater(() -> {
            JScrollBar verticalBar = chat_scroll.getVerticalScrollBar();
            verticalBar.setValue(verticalBar.getMaximum());
        });
    }

    private void reportUser() {}                                                        

    private void unfriend() {}                                                 

    private void addToGroup() {}                                                             

    private void blockFriend() {}   
}