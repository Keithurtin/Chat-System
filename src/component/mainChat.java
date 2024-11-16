package component;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class mainChat extends JFrame {
    private JPanel chatPanel;
    private CardLayout cardLayout;   

    private JPanel side_panel;
    private JScrollPane side_scroll;
    private JPanel friend_side;
    private GroupLayout.ParallelGroup horizontalGroup;
    private GroupLayout.SequentialGroup verticalGroup;

    private final JPanel blank_chat_panel;
    
    public mainChat() {

        setupSideLayout();

        cardLayout = new CardLayout();
        chatPanel = new JPanel(cardLayout);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        blank_chat_panel = createBlankChat("Blank Chat...");

        chatPanel.add(blank_chat_panel, "blankChat");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(side_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(side_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chatPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setResizable(false); 
        setLocation(400, 150);
        pack();
        // chatPanel.add(group_chat_panel, "groupChat");
        // chatPanel.add(friend_chat_panel, "friendChat");
        
    }

    private void setupSideLayout() {
        side_panel = new JPanel();
        JPanel side_navigator = new JPanel();
        friend_side = new JPanel();
        JTextField side_search_input = new JTextField("Search");
        JButton side_search_button = new JButton("Search");
        JButton side_sort_button = new JButton("Sort");
        JButton side_more_button = new JButton("...");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        side_panel.setBackground(new java.awt.Color(255, 255, 255));

        side_navigator.setBackground(new java.awt.Color(153, 204, 255));
        side_navigator.setPreferredSize(new java.awt.Dimension(218, 70));

        JPopupMenu sort_menu = new JPopupMenu();

        JMenuItem group_only_button = new JMenuItem("Group");
        JMenuItem friend_only_button = new JMenuItem("Friend");
        JMenuItem sort_by_name_button = new JMenuItem("By Name");

        group_only_button.addActionListener(e -> sortGroup());
        friend_only_button.addActionListener(e -> sortFriend());
        sort_by_name_button.addActionListener(e -> sortByName());

        sort_menu.add(group_only_button);
        sort_menu.add(friend_only_button);
        sort_menu.add(sort_by_name_button);

        side_sort_button.addActionListener(e -> sort_menu.show(side_sort_button, 0, side_sort_button.getHeight()));

        JPopupMenu more_menu = new JPopupMenu();

        JMenuItem friend_request_button = new JMenuItem("Friend List");
        JMenuItem user_profile_button = new JMenuItem("Profile");

        friend_request_button.addActionListener(e -> openFriendRequest());
        user_profile_button.addActionListener(e -> openProfile());

        more_menu.add(friend_request_button);
        more_menu.add(user_profile_button);

        side_more_button.addActionListener(e -> more_menu.show(side_more_button, 0, side_more_button.getHeight()));

        javax.swing.GroupLayout side_navigatorLayout = new javax.swing.GroupLayout(side_navigator);
        side_navigator.setLayout(side_navigatorLayout);
        side_navigatorLayout.setHorizontalGroup(
            side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_navigatorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_more_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_sort_button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        side_navigatorLayout.setVerticalGroup(
            side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_sort_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_more_button, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(side_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        friend_side = new JPanel();
        GroupLayout friend_sideLayout = new GroupLayout(friend_side);
        friend_side.setLayout(friend_sideLayout);

        horizontalGroup = friend_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        verticalGroup = friend_sideLayout.createSequentialGroup();

        friend_sideLayout.setHorizontalGroup(
            friend_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(horizontalGroup)
        );

        friend_sideLayout.setVerticalGroup(
            friend_sideLayout.createSequentialGroup()
                .addGroup(verticalGroup)
        );

        side_scroll = new JScrollPane(friend_side);
        side_scroll.setBorder(null);

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

        addGroupToList("AbC", true, true);
        addGroupToList("ADC", false, true);
        addGroupToList("ABC", true, false);
    }

    private void addGroupToList(String name, boolean isOn, boolean isFriend) {
        friend friend_panel = new friend(name, isOn, isFriend);

        horizontalGroup.addComponent(friend_panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE);
        verticalGroup.addComponent(friend_panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);

        friend_side.add(friend_panel);
        friend_side.revalidate();
        friend_side.repaint();
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

    private void sortByName() {}

    private void sortFriend() {}

    private void sortGroup() {}

    private void openProfile() {}

    private void openFriendRequest() {}

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new mainChat().setVisible(true));
    }

}