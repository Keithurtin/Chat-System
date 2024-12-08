package presentation.User;

import bus.*;
import dto.*;
import dto.UsersDTO;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

public class MainUserWindow extends JFrame {
    private static JPanel chatPanel;
    private static CardLayout cardLayout;
    private static int uid;
    private static int numberOfTab = 0;
    private static String mode;
    private final boolean isAdmin;
    private static volatile boolean isFetching = false;
    private static final Object fetchLock = new Object();
    private JPanel side_panel;
    private static JPanel friend_side;
    private static GroupLayout.ParallelGroup horizontalGroup;
    private static GroupLayout.SequentialGroup verticalGroup;
    private static JPanel blank_chat_panel;
    private static JButton new_group_button;
    private static JButton side_more_button;

    public MainUserWindow(int id) {
        uid = id;
        UsersBUS usersBUS = new UsersBUS();
        isAdmin = (usersBUS.getById(uid)).getIsAdmin();

        cardLayout = new CardLayout();
        chatPanel = new JPanel(cardLayout);
        blank_chat_panel = createBlankChat("Blank Chat...");
        chatPanel.add(blank_chat_panel, "0");
        cardLayout.show(chatPanel, "0");

        setupSideLayout();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
    }

    private void setupSideLayout() {
        side_panel = new JPanel();
        JPanel side_navigator = new JPanel();
        friend_side = new JPanel();
        PlaceHolder side_search_input = new PlaceHolder("Search");
        JButton side_search_button = new JButton("Search");
        side_search_button.addActionListener(_ -> searchTab(side_search_input.getText()));
        new_group_button = new JButton("New");
        side_more_button = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        side_panel.setBackground(new Color(255, 255, 255));

        side_navigator.setBackground(new Color(153, 204, 255));
        side_navigator.setPreferredSize(new Dimension(218, 70));

        new_group_button.addActionListener(_ -> createGroupChat());

        JPopupMenu more_menu = MoreMenu();

        side_more_button.addActionListener(_ -> more_menu.show(side_more_button, 0, side_more_button.getHeight()));

        GroupLayout side_navigatorLayout = new GroupLayout(side_navigator);
        side_navigator.setLayout(side_navigatorLayout);
        side_navigatorLayout.setHorizontalGroup(
            side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(side_navigatorLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(side_search_input, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                        .addComponent(side_more_button))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(side_search_button, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                        .addComponent(new_group_button, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(14, Short.MAX_VALUE))
        );
        side_navigatorLayout.setVerticalGroup(
            side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(side_navigatorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(new_group_button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(side_more_button, GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(side_navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(side_search_input, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(side_search_button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
        );

        friend_side = new JPanel();
        friend_side.setBackground(new Color(255, 255, 255));

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

        JScrollPane side_scroll = new JScrollPane(friend_side);
        side_scroll.setBorder(null);

        GroupLayout side_panelLayout = new GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(side_navigator, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addComponent(side_scroll, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addComponent(side_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(side_scroll, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );
        allChat();
    }

    private JPopupMenu MoreMenu() {
        JPopupMenu more_menu = new JPopupMenu();

        JMenuItem all_button = new JMenuItem("All");
        JMenuItem friend_request_button = new JMenuItem("Friend Request");
        JMenuItem online_friend_button = new JMenuItem("Online Friend");
        JMenuItem group_button = new JMenuItem("Group Chat");
        JMenuItem user_profile_button = new JMenuItem("Profile");
        JMenuItem logout = new JMenuItem("Log Out");

        all_button.addActionListener(_ -> allChat());
        online_friend_button.addActionListener(_ -> onlineFriend());
        group_button.addActionListener(_ -> groupChat());
        friend_request_button.addActionListener(_ -> friendRequest());
        logout.addActionListener(_ -> {
            removeAll();
            dispose();
            new Thread(() -> {
                synchronized (fetchLock) {
                    while (isFetching) {
                        try {
                            fetchLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    try {
                        isFetching = true; // Mark the operation as ongoing
                        UsersBUS usersBUS = new UsersBUS();
                        UsersDTO user = usersBUS.getById(uid);
                        if (user != null) {
                            user.setStatus("Offline");
                            usersBUS.updateUser(user);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        isFetching = false; // Reset the flag
                        fetchLock.notifyAll(); // Notify other waiting threads
                    }
                }
            }).start();
            Authentication newWindow = new Authentication();
            newWindow.setVisible(true);
        });

        user_profile_button.addActionListener(_ -> {
            JFrame newWindow = new UserProfileWindow(uid);
            newWindow.setVisible(true);
        });

        more_menu.add(all_button);
        more_menu.add(online_friend_button);
        more_menu.add(group_button);
        more_menu.add(friend_request_button);
        more_menu.add(user_profile_button);
        more_menu.add(logout);

        if(isAdmin) {
            JMenuItem goBackAdmin = new JMenuItem("Go Back");
            goBackAdmin.addActionListener(_ -> {
                dispose();
                JFrame newWindow = new Admin.adminMenu(uid);
                newWindow.setVisible(true);
            });
            more_menu.add(goBackAdmin);
        }

        return more_menu;
    }

    JPanel createBlankChat(String label){
        JPanel blank_chat = new JPanel();
        JPanel blank_chat_navigator = new JPanel();
        JLabel blank_chat_label = new JLabel();
        JLabel blank_chat_description = new JLabel();

        blank_chat.setBackground(new Color(255, 255, 255));

        blank_chat_navigator.setBackground(new Color(153, 204, 255));
        blank_chat_navigator.setPreferredSize(new Dimension(390, 70));

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

        blank_chat_label.setFont(new Font("Segoe UI", Font.PLAIN, 36)); // NOI18N
        blank_chat_label.setText(label);

        blank_chat_description.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
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

    private static void loadChatMode(String modeName, Runnable fetchTask) {
        clearFriendSide();
        synchronized (fetchLock) {
            if (isFetching) {
                return;  // Prevent a new fetch operation if one is already ongoing
            }
            mode = modeName;
            side_more_button.setText(modeName);
            isFetching = true;

            new Thread(() -> {
                try {
                    fetchTask.run();  // Run the data fetching task (for example, fetching friends or groups)
                } catch (Exception e) {
                    e.printStackTrace();
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null,
                            "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                } finally {
                    synchronized (fetchLock) {
                        isFetching = false;  // Reset the flag after the operation is done
                        fetchLock.notifyAll();  // Notify waiting threads that the fetch is complete
                    }
                }
            }).start();
        }
    }

    private static void reloadFriendSide(List<UsersDTO> friends, List<GroupChatDTO> groups) {
        SwingUtilities.invokeLater(() -> {
            loadFriendTabs(friends);
            loadGroupTabs(groups);
            updateGroupButtonVisibility();
        });
    }

    private static void clearFriendSide() {
        System.out.print("clear");
        friend_side.removeAll();
        chatPanel.removeAll();
        chatPanel.add(blank_chat_panel, "0");
        cardLayout.show(chatPanel, "0");
        numberOfTab = 0;
    }

    private static void loadFriendTabs(List<UsersDTO> friends) {
        for (UsersDTO friend : friends) {
            addFriendChat(new UserPanel(uid, friend));
        }
    }

    private static void loadGroupTabs(List<GroupChatDTO> groups) {
        for (GroupChatDTO group : groups) {
            addGroupChat(new UserPanel(uid, group));
        }
    }

    private static void addFriendChat(UserPanel user) {
        TabPanel tab = user.tab;
        addToList(tab);
        FriendChatSection chat = user.friendChat;
        numberOfTab += 1;
        String id = String.valueOf(numberOfTab);
        chatPanel.add(chat, id);

        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(chatPanel, id);
            }
        });
    }

    private static void addGroupChat(UserPanel user) {
        TabPanel tab = user.tab;
        addToList(tab);
        GroupChatSection chat = user.groupChat;
        numberOfTab += 1;
        String id = String.valueOf(numberOfTab);
        chatPanel.add(chat, id);

        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(chatPanel, id);
            }
        });
    }

    private static void addToList(JPanel tag_panel) {
        horizontalGroup.addComponent(tag_panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE);
        verticalGroup.addComponent(tag_panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);

        friend_side.add(tag_panel);
    }

    private static void updateGroupButtonVisibility() {
        boolean isGroupMode = mode.equals("Online");
        new_group_button.setVisible(isGroupMode);
        new_group_button.setEnabled(isGroupMode);
    }

    public static void groupChat() {
        loadChatMode("Group", () -> {
            GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
            List<GroupChatDTO> groupList = groupMembersBUS.getGroups(uid);
            reloadFriendSide(Collections.emptyList(), groupList);
        });
    }

    public static void onlineFriend() {
        loadChatMode("Online", () -> {
            FriendListBUS friendListBUS = new FriendListBUS();
            List<UsersDTO> friendList = friendListBUS.getOnlineFriends(uid);
            reloadFriendSide(friendList, Collections.emptyList());
        });
    }

    public static void allChat() {
        loadChatMode("All", () -> {
            FriendListBUS friendListBUS = new FriendListBUS();
            List<UsersDTO> friendList = friendListBUS.getFriends(uid);
            reloadFriendSide(friendList, Collections.emptyList());
        });
    }

    public void friendRequest() {
        loadChatMode("Request", () -> {
            FriendListBUS friendListBUS = new FriendListBUS();
            List<UsersDTO> friendList = friendListBUS.getFriendsRequesting(uid);
            reloadFriendSide(friendList, Collections.emptyList());
        });
    }

    private void createGroupChat() {

    }

    private void searchTab(String query) {
        List<UsersDTO> users = new ArrayList<>();
        List<GroupChatDTO> groups = new ArrayList<>();
        FriendListBUS friendListBUS = new FriendListBUS();
        UsersBUS usersBUS = new UsersBUS();
        List<UsersDTO> friendList;
        switch (mode) {
            case "Group":
                GroupChatBUS groupChatBUS = new GroupChatBUS();
                GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
                groups = groupChatBUS.getByName(query);
                groups.retainAll(groupMembersBUS.getGroups(uid));
                break;
            case "Online":
                friendList = friendListBUS.getOnlineFriends(uid);
                users = usersBUS.getByNameOrUName(query);
                users.retainAll(friendList);
                break;
            case "All":
                BlockBUS blockBUS = new BlockBUS();
                friendList = blockBUS.getBlocked(uid);
                users = usersBUS.getByNameOrUName(query);
                users.removeAll(friendList);
                break;
            case "Request":
                friendList = friendListBUS.getFriendsRequesting(uid);
                users = usersBUS.getByNameOrUName(query);
                users.retainAll(friendList);
        }
        reloadFriendSide(users, groups);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new MainUserWindow(1).setVisible(true));
    }

}