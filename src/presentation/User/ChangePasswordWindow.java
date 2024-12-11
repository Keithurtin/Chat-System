package presentation.User;

import bus.UsersBUS;
import dto.UsersDTO;

import javax.swing.*;
import java.awt.*;

public class ChangePasswordWindow extends JFrame {
    private final JPasswordField oldPasswordField;
    private final JPasswordField newPasswordField;
    private final JPasswordField reenterPasswordField;

    public ChangePasswordWindow(int uid) {
        setTitle("Change Password");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for layout
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));

        // Labels
        JLabel oldPasswordLabel = new JLabel("Old Password:");
        JLabel newPasswordLabel = new JLabel("New Password:");
        JLabel reenterPasswordLabel = new JLabel("Re-enter New Password:");

        Font defaultLabelFont = new Font("Segoe UI", Font.BOLD, 18);
        Font defaultTextFont = new Font("Segoe UI", Font.BOLD, 16);

        oldPasswordLabel.setFont(defaultLabelFont);
        newPasswordLabel.setFont(defaultLabelFont);
        reenterPasswordLabel.setFont(defaultLabelFont);


        // Password fields
        oldPasswordField = new JPasswordField();
        newPasswordField = new JPasswordField();
        reenterPasswordField = new JPasswordField();

        oldPasswordField.setFont(defaultTextFont);
        newPasswordField.setFont(defaultTextFont);
        reenterPasswordField.setFont(defaultTextFont);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(defaultTextFont);
        submitButton.addActionListener(_ -> handlePasswordChange(uid));

        JPanel navigator = setupNavigatorLayout();

        GroupLayout defaultLayout = new GroupLayout(panel);
        panel.setLayout(defaultLayout);
        defaultLayout.setHorizontalGroup(
                defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(defaultLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(defaultLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, defaultLayout.createSequentialGroup()
                                                .addGap(0, 5, Short.MAX_VALUE)
                                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(oldPasswordLabel, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(newPasswordLabel, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(reenterPasswordLabel, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(oldPasswordField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,180, Short.MAX_VALUE)
                                                        .addComponent(newPasswordField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                                        .addComponent(reenterPasswordField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                                .addGap(50, 50, 50))))
                        .addGroup(GroupLayout.Alignment.TRAILING, defaultLayout.createSequentialGroup()
                                .addComponent(submitButton)
                                .addGap(220, 220, 220)));

        defaultLayout.setVerticalGroup(
                defaultLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(oldPasswordLabel)
                                .addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(newPasswordLabel)
                                .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(defaultLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(reenterPasswordLabel)
                                .addComponent(reenterPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(submitButton)
                        .addGap(140, 140, 140)
        );

        GroupLayout main_panelLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        main_panelLayout.setVerticalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(main_panelLayout.createSequentialGroup()
                                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension panelSize = panel.getPreferredSize();
        add(panel);
        setResizable(false);
        setLocation(600, 180);
        setSize(panelSize);
    }

    private JPanel setupNavigatorLayout() {
        JPanel navigator = new JPanel();
        navigator.setBackground(new Color(153, 204, 255));
        navigator.setPreferredSize(new Dimension(400, 70));

        JLabel title = new JLabel("Change Password");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
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

    private void handlePasswordChange(int uid) {
        char[] oldPassword = oldPasswordField.getPassword();
        char[] newPassword = newPasswordField.getPassword();
        char[] reenteredPassword = reenterPasswordField.getPassword();

        String oldPasswordStr = new String(oldPassword);
        if (oldPasswordStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Old password is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String newPasswordStr = new String(newPassword);
        if (newPasswordStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "New password is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!newPasswordStr.equals(new String(reenteredPassword))) {
            JOptionPane.showMessageDialog(this, "New passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UsersBUS usersBUS = new UsersBUS();
        UsersDTO usersDTO = usersBUS.getById(uid);
        if(!HashString.verifyHash(usersDTO.getPassword(), oldPasswordStr)){
            JOptionPane.showMessageDialog(this, "Old password is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);            return;
        }
        usersDTO.setPassword(HashString.hashString(newPasswordStr));
        if(usersBUS.updateUser(usersDTO)){
            JOptionPane.showMessageDialog(this, "Password changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "There something went wrong!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
