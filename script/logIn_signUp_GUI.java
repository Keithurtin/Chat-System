import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logIn_signUp_GUI extends javax.swing.JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;             
    private JLabel description;
    private JLabel emailLabel;
    private JLabel forgetPasswordLabel;
    private JButton goBackToLogin;
    private JButton goToLogin;
    private JButton goToResetPassword;
    private JButton goToSignUp;
    private JLabel goToSignUpLabel;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPasswordField loginPassInput;
    private JLabel loginTitle;
    private JTextField loginUserInput;
    private JLabel passwordLabel;
    private JButton resetPasswordButton;
    private JTextField resetPasswordEmail;
    private JPanel resetPasswordPanel;
    private JLabel resetPasswordTitle;
    private JButton signupButton;
    private JTextField signupEmailInput;
    private JPanel signupPanel;
    private JPasswordField signupPasswordInput;
    private JLabel signupTitle;
    private JTextField signupUserInput;
    private JLabel usernameLabel; 

    public logIn_signUp_GUI() {
        initComponents();
    }
    @SuppressWarnings("unchecked")                       
    private void initComponents() {
        signupPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        signupUserInput = new javax.swing.JTextField();
        signupPasswordInput = new javax.swing.JPasswordField();
        signupTitle = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        goToLogin = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        signupEmailInput = new javax.swing.JTextField();
        resetPasswordPanel = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        resetPasswordEmail = new javax.swing.JTextField();
        resetPasswordTitle = new javax.swing.JLabel();
        resetPasswordButton = new javax.swing.JButton();
        goBackToLogin = new javax.swing.JButton();
        description = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        forgetPasswordLabel = new javax.swing.JLabel();
        goToResetPassword = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        loginUserInput = new javax.swing.JTextField();
        loginPassInput = new javax.swing.JPasswordField();
        loginTitle = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        goToSignUp = new javax.swing.JButton();
        goToSignUpLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        signupPanel.setName(""); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Username:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Password:");

        signupUserInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupUserInputActionPerformed(evt);
            }
        });

        signupPasswordInput.setText("jPasswordField1");
        signupPasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupPasswordInputActionPerformed(evt);
            }
        });

        signupTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        signupTitle.setForeground(new java.awt.Color(102, 153, 255));
        signupTitle.setText("Sign Up");
        signupTitle.setIconTextGap(10);

        signupButton.setBackground(new java.awt.Color(153, 204, 255));
        signupButton.setText("Sign Up");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        goToLogin.setBackground(new java.awt.Color(153, 204, 255));
        goToLogin.setText("Log In");
        goToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToLoginActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Already had account?");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Email:");

        signupEmailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupEmailInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout signupPanelLayout = new javax.swing.GroupLayout(signupPanel);
        signupPanel.setLayout(signupPanelLayout);
        signupPanelLayout.setHorizontalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(signupPanelLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(signupButton)
                                .addComponent(signupPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signupPanelLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(signupEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signupPanelLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(26, 26, 26)
                            .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(signupUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(signupPanelLayout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(signupTitle)))))
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(goToLogin)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        signupPanelLayout.setVerticalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(signupTitle)
                .addGap(18, 18, 18)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(signupUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(signupEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(signupPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(signupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(goToLogin))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailLabel.setText("Email:");

        resetPasswordTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        resetPasswordTitle.setForeground(new java.awt.Color(102, 153, 255));
        resetPasswordTitle.setText("Reset Password");
        resetPasswordTitle.setIconTextGap(10);

        resetPasswordButton.setBackground(new java.awt.Color(153, 204, 255));
        resetPasswordButton.setText("Submit");
        resetPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPasswordButtonActionPerformed(evt);
            }
        });

        goBackToLogin.setBackground(new java.awt.Color(153, 204, 255));
        goBackToLogin.setText("Go Back");
        goBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackToLoginActionPerformed(evt);
            }
        });

        description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        description.setText("Please enter the email that linked to your account.");

        javax.swing.GroupLayout resetPasswordPanelLayout = new javax.swing.GroupLayout(resetPasswordPanel);
        resetPasswordPanel.setLayout(resetPasswordPanelLayout);
        resetPasswordPanelLayout.setHorizontalGroup(
            resetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                .addGroup(resetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addComponent(resetPasswordTitle))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resetPasswordPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(goBackToLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(resetPasswordButton)
                            .addGap(12, 12, 12)))
                    .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(resetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addGap(37, 37, 37)
                                .addComponent(resetPasswordEmail))
                            .addComponent(description))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        resetPasswordPanelLayout.setVerticalGroup(
            resetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resetPasswordPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(resetPasswordTitle)
                .addGap(31, 31, 31)
                .addGroup(resetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(resetPasswordEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(description)
                .addGap(53, 53, 53)
                .addGroup(resetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goBackToLogin)
                    .addComponent(resetPasswordButton))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginPanel.setForeground(new java.awt.Color(255, 255, 255));

        forgetPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        forgetPasswordLabel.setText("Forget password?");

        goToResetPassword.setBackground(new java.awt.Color(153, 204, 255));
        goToResetPassword.setText("Reset Password");
        goToResetPassword.setActionCommand("Reset");
        goToResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToResetPasswordActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordLabel.setText("Password:");

        loginUserInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUserInputActionPerformed(evt);
            }
        });

        loginPassInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPassInputActionPerformed(evt);
            }
        });

        loginTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        loginTitle.setForeground(new java.awt.Color(102, 153, 255));
        loginTitle.setText("Log In");
        loginTitle.setIconTextGap(10);

        loginButton.setBackground(new java.awt.Color(153, 204, 255));
        loginButton.setText("Submit");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        goToSignUp.setBackground(new java.awt.Color(153, 204, 255));
        goToSignUp.setText("Sign Up");
        goToSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToSignUpActionPerformed(evt);
            }
        });

        goToSignUpLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        goToSignUpLabel.setText("Don't have account yet?");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameLabel)
                                    .addComponent(passwordLabel))
                                .addGap(26, 26, 26)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(loginPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(goToSignUpLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goToSignUp))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(forgetPasswordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(goToResetPassword))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(loginTitle))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(loginButton)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(loginTitle)
                .addGap(18, 18, 18)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(loginUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(loginPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goToSignUpLabel)
                    .addComponent(goToSignUp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgetPasswordLabel)
                    .addComponent(goToResetPassword))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pack();

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.add(loginPanel, "loginPanel");
        mainPanel.add(signupPanel, "signupPanel");
        mainPanel.add(resetPasswordPanel, "resetPasswordPanel");
         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        getContentPane().add(mainPanel);
        cardLayout.show(mainPanel, "loginPanel");
    }   

    // private void setPanel(javax.swing.GroupLayout layout, ) {

    // }                   

    private void signupUserInputActionPerformed(java.awt.event.ActionEvent evt) {                                                

    }                                               

    private void signupPasswordInputActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.out.println("sign up submitted");
    }                                            

    private void goToLoginActionPerformed(java.awt.event.ActionEvent evt) {                                          
        cardLayout.show(mainPanel, "loginPanel");
    }                                         

    private void signupEmailInputActionPerformed(java.awt.event.ActionEvent evt) {                                                 

    }                                                

    private void resetPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        System.out.println("request reset password submitted");
    }                                                   

    private void goBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {                                              
        cardLayout.show(mainPanel, "loginPanel");
    }                                             

    private void goToResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        cardLayout.show(mainPanel, "resetPasswordPanel");
    }                                                 

    private void loginUserInputActionPerformed(java.awt.event.ActionEvent evt) {                                               

    }                                              

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        System.out.println("log in submitted");
    }                                           

    private void goToSignUpActionPerformed(java.awt.event.ActionEvent evt) {                                           
        cardLayout.show(mainPanel, "signupPanel");
    }                                          

    private void loginPassInputActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(logIn_signUp_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logIn_signUp_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logIn_signUp_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logIn_signUp_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logIn_signUp_GUI().setVisible(true);
            }
        });
    }    
}
