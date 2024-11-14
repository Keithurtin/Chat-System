import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainChat extends JFrame {
    private JPanel chatPanel;
    private CardLayout cardLayout;   

    private final JPanel side_panel;
    private final JPanel side_navigator;
    private final JButton side_more_button;
    private final JScrollPane side_scroll;
    private final JButton side_search_button;
    private final JTextField side_search_input;
    private final JButton side_sort_button;
    private final JPanel blank_chat_panel;
    private final JPanel friend_side;
    // private groupChatSection;
    // private friendChatSection;
    
    public mainChat() {
        cardLayout = new CardLayout();
        side_panel = new JPanel();
        side_navigator = new JPanel();
        friend_side = new JPanel();
        side_search_input = new JTextField();
        side_search_button = new JButton();
        side_sort_button = new JButton();
        side_more_button = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        side_panel.setBackground(new java.awt.Color(255, 255, 255));

        side_navigator.setBackground(new java.awt.Color(153, 204, 255));
        side_navigator.setPreferredSize(new java.awt.Dimension(218, 70));

        side_search_input.setText("Search");

        side_search_button.setText("search");

        side_sort_button.setText("  sort   ");

        JPopupMenu sort_menu = new JPopupMenu();

        JMenuItem group_only_button = new JMenuItem("Group");
        JMenuItem friend_only_button = new JMenuItem("Friend");
        JMenuItem sort_by_name_button = new JMenuItem("By Name");

        group_only_button.addActionListener(this::sortGroup);
        friend_only_button.addActionListener(this::sortFriend);
        sort_by_name_button.addActionListener(this::sortByName);

        sort_menu.add(group_only_button);
        sort_menu.add(friend_only_button);
        sort_menu.add(sort_by_name_button);

        side_sort_button.addActionListener(e -> sort_menu.show(side_sort_button, 0, side_sort_button.getHeight()));

        side_more_button.setText("...");

        JPopupMenu more_menu = new JPopupMenu();

        JMenuItem friend_request_button = new JMenuItem("Friend List");
        JMenuItem user_profile_button = new JMenuItem("Profile");

        friend_request_button.addActionListener(this::openFriendRequest);
        user_profile_button.addActionListener(this::openProfile);

        more_menu.add(friend_request_button);
        more_menu.add(user_profile_button);

        side_more_button.addActionListener(e -> more_menu.show(side_more_button, 0, side_more_button.getHeight()));

        GroupLayout side_navigatorLayout = new GroupLayout(side_navigator);
        side_navigator.setLayout(side_navigatorLayout);
        side_navigatorLayout.setHorizontalGroup(
            side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(side_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(side_navigatorLayout.createSequentialGroup()
                        .addComponent(side_search_input, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(side_search_button, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                    .addGroup(side_navigatorLayout.createSequentialGroup()
                        .addComponent(side_more_button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(side_sort_button)))
                .addContainerGap())
        );
        side_navigatorLayout.setVerticalGroup(
            side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, side_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(side_more_button)
                    .addComponent(side_sort_button))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(side_search_button)
                    .addComponent(side_search_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        friend_side.setLayout(new BoxLayout(friend_side, BoxLayout.Y_AXIS));

        side_scroll = new JScrollPane(friend_side);
        side_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
        side_scroll.getVerticalScrollBar().setValue(side_scroll.getVerticalScrollBar().getMaximum());

        side_scroll.setViewportView(friend_side);

        GroupLayout side_panelLayout = new GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(side_navigator, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addComponent(side_scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addComponent(side_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(side_scroll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chatPanel = new JPanel(cardLayout);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        blank_chat_panel = createBlankChat("Blank Chat...");

        chatPanel.add(blank_chat_panel, "blankChat");
        // chatPanel.add(group_chat_panel, "groupChat");
        // chatPanel.add(friend_chat_panel, "friendChat");
        
    }

    private void addChatPanel(JPanel friend_chat_panel, String name) {
        JPanel friend_panel = new JPanel();
        friend_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(friend_chat_panel, name);
            }
        });
    }

    JPanel createBlankChat(String label){
        JPanel blank_chat = new JPanel();
        JPanel blank_chat_navigator = new JPanel();
        JLabel blank_chat_label = new JLabel();
        JLabel blank_chat_description = new JLabel();

        blank_chat.setBackground(new java.awt.Color(255, 255, 255));

        blank_chat_navigator.setBackground(new java.awt.Color(153, 204, 255));
        blank_chat_navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        GroupLayout blank_chat_navigatorLayout = new GroupLayout(blank_chat_navigator);
        blank_chat_navigator.setLayout(blank_chat_navigatorLayout);
        blank_chat_navigatorLayout.setHorizontalGroup(
            blank_chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        blank_chat_navigatorLayout.setVerticalGroup(
            blank_chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        blank_chat_label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        blank_chat_label.setText(label);

        blank_chat_description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        blank_chat_description.setText("Please choose one chat room or create new chat");

        GroupLayout blank_chatLayout = new GroupLayout(blank_chat);
        blank_chat.setLayout(blank_chatLayout);
        blank_chatLayout.setHorizontalGroup(
            blank_chatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(blank_chat_navigator, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(blank_chatLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(blank_chat_description)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, blank_chatLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(blank_chat_label)
                .addGap(196, 196, 196))
        );
        blank_chatLayout.setVerticalGroup(
            blank_chatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(blank_chatLayout.createSequentialGroup()
                .addComponent(blank_chat_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(blank_chat_label, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blank_chat_description)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        return blank_chat;
    }

    private void sortByName(ActionEvent e) {}

    private void sortFriend(ActionEvent e) {}

    private void sortGroup(ActionEvent e) {}

    private void openProfile(ActionEvent e) {}

    private void openFriendRequest(ActionEvent e) {}

    private void addChatPanel() {}

}