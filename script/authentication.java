import java.awt.*;
import javax.swing.*;

public class authentication extends javax.swing.JFrame {

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
        signup_panel = new javax.swing.JPanel();
        signup_username_label = new javax.swing.JLabel();
        signup_password_label = new javax.swing.JLabel();
        signup_username_input = new javax.swing.JTextField();
        signup_password_input = new javax.swing.JPasswordField();
        signup_title = new javax.swing.JLabel();
        signup_button = new javax.swing.JButton();
        go_to_login_button = new javax.swing.JButton();
        go_to_login_label = new javax.swing.JLabel();
        signup_separator = new javax.swing.JSeparator();
        signup_email_label = new javax.swing.JLabel();
        signup_email_input = new javax.swing.JTextField();
        reset_password_panel = new javax.swing.JPanel();
        reset_password_email_label = new javax.swing.JLabel();
        reset_password_email = new javax.swing.JTextField();
        reset_password_title = new javax.swing.JLabel();
        reset_password_button = new javax.swing.JButton();
        go_back_to_login_button = new javax.swing.JButton();
        reset_password_description = new javax.swing.JLabel();
        login_panel = new javax.swing.JPanel();
         go_to_reset_password_label = new javax.swing.JLabel();
        go_to_reset_password_button = new javax.swing.JButton();
        login_username_label = new javax.swing.JLabel();
        login_password_label = new javax.swing.JLabel();
        login_username_input = new javax.swing.JTextField();
        login_password_input = new javax.swing.JPasswordField();
        login_title = new javax.swing.JLabel();
        login_button = new javax.swing.JButton();
        go_to_signup_button = new javax.swing.JButton();
         go_to_signup_label = new javax.swing.JLabel();
        login_separator = new javax.swing.JSeparator();

        signup_panel.setName(""); // NOI18N

        signup_username_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signup_username_label.setText("Username:");

        signup_password_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signup_password_label.setText("Password:");

        signup_username_input.addActionListener(this::signupUsernameInput);

        signup_password_input.setText("jPasswordField1");
        signup_password_input.addActionListener(this::signupPasswordInput);

        signup_title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        signup_title.setForeground(new java.awt.Color(102, 153, 255));
        signup_title.setText("Sign Up");
        signup_title.setIconTextGap(10);

        signup_button.setBackground(new java.awt.Color(153, 204, 255));
        signup_button.setText("Sign Up");
        signup_button.addActionListener(this::signupButton);

        go_to_login_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_login_button.setText("Log In");
        go_to_login_button.addActionListener(this::goToLogin);

        go_to_login_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        go_to_login_label.setText("Already had account?");

        signup_email_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signup_email_label.setText("Email:");

        signup_email_input.addActionListener(this::signupEmailInput);

