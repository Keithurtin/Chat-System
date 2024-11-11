import java.awt.*;
import javax.swing.*;

public class logIn_signUp_GUI extends JFrame {
    private final JPanel mainPanel;
    private final CardLayout cardLayout;
    private JPanel loginPanel, signupPanel, resetPasswordPanel;

    private JTextField loginUsernameField, inputUsernameField;
    private JPasswordField loginPasswordField;
    private JTextField signupFullNameField, signupUsernameField;
    private JPasswordField signupPasswordField, signupConfirmPasswordField;

    public logIn_signUp_GUI() {
        setTitle("Login/Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        createLoginPanel();
        createResetPasswordPanel();
        createSignupPanel();

        mainPanel.add(loginPanel, "login");
        mainPanel.add(signupPanel, "signup");
        mainPanel.add(resetPasswordPanel, "resetPassword");

        add(mainPanel);
        cardLayout.show(mainPanel, "login");

        setVisible(true);
    }

    private void createLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel loginTitle = new JLabel("Log In", SwingConstants.CENTER);
        loginTitle.setFont(new Font("Serif", Font.BOLD, 22));
        loginPanel.add(loginTitle);

        loginUsernameField = createInputField();
        loginPasswordField = createPasswordField();
        JButton resetPassword = new JButton("reset");
        

        loginPanel.add(Box.createVerticalStrut(15));
        loginPanel.add(createLabeledField("Username:", loginUsernameField));
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(createLabeledField("Password:", loginPasswordField));
        loginPanel.add(Box.createVerticalStrut(20));
        loginPanel.add(createLabeledField("Foget Password?", resetPassword));
        loginPanel.add(Box.createVerticalStrut(20));

        JPanel loginButtonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton goToSignupButton = new JButton("Sign Up");
        loginButtonPanel.add(loginButton);
        loginButtonPanel.add(goToSignupButton);
        loginPanel.add(loginButtonPanel);

        loginButton.addActionListener(e -> System.out.println("Login button clicked"));
        resetPassword.addActionListener(e -> cardLayout.show(mainPanel, "resetPassword"));
        goToSignupButton.addActionListener(e -> cardLayout.show(mainPanel, "signup"));
    }

    private void createResetPasswordPanel() {
        resetPasswordPanel = new JPanel();
        resetPasswordPanel.setLayout(new BoxLayout(resetPasswordPanel, BoxLayout.Y_AXIS));
        resetPasswordPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel resetPasswordTitle = new JLabel("Reset Password", SwingConstants.CENTER);
        resetPasswordPanel.setFont(new Font("Serif", Font.BOLD, 22));
        resetPasswordPanel.add(resetPasswordTitle);

        inputUsernameField = createInputField();
        resetPasswordPanel.add(Box.createVerticalStrut(15));
        resetPasswordPanel.add(createLabeledField("Email:", inputUsernameField));
        JLabel resetPasswordText = new JLabel("Please enter email that linked to your account", SwingConstants.LEFT);
        resetPasswordText.setFont(new Font("Serif", Font.PLAIN, 16));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(resetPasswordText);
        resetPasswordPanel.add(panel);

        JPanel resetPasswordButtonPanel = new JPanel();
        JButton  resetPasswordButton = new JButton("Submit");
        JButton  resetPasswordGoBackButton = new JButton("Go back");
        resetPasswordButtonPanel.add(resetPasswordGoBackButton);
        resetPasswordButtonPanel.add(resetPasswordButton);
        resetPasswordPanel.add(resetPasswordButtonPanel);

        resetPasswordButton.addActionListener(e -> System.out.println("reset password button clicked"));
        resetPasswordGoBackButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));
    }

    private void createSignupPanel() {
        signupPanel = new JPanel();
        signupPanel.setLayout(new BoxLayout(signupPanel, BoxLayout.Y_AXIS));
        signupPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel signupTitle = new JLabel("Sign Up", SwingConstants.CENTER);
        signupTitle.setFont(new Font("Serif", Font.BOLD, 22));
        signupPanel.add(signupTitle);

        signupFullNameField = createInputField();
        signupUsernameField = createInputField();
        signupPasswordField = createPasswordField();
        signupConfirmPasswordField = createPasswordField();

        signupPanel.add(Box.createVerticalStrut(15));
        signupPanel.add(createLabeledField("Full Name:", signupFullNameField));
        signupPanel.add(Box.createVerticalStrut(10));
        signupPanel.add(createLabeledField("Username:", signupUsernameField));
        signupPanel.add(Box.createVerticalStrut(10));
        signupPanel.add(createLabeledField("Password:", signupPasswordField));
        signupPanel.add(Box.createVerticalStrut(10));
        signupPanel.add(createLabeledField("Confirm Password:", signupConfirmPasswordField));
        signupPanel.add(Box.createVerticalStrut(20));

        JPanel signupButtonPanel = new JPanel();
        JButton signupButton = new JButton("Sign Up");
        JButton goToLoginButton = new JButton("Login");
        signupButtonPanel.add(signupButton);
        signupButtonPanel.add(goToLoginButton);
        signupPanel.add(signupButtonPanel);

        signupButton.addActionListener(e -> System.out.println("Sign Up button clicked"));

        goToLoginButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));
    }

    private JPanel createLabeledField(String labelText, JComponent inputField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(130, 25));
        panel.add(label);
        panel.add(inputField);
        return panel;
    }

    private JTextField createInputField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 25));
        return textField;
    }

    private JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 25));
        return passwordField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new logIn_signUp_GUI());
    }
}
