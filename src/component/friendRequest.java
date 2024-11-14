import javax.swing.*;

public class friendRequest extends JPanel{
    
    private JPanel main_panel;
    private JButton approve_button;
    private JButton reject_button;
    private JLabel name_label;
    private JLabel status_label; 

    public friendRequest(String username, String status) {
        main_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        name_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name_label.setText(username);

        status_label.setText("status:" + status);

        approve_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        approve_button.setText("Approve");
        approve_button.addActionListener(this::approveFriendRequest);

        reject_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reject_button.setText("Reject");
        reject_button.addActionListener(this::rejectFriendRequest);

        GroupLayout panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(status_label, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reject_button))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(name_label, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(approve_button)))
                .addGap(18, 18, 18))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addComponent(approve_button))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(status_label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addComponent(reject_button))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }

    private void approveFriendRequest(java.awt.event.ActionEvent evt) {}                                                              

    private void rejectFriendRequest(java.awt.event.ActionEvent evt) {} 
}