
import java.awt.*;
import javax.swing.*;

public class authentication extends JFrame {

    private final JPanel main_panel;
    private final CardLayout card_layout;

    private final JPanel reset_password_panel;
    private final JLabel reset_password_title;
    private final JLabel reset_password_email_label;
    private final JLabel reset_password_description;
    private final JTextField reset_password_email;
    private final JButton reset_password_button;
    private final JButton go_back_to_login_button;

    private final JPanel login_panel;
    private final JLabel login_title;
    private final JLabel login_username_label;
    private final JLabel login_password_label;
    private final JLabel go_to_reset_password_label;
    private final JLabel go_to_signup_label;
    private final JSeparator login_separator;
    private final JTextField login_username_input;
    private final JPasswordField login_password_input;
    private final JButton go_to_reset_password_button;
    private final JButton go_to_signup_button;
    private final JButton login_button;

    private final JPanel signup_panel;
    private final JLabel signup_title;
    private final JLabel signup_email_label;
    private final JLabel signup_username_label;
    private final JLabel signup_password_label;
    private final JLabel go_to_login_label;
    private final JSeparator signup_separator;
    private final JTextField signup_username_input;
    private final JTextField signup_email_input;
    private final JPasswordField signup_password_input;
    private final JButton go_to_login_button;
    private final JButton signup_button;

    public authentication() {
        signup_panel = new JPanel();
        signup_username_label = new JLabel();
        signup_password_label = new JLabel();
        signup_username_input = new JTextField();
        signup_password_input = new JPasswordField();
        signup_title = new JLabel();
        signup_button = new JButton();
        go_to_login_button = new JButton();
        go_to_login_label = new JLabel();
        signup_separator = new JSeparator();
        signup_email_label = new JLabel();
        signup_email_input = new JTextField();
        reset_password_panel = new JPanel();
        reset_password_email_label = new JLabel();
        reset_password_email = new JTextField();
        reset_password_title = new JLabel();
        reset_password_button = new JButton();
        go_back_to_login_button = new JButton();
        reset_password_description = new JLabel();
        login_panel = new JPanel();
        go_to_reset_password_label = new JLabel();
        go_to_reset_password_button = new JButton();
        login_username_label = new JLabel();
        login_password_label = new JLabel();
        login_username_input = new JTextField();
        login_password_input = new JPasswordField();
        login_title = new JLabel();
        login_button = new JButton();
        go_to_signup_button = new JButton();
        go_to_signup_label = new JLabel();
        login_separator = new JSeparator();

        signup_panel.setBackground(new java.awt.Color(255, 255, 255));
        login_panel.setBackground(new java.awt.Color(255, 255, 255));
        reset_password_panel.setBackground(new java.awt.Color(255, 255, 255));

        signup_panel.setName(""); // NOI18N

        signup_username_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signup_username_label.setText("Username:");

        signup_password_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signup_password_label.setText("Password:");

        signup_password_input.setText("jPasswordField1");

        signup_title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        signup_title.setForeground(new java.awt.Color(102, 153, 255));
        signup_title.setText("Sign Up");
        signup_title.setIconTextGap(10);

        signup_button.setBackground(new java.awt.Color(153, 204, 255));
        signup_button.setText("Sign Up");
        signup_button.addActionListener(e -> signupButton());

        go_to_login_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_login_button.setText("Log In");
        go_to_login_button.addActionListener(e -> goToLogin());

        go_to_login_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        go_to_login_label.setText("Already had account?");

        signup_email_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signup_email_label.setText("Email:");

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

        reset_password_email_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reset_password_email_label.setText("Email:");

        reset_password_title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        reset_password_title.setForeground(new java.awt.Color(102, 153, 255));
        reset_password_title.setText("Reset Password");
        reset_password_title.setIconTextGap(10);

        reset_password_button.setBackground(new java.awt.Color(153, 204, 255));
        reset_password_button.setText("Submit");
        reset_password_button.addActionListener(e -> resetPassword());

        go_back_to_login_button.setBackground(new java.awt.Color(153, 204, 255));
        go_back_to_login_button.setText("Go Back");
        go_back_to_login_button.addActionListener(e -> goToLogin());

        reset_password_description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reset_password_description.setText("Please enter the email that linked to your account.");

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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        login_panel.setForeground(new java.awt.Color(255, 255, 255));

        go_to_reset_password_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        go_to_reset_password_label.setText("Forget password?");

        go_to_reset_password_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_reset_password_button.setText("Reset Password");
        go_to_reset_password_button.setActionCommand("Reset");
        go_to_reset_password_button.addActionListener(e -> goToResetPassword());

        login_username_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        login_username_label.setText("Username:");

        login_password_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        login_password_label.setText("Password:");

        login_title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        login_title.setForeground(new java.awt.Color(102, 153, 255));
        login_title.setText("Log In");
        login_title.setIconTextGap(10);

        login_button.setBackground(new java.awt.Color(153, 204, 255));
        login_button.setText("Submit");
        login_button.addActionListener(e -> loginButton());

        go_to_signup_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_signup_button.setText("Sign Up");
        go_to_signup_button.addActionListener(e -> goToSignUp());

        go_to_signup_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        go_to_signup_label.setText("Don't have account yet?");

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
                                                                .addGroup(login_panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(login_password_input, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(login_username_input, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
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
        pack();

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
        JLabel fullname_label = new JLabel();
        JLabel birthdate_label = new JLabel();
        JLabel address_label = new JLabel();
        JLabel gender_label = new JLabel();
        JTextField fullname_input = new JTextField();
        JTextField address_input = new JTextField();
        JTextField birthdate_input = new JTextField();
        JComboBox<String> gender_input = new JComboBox<>(new String[]{"Male", "Female"});
        JButton submit_button = new JButton();

        newWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        navigator.setBackground(new java.awt.Color(153, 204, 255));

        title.setFont(new java.awt.Font("Segoe UI", 1, 24));
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Sign Up Information");

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

        fullname_label.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        fullname_label.setText("Fullname:");

        birthdate_label.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        birthdate_label.setText("Birthdate:");

        address_label.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        address_label.setText("Address:");

        gender_label.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        gender_label.setText("Gender");

        birthdate_input.setText("dd/mm/yyyy");
        
        submit_button.setBackground(new java.awt.Color(153, 204, 255));
        submit_button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        submit_button.setForeground(new java.awt.Color(255, 255, 255));
        submit_button.setText("Submit");

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
        System.out.println("log in submitted");
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
            java.util.logging.Logger.getLogger(authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new authentication().setVisible(true);
        });
    }
}
