package Admin;

import dao.GroupMembersDAO;
import dto.*;
import bus.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class groupManage extends JFrame {
    JPanel navigator;
    JScrollPane table_scroll;
    JTable table;
    private DefaultTableModel tableModel;

    public groupManage(int gID, String name) {
        JPanel menu = new JPanel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setPreferredSize(new java.awt.Dimension(620, 500));

        setupNavigatorLayout(gID, name);
        createTableLayout(gID);

        GroupLayout admin_menuLayout = new GroupLayout(menu);
        menu.setLayout(admin_menuLayout);
        admin_menuLayout.setHorizontalGroup(
                admin_menuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(table_scroll, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        admin_menuLayout.setVerticalGroup(
                admin_menuLayout.createSequentialGroup()
                        .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(table_scroll, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        setResizable(false);
        setLocation(400, 150);
        pack();
    }   

    private void setupNavigatorLayout(int gID, String name) {
        navigator = new JPanel();
        JLabel title = new JLabel("Group " + name);
        JComboBox<String> choose_type = new JComboBox<>(new String[]{"Member", "Admin"});

        choose_type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                String comp = (String) choose_type.getSelectedItem();
                if (comp == "Member") {
                    GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
                    addTable(groupMembersBUS.getAll(gID));
                } else if (comp == "Admin") {
                    GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
                    addTable(groupMembersBUS.getAdmin(gID));
                }
            }
        });

        navigator.setBackground(new java.awt.Color(153, 204, 255));

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(choose_type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choose_type))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void createTableLayout(int gID) {
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Index", "Username", "Status", "Admin"});
        table = new JTable(tableModel);

        table.setRowHeight(30);

        table.getColumnModel().getColumn(0).setPreferredWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        table_scroll = new JScrollPane(table);

        GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
        addTable(groupMembersBUS.getAll(gID));
    }

    private void addTable(List<GroupMembersDTO> members) {
        UsersBUS usersBUS = new UsersBUS();
        for (GroupMembersDTO member : members) {
            UsersDTO info = usersBUS.getById(member.getUID());
            addRowToTable(info.getuID(), info.getuName(), info.getStatus(), member.isAdmin());
        }
    }

    private void addRowToTable(int uID, String username, String status, boolean isAdmin) {
        tableModel.addRow(new Object[]{uID, username, status, isAdmin? "Yes" : ""});
    }
}