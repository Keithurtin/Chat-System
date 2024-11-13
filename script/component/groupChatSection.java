import javax.swing.*;

public class groupChatSection extends JPanel {

    private final JPanel main_panel;

    private final JPanel navigator;
    private final JLabel name_label;
    private final JLabel number_member_label;
    private final JButton change_name_button;
    private final JButton manage_button;
    private final JButton report_button;

    private final JPanel send_message_panel;
    private final JTextField input_message;
    private final JButton send_button;

    private final JScrollBar scroll_bar;

    public groupChatSection(String name, int member) {
        main_panel = new javax.swing.JPanel();
        navigator = new javax.swing.JPanel();
        report_button = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();
        manage_button = new javax.swing.JButton();
        change_name_button = new javax.swing.JButton();
        number_member_label = new javax.swing.JLabel();
        scroll_bar = new javax.swing.JScrollBar();
        send_message_panel = new javax.swing.JPanel();
        input_message = new javax.swing.JTextField();
        send_button = new javax.swing.JButton();
        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setPreferredSize(new java.awt.Dimension(593, 450));
        main_panel.setVerifyInputWhenFocusTarget(false);

        navigator.setBackground(new java.awt.Color(153, 204, 255));
        navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        report_button.setBackground(new java.awt.Color(255, 102, 102));
        report_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        report_button.setForeground(new java.awt.Color(255, 255, 255));
        report_button.setText("Report!");
        report_button.addActionListener(this::reportGroup);

        name_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name_label.setText(name);

        manage_button.setBackground(new java.awt.Color(153, 204, 255));
        manage_button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        manage_button.setForeground(new java.awt.Color(255, 255, 255));
        manage_button.setText("...");
        manage_button.setBorder(null);
        manage_button.addActionListener(this::manageGroup);

        change_name_button.setBackground(new java.awt.Color(153, 204, 255));
        change_name_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        change_name_button.setForeground(new java.awt.Color(255, 255, 255));
        change_name_button.setText("Change");
        change_name_button.addActionListener(this::changeGroupName);

        number_member_label.setText("Member: " + member);

        javax.swing.GroupLayout navigatorLayout = new javax.swing.GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(number_member_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name_label, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(change_name_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manage_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(report_button)
                .addContainerGap())
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(manage_button)
                        .addComponent(report_button))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name_label)
                        .addComponent(change_name_button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(number_member_label)
                .addGap(32, 32, 32))
        );

        send_message_panel.setBackground(new java.awt.Color(204, 204, 204));

        input_message.setText("Text....");
        input_message.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputMessage(evt);
        });

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
                .addComponent(input_message, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        send_message_panelLayout.setVerticalGroup(
            send_message_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(send_message_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(send_message_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_message, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigator, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(send_message_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addComponent(navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send_message_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    private void reportGroup(java.awt.event.ActionEvent evt) {}                                                        

    private void manageGroup(java.awt.event.ActionEvent evt) {}                                                 

    private void changeGroupName(java.awt.event.ActionEvent evt) {}                                                             

    private void inputMessage(java.awt.event.ActionEvent evt) {}                                                        

    private void sendMessage(java.awt.event.ActionEvent evt) {}
}