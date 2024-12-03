package presentation.User;
import java.awt.*;
import javax.swing.*;
import bus.*;
import com.toedter.calendar.JDateChooser;
import dto.*;

import java.text.SimpleDateFormat;
import java.util.List;

public class UserProfileWindow extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel main_panel;

    public UserProfileWindow(int uid) {
        UsersBUS usersBUS = new UsersBUS();
        UsersDTO user = usersBUS.getById(uid);

        cardLayout = new CardLayout();
        main_panel = new JPanel(cardLayout);
        main_panel.setBackground(new Color(255, 255, 255));
        main_panel.setRequestFocusEnabled(false);

        JPanel navigator = setupNavigatorLayout();

        main_panel.add(defaultLayout(user), "Default");
        main_panel.add(editLayout(user), "Edit");
        cardLayout.show(main_panel, "Default");


        GroupLayout main_panelLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(main_panel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addComponent(main_panel, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension panelSize = main_panel.getPreferredSize();
        add(main_panel);
        setResizable(false);
        setLocation(600, 180);
        setSize(panelSize);
    }

    private JPanel defaultLayout(UsersDTO user) {
        FriendListBUS friendListBUS = new FriendListBUS();
        JPanel content_side = new JPanel();
        content_side.setBackground(new Color(255, 255, 255));

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); // You can change the pattern as needed
        String birthDateString = formatter.format(user.getBirthDate());
        JLabel username_label = new JLabel("Name: ");
        JLabel fullname_label = new JLabel("Fullname: ");
        JLabel gender_label = new JLabel("Gender: ");
        JLabel address_label = new JLabel("Address: ");
        JLabel birthdate_label = new JLabel("Birthday: ");
        JLabel email_label = new JLabel("Email: ");
        JLabel num_friend_label = new JLabel("No. Friends: ");
        JLabel username_value_label = new JLabel(user.getuName());
        JLabel fullname_value_label = new JLabel(user.getFullname());
        JLabel address_value_label = new JLabel(user.getAddress());
        JLabel birthdate_value_label = new JLabel(birthDateString);
        JLabel gender_value_label = new JLabel(user.getGender());
        JLabel email_value_label = new JLabel(user.getEmail());
        JLabel num_of_friend_value_label = new JLabel(String.valueOf(friendListBUS.countFriends(user.getuID())));

        Font defaultLabelFont = new Font("Segoe UI", 1, 18);
        Font defaultValueFont = new Font("Segoe UI", 0, 18);
        
        username_label.setFont(defaultLabelFont);
        fullname_label.setFont(defaultLabelFont);
        address_label.setFont(defaultLabelFont);
        birthdate_label.setFont(defaultLabelFont);
        gender_label.setFont(defaultLabelFont);
        email_label.setFont(defaultLabelFont);
        num_friend_label.setFont(defaultLabelFont);
        
        username_value_label.setFont(defaultValueFont);
        fullname_value_label.setFont(defaultValueFont);
        address_value_label.setFont(defaultValueFont);
        birthdate_value_label.setFont(defaultValueFont);
        gender_value_label.setFont(defaultValueFont);
        email_value_label.setFont(defaultValueFont);
        num_of_friend_value_label.setFont(defaultValueFont);

        JButton manage_button = new JButton("Manage");
        manage_button.setBackground(new Color(153, 204, 255));
        manage_button.setFont(defaultLabelFont);
        manage_button.setForeground(new Color(255, 255, 255));

        manage_button.addActionListener(e -> {
                cardLayout.show(main_panel, "Edit");
        });

        JLabel password_label = new JLabel("Change password:");
        password_label.setFont(defaultLabelFont);

        JButton change_password_button = new JButton("Change");
        change_password_button.setBackground(new Color(153, 204, 255));
        change_password_button.setFont(defaultLabelFont);
        change_password_button.setForeground(new Color(255, 255, 255));

        change_password_button.addActionListener(e -> changePassword(user.getuID()));

        GroupLayout defaultLayout = new GroupLayout(content_side);
        content_side.setLayout(defaultLayout);
        defaultLayout.setHorizontalGroup(
                defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(defaultLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(defaultLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, defaultLayout.createSequentialGroup()
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(username_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(gender_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(num_friend_label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(gender_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(username_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_value_label, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(num_of_friend_value_label, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20))))
                        .addGroup(GroupLayout.Alignment.TRAILING, defaultLayout.createSequentialGroup()
                                .addComponent(manage_button)
                                .addGap(201, 201, 201))
                        .addGroup(GroupLayout.Alignment.TRAILING, defaultLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(password_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(change_password_button)
                                .addGap(90, 90, 90))
        );
        defaultLayout.setVerticalGroup(
                defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(defaultLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(defaultLayout.createSequentialGroup()
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
                                        .addGroup(defaultLayout.createSequentialGroup()
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
                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(password_label)
                                        .addComponent(change_password_button))
                                .addGap(30, 30, 30))
        );
        return content_side;
    }

    private JPanel editLayout(UsersDTO user) {
        UsersBUS usersBUS = new UsersBUS();
        JPanel content_side = new JPanel();
        content_side.setBackground(new Color(255, 255, 255));

        JLabel username_label = new JLabel("Name: ");
        JLabel fullname_label = new JLabel("Fullname: ");
        JLabel gender_label = new JLabel("Gender: ");
        JLabel address_label = new JLabel("Address: ");
        JLabel birthdate_label = new JLabel("Birthday: ");
        JLabel email_label = new JLabel("Email: ");
        JTextField username_value_label = new JTextField(user.getuName());
        JTextField fullname_value_label = new JTextField(user.getFullname());
        JTextField address_value_label = new JTextField(user.getAddress());
        JDateChooser birthdate_value_label = new JDateChooser(user.getBirthDate());
        JTextField gender_value_label = new JTextField(user.getGender());
        JTextField email_value_label = new JTextField(user.getEmail());

        Font defaultLabelFont = new Font("Segoe UI", 1, 18);
        Font defaultValueFont = new Font("Segoe UI", 0, 16);
        
        username_label.setFont(defaultLabelFont);
        fullname_label.setFont(defaultLabelFont);
        address_label.setFont(defaultLabelFont);
        birthdate_label.setFont(defaultLabelFont);
        gender_label.setFont(defaultLabelFont);
        email_label.setFont(defaultLabelFont);

        username_value_label.setFont(defaultValueFont);
        fullname_value_label.setFont(defaultValueFont);
        address_value_label.setFont(defaultValueFont);
        birthdate_value_label.setFont(defaultValueFont);
        gender_value_label.setFont(defaultValueFont);
        email_value_label.setFont(defaultValueFont);

        JButton manage_button = new JButton("Save");
        manage_button.setBackground(new Color(153, 204, 255));
        manage_button.setFont(defaultLabelFont);
        manage_button.setForeground(new Color(255, 255, 255));

        manage_button.addActionListener(e -> {
            String username = username_value_label.getText().trim();
            String fullname = fullname_value_label.getText().trim();
            String address = address_value_label.getText().trim();
            String gender = gender_value_label.getText().trim();
            String email = email_value_label.getText().trim();
            java.util.Date birthdate = birthdate_value_label.getDate();

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!ValidateData.isValidName(fullname)) {
                JOptionPane.showMessageDialog(this, "Your name is Invalid", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!ValidateData.isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Your Email is Invalid", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!ValidateData.isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            UsersDTO updateData = new UsersDTO(user.getuID(),
                    username, user.getIsAdmin(), user.getIsLocked(),
                    fullname, address.isEmpty() ? null : address,
                    new java.sql.Date(birthdate.getTime()),
                    gender.isEmpty() ? null : gender,
                    email,
                    user.getPassword(),
                    user.getStatus(),
                    user.getCreateTime()
            );
            if(usersBUS.updateUser(updateData)) {
                main_panel.removeAll();
                UsersDTO updatedUser = usersBUS.getById(user.getuID());
                main_panel.add(defaultLayout(updatedUser), "Default");
                main_panel.add(editLayout(updatedUser), "Edit");
                cardLayout.show(main_panel, "Default");
            }
        });

        JLabel password_label = new JLabel("Change password:");
        password_label.setFont(defaultLabelFont);

        JButton change_password_button = new JButton("Change");
        change_password_button.setBackground(new Color(153, 204, 255));
        change_password_button.setFont(defaultLabelFont);
        change_password_button.setForeground(new Color(255, 255, 255));

        change_password_button.addActionListener(e -> changePassword(user.getuID()));

        GroupLayout defaultLayout = new GroupLayout(content_side);
        content_side.setLayout(defaultLayout);
        defaultLayout.setHorizontalGroup(
                defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(defaultLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(defaultLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, defaultLayout.createSequentialGroup()
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(username_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(gender_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(gender_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(username_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_value_label, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20))))
                        .addGroup(GroupLayout.Alignment.TRAILING, defaultLayout.createSequentialGroup()
                                .addComponent(manage_button)
                                .addGap(201, 201, 201))
                        .addGroup(GroupLayout.Alignment.TRAILING, defaultLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(password_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(change_password_button)
                                .addGap(90, 90, 90))
        );
        defaultLayout.setVerticalGroup(
                defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(defaultLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(defaultLayout.createSequentialGroup()
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
                                        )
                                        .addGroup(defaultLayout.createSequentialGroup()
                                                .addComponent(username_label)
                                                .addGap(30, 30, 30)
                                                .addComponent(fullname_label)
                                                .addGap(30, 30, 30)
                                                .addComponent(address_label)
                                                .addGap(30, 30, 30)
                                                .addComponent(birthdate_label)
                                                .addGap(30, 30, 30)
                                                .addComponent(gender_label)
                                                .addGap(30, 30, 30)
                                                .addComponent(email_label)
                                                .addGap(30, 30, 30)))
                                .addGap(18, 18, 18)
                                .addComponent(manage_button)
                                .addGap(30, 30, 30)
                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(password_label)
                                        .addComponent(change_password_button))
                                .addGap(120, 120, 120))
        );
        return content_side;
    }

    private JPanel setupNavigatorLayout() {
        JPanel navigator = new JPanel();
        navigator.setBackground(new Color(153, 204, 255));
        navigator.setPreferredSize(new Dimension(400, 70));

        JLabel title = new JLabel("Personal Profile");
        title.setFont(new Font("Segoe UI", 1, 24));
        title.setForeground(new Color(255, 255, 255));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(140, 140, 140)
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
        return navigator;
    }
    
    private void changePassword(int uid) {
        JFrame newWindow = new ChangePasswordWindow(uid);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new UserProfileWindow(1).setVisible(true));
    }
}