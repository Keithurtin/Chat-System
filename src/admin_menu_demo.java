import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
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

        group_list_section.addActionListener(e -> openGroupList());
        spam_section.addActionListener(e -> openSpamSection());
        new_register_section.addActionListener(e -> openNewRegister());

        more_menu.add(group_list_section);
        more_menu.add(spam_section);
        more_menu.add(new_register_section);

        more_button.addActionListener(e -> more_menu.show(more_button, 0, more_button.getHeight()));


        JButton chart_button = new JButton("Chart");
        chart_button.setFont(new java.awt.Font("Segoe UI", 1, 14));

        JPopupMenu year_menu = new JPopupMenu();

        JMenuItem year1 = new JMenuItem("2024");
        year1.addActionListener(e -> openChartView(year1.getText(), null));
        year_menu.add(year1);
        chart_button.addActionListener(e -> year_menu.show(chart_button, 0, chart_button.getHeight()));

        JButton sort_button = new JButton("Sort");
        sort_button.setFont(new java.awt.Font("Segoe UI", 1, 14));

        JPopupMenu sort_menu = new JPopupMenu();

        JMenuItem by_name = new JMenuItem("By Name");
        JMenuItem by_username = new JMenuItem("By Username");
        JMenuItem by_status = new JMenuItem("By status");

        sort_menu.add(by_name);
        sort_menu.add(by_username);
        sort_menu.add(by_status);

        sort_button.addActionListener(e -> sort_menu.show(sort_button, 0, sort_button.getHeight()));

        JButton search_button = new JButton("Search");
        search_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        JTextField search_input = new JTextField("search");

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(more_button)
                    .addComponent(chart_button))
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
                        .addGap(30, 30, 30)
                        .addComponent(sort_button, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(chart_button)
                    .addComponent(title))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(more_button)
                    .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button)
                    .addComponent(sort_button))
                .addGap(10, 10, 10))
        );

        // GroupLayout navigatorLayout = new GroupLayout(navigator);
        // navigator.setLayout(navigatorLayout);
        // navigatorLayout.setHorizontalGroup(
        //     navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        //     .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
        //         .addGap(36, 36, 36)
        //         .addComponent(more_button)
        //         .addGap(15, 15, 15)
        //         .addComponent(chart_button)
        //         .addGap(50, 50, 50)
        //         .addComponent(title, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
        //         .addGap(70, 70, 70)
        //         .addComponent(sort_button)
        //         .addContainerGap(36, Short.MAX_VALUE))
        // );
        // navigatorLayout.setVerticalGroup(
        //     navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        //     .addGroup(navigatorLayout.createSequentialGroup()
        //         .addContainerGap()
        //         .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        //             .addComponent(title)
        //             .addComponent(sort_button)
        //             .addComponent(chart_button)
        //             .addComponent(more_button))
        //         .addContainerGap(8, Short.MAX_VALUE))
        // );
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

    private void openChartActiceUser() {
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

    private Map<String, Integer> generateExampleData() {
        Map<String, Integer> data = new HashMap<>();
        data.put("Jan", 120);
        data.put("Feb", 80);
        data.put("Mar", 150);
        data.put("Apr", 90);
        data.put("May", 130);
        data.put("Jun", 170);
        data.put("Jul", 160);
        data.put("Aug", 140);
        data.put("Sep", 180);
        data.put("Oct", 110);
        data.put("Nov", 190);
        data.put("Dec", 200);
        return data;
    }

    private void openChartView(String year, Map<String, Integer> data) {
        JFrame chartFrame = new JFrame("Active Users Year " + year);
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chartFrame.setSize(800, 600);
        if(data == null){
            data = generateExampleData();
        }
        chart_panel_demo chartPanel = new chart_panel_demo(year, data, false);
        chartFrame.add(chartPanel);
        chartFrame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new admin_menu_demo().setVisible(true));
    }
}
