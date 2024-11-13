import javax.swing.*;

public class friendInList extends JPanel{

    private final JPanel main_panel;

    private final JLabel name_label;
    private JLabel status_label;

    private JButton block_button;
    private JButton unfriend_button;
    private JButton send_request_button;

    public friendInList(String name, String status, boolean isFriend){
        main_panel = new javax.swing.JPanel();
        name_label = new javax.swing.JLabel();

        main_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        name_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name_label.setText(name);

        if(isFriend) {
            status_label = new javax.swing.JLabel();
            unfriend_button = new javax.swing.JButton();
            block_button = new javax.swing.JButton();

            status_label.setText("status: " + status);

            unfriend_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            unfriend_button.setText("Unfriend");
            unfriend_button.addActionListener(this::unfriend);

            block_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            block_button.setText("Block");
            block_button.addActionListener(this::blockFriend);

            javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(main_panel);
            main_panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(status_label, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(block_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unfriend_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18))
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(unfriend_button))
                    .addGap(18, 18, 18)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(status_label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(block_button))
                    .addContainerGap(12, Short.MAX_VALUE))
            );
        } else {
            send_request_button = new javax.swing.JButton();
            send_request_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            send_request_button.setText("Send Request");
            send_request_button.addActionListener(this::sendFriendRequest);

            javax.swing.GroupLayout friend2_panelLayout = new javax.swing.GroupLayout(main_panel);
            main_panel.setLayout(friend2_panelLayout);
            friend2_panelLayout.setHorizontalGroup(
                friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friend2_panelLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(send_request_button)
                    .addGap(19, 19, 19))
            );
            friend2_panelLayout.setVerticalGroup(
                friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(friend2_panelLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(send_request_button)
                        .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(32, Short.MAX_VALUE))
            );
        }

    }

    private void sendFriendRequest(java.awt.event.ActionEvent evt) {}

    private void unfriend(java.awt.event.ActionEvent evt) {}

    private void blockFriend(java.awt.event.ActionEvent evt) {}

}