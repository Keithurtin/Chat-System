import javax.swing.*;

public class profileWindow extends JPanel {

    private final JButton profile_change_password_button;
    private final JLabel profile_email_label;
    private final JButton profile_manage_email_button;
    private final JButton profile_manage_name_button;
    private final JLabel profile_name_label;
    private final JPanel profile_navigator;
    private final JLabel profile_num_friend_label;
    private final JPanel profile_panel;
    private final JLabel profile_password_label;
    private final JLabel profile_title;

    public profileWindow(String name, String email, int noOfFriend) {
        profile_panel = new JPanel();
        profile_navigator = new JPanel();
        profile_title = new JLabel();
        profile_name_label = new JLabel();
        profile_email_label = new JLabel();
        profile_num_friend_label = new JLabel();
        profile_manage_name_button = new JButton();
        profile_change_password_button = new JButton();
        profile_password_label = new JLabel();
        profile_manage_email_button = new JButton();


        profile_panel.setBackground(new java.awt.Color(255, 255, 255));
        profile_panel.setPreferredSize(new java.awt.Dimension(400, 370));
        profile_panel.setRequestFocusEnabled(false);

        profile_navigator.setBackground(new java.awt.Color(153, 204, 255));
        profile_navigator.setPreferredSize(new java.awt.Dimension(400, 70));

        profile_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        profile_title.setForeground(new java.awt.Color(255, 255, 255));
        profile_title.setText("Personal Profile");

        GroupLayout profile_navigatorLayout = new GroupLayout(profile_navigator);
        profile_navigator.setLayout(profile_navigatorLayout);
        profile_navigatorLayout.setHorizontalGroup(
            profile_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(profile_navigatorLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(profile_title)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        profile_navigatorLayout.setVerticalGroup(
            profile_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(profile_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile_title)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        profile_name_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile_name_label.setText("Name: " + name);

        profile_email_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile_email_label.setText("Email:" + email);

        profile_num_friend_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile_num_friend_label.setText("No. Friends:" + noOfFriend);

        profile_manage_name_button.setText("Manage");
        profile_manage_name_button.addActionListener(e -> changeName());

        profile_password_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile_password_label.setText("Change password:");

        profile_change_password_button.setText("Change");
        profile_manage_email_button.addActionListener(e -> changePassword());

        profile_manage_email_button.setText("Manage");
        profile_manage_email_button.addActionListener(e -> changeEmail());

        GroupLayout profile_panelLayout = new GroupLayout(profile_panel);
        profile_panel.setLayout(profile_panelLayout);
        profile_panelLayout.setHorizontalGroup(
            profile_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(profile_navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(profile_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(profile_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(profile_panelLayout.createSequentialGroup()
                        .addComponent(profile_email_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profile_manage_email_button))
                    .addComponent(profile_num_friend_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(profile_panelLayout.createSequentialGroup()
                        .addComponent(profile_name_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profile_manage_name_button))
                    .addGroup(profile_panelLayout.createSequentialGroup()
                        .addComponent(profile_password_label)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(profile_change_password_button)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profile_panelLayout.setVerticalGroup(
            profile_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(profile_panelLayout.createSequentialGroup()
                .addComponent(profile_navigator, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(profile_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(profile_name_label)
                    .addComponent(profile_manage_name_button))
                .addGap(31, 31, 31)
                .addGroup(profile_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(profile_email_label)
                    .addComponent(profile_manage_email_button))
                .addGap(30, 30, 30)
                .addComponent(profile_num_friend_label)
                .addGap(30, 30, 30)
                .addGroup(profile_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(profile_password_label)
                    .addComponent(profile_change_password_button))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }

    private void changeEmail() {}

    private void changeName() {}
    
    private void changePassword() {}
}