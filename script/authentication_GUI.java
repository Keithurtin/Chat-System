import java.awt.*;
import javax.swing.*;

public class authentication_GUI extends javax.swing.JFrame {

    private JPanel main_panel;
    private CardLayout card_layout;             
    private JLabel description;
    private JLabel email_label;
    private JLabel forget_password_label;
    private JButton go_back_to_login_button;
    private JButton go_to_login_button;
    private JButton go_to_reset_password_button;
    private JButton go_to_signup_button;
    private JLabel go_to_signup_buttonLabel;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JButton login_button;
    private JPanel login_panel;
    private JPasswordField login_password_input;
    private JLabel login_title;
    private JTextField login_user_input;
    private JLabel password_label;
    private JButton reset_password_button;
    private JTextField reset_password_email;
    private JPanel reset_password_panel;
    private JLabel reset_password_title;
    private JButton signup_button;
    private JTextField signup_email_input;
    private JPanel signup_panel;
    private JPasswordField signup_password_input;
    private JLabel signup_title;
    private JTextField signup_user_input;
    private JLabel username_label; 

    public authentication_GUI() {
        initComponents();
    }
    @SuppressWarnings("unchecked")                       
    private void initComponents() {
        signup_panel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        signup_user_input = new javax.swing.JTextField();
        signup_password_input = new javax.swing.JPasswordField();
        signup_title = new javax.swing.JLabel();
        signup_button = new javax.swing.JButton();
        go_to_login_button = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        signup_email_input = new javax.swing.JTextField();
        reset_password_panel = new javax.swing.JPanel();
        email_label = new javax.swing.JLabel();
        reset_password_email = new javax.swing.JTextField();
        reset_password_title = new javax.swing.JLabel();
        reset_password_button = new javax.swing.JButton();
        go_back_to_login_button = new javax.swing.JButton();
        description = new javax.swing.JLabel();
        login_panel = new javax.swing.JPanel();
        forget_password_label = new javax.swing.JLabel();
        go_to_reset_password_button = new javax.swing.JButton();
        username_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        login_user_input = new javax.swing.JTextField();
        login_password_input = new javax.swing.JPasswordField();
        login_title = new javax.swing.JLabel();
        login_button = new javax.swing.JButton();
        go_to_signup_button = new javax.swing.JButton();
        go_to_signup_buttonLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        signup_panel.setName(""); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Username:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Password:");

        signup_user_input.addActionListener(evt -> signup_user_inputActionPerformed(evt));

        signup_password_input.setText("jPasswordField1");
        signup_password_input.addActionListener(evt -> signup_password_inputActionPerformed(evt));

        signup_title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        signup_title.setForeground(new java.awt.Color(102, 153, 255));
        signup_title.setText("Sign Up");
        signup_title.setIconTextGap(10);

        signup_button.setBackground(new java.awt.Color(153, 204, 255));
        signup_button.setText("Sign Up");
        signup_button.addActionListener(evt -> signup_buttonActionPerformed(evt));

        go_to_login_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_login_button.setText("Log In");
        go_to_login_button.addActionListener(evt -> go_to_login_buttonActionPerformed(evt));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Already had account?");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Email:");

        signup_email_input.addActionListener(evt -> signup_email_inputActionPerformed(evt));

