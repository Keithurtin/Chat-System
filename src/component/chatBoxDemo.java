package component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chatBoxDemo extends JFrame {
 
    private JPanel chatPanel;
    private CardLayout cardLayout;
    private final JPanel friend_chat_panel;
    private final JLabel friend_name;
    private final JPanel friend_panel;
    private final JLabel friend_status;
    private final JLabel group_member_label;
    private final JLabel group_chat_label;
    private final JPanel group_chat_panel;
    private final JPanel group_panel;
    private final JPanel not_friend_panel;
    private final JLabel not_friend_name_label;
    private final JButton not_friend_send_request_button;
    private final JButton side_sort_button;
    private final JButton side_more_button;
    private final JPanel side_navigator;
    private final JPanel user_container;
    private final JPanel side_panel;
    private final JScrollPane side_scroll;
    private final JButton side_search_button;
    private final JTextField side_search_input;
    private final JLabel blank_chat_description;
    private final JLabel blank_chat_label;
    private final JPanel blank_chat_panel;
    private final JPanel blank_chat_navigator;

    private final JPanel group_list_panel;
    private final JPanel member1_panel;
    private final JPanel member2_panel;
    private final JPanel group_list_navigator;
    private final JLabel group_list_title;
    private final JLabel member1_name;
    private final JLabel member2_name;
    private final JLabel member1_status;
    private final JLabel member2_status;
    private final JButton member1_remove_button;
    private final JButton member2_remove_button;
    private final JButton group_list_sort_button;
    private final JButton group_list_search_button;
    private final JButton group_list_add_button;
    private final JTextField group_list_search_input;
    private final JPanel group_list_side;
    private final JScrollPane group_list_scroll;

    public chatBoxDemo() {

        group_list_panel = new JPanel();
        member1_panel = new JPanel();
        member2_panel = new JPanel();
        group_list_navigator  = new JPanel();
        group_list_title = new JLabel();
        member1_name = new JLabel();
        member2_name = new JLabel();
        member1_status = new JLabel();
        member2_status = new JLabel();
        member1_remove_button = new JButton();
        member2_remove_button = new JButton();
        group_list_sort_button = new JButton();
        group_list_search_button = new JButton();
        group_list_add_button = new JButton();
        group_list_search_input = new JTextField();
        group_list_side = new JPanel();
        side_panel = new JPanel();
        side_navigator = new JPanel();
        side_search_input = new JTextField();
        side_search_button = new JButton();
        side_sort_button = new JButton();
        side_more_button = new JButton();
        friend_panel = new JPanel();
        friend_name = new JLabel();
        friend_status = new JLabel();
        group_panel = new JPanel();
        group_chat_label = new JLabel();
        group_member_label = new JLabel();
        not_friend_panel = new JPanel();
        not_friend_name_label = new JLabel();
        not_friend_send_request_button = new JButton();
        user_container = new JPanel();
        blank_chat_panel = new JPanel();
        blank_chat_navigator = new JPanel();
        blank_chat_label = new JLabel();
        blank_chat_description = new JLabel();
        group_chat_panel = new groupChatSection("Group 1", 12);
        friend_chat_panel = new friendChatSection("ABC", true);

        
        group_list_panel.setBackground(new java.awt.Color(255, 255, 255));
        group_list_panel.setFocusable(false);
        group_list_panel.setPreferredSize(new java.awt.Dimension(660, 550));

        group_list_navigator.setBackground(new java.awt.Color(153, 204, 255));

        group_list_search_input.setText("Search...");

        group_list_search_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        group_list_search_button.setText("Search");

        group_list_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        group_list_title.setForeground(new java.awt.Color(255, 255, 255));
        group_list_title.setText("Group member list");

        group_list_sort_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        group_list_sort_button.setText("Sort ");

        group_list_add_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        group_list_add_button.setText("Add");

        GroupLayout group_list_navigatorLayout = new GroupLayout(group_list_navigator);
        group_list_navigator.setLayout(group_list_navigatorLayout);
        group_list_navigatorLayout.setHorizontalGroup(
            group_list_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_list_navigatorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(group_list_navigatorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(group_list_title)
                    .addGroup(group_list_navigatorLayout.createSequentialGroup()
                        .addComponent(group_list_sort_button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(group_list_search_input, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_list_search_button)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_list_add_button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );
        group_list_navigatorLayout.setVerticalGroup(
            group_list_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, group_list_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(group_list_title)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(group_list_navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(group_list_search_input, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_list_search_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_list_sort_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_list_add_button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        group_list_side.setBackground(new java.awt.Color(255, 255, 255));
        group_list_side.setLayout(new BoxLayout(group_list_side, BoxLayout.Y_AXIS));


        member1_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        member1_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        member1_name.setText("XYZ");

        member1_status.setText("status");

        member1_remove_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        member1_remove_button.setText("Remove");

        GroupLayout member1_panelLayout = new GroupLayout(member1_panel);
        member1_panel.setLayout(member1_panelLayout);
        member1_panelLayout.setHorizontalGroup(
            member1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(member1_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(member1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(member1_panelLayout.createSequentialGroup()
                        .addComponent(member1_status, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(379, Short.MAX_VALUE))
                    .addGroup(member1_panelLayout.createSequentialGroup()
                        .addComponent(member1_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(member1_remove_button)
                        .addGap(47, 47, 47))))
        );
        member1_panelLayout.setVerticalGroup(
            member1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(member1_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(member1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(member1_panelLayout.createSequentialGroup()
                        .addComponent(member1_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(GroupLayout.Alignment.TRAILING, member1_panelLayout.createSequentialGroup()
                        .addComponent(member1_remove_button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(member1_status, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        member2_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        member2_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        member2_name.setText("ABC");

        member2_status.setText("status");

        member2_remove_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        member2_remove_button.setText("Remove");

        GroupLayout member2_panelLayout = new GroupLayout(member2_panel);
        member2_panel.setLayout(member2_panelLayout);
        member2_panelLayout.setHorizontalGroup(
            member2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(member2_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(member2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(member2_panelLayout.createSequentialGroup()
                        .addComponent(member2_status, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(379, Short.MAX_VALUE))
                    .addGroup(member2_panelLayout.createSequentialGroup()
                        .addComponent(member2_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(member2_remove_button)
                        .addGap(47, 47, 47))))
        );
        member2_panelLayout.setVerticalGroup(
            member2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(member2_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(member2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(member2_panelLayout.createSequentialGroup()
                        .addComponent(member2_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(GroupLayout.Alignment.TRAILING, member2_panelLayout.createSequentialGroup()
                        .addComponent(member2_remove_button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(member2_status, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        GroupLayout group_list_sideLayout = new GroupLayout(group_list_side);
        group_list_side.setLayout(group_list_sideLayout);
        group_list_sideLayout.setHorizontalGroup(
            group_list_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_list_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(group_list_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(member1_panel, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addComponent(member2_panel, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                .addContainerGap())
        );
        group_list_sideLayout.setVerticalGroup(
            group_list_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_list_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(member1_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(member2_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        group_list_scroll = new JScrollPane(group_list_side);
        group_list_scroll.setBorder(null);

        group_list_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
        group_list_scroll.getVerticalScrollBar().setValue(group_list_scroll.getVerticalScrollBar().getMaximum());

        GroupLayout group_list_panelLayout = new GroupLayout(group_list_panel);
        group_list_panel.setLayout(group_list_panelLayout);
        group_list_panelLayout.setHorizontalGroup(
            group_list_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(group_list_navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(group_list_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(group_list_scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        group_list_panelLayout.setVerticalGroup(
            group_list_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_list_panelLayout.createSequentialGroup()
                .addComponent(group_list_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(group_list_scroll, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        side_panel.setBackground(new java.awt.Color(255, 255, 255));

        side_navigator.setBackground(new java.awt.Color(153, 204, 255));
        side_navigator.setPreferredSize(new java.awt.Dimension(218, 70));

        side_more_button.setText("...");
        JPopupMenu side_more_menu = new JPopupMenu();

        JMenuItem friend_request_button = new JMenuItem("Friend Request");
        JMenuItem profile_button = new JMenuItem("Profile");

        friend_request_button.addActionListener(e -> openFriendRequest());
        profile_button.addActionListener(e -> openProfile());

        side_more_menu.add(friend_request_button);
        side_more_menu.add(profile_button);
        
        side_more_button.addActionListener(e -> side_more_menu.show(side_more_button, 0, side_more_button.getHeight()));

        side_sort_button.setText("Sort");

        side_search_input.setText("search");

        side_search_button.setText("Search");

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
                    .addComponent(side_sort_button)
                    .addComponent(side_more_button, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(side_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_search_button))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        user_container.setBackground(new java.awt.Color(255, 255, 255));
        user_container.setLayout(new BoxLayout(user_container, BoxLayout.Y_AXIS));

        friend_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        friend_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        friend_name.setText("ABC");

        friend_status.setText("Status:");

        GroupLayout friend_panelLayout = new GroupLayout(friend_panel);
        friend_panel.setLayout(friend_panelLayout);
        friend_panelLayout.setHorizontalGroup(
            friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(friend_name, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friend_status, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        friend_panelLayout.setVerticalGroup(
            friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_name)
                .addComponent(friend_status)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        group_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        group_chat_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        group_chat_label.setText("Group ABC");

        group_member_label.setText("Member:");

        GroupLayout group_panelLayout = new GroupLayout(group_panel);
        group_panel.setLayout(group_panelLayout);
        group_panelLayout.setHorizontalGroup(
            group_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(group_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(group_chat_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(group_member_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        group_panelLayout.setVerticalGroup(
            group_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(group_chat_label)
                .addComponent(group_member_label)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        not_friend_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        not_friend_name_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        not_friend_name_label.setText("XYZ");

        not_friend_send_request_button.setText("Send Request");

        GroupLayout not_friend_panelLayout = new GroupLayout(not_friend_panel);
        not_friend_panel.setLayout(not_friend_panelLayout);
        not_friend_panelLayout.setHorizontalGroup(
            not_friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(not_friend_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(not_friend_name_label, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(not_friend_send_request_button)
                .addContainerGap())
        );
        not_friend_panelLayout.setVerticalGroup(
            not_friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(not_friend_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(not_friend_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(not_friend_name_label)
                    .addComponent(not_friend_send_request_button))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        GroupLayout user_containerLayout = new GroupLayout(user_container);
        user_container.setLayout(user_containerLayout);
        user_containerLayout.setHorizontalGroup(
            user_containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(friend_panel, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
            .addComponent(group_panel, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
            .addComponent(not_friend_panel, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        user_containerLayout.setVerticalGroup(
            user_containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(user_containerLayout.createSequentialGroup()
                .addComponent(friend_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(not_friend_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );

        side_scroll = new JScrollPane(user_container);
        side_scroll.setBorder(null);
        
        side_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
        
        side_scroll.getVerticalScrollBar().setValue(side_scroll.getVerticalScrollBar().getMaximum());

        side_scroll.setViewportView(user_container);

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

        blank_chat_panel.setBackground(new java.awt.Color(255, 255, 255));

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
        blank_chat_label.setText("Blank Chat...");

        blank_chat_description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        blank_chat_description.setText("Please choose one chat room or create new chat");

        GroupLayout blank_chat_panelLayout = new GroupLayout(blank_chat_panel);
        blank_chat_panel.setLayout(blank_chat_panelLayout);
        blank_chat_panelLayout.setHorizontalGroup(
            blank_chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(blank_chat_navigator, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(blank_chat_panelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(blank_chat_description)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, blank_chat_panelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(blank_chat_label)
                .addGap(196, 196, 196))
        );
        blank_chat_panelLayout.setVerticalGroup(
            blank_chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(blank_chat_panelLayout.createSequentialGroup()
                .addComponent(blank_chat_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(blank_chat_label, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blank_chat_description)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        
        cardLayout = new CardLayout();
        chatPanel = new JPanel(cardLayout);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        chatPanel.add(blank_chat_panel, "blankChat");
        chatPanel.add(group_chat_panel, "groupChat");
        chatPanel.add(friend_chat_panel, "friendChat");
    
        friend_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(chatPanel, "friendChat");
            }
        });
        
        group_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(chatPanel, "groupChat");
            }
        });


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

        getContentPane().add(chatPanel);
        setResizable(false); 
        setLocation(400, 150);
        pack();
    }// </editor-fold>                        


    private void openFriendRequest() {
        Frame newWindow = new friendRequestWindow();
        newWindow.setVisible(true);
    }

    private void openProfile() {
        Frame newWindow = new profileWindow("abc", "abcdef" ,"213 ac", "12/12/1200", true, "abc@gmail", 12);
        newWindow.setVisible(true);
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
            java.util.logging.Logger.getLogger(chatBoxDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new chatBoxDemo().setVisible(true);
        });
    }       
}