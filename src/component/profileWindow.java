package component;
import java.awt.*;
import javax.swing.*;

public class profileWindow extends JFrame {
    private JPanel navigator;
    private final JScrollPane main_scroll;

    public profileWindow(String name, String fullname, String address, String birthday, boolean gender, String email, int noOfFriend) {
        JPanel main_panel = new JPanel();
        JPanel content_side = new JPanel();
        JLabel username_label = new JLabel("Name: ");
        JLabel fullname_label = new JLabel("Fullname: ");
        JLabel gender_label = new JLabel("Gender: ");
        JLabel address_label = new JLabel("Address: ");
        JLabel birthdate_label = new JLabel("Birthday: ");
        JLabel email_label = new JLabel("Email: ");
        JLabel num_friend_label = new JLabel("No. Friends: ");
        JLabel username_value_label = new JLabel(name);
        JLabel fullname_value_label = new JLabel(fullname);
        JLabel address_value_label = new JLabel(address);
        JLabel birthdate_value_label = new JLabel(birthday);
        JLabel gender_value_label = new JLabel(gender?"Male":"Female");
        JLabel email_value_label = new JLabel(email);
        JLabel num_of_friend_value_label = new JLabel(String.valueOf(noOfFriend));

        setupNavigatorLayout();

        username_label.setFont(new java.awt.Font("Segoe UI", 1, 18));
        fullname_label.setFont(new java.awt.Font("Segoe UI", 1, 18));
        address_label.setFont(new java.awt.Font("Segoe UI", 1, 18));
        birthdate_label.setFont(new java.awt.Font("Segoe UI", 1, 18));
        gender_label.setFont(new java.awt.Font("Segoe UI", 1, 18));
        email_label.setFont(new java.awt.Font("Segoe UI", 1, 18));
        num_friend_label.setFont(new java.awt.Font("Segoe UI", 1, 18));

        username_value_label.setFont(new java.awt.Font("Segoe UI", 0, 18));
        fullname_value_label.setFont(new java.awt.Font("Segoe UI", 0, 18));
        address_value_label.setFont(new java.awt.Font("Segoe UI", 0, 18));
        birthdate_value_label.setFont(new java.awt.Font("Segoe UI", 0, 18));
        gender_value_label.setFont(new java.awt.Font("Segoe UI", 0, 18));
        email_value_label.setFont(new java.awt.Font("Segoe UI", 0, 18));
        num_of_friend_value_label.setFont(new java.awt.Font("Segoe UI", 0, 18));

        JButton manage_button = new JButton("Manage");
        manage_button.setBackground(new java.awt.Color(153, 204, 255));
        manage_button.setFont(new java.awt.Font("Segoe UI", 1, 18));
        manage_button.setForeground(new java.awt.Color(255, 255, 255));
        
        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setRequestFocusEnabled(false);

        content_side.setBackground(new java.awt.Color(255, 255, 255));
        JLabel password_label = new JLabel("Change password:");
        password_label.setFont(new java.awt.Font("Segoe UI", 1, 18));

        JButton change_password_button = new JButton("Change");
        change_password_button.setBackground(new java.awt.Color(153, 204, 255));
        change_password_button.setFont(new java.awt.Font("Segoe UI", 1, 18));
        change_password_button.setForeground(new java.awt.Color(255, 255, 255));

        change_password_button.addActionListener(e -> changePassword());

        GroupLayout content_sideLayout = new GroupLayout(content_side);
        content_side.setLayout(content_sideLayout);
        content_sideLayout.setHorizontalGroup(
                content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(username_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(gender_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(num_friend_label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(gender_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(username_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_value_label, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(num_of_friend_value_label, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28))))
                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                .addComponent(manage_button)
                                .addGap(201, 201, 201))
                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(password_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(change_password_button)
                                .addGap(90, 90, 90))
        );
        content_sideLayout.setVerticalGroup(
                content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(username_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(fullname_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(address_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(birthdate_value_label)
                                                .addGap(17, 17, 17)
                                                .addComponent(gender_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(email_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(num_of_friend_value_label))
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(username_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(fullname_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(address_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(birthdate_label)
                                                .addGap(17, 17, 17)
                                                .addComponent(gender_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(email_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(num_friend_label)))
                                .addGap(18, 18, 18)
                                .addComponent(manage_button)
                                .addGap(23, 23, 23)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(password_label)
                                        .addComponent(change_password_button))
                                .addGap(30, 30, 30))
        );

        main_scroll = new JScrollPane(content_side);
        main_scroll.setBorder(null);

        GroupLayout main_panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(main_scroll)
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addComponent(main_scroll, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension panelSize = main_panel.getPreferredSize();
        add(main_panel);
        setResizable(false);
        setLocation(600, 180);
        setSize(panelSize);
    }

    private void setupNavigatorLayout() {
        navigator = new JPanel();
        navigator.setBackground(new java.awt.Color(153, 204, 255));
        navigator.setPreferredSize(new java.awt.Dimension(400, 70));

        JLabel title = new JLabel("Personal Profile");
        title.setFont(new java.awt.Font("Segoe UI", 1, 24));
        title.setForeground(new java.awt.Color(255, 255, 255));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(title)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(8, Short.MAX_VALUE))
        );

    }
    
    private void changePassword() {}

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new profileWindow("abc", "abcdef" ,"213 ac", "12/12/1200", true, "abc@gmail", 12).setVisible(true));
    }
}