        javax.swing.GroupLayout signup_panelLayout = new javax.swing.GroupLayout(signup_panel);
        signup_panel.setLayout(signup_panelLayout);
        signup_panelLayout.setHorizontalGroup(
            signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signup_panelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(signup_separator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(signup_panelLayout.createSequentialGroup()
                            .addComponent(signup_password_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(signup_button)
                                .addComponent(signup_password_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signup_panelLayout.createSequentialGroup()
                            .addComponent(signup_email_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(signup_email_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signup_panelLayout.createSequentialGroup()
                            .addComponent(signup_username_label)
                            .addGap(26, 26, 26)
                            .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(signup_username_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(signup_panelLayout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(signup_title)))))
                    .addGroup(signup_panelLayout.createSequentialGroup()
                        .addComponent(go_to_login_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(go_to_login_button)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        signup_panelLayout.setVerticalGroup(
            signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signup_panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(signup_title)
                .addGap(18, 18, 18)
                .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signup_username_label)
                    .addComponent(signup_username_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signup_email_label)
                    .addComponent(signup_email_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signup_password_label)
                    .addComponent(signup_password_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(signup_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signup_separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
        reset_password_button.addActionListener(this::resetPassword);

        go_back_to_login_button.setBackground(new java.awt.Color(153, 204, 255));
        go_back_to_login_button.setText("Go Back");
        go_back_to_login_button.addActionListener(this::goToLogin);

        reset_password_description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reset_password_description.setText("Please enter the email that linked to your account.");

        javax.swing.GroupLayout reset_password_panelLayout = new javax.swing.GroupLayout(reset_password_panel);
        reset_password_panel.setLayout(reset_password_panelLayout);
        reset_password_panelLayout.setHorizontalGroup(
            reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reset_password_panelLayout.createSequentialGroup()
                .addGroup(reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(reset_password_panelLayout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addComponent(reset_password_title))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reset_password_panelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(go_back_to_login_button)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(reset_password_button)
                            .addGap(12, 12, 12)))
                    .addGroup(reset_password_panelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(reset_password_panelLayout.createSequentialGroup()
                                .addComponent(reset_password_email_label)
                                .addGap(37, 37, 37)
                                .addComponent(reset_password_email))
                            .addComponent(reset_password_description))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        reset_password_panelLayout.setVerticalGroup(
            reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reset_password_panelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(reset_password_title)
                .addGap(31, 31, 31)
                .addGroup(reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_password_email_label)
                    .addComponent(reset_password_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(reset_password_description)
                .addGap(53, 53, 53)
                .addGroup(reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(go_back_to_login_button)
                    .addComponent(reset_password_button))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        login_panel.setForeground(new java.awt.Color(255, 255, 255));

         go_to_reset_password_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
         go_to_reset_password_label.setText("Forget password?");

        go_to_reset_password_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_reset_password_button.setText("Reset Password");
        go_to_reset_password_button.setActionCommand("Reset");
        go_to_reset_password_button.addActionListener(this::goToResetPassword);

        login_username_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        login_username_label.setText("Username:");

        login_password_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        login_password_label.setText("Password:");

        login_username_input.addActionListener(this::loginUsernameInput);

        login_password_input.addActionListener(this::loginPasswordInput);

        login_title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        login_title.setForeground(new java.awt.Color(102, 153, 255));
        login_title.setText("Log In");
        login_title.setIconTextGap(10);

        login_button.setBackground(new java.awt.Color(153, 204, 255));
        login_button.setText("Submit");
        login_button.addActionListener(this::loginButton);

        go_to_signup_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_signup_button.setText("Sign Up");
        go_to_signup_button.addActionListener(this::goToSignUp);

         go_to_signup_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
         go_to_signup_label.setText("Don't have account yet?");

        javax.swing.GroupLayout login_panelLayout = new javax.swing.GroupLayout(login_panel);
        login_panel.setLayout(login_panelLayout);
        login_panelLayout.setHorizontalGroup(
            login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_panelLayout.createSequentialGroup()
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(login_panelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(login_panelLayout.createSequentialGroup()
                                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(login_username_label)
                                    .addComponent(login_password_label))
                                .addGap(26, 26, 26)
                                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(login_password_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(login_username_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(login_panelLayout.createSequentialGroup()
                                .addComponent( go_to_signup_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(go_to_signup_button))
                            .addComponent(login_separator, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(login_panelLayout.createSequentialGroup()
                                .addComponent( go_to_reset_password_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(login_title)
                .addGap(18, 18, 18)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_username_label)
                    .addComponent(login_username_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_password_label)
                    .addComponent(login_password_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(login_button)
                .addGap(12, 12, 12)
                .addComponent(login_separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent( go_to_signup_label)
                    .addComponent(go_to_signup_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent( go_to_reset_password_label)
                    .addComponent(go_to_reset_password_button))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pack();

        card_layout = new CardLayout();
        main_panel = new JPanel(card_layout);
        main_panel.add(login_panel, "login_panel");
        main_panel.add(signup_panel, "signup_panel");
        main_panel.add(reset_password_panel, "reset_password_panel");
         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        getContentPane().add(main_panel);
        card_layout.show(main_panel, "login_panel");
    }                  

    private void signupUsernameInput(java.awt.event.ActionEvent evt) {}                                               

    private void signupPasswordInput(java.awt.event.ActionEvent evt) {}                                                   

    private void signupButton(java.awt.event.ActionEvent evt) {                                             
        System.out.println("sign up submitted");
    }                                            

    private void goToLogin(java.awt.event.ActionEvent evt) {                                          
        card_layout.show(main_panel, "login_panel");
    }                                         

    private void signupEmailInput(java.awt.event.ActionEvent evt) {}                                                

    private void resetPassword(java.awt.event.ActionEvent evt) {                                                    
        System.out.println("request reset password submitted");
    }                                                                                             

    private void goToResetPassword(java.awt.event.ActionEvent evt) {                                                  
        card_layout.show(main_panel, "reset_password_panel");
    }                                                 

    private void loginUsernameInput(java.awt.event.ActionEvent evt) {}                                              

    private void loginButton(java.awt.event.ActionEvent evt) {                                            
        System.out.println("log in submitted");
    }                                           

    private void goToSignUp(java.awt.event.ActionEvent evt) {                                           
        card_layout.show(main_panel, "signup_panel");
    }                                          

    private void loginPasswordInput(java.awt.event.ActionEvent evt) {}                                              

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new authentication().setVisible(true);
        });
    }    
}
