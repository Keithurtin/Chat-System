import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logIn_signUp_GUI extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JPanel loginPanel, signupPanel;

    private JTextField loginUsernameField;
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
        createSignupPanel();

        mainPanel.add(loginPanel, "login");
        mainPanel.add(signupPanel, "signup");

        add(mainPanel);
        cardLayout.show(mainPanel, "login");

        setVisible(true);
    }

    private void createLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Centered title for Login Panel
        JLabel loginTitle = new JLabel("Log In", SwingConstants.CENTER);
        loginTitle.setFont(new Font("Serif", Font.BOLD, 22));
        loginPanel.add(loginTitle);

        loginUsernameField = createInputField();
        loginPasswordField = createPasswordField();

        loginPanel.add(Box.createVerticalStrut(15));
        loginPanel.add(createLabeledField("Username:", loginUsernameField));
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(createLabeledField("Password:", loginPasswordField));
        loginPanel.add(Box.createVerticalStrut(20));

        JPanel loginButtonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton goToSignupButton = new JButton("Sign Up");
        loginButtonPanel.add(loginButton);
        loginButtonPanel.add(goToSignupButton);
        loginPanel.add(loginButtonPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login button clicked");
            }
        });

        goToSignupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "signup");
            }
        });
    }

    private void createSignupPanel() {
        signupPanel = new JPanel();
        signupPanel.setLayout(new BoxLayout(signupPanel, BoxLayout.Y_AXIS));
        signupPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Centered title for Signup Panel
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

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign Up button clicked");
            }
        });

        goToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "login");
            }
        });
    }

    private JPanel createLabeledField(String labelText, JComponent inputField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(130, 25));  // Static width for labels
        panel.add(label);
        panel.add(inputField);
        return panel;
    }

    private JTextField createInputField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 25));  // Static width and height
        return textField;
    }

    private JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 25));  // Static width and height
        return passwordField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new logIn_signUp_GUI());
    }
}
