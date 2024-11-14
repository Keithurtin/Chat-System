import javax.swing.*;

public class friend extends JPanel{

    private final JPanel main_panel;

    private final JLabel name_label;
    private JLabel status_label;

    private JButton send_request_button;

    public friend(String name, String status_no, String type){
        main_panel = new javax.swing.JPanel();
        name_label = new javax.swing.JLabel();

        main_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        name_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name_label.setText(name);

        if(type.equals("group")) {
            status_label = new javax.swing.JLabel();

            status_label.setText("member:" + status_no);

            GroupLayout panelLayout = new javax.swing.GroupLayout(main_panel);
            main_panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(status_label, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(name_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status_label)
                    .addContainerGap())
            );
            return;
        }

        if(type.equals("friend")) {
            status_label = new javax.swing.JLabel();

            status_label.setText("Status:" + status_no);

            javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(main_panel);
            main_panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(status_label, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(name_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status_label)
                    .addContainerGap())
            );
        } else {
            send_request_button = new javax.swing.JButton();
            send_request_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            send_request_button.setText("Send Request");
            send_request_button.addActionListener(this::sendFriendRequest);

            javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(main_panel);
            main_panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(name_label, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(send_request_button)
                    .addContainerGap())
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name_label)
                        .addComponent(send_request_button))
                    .addContainerGap(21, Short.MAX_VALUE))
            );
        }
    }

    private void sendFriendRequest(java.awt.event.ActionEvent evt) {
        if (send_request_button.getText().equals("Send Request")) {
            send_request_button.setText("Unsend");
        } else{
            send_request_button.setText("Send Request");
        }
    }
}