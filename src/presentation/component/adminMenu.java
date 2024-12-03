package component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import bus.*;
import dto.*;
import presentation.component.loginTimeHistory;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class adminMenu extends JFrame {

    private JPanel admin_menu;
    private static int uid;
    private JPanel navigator;
    private JScrollPane user_table_scroll;
    private JTable user_table;
    static DefaultTableModel tableModel;

    public adminMenu(int uid) {
        this.uid = uid;
        initComponents();
    }

    private void initComponents() {
        admin_menu = new JPanel();
        user_table_scroll = new JScrollPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        admin_menu.setBackground(new java.awt.Color(255, 255, 255));
        admin_menu.setPreferredSize(new java.awt.Dimension(620, 500));

        setupNavigatorLayout();
        createTableLayout();

        GroupLayout admin_menuLayout = new GroupLayout(admin_menu);
        admin_menu.setLayout(admin_menuLayout);
        admin_menuLayout.setHorizontalGroup(
            admin_menuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(user_table_scroll, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        admin_menuLayout.setVerticalGroup(
            admin_menuLayout.createSequentialGroup()
                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_table_scroll, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(admin_menu, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(admin_menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        setResizable(false);
        setLocation(400, 180);
        setVisible(true);

        pack();
    }

    private void setupNavigatorLayout() {
        navigator = new JPanel();
        navigator.setBackground(new java.awt.Color(153, 204, 255));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Admin Menu");
        title.setFont(new java.awt.Font("Segoe UI", 1, 24));
        title.setForeground(new java.awt.Color(255, 255, 255));

        JButton more_button = new JButton("More");
        more_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        JPopupMenu more_menu = new JPopupMenu();

        JMenuItem group_list_section = new JMenuItem("Groups Section");
        JMenuItem spam_section = new JMenuItem("Spam Report");
        JMenuItem new_register_section = new JMenuItem("New Registers");
        JMenuItem active_user_button = new JMenuItem("Active Users");
        JMenuItem login_history = new JMenuItem("Users Login");
        JMenuItem chat_button = new JMenuItem("Chat Box");
        JMenuItem add_new_user = new JMenuItem("Add User");

        group_list_section.addActionListener(e -> openGroupList());
        spam_section.addActionListener(e -> openSpamSection());
        new_register_section.addActionListener(e -> openNewRegister());
        active_user_button.addActionListener(e -> openActiveUser());
        login_history.addActionListener(e -> openLoginHistory());
        add_new_user.addActionListener(e -> openAddUserMenu());
        chat_button.addActionListener(e -> openChatBox());

        more_menu.add(group_list_section);
        more_menu.add(spam_section);
        more_menu.add(new_register_section);
        more_menu.add(active_user_button);
        more_menu.add(add_new_user);
        more_menu.add(login_history);
        more_menu.add(chat_button);

        more_button.addActionListener(e -> more_menu.show(more_button, 0, more_button.getHeight()));

        JButton sort_button = new JButton("Sort");
        sort_button.setFont(new java.awt.Font("Segoe UI", 1, 14));

        JPopupMenu sort_menu = new JPopupMenu();

        JMenuItem by_fullname = new JMenuItem("By Name");
        JMenuItem by_created_date = new JMenuItem("By Created Date");

        sort_menu.add(by_fullname);
        sort_menu.add(by_created_date);

        sort_button.addActionListener(e -> sort_menu.show(sort_button, 0, sort_button.getHeight()));

        by_fullname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                UsersBUS usersBUS = new UsersBUS();
                List<UsersDTO> usersList = usersBUS.sortByName();
                addTable(usersList);
            }
        });

        by_created_date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                UsersBUS usersBUS = new UsersBUS();
                List<UsersDTO> usersList = usersBUS.sortByCreatedDate();
                addTable(usersList);
            }
        });

        JButton search_button = new JButton("Filter");
        search_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        JTextField search_input = new JTextField("");

        JPopupMenu search_menu = new JPopupMenu();

        JMenuItem by_name = new JMenuItem("By Name");
        JMenuItem by_username = new JMenuItem("By Username");
        JMenuItem by_status = new JMenuItem("By Status");
        JMenuItem by_friend = new JMenuItem("By Friend (equal)");
        JMenuItem by_friend_less = new JMenuItem(("By Friend (less)"));
        JMenuItem by_friend_more = new JMenuItem(("By Friend (more)"));

        search_menu.add(by_name);
        search_menu.add(by_username);
        search_menu.add(by_status);
        search_menu.add(by_friend);
        search_menu.add(by_friend_less);
        search_menu.add(by_friend_more);

        search_button.addActionListener(e -> search_menu.show(search_button, 0, search_button.getHeight()));

        by_name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = search_input.getText();
                tableModel.setRowCount(0);
                UsersBUS usersBUS = new UsersBUS();
                List<UsersDTO> usersList = usersBUS.getByName(name);
                addTable(usersList);
            }
        });

        by_username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = search_input.getText();
                tableModel.setRowCount(0);
                UsersBUS usersBUS = new UsersBUS();
                List<UsersDTO> usersList = usersBUS.getByUserName(username);
                addTable(usersList);
            }
        });

        by_status.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String status = search_input.getText();
                tableModel.setRowCount(0);
                UsersBUS usersBUS = new UsersBUS();
                List<UsersDTO> usersList = usersBUS.getByStatus(status);
                addTable(usersList);
            }
        });

        by_friend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int friend = Integer.parseInt(search_input.getText());
                tableModel.setRowCount(0);
                UsersBUS usersBUS = new UsersBUS();
                List<UsersDTO> usersList = usersBUS.getByFriend(friend, 0);
                addTable(usersList);
            }
        });

        by_friend_less.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int friend = Integer.parseInt(search_input.getText());
                tableModel.setRowCount(0);
                UsersBUS usersBUS = new UsersBUS();
                List<UsersDTO> usersList = usersBUS.getByFriend(friend, -1);
                addTable(usersList);
            }
        });

        by_friend_more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int friend = Integer.parseInt(search_input.getText());
                tableModel.setRowCount(0);
                UsersBUS usersBUS = new UsersBUS();
                List<UsersDTO> usersList = usersBUS.getByFriend(friend, 1);
                addTable(usersList);
            }
        });

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(more_button, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sort_button, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(navigatorLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 240, 240))
                    .addGroup(navigatorLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_button, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sort_button)
                    .addComponent(title))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(more_button)
                    .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button))
                .addGap(10, 10, 10))
        );
    }

    private void createTableLayout() {
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Username", "Fullname", "Status", "Created Date", "No.Friend", "Frs.Friends"});
        user_table = new JTable(tableModel);

        user_table.setRowHeight(30);
        user_table.getColumnModel().getColumn(0).setPreferredWidth(50);
        user_table.getColumnModel().getColumn(1).setPreferredWidth(100);
        user_table.getColumnModel().getColumn(2).setPreferredWidth(250);
        user_table.getColumnModel().getColumn(3).setPreferredWidth(50);
        user_table.getColumnModel().getColumn(4).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        user_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        user_table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        user_table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        user_table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        user_table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        user_table_scroll.setViewportView(user_table);

        // Add data
        UsersBUS userBUS = new UsersBUS();
        List<UsersDTO> userList = userBUS.getAll();
        addTable(userList);

        user_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = user_table.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    String selectedUsername = user_table.getValueAt(row, 1).toString();
                    int id = (int) user_table.getValueAt(row, 0);
                    System.out.println("clicked at " + selectedUsername);
                    openUserWindow(id);
                }
            }
        });
    }

    private static void addRowToTable(int ID, String username, String fullname, String status, String createDate, int noFriend, int noFriend2) {
        tableModel.addRow(new Object[]{ID, username, fullname, status, createDate, noFriend, noFriend2});
    }

    private static void addTable(List<UsersDTO> userList) {
        FriendListBUS friendListBUS = new FriendListBUS();
        for (UsersDTO user : userList) {
            addRowToTable(user.getuID(), user.getuName(), user.getFullname(), user.getStatus(), user.getCreateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), friendListBUS.countFriends(user.getuID()), friendListBUS.countFriendsOfFriend(user.getuID()));
        }
    }

    public static void reloadAdminTable() {
        tableModel.setRowCount(0);
        UsersBUS usersBUS = new UsersBUS();
        List<UsersDTO> usersList = usersBUS.getAll();
        addTable(usersList);
    }

    private void openUserWindow(int id){
        JFrame newWindow = new JFrame("User Management");
        UsersBUS userBUS = new UsersBUS();
        UsersDTO user = userBUS.getById(id);
        JPanel userManage = new userManage(user);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = userManage.getPreferredSize();
        newWindow.add(userManage);
        newWindow.setResizable(false);
        newWindow.setLocation(600, 180);
        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    private void openGroupList() {
        JFrame newWindow = new groupListManage();
        newWindow.setResizable(false);
        newWindow.setLocation(640, 200);
        newWindow.setVisible(true);
    }

    private void openSpamSection() {
        JFrame newWindow = new spamManage();
        newWindow.setResizable(false);
        newWindow.setLocation(480, 190);
        newWindow.setVisible(true);
    }

    private void openNewRegister() {
        JFrame newWindow = new newUsersManage();
        newWindow.setResizable(false);
        newWindow.setLocation(480, 190);
        newWindow.setVisible(true);
    }

    private void openActiveUser() {
        JFrame newWindow = new activeUserManage();
        newWindow.setResizable(false);
        newWindow.setLocation(480, 190);
        newWindow.setVisible(true);
    }

    private void openLoginHistory() {
        JFrame newWindow = new loginTimeHistory();
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setResizable(false);
        newWindow.setLocation(470, 200);
        newWindow.setVisible(true);
    }

    private void openChatBox() {
        JFrame newWindow = new component.mainChat(uid);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setResizable(false);
        newWindow.setLocation(480, 190);
        newWindow.setVisible(true);
    }

    private void openAddUserMenu() {
        JFrame newWindow = new JFrame("Add New User");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addNewUser newPanel = new addNewUser();
        Dimension panelSize = newPanel.getPreferredSize();
        newWindow.add(newPanel);
        newWindow.setResizable(false);
        newWindow.setLocation(600, 180);
        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new component.adminMenu(1).setVisible(true));
    }
}