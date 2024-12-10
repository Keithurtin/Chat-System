package presentation;

import javax.swing.*;
import java.awt.*;

public class chat {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(chat::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Main frame
        JFrame frame = new JFrame("Chat App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        // Panel for chat messages
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        chatPanel.setBackground(Color.WHITE);

        // Scroll pane for chat messages
        JScrollPane scrollPane = new JScrollPane(chatPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add some sample messages
        addMessage(chatPanel, "John", "Hello there!", false);
        addMessage(chatPanel, "Me", "Hi John! How are you?", true);
        addMessage(chatPanel, "John", "I'm good, thanks! What about you?", false);

        // Add scroll pane to frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void addMessage(JPanel chatPanel, String sender, String message, boolean isMe) {
        // Create a panel for the message
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        messagePanel.setOpaque(false);

        // Name label
        JLabel nameLabel = new JLabel(sender);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        nameLabel.setForeground(Color.GRAY);

        // Message label
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Style the message bubble
        if (isMe) {
            messageLabel.setBackground(new Color(173, 216, 230));
            messagePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            messagePanel.add(messageLabel);
        } else {
            messageLabel.setBackground(new Color(211, 211, 211));
            GroupLayout navigatorLayout = new GroupLayout(messagePanel);
            messagePanel.setLayout(navigatorLayout);
            navigatorLayout.setHorizontalGroup(
                    navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addGroup(navigatorLayout.createSequentialGroup()
                                    .addComponent(messageLabel)
                                    .addContainerGap(112, Short.MAX_VALUE))
            );
            navigatorLayout.setVerticalGroup(
                    navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(navigatorLayout.createSequentialGroup()
                                    .addComponent(nameLabel)
                                    .addComponent(messageLabel)
                                    .addContainerGap(8, Short.MAX_VALUE))
            );
        }


        messageLabel.setOpaque(true);

        // Add the name and message to the chat panel
        chatPanel.add(messagePanel);

        // Refresh the chat panel
        chatPanel.revalidate();
        chatPanel.repaint();
    }
}

