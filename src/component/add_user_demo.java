package component;

import java.awt.*;
import javax.swing.*;

public class add_user_demo extends JPanel {

    private JPanel main_panel;
    private JPanel navigator;

    private JScrollPane main_scroll;
    private JPanel content_side;

    public add_user_demo() {
        initComponents();
    }

    private void initComponents() {

        main_panel = new JPanel();
        navigator = new JPanel();
        JLabel title = new JLabel("User Management");
        main_scroll = new JScrollPane();
        content_side = new JPanel();

        JLabel username_label = new JLabel("Username:");
        JLabel fullname_label = new JLabel("Fullname:");
        JLabel address_label = new JLabel("Address:");
        JLabel birthdate_label = new JLabel("Birthdate:");
        JLabel gender_label = new JLabel("Gender:");
        JLabel email_label = new JLabel("Email:");
        JLabel password_label = new JLabel("Password:");

        JTextField username_input = new JTextField();
        JTextField fullname_input = new JTextField();
        JTextField address_input = new JTextField();
        JTextField birthdate_input = new JTextField("dd/mm/yyyy");
        JPasswordField password_input = new JPasswordField();
        JComboBox<String> gender_input = new JComboBox<>(new String[]{"Male", "Femail"});

        JTextField email_input = new JTextField();

        JButton submit_button = new JButton("Add");

        GroupLayout main_panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 428, Short.MAX_VALUE)
        );
        main_panelLayout.setVerticalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 434, Short.MAX_VALUE)
        );

        navigator.setBackground(new java.awt.Color(153, 204, 255));

        title.setFont(new java.awt.Font("Segoe UI", 1, 24));
        title.setForeground(new java.awt.Color(255, 255, 255));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
                navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navigatorLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navigatorLayout.setVerticalGroup(
                navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navigatorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        content_side.setBackground(new java.awt.Color(255, 255, 255));

        username_label.setFont(new java.awt.Font("Segoe UI", 1, 14));
        fullname_label.setFont(new java.awt.Font("Segoe UI", 1, 14));
        address_label.setFont(new java.awt.Font("Segoe UI", 1, 14));
        birthdate_label.setFont(new java.awt.Font("Segoe UI", 1, 14));
        gender_label.setFont(new java.awt.Font("Segoe UI", 1, 14));
        email_label.setFont(new java.awt.Font("Segoe UI", 1, 14));
        password_label.setFont(new java.awt.Font("Segoe UI", 1, 14));

        username_input.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fullname_input.setFont(new java.awt.Font("Segoe UI", 0, 14));
        address_input.setFont(new java.awt.Font("Segoe UI", 0, 14));
        birthdate_input.setFont(new java.awt.Font("Segoe UI", 0, 14));
        gender_input.setFont(new java.awt.Font("Segoe UI", 0, 14));
        email_input.setFont(new java.awt.Font("Segoe UI", 0, 14));

        submit_button.setBackground(new java.awt.Color(153, 204, 255));
        submit_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        submit_button.setForeground(new java.awt.Color(255, 255, 255));

        Dimension fieldSize = new Dimension(256, 25);
        username_input.setPreferredSize(fieldSize);
        fullname_input.setPreferredSize(fieldSize);
        address_input.setPreferredSize(fieldSize);
        birthdate_input.setPreferredSize(fieldSize);
        gender_input.setPreferredSize(fieldSize);
        email_input.setPreferredSize(fieldSize);
        password_input.setPreferredSize(fieldSize);

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
                                                        .addComponent(email_label, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(password_label, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(gender_input, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(birthdate_input, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_input, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_input, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(username_input, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_input, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(password_input, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28))))
                        .addGroup(GroupLayout.Alignment.LEADING, content_sideLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submit_button)
                                .addGap(161, 161, 161))
        );
        content_sideLayout.setVerticalGroup(
                content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(username_label)
                                        .addComponent(username_input))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(fullname_label)
                                        .addComponent(fullname_input))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(address_label)
                                        .addComponent(address_input))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(birthdate_label)
                                        .addComponent(birthdate_input))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(gender_label)
                                        .addComponent(gender_input))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(email_label)
                                        .addComponent(email_input))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(password_label)
                                        .addComponent(password_input))
                                .addGap(18, 18, 18)
                                .addComponent(submit_button)
                                .addGap(18, 18, 18))
        );

        main_scroll = new JScrollPane(content_side);
        main_scroll.setBorder(null);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 441, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(main_scroll, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                                .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 446, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(main_scroll, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)))
        );
    }

    public static void main(String[] args) {
        JFrame newWindow = new JFrame("User Management");
        JPanel userManage = new add_user_demo();
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = userManage.getPreferredSize();
        newWindow.add(userManage);
        newWindow.setResizable(false);
        newWindow.setLocation(600, 180);
        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }
}
