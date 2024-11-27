package component;

import com.toedter.calendar.JDateChooser;
import dto.UsersDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import bus.*;
import dto.*;

import java.util.ArrayList;
import java.util.List;
import static component.adminMenu.reloadAdminTable;

public class userManage extends JPanel {

    private JPanel main_panel;
    private JPanel navigator;
    private JLabel title;

    private JScrollPane main_scroll;
    private JPanel content_side;
    
    private JDateChooser birthdate_value_label;
    private JTextField username_value_label;
    private JTextField fullname_value_label;
    private JTextField address_value_label;
    private JTextField gender_value_label;
    private JTextField email_value_label;
    private JPasswordField password_value_label;
    private JComboBox<String> lock_value_label;
    private JButton manage_button;
    private JButton delete_button;
    private JSeparator separator;

    private JLabel history_login_label;
    private JScrollPane login_scroll;
    private JTable login_table;
    DefaultTableModel tableModel2;

    private JLabel friend_list_label;
    private JScrollPane friend_list_scroll;
    private JTable friend_list_table;
    DefaultTableModel tableModel;

    public userManage(UsersDTO user) {
        initComponents(user);
    }

    private void initComponents(UsersDTO user) {
        main_panel = new JPanel();
        navigator = new JPanel();
        title = new JLabel();
        main_scroll = new JScrollPane();
        content_side = new JPanel();
        JLabel username_label = new JLabel();
        JLabel fullname_label = new JLabel();
        JLabel address_label = new JLabel();
        JLabel birthdate_label = new JLabel();
        JLabel gender_label = new JLabel();
        JLabel email_label = new JLabel();
        JLabel lock_label = new JLabel();
        JLabel password_label = new JLabel();
        username_value_label = new JTextField(user.getuName());
        fullname_value_label = new JTextField(user.getFullname());
        address_value_label = new JTextField(user.getAddress());
        birthdate_value_label = new JDateChooser(user.getBirthDate());
        gender_value_label = new JTextField(user.getGender());
        email_value_label = new JTextField(user.getEmail());
        lock_value_label = new JComboBox<>(new String[]{"Lock", "Unlock"});
        if (user.getIsLocked()) {
            lock_value_label.setSelectedItem("Lock");
        } else {
            lock_value_label.setSelectedItem("Unlock");
        }
        password_value_label = new JPasswordField(user.getPassword());
        manage_button = new JButton();
        delete_button = new JButton();
        history_login_label = new JLabel();
        friend_list_label = new JLabel();
        separator = new JSeparator();

        GroupLayout main_panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 428, Short.MAX_VALUE)
        );
        main_panelLayout.setVerticalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 434, Short.MAX_VALUE)
        );

        navigator.setBackground(new java.awt.Color(153, 204, 255));

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("User Management");

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
                navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navigatorLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navigatorLayout.setVerticalGroup(
                navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navigatorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        main_scroll.setBorder(null);

        content_side.setBackground(new java.awt.Color(255, 255, 255));

        username_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username_label.setText("Username:");

        password_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        password_label.setText("Password:");

        fullname_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fullname_label.setText("Fulllname:");

        address_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        address_label.setText("Address:");

        birthdate_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        birthdate_label.setText("Birthdate:");

        gender_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gender_label.setText("Gender:");

        email_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        email_label.setText("Email:");

        lock_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lock_label.setText("Lock status:");

        manage_button.setBackground(new java.awt.Color(153, 204, 255));
        manage_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manage_button.setForeground(new java.awt.Color(255, 255, 255));
        manage_button.setText("Change");
        manage_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Do you want to change this user?", "Change User", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    String username = username_value_label.getText();
                    String password = password_value_label.getText();
                    String fullname = fullname_value_label.getText();
                    String address = address_value_label.getText();
                    Date birthday = new java.sql.Date(birthdate_value_label.getDate().getTime());
                    String gender = gender_value_label.getText();
                    String email = email_value_label.getText();
                    boolean lock = false;
                    if (lock_value_label.getSelectedItem().equals("Lock")) {
                        lock = true;
                    }
                    user.setuName(username);
                    user.setPassword(password);
                    user.setFullname(fullname);
                    user.setAddress(address);
                    user.setBirthDate(birthday);
                    user.setGender(gender);
                    user.setEmail(email);
                    user.setIsLocked(lock);
                    UsersBUS usersBUS = new UsersBUS();
                    if (usersBUS.updateUser(user) == true) {
                        JOptionPane.showMessageDialog(null, "User deleted successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                        reloadAdminTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });

        delete_button.setBackground(new java.awt.Color(255, 0, 0));
        delete_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete_button.setForeground(new java.awt.Color(255, 255, 255));
        delete_button.setText("Delete");
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Do you want to change this user?", "Change User", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    UsersBUS usersBUS = new UsersBUS();
                    if (usersBUS.deleteUser(user.getuID()) == true) {
                        JOptionPane.showMessageDialog(null, "User updated successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                        reloadAdminTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });


        history_login_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        history_login_label.setText("History of login:");

        friend_list_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        friend_list_label.setText("List of friend:");

        createFriendTableLayout(user.getuID());
        createLoginTableLayout(user.getuID());

        GroupLayout content_sideLayout = new GroupLayout(content_side);
        content_side.setLayout(content_sideLayout);
        content_sideLayout.setHorizontalGroup(
                content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(friend_list_label)
                                        .addComponent(history_login_label))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(friend_list_scroll, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(login_scroll, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                                .addComponent(separator)
                                                .addGap(16, 16, 16))
                                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(username_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(password_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(gender_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_label, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lock_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(gender_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(username_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(password_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_value_label, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lock_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(28, 28, 28))))
                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(manage_button)
                                .addGap(160, 160, 160))
                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(delete_button)
                                .addGap(165, 165, 165))
        );
        content_sideLayout.setVerticalGroup(
                content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(username_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(password_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(fullname_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(address_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(birthdate_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(gender_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(email_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(lock_value_label))
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(username_label)
                                                .addGap(26, 26, 26)
                                                .addComponent(password_label)
                                                .addGap(26, 26, 26)
                                                .addComponent(fullname_label)
                                                .addGap(26, 26, 26)
                                                .addComponent(address_label)
                                                .addGap(26, 26, 26)
                                                .addComponent(birthdate_label)
                                                .addGap(26, 26, 26)
                                                .addComponent(gender_label)
                                                .addGap(26, 26, 26)
                                                .addComponent(email_label)
                                                .addGap(26, 26, 26)
                                                .addComponent(lock_label)))
                                .addGap(18, 18, 18)
                                .addComponent(manage_button)
                                .addGap(18, 18, 18)
                                .addComponent(delete_button)
                                .addGap(18, 18, 18)
                                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(history_login_label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(login_scroll, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(friend_list_label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(friend_list_scroll, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        main_scroll.setViewportView(content_side);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 441, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(main_scroll, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                                .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 446, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(main_scroll, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)))
        );
    }

    private void createFriendTableLayout(int uID) {
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Username", "Status", "Fullname", "No. F"});
        friend_list_table = new JTable(tableModel);

        friend_list_table.setRowHeight(30);
        friend_list_table.getColumnModel().getColumn(0).setPreferredWidth(100);
        friend_list_table.getColumnModel().getColumn(1).setPreferredWidth(140);
        friend_list_table.getColumnModel().getColumn(2).setPreferredWidth(60);
        friend_list_table.getColumnModel().getColumn(3).setPreferredWidth(250);
        friend_list_table.getColumnModel().getColumn(4).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        friend_list_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        friend_list_table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        friend_list_table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        FriendListBUS friendListBUS = new FriendListBUS();
        UsersBUS usersBUS = new UsersBUS();
        List<Integer> friendListID = friendListBUS.getFriends(uID);
        List<UsersDTO> friendList = new ArrayList<>();
        for (int id : friendListID) {
            UsersDTO user = usersBUS.getById(id);
            friendList.add(user);
        }
        addFriendTable(friendList);

        friend_list_scroll = new JScrollPane(friend_list_table);
    }

    private void addRowToTableFriend(int uId, String username, String status, String fullname, int NoF) {
        tableModel.addRow(new Object[]{uId, username, status, fullname, NoF});
    }

    private void addFriendTable(List<UsersDTO> friendList) {
        for (UsersDTO friend : friendList) {
            FriendListBUS friendListBUS = new FriendListBUS();
            List<Integer> FoF = friendListBUS.getFriends(friend.getuID());
            int NoF = FoF.size();
            addRowToTableFriend(friend.getuID(), friend.getuName(), friend.getStatus(), friend.getFullname(), NoF);
        }
    }
    
    private void createLoginTableLayout(int uID) {
        tableModel2 = new DefaultTableModel(new Object[][]{}, new String[]{"UserID", "Time"});
        login_table = new JTable(tableModel2);

        login_table.setRowHeight(30);
        login_table.getColumnModel().getColumn(0).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        login_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        login_table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        LoginHistoryBUS loginHistoryBUS = new LoginHistoryBUS();
        List<LoginHistoryDTO> loginList = loginHistoryBUS.getLoginHistory(uID);
        addLoginTable(loginList);

        login_scroll = new JScrollPane(login_table);
    }

    private void addRowToTableLogin(int id, String time) {
        tableModel2.addRow(new Object[]{id, time});
    }

    private void addLoginTable(List<LoginHistoryDTO> loginHistory) {
        for (LoginHistoryDTO login : loginHistory) {
            addRowToTableLogin(login.getUId(), login.getLoginTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
    }

}
