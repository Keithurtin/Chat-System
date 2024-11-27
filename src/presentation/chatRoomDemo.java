import component.chatBoxDemo;
import java.awt.*;
import javax.swing.*;

public class chatRoomDemo extends JFrame {

    private final JPanel main_panel;
    private final CardLayout card_layout;
    private JPanel reset_password_panel;
    private JPanel login_panel;
    private JPanel signup_panel;
    JCheckBox isAdmin;

    public chatRoomDemo() {
        setUpLogin();
        setUpSignUp();
        setUpResetPassword();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        card_layout = new CardLayout();
        main_panel = new JPanel(card_layout);
        main_panel.add(login_panel, "login_panel");
        main_panel.add(signup_panel, "signup_panel");
        main_panel.add(reset_password_panel, "reset_password_panel");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocation(550, 150);
        getContentPane().add(main_panel);
        card_layout.show(main_panel, "login_panel");
    }

    private void signupButton() {
        JFrame newWindow = new JFrame();
        JPanel navigator = new JPanel();
        JLabel title = new JLabel();
        JPanel content_side = new JPanel();
        JLabel fullname_label = new JLabel("Fullname: ");
        JLabel birthdate_label = new JLabel("Birthdate: ");
        JLabel address_label = new JLabel("Address: ");
        JLabel gender_label = new JLabel("Gender: ");
        JTextField fullname_input = new JTextField();
        JTextField address_input = new JTextField();
        JTextField birthdate_input = new JTextField("dd/mm/yyyy");
        JComboBox<String> gender_input = new JComboBox<>(new String[]{"Male", "Female"});
        JButton submit_button = new JButton("Submit");

        newWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        navigator.setBackground(new java.awt.Color(153, 204, 255));

        title = new JLabel("Sign Up Information");
        title.setFont(new java.awt.Font("Segoe UI", 1, 24));
        title.setForeground(new java.awt.Color(255, 255, 255));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
                navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navigatorLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(title)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navigatorLayout.setVerticalGroup(
                navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navigatorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addContainerGap(8, Short.MAX_VALUE))
        );

        content_side.setBackground(new java.awt.Color(255, 255, 255));
        fullname_label.setFont(new java.awt.Font("Segoe UI", 3, 18));
        birthdate_label.setFont(new java.awt.Font("Segoe UI", 3, 18));
        address_label.setFont(new java.awt.Font("Segoe UI", 3, 18));
        gender_label.setFont(new java.awt.Font("Segoe UI", 3, 18));

        submit_button.setBackground(new java.awt.Color(153, 204, 255));
        submit_button.setFont(new java.awt.Font("Segoe UI", 1, 18));
        submit_button.setForeground(new java.awt.Color(255, 255, 255));
        submit_button.addActionListener(e -> goToLogin());

