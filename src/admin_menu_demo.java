import component.active_user_demo;
import component.add_user_demo;
import component.group_list_demo;
import component.new_register_demo;
import component.spam_menu_demo;
import component.user_management_demo;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class admin_menu_demo extends JFrame {

    private JPanel admin_menu;
    private JPanel navigator;
    private JScrollPane user_table_scroll;
    private JTable user_table;
    private DefaultTableModel tableModel;

    public admin_menu_demo() {
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
                .addComponent(user_table_scroll, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
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
                .addComponent(admin_menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
        JMenuItem chat_button = new JMenuItem("Chat Box");
        JMenuItem add_new_user = new JMenuItem("Add User");

        group_list_section.addActionListener(e -> openGroupList());
        spam_section.addActionListener(e -> openSpamSection());
        new_register_section.addActionListener(e -> openNewRegister());
        active_user_button.addActionListener(e -> openActiveUser());
        add_new_user.addActionListener(e -> openAddUserMenu());
        chat_button.addActionListener(e -> openChatBox());

        more_menu.add(group_list_section);
        more_menu.add(spam_section);
        more_menu.add(new_register_section);
        more_menu.add(active_user_button);
        more_menu.add(add_new_user);
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

        JButton search_button = new JButton("Search");
        search_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        JTextField search_input = new JTextField("search");

        JPopupMenu search_menu = new JPopupMenu();

        JMenuItem by_name = new JMenuItem("By Name");
        JMenuItem by_username = new JMenuItem("By Username");
        JMenuItem by_status = new JMenuItem("By Status");
        JMenuItem by_friend = new JMenuItem("By Friend");

        search_menu.add(by_name);
        search_menu.add(by_username);
        search_menu.add(by_status);
        search_menu.add(by_friend);

        search_button.addActionListener(e -> search_menu.show(search_button, 0, search_button.getHeight()));

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
                        .addGap(136, 136, 136))
                    .addGroup(navigatorLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
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
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Index", "Username", "Status", "Fullname", "No. F", "No. F2"});
        user_table = new JTable(tableModel);

        user_table.setRowHeight(30);
        user_table.getColumnModel().getColumn(0).setPreferredWidth(50);
        user_table.getColumnModel().getColumn(1).setPreferredWidth(100);
        user_table.getColumnModel().getColumn(2).setPreferredWidth(60);
        user_table.getColumnModel().getColumn(3).setPreferredWidth(250); 
        user_table.getColumnModel().getColumn(4).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        user_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        user_table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        user_table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        user_table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        user_table_scroll.setViewportView(user_table);

        // Add sample data
        addRowToTable("1", "Username1", "On", "ABC XYZ", 1, 2);
        addRowToTable("2", "Username2", "Off", "DEF UVW", 4, 11);

        user_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = user_table.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    String selectedUsername = user_table.getValueAt(row, 1).toString();
                    System.out.println("clicked at " + selectedUsername);
                    openUserWindow();
                }
            }
        });
    }

    private void addRowToTable(String stt, String username, String status, String fullname, int numF, int numF2) {
        tableModel.addRow(new Object[]{stt, username, status, fullname, numF, numF2});
    }

    private void openUserWindow(){
        JFrame newWindow = new JFrame("User Management");
        JPanel userManage = new user_management_demo("Abc", "Nguyen Van A", "1/1/2001", "123 NVC", false, "abc123@mail.com");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = userManage.getPreferredSize();
        newWindow.add(userManage);
        newWindow.setResizable(false);
        newWindow.setLocation(600, 180);
        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    private void openGroupList() {
        JFrame newWindow = new group_list_demo();
        newWindow.setResizable(false);
        newWindow.setLocation(640, 200);
        newWindow.setVisible(true);
    }

    private void openSpamSection() {
        JFrame newWindow = new spam_menu_demo();
        newWindow.setResizable(false);
        newWindow.setLocation(480, 190);
        newWindow.setVisible(true);
    }

    private void openNewRegister() {
        JFrame newWindow = new new_register_demo();
        newWindow.setResizable(false);
        newWindow.setLocation(480, 190);
        newWindow.setVisible(true);
    }

    private void openActiveUser() {
        JFrame newWindow = new active_user_demo();
        newWindow.setResizable(false);
        newWindow.setLocation(480, 190);
        newWindow.setVisible(true);
    }

    private void openChatBox() {
        JFrame newWindow = new chat_box_demo();
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setResizable(false);
        newWindow.setLocation(480, 190);
        newWindow.setVisible(true);
    }

    private void openAddUserMenu() {
        JFrame newWindow = new JFrame("Add New User");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add_user_demo newPanel = new add_user_demo();
        Dimension panelSize = newPanel.getPreferredSize();
        newWindow.add(newPanel);
        newWindow.setResizable(false);
        newWindow.setLocation(600, 180);
        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new admin_menu_demo().setVisible(true));
    }
}
