package Admin;

import bus.LoginHistoryBUS;
import bus.UsersBUS;
import dto.LoginHistoryDTO;
import dto.UsersDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class loginTimeHistory extends JFrame {

    private JPanel navigator;
    private JScrollPane user_table_scroll;
    private JTable user_table;
    static DefaultTableModel tableModel;

    public loginTimeHistory() {
        initComponents();
    }

    private void initComponents() {
        JPanel admin_menu = new JPanel();
        user_table_scroll = new JScrollPane();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        admin_menu.setBackground(new Color(255, 255, 255));
        admin_menu.setPreferredSize(new Dimension(620, 500));

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
                        .addComponent(admin_menu, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
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
        navigator.setBackground(new Color(153, 204, 255));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Users Login History");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(255, 255, 255));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
                navigatorLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        navigatorLayout.setVerticalGroup(
                navigatorLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(title)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void createTableLayout() {
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Username", "Fullname", "Login Time"});
        user_table = new JTable(tableModel);

        user_table.setRowHeight(30);
        user_table.getColumnModel().getColumn(0).setPreferredWidth(50);
        user_table.getColumnModel().getColumn(1).setPreferredWidth(100);
        user_table.getColumnModel().getColumn(2).setPreferredWidth(210);
        user_table.getColumnModel().getColumn(3).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        user_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        user_table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        user_table_scroll.setViewportView(user_table);

        // Add data
        LoginHistoryBUS loginHistoryBUS = new LoginHistoryBUS();
        List<LoginHistoryDTO> loginHistoryList = loginHistoryBUS.getAll();
        addTable(loginHistoryList);
    }

    private static void addRowToTable(int ID, String username, String fullname, String loginTime) {
        tableModel.addRow(new Object[]{ID, username, fullname, loginTime});
    }

    private static void addTable(List<LoginHistoryDTO> loginHistoryList) {
        for (LoginHistoryDTO login : loginHistoryList) {
            UsersBUS usersBUS = new UsersBUS();
            UsersDTO user = usersBUS.getById(login.getUId());
            addRowToTable(user.getuID(), user.getuName(), user.getFullname(), login.getLoginTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new loginTimeHistory().setVisible(true));
    }
}