        GroupLayout content_sideLayout = new GroupLayout(content_side);
        content_side.setLayout(content_sideLayout);
        content_sideLayout.setHorizontalGroup(
                content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(birthdate_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(gender_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(address_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fullname_label, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(fullname_input, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(address_input, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthdate_input, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(submit_button)
                                                .addComponent(gender_input, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        content_sideLayout.setVerticalGroup(
                content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(fullname_label)
                                        .addComponent(fullname_input, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(address_input)
                                                .addGap(1, 1, 1))
                                        .addComponent(address_label))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(birthdate_input)
                                                .addGap(1, 1, 1))
                                        .addComponent(birthdate_label))
                                .addGap(18, 18, 18)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(gender_label)
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(gender_input)
                                                .addGap(1, 1, 1)))
                                .addGap(39, 39, 39)
                                .addComponent(submit_button)
                                .addGap(69, 69, 69))
        );

        GroupLayout layout = new GroupLayout(newWindow.getContentPane());
        newWindow.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(content_side, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(content_side, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        newWindow.setResizable(false);
        newWindow.setLocation(600,170);
        newWindow.pack();
        newWindow.setVisible(true);
    }

    private void setUpSignUp() {
        signup_panel = new JPanel();
        signup_panel.setBackground(new java.awt.Color(255, 255, 255));

        signup_panel.setName("Sign Up");

        JLabel signup_username_label = new JLabel("Username:");
        signup_username_label.setFont(new java.awt.Font("Segoe UI", 0, 18));

        JLabel signup_password_label = new JLabel("Password:");
        signup_password_label.setFont(new java.awt.Font("Segoe UI", 0, 18));

        JLabel signup_email_label = new JLabel("Email:"); 
        signup_email_label.setFont(new java.awt.Font("Segoe UI", 0, 18));
        
        JLabel signup_title = new JLabel("Sign Up");
        signup_title.setFont(new java.awt.Font("Times New Roman", 1, 24));
        signup_title.setForeground(new java.awt.Color(102, 153, 255));
        signup_title.setIconTextGap(10);

        JButton signup_button = new JButton("Sign Up");
        signup_button.setBackground(new java.awt.Color(153, 204, 255));
        signup_button.setFont(new java.awt.Font("Segoe UI", 1, 16));
        signup_button.setForeground(Color.white);
        signup_button.addActionListener(e -> signupButton());

        JButton go_to_login_button = new JButton("Log In");
        go_to_login_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_login_button.setFont(new java.awt.Font("Segoe UI", 1, 16));
        go_to_login_button.setForeground(Color.white);
        go_to_login_button.addActionListener(e -> goToLogin());

        JLabel go_to_login_label = new JLabel("Already had account?");
        go_to_login_label.setFont(new java.awt.Font("Segoe UI", 0, 16));

        JSeparator signup_separator = new JSeparator();

        JTextField signup_email_input = new JTextField();
        JTextField signup_username_input = new JTextField();
        JPasswordField signup_password_input = new JPasswordField();

        GroupLayout signup_panelLayout = new GroupLayout(signup_panel);
        signup_panel.setLayout(signup_panelLayout);
        signup_panelLayout.setHorizontalGroup(
                signup_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(signup_panelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(signup_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(signup_panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(signup_separator, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(signup_panelLayout.createSequentialGroup()
                                                        .addComponent(signup_password_label)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(signup_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(signup_button)
                                                                .addComponent(signup_password_input, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(signup_panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(GroupLayout.Alignment.LEADING, signup_panelLayout.createSequentialGroup()
                                                        .addComponent(signup_email_label)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(signup_email_input, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.LEADING, signup_panelLayout.createSequentialGroup()
                                                        .addComponent(signup_username_label)
                                                        .addGap(26, 26, 26)
                                                        .addGroup(signup_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(signup_username_input, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(signup_panelLayout.createSequentialGroup()
                                                                        .addGap(13, 13, 13)
                                                                        .addComponent(signup_title)))))
                                        .addGroup(signup_panelLayout.createSequentialGroup()
                                                .addComponent(go_to_login_label)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(go_to_login_button)))
                                .addContainerGap(62, Short.MAX_VALUE))
        );
        signup_panelLayout.setVerticalGroup(
                signup_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(signup_panelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(signup_title)
                                .addGap(18, 18, 18)
                                .addGroup(signup_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(signup_username_label)
                                        .addComponent(signup_username_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(signup_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(signup_email_label)
                                        .addComponent(signup_email_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(signup_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(signup_password_label)
                                        .addComponent(signup_password_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(signup_button)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(signup_separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(signup_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(go_to_login_label)
                                        .addComponent(go_to_login_button))
                                .addContainerGap(46, Short.MAX_VALUE))
        );
    }

    private void setUpLogin() {
        login_panel = new JPanel();
        login_panel.setBackground(new java.awt.Color(255, 255, 255));
        login_panel.setForeground(new java.awt.Color(255, 255, 255));

        JLabel go_to_reset_password_label = new JLabel("Forget password?");
        go_to_reset_password_label.setFont(new java.awt.Font("Segoe UI", 0, 16));

        JButton go_to_reset_password_button = new JButton("Reset Password");
        go_to_reset_password_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_reset_password_button.setFont(new java.awt.Font("Segoe UI", 1, 16));
        go_to_reset_password_button.setForeground(Color.white);
        go_to_reset_password_button.setActionCommand("Reset");
        go_to_reset_password_button.addActionListener(e -> goToResetPassword());

        JLabel login_username_label = new JLabel("Username:");
        login_username_label.setFont(new java.awt.Font("Segoe UI", 0, 18));

        JLabel login_password_label = new JLabel("Password:");
        login_password_label.setFont(new java.awt.Font("Segoe UI", 0, 18));

        JLabel login_title = new JLabel("Log In");
        login_title.setFont(new java.awt.Font("Times New Roman", 1, 24));
        login_title.setForeground(new java.awt.Color(102, 153, 255));
        login_title.setIconTextGap(10);

        isAdmin = new JCheckBox("Are you Admin?");
        isAdmin.setFont(new java.awt.Font("Segoe UI", 0, 16));

        JButton login_button = new JButton("Submit");
        login_button.setBackground(new java.awt.Color(153, 204, 255));
        login_button.setFont(new java.awt.Font("Segoe UI", 1, 16));
        login_button.setForeground(Color.white);
        login_button.addActionListener(e -> loginButton());

        JButton go_to_signup_button = new JButton("Sign Up");
        go_to_signup_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_signup_button.setFont(new java.awt.Font("Segoe UI", 1, 16));
        go_to_signup_button.setForeground(Color.white);
        go_to_signup_button.addActionListener(e -> goToSignUp());

        JLabel go_to_signup_label = new JLabel("Don't have account yet?");
        go_to_signup_label.setFont(new java.awt.Font("Segoe UI", 0, 16));

        JSeparator login_separator = new JSeparator();

        JTextField login_username_input = new JTextField();
        JPasswordField login_password_input = new JPasswordField();

        GroupLayout login_panelLayout = new GroupLayout(login_panel);
        login_panel.setLayout(login_panelLayout);
        login_panelLayout.setHorizontalGroup(
                login_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(login_panelLayout.createSequentialGroup()
                                .addGroup(login_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(login_panelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(login_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(login_panelLayout.createSequentialGroup()
                                                                .addGroup(login_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(login_username_label)
                                                                        .addComponent(login_password_label))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(login_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(login_password_input, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(login_username_input, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(isAdmin)))
                                                        .addGroup(login_panelLayout.createSequentialGroup()
                                                                .addComponent(go_to_signup_label)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(go_to_signup_button))
                                                        .addComponent(login_separator, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(login_panelLayout.createSequentialGroup()
                                                                .addComponent(go_to_reset_password_label)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(go_to_reset_password_button))))
                                        .addGroup(login_panelLayout.createSequentialGroup()
                                                .addGap(163, 163, 163)
                                                .addComponent(login_title))
                                        .addGroup(login_panelLayout.createSequentialGroup()
                                                .addGap(158, 158, 158)
                                                .addComponent(login_button)))
                                .addContainerGap(62, Short.MAX_VALUE))
        );
        login_panelLayout.setVerticalGroup(
                login_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(login_panelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(login_title)
                                .addGap(18, 18, 18)
                                .addGroup(login_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(login_username_label)
                                        .addComponent(login_username_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(login_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(login_password_label)
                                        .addComponent(login_password_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(isAdmin)
                                .addGap(18, 18, 18)
                                .addComponent(login_button)
                                .addGap(12, 12, 12)
                                .addComponent(login_separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(login_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(go_to_signup_label)
                                        .addComponent(go_to_signup_button))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(login_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(go_to_reset_password_label)
                                        .addComponent(go_to_reset_password_button))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
    }

    private void setUpResetPassword() {
        reset_password_panel = new JPanel();
        reset_password_panel.setBackground(new java.awt.Color(255, 255, 255));
        JLabel reset_password_email_label = new JLabel("Email:");
        reset_password_email_label.setFont(new java.awt.Font("Segoe UI", 0, 18));

        JLabel reset_password_title = new JLabel("Reset Password");
        reset_password_title.setFont(new java.awt.Font("Times New Roman", 1, 24));
        reset_password_title.setForeground(new java.awt.Color(102, 153, 255));
        reset_password_title.setIconTextGap(10);

        JButton reset_password_button = new JButton("Submit");
        reset_password_button.setBackground(new java.awt.Color(153, 204, 255));
        reset_password_button.setFont(new java.awt.Font("Segoe UI", 1, 16));
        reset_password_button.setForeground(Color.white);
        reset_password_button.addActionListener(e -> resetPassword());

        JButton go_back_to_login_button = new JButton("Go Back");
        go_back_to_login_button.setBackground(new java.awt.Color(153, 204, 255));
        go_back_to_login_button.setFont(new java.awt.Font("Segoe UI", 1, 16));
        go_back_to_login_button.setForeground(Color.white);
        go_back_to_login_button.addActionListener(e -> goToLogin());

        JLabel reset_password_description = new JLabel("Please enter the email that linked to your account.");
        reset_password_description.setFont(new java.awt.Font("Segoe UI", 0, 16)); 

        JTextField reset_password_email = new JTextField();

        GroupLayout reset_password_panelLayout = new GroupLayout(reset_password_panel);
        reset_password_panel.setLayout(reset_password_panelLayout);
        reset_password_panelLayout.setHorizontalGroup(
                reset_password_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(reset_password_panelLayout.createSequentialGroup()
                                .addGroup(reset_password_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(reset_password_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(reset_password_panelLayout.createSequentialGroup()
                                                        .addGap(113, 113, 113)
                                                        .addComponent(reset_password_title))
                                                .addGroup(GroupLayout.Alignment.TRAILING, reset_password_panelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(go_back_to_login_button)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(reset_password_button)
                                                        .addGap(12, 12, 12)))
                                        .addGroup(reset_password_panelLayout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(reset_password_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(reset_password_panelLayout.createSequentialGroup()
                                                                .addComponent(reset_password_email_label)
                                                                .addGap(37, 37, 37)
                                                                .addComponent(reset_password_email))
                                                        .addComponent(reset_password_description))))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        reset_password_panelLayout.setVerticalGroup(
                reset_password_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, reset_password_panelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(reset_password_title)
                                .addGap(31, 31, 31)
                                .addGroup(reset_password_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(reset_password_email_label)
                                        .addComponent(reset_password_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(reset_password_description)
                                .addGap(53, 53, 53)
                                .addGroup(reset_password_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(go_back_to_login_button)
                                        .addComponent(reset_password_button))
                                .addContainerGap(67, Short.MAX_VALUE))
        );
    }

    private void goToLogin() {
        card_layout.show(main_panel, "login_panel");
    }

    private void resetPassword() {
        System.out.println("request reset password submitted");
    }

    private void goToResetPassword() {
        card_layout.show(main_panel, "reset_password_panel");
    }

    private void loginButton() {
        boolean adminStatus = isAdmin.isSelected();
        JFrame newWindow;
        if(adminStatus) {
                newWindow = new component.adminMenu();
        } else {
                newWindow = new chatBoxDemo();
        }
        dispose();
        newWindow.setVisible(true);
    }

    private void goToSignUp() {
        card_layout.show(main_panel, "signup_panel");
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chatRoomDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new chatRoomDemo().setVisible(true);
        });
    }
}
