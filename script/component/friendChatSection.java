import javax.swing.*;

public class friendChatSection extends JPanel {

    private final JPanel main_panel;
    
    private final JPanel navigator;
    private final JButton more_button;
    private final JButton report_user_button;
    private final JLabel name_label;
    private final JLabel status_label;

    private final JPanel send_message_panel;
    private final JTextField message_input;
    private final JButton send_button;

    private final JScrollBar scroll_bar;

    public friendChatSection(String name, String status) {
        main_panel = new javax.swing.JPanel();
        navigator = new javax.swing.JPanel();
        report_user_button = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();
        status_label = new javax.swing.JLabel();
        more_button = new javax.swing.JButton();
        send_message_panel = new javax.swing.JPanel();
        message_input = new javax.swing.JTextField();
        send_button = new javax.swing.JButton();
        scroll_bar = new javax.swing.JScrollBar();
        
        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setVerifyInputWhenFocusTarget(false);

        navigator.setBackground(new java.awt.Color(153, 204, 255));
        navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        report_user_button.setBackground(new java.awt.Color(255, 102, 102));
        report_user_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        report_user_button.setForeground(new java.awt.Color(255, 255, 255));
        report_user_button.setText("Report!");
        report_user_button.addActionListener(this::reportUser);

        name_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name_label.setText(name);

        status_label.setBackground(new java.awt.Color(153, 204, 255));
        status_label.setText("Status: " + status);

        more_button.setBackground(new java.awt.Color(153, 204, 255));
        more_button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        more_button.setForeground(new java.awt.Color(255, 255, 255));
        more_button.setText("...");
        more_button.setBorder(null);
        
        JPopupMenu dropdownMenu = new JPopupMenu();

        JMenuItem unfriend_button = new JMenuItem("Unfriend");
        JMenuItem block_button = new JMenuItem("Block");
        JMenuItem add_to_group_button = new JMenuItem("Add Group");

        unfriend_button.addActionListener(this::unfriend);
        block_button.addActionListener(this::blockFriend);
        add_to_group_button.addActionListener(this::addToGroup);

        dropdownMenu.add(unfriend_button);
        dropdownMenu.add(block_button);
        dropdownMenu.add(add_to_group_button);

        more_button.addActionListener(e -> dropdownMenu.show(more_button, 0, more_button.getHeight()));

        javax.swing.GroupLayout navigatorLayout = new javax.swing.GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status_label, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(more_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(report_user_button)
                .addContainerGap())
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label)
                    .addComponent(more_button)
                    .addComponent(report_user_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status_label)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        send_message_panel.setBackground(new java.awt.Color(204, 204, 204));

        message_input.setText("Text....");
        message_input.addActionListener(this::inputMessage);

        send_button.setBackground(new java.awt.Color(153, 204, 255));
        send_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        send_button.setForeground(new java.awt.Color(255, 255, 255));
        send_button.setText("Send");
        send_button.addActionListener(this::sendMessage);

        javax.swing.GroupLayout send_message_panelLayout = new javax.swing.GroupLayout(send_message_panel);
        send_message_panel.setLayout(send_message_panelLayout);
        send_message_panelLayout.setHorizontalGroup(
            send_message_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(send_message_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(message_input, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        send_message_panelLayout.setVerticalGroup(
            send_message_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(send_message_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(send_message_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(message_input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigator, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
            .addComponent(send_message_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addComponent(navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send_message_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    private void sendMessage(java.awt.event.ActionEvent evt) {}                                                       

    private void reportUser(java.awt.event.ActionEvent evt) {}                                                  

    private void unfriend(java.awt.event.ActionEvent evt) {}                                                       
    
    private void blockFriend(java.awt.event.ActionEvent evt) {} 

    private void addToGroup(java.awt.event.ActionEvent evt) {}                                                       

    private void inputMessage(java.awt.event.ActionEvent evt) {}         
}