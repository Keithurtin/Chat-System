import java.awt.event.ActionEvent;
import javax.swing.*;

public class NewWindow {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Main window (frame)
            JFrame mainFrame = new JFrame("Main Window");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(300, 200);
            mainFrame.setLayout(null);

            // Button to open new window
            JButton openButton = new JButton("Open New Window");
            openButton.setBounds(80, 60, 140, 30);

            // Add action listener to open the new window when clicked
            openButton.addActionListener((ActionEvent e) -> {
                openNewWindow();
            });

            // Add button to main frame
            mainFrame.add(openButton);
            mainFrame.setVisible(true);
        });
    }

    // Method to create and display a new window
    private static void openNewWindow() {
        JFrame newWindow = new JFrame("New Window");
        newWindow.setSize(250, 150);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel messageLabel = new JLabel("This is a new window!", SwingConstants.CENTER);
        newWindow.add(messageLabel);

        newWindow.setVisible(true);
    }
}