        javax.swing.GroupLayout signup_panelLayout = new javax.swing.GroupLayout(signup_panel);
        signup_panel.setLayout(signup_panelLayout);
        signup_panelLayout.setHorizontalGroup(
            signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signup_panelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(signup_panelLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(signup_button)
                                .addComponent(signup_password_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signup_panelLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(signup_email_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signup_panelLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(26, 26, 26)
                            .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(signup_user_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(signup_panelLayout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(signup_title)))))
                    .addGroup(signup_panelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
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
                    .addComponent(jLabel7)
                    .addComponent(signup_user_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(signup_email_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(signup_password_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(signup_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signup_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(go_to_login_button))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        email_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        email_label.setText("Email:");

        reset_password_title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        reset_password_title.setForeground(new java.awt.Color(102, 153, 255));
        reset_password_title.setText("Reset Password");
        reset_password_title.setIconTextGap(10);

        reset_password_button.setBackground(new java.awt.Color(153, 204, 255));
        reset_password_button.setText("Submit");
        reset_password_button.addActionListener(evt -> reset_password_buttonActionPerformed(evt));

        go_back_to_login_button.setBackground(new java.awt.Color(153, 204, 255));
        go_back_to_login_button.setText("Go Back");
        go_back_to_login_button.addActionListener(evt -> go_to_login_buttonActionPerformed(evt));

        description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        description.setText("Please enter the email that linked to your account.");

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
                                .addComponent(email_label)
                                .addGap(37, 37, 37)
                                .addComponent(reset_password_email))
                            .addComponent(description))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        reset_password_panelLayout.setVerticalGroup(
            reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reset_password_panelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(reset_password_title)
                .addGap(31, 31, 31)
                .addGroup(reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_label)
                    .addComponent(reset_password_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(description)
                .addGap(53, 53, 53)
                .addGroup(reset_password_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(go_back_to_login_button)
                    .addComponent(reset_password_button))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        login_panel.setForeground(new java.awt.Color(255, 255, 255));

        forget_password_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        forget_password_label.setText("Forget password?");

        go_to_reset_password_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_reset_password_button.setText("Reset Password");
        go_to_reset_password_button.setActionCommand("Reset");
        go_to_reset_password_button.addActionListener(evt -> go_to_reset_password_buttonActionPerformed(evt));

        username_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        username_label.setText("Username:");

        password_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        password_label.setText("Password:");

        login_user_input.addActionListener((java.awt.event.ActionEvent evt) -> {
            login_user_inputActionPerformed(evt);
        });

        login_password_input.addActionListener((java.awt.event.ActionEvent evt) -> {
            login_password_inputActionPerformed(evt);
        });

        login_title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        login_title.setForeground(new java.awt.Color(102, 153, 255));
        login_title.setText("Log In");
        login_title.setIconTextGap(10);

        login_button.setBackground(new java.awt.Color(153, 204, 255));
        login_button.setText("Submit");
        login_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            login_buttonActionPerformed(evt);
        });

        go_to_signup_button.setBackground(new java.awt.Color(153, 204, 255));
        go_to_signup_button.setText("Sign Up");
        go_to_signup_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            go_to_signup_buttonActionPerformed(evt);
        });

        go_to_signup_buttonLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        go_to_signup_buttonLabel.setText("Don't have account yet?");

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
                                    .addComponent(username_label)
                                    .addComponent(password_label))
                                .addGap(26, 26, 26)
                                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(login_password_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(login_user_input, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(login_panelLayout.createSequentialGroup()
                                .addComponent(go_to_signup_buttonLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(go_to_signup_button))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(login_panelLayout.createSequentialGroup()
                                .addComponent(forget_password_label)
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
                    .addComponent(username_label)
                    .addComponent(login_user_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_label)
                    .addComponent(login_password_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(login_button)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(go_to_signup_buttonLabel)
                    .addComponent(go_to_signup_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forget_password_label)
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

    private void signup_user_inputActionPerformed(java.awt.event.ActionEvent evt) {                                                

    }                                               

    private void signup_password_inputActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void signup_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.out.println("sign up submitted");
    }                                            

    private void go_to_login_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        card_layout.show(main_panel, "login_panel");
    }                                         

    private void signup_email_inputActionPerformed(java.awt.event.ActionEvent evt) {                                                 

    }                                                

    private void reset_password_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        System.out.println("request reset password submitted");
    }                                                                                             

    private void go_to_reset_password_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        card_layout.show(main_panel, "reset_password_panel");
    }                                                 

    private void login_user_inputActionPerformed(java.awt.event.ActionEvent evt) {                                               

    }                                              

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        System.out.println("log in submitted");
    }                                           

    private void go_to_signup_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        card_layout.show(main_panel, "signup_panel");
    }                                          

    private void login_password_inputActionPerformed(java.awt.event.ActionEvent evt) {}                                              

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(authentication_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new authentication_GUI().setVisible(true);
        });
    }    
}
