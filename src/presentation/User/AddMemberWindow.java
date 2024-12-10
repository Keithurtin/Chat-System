package presentation.User;

import bus.GroupMembersBUS;
import bus.UsersBUS;
import dao.FriendListDAO;
import dao.GroupMembersDAO;
import dto.GroupMembersDTO;
import dto.UsersDTO;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.*;


public class AddMemberWindow extends JFrame {
    //id
    private static int uid;
    private static int gid;
    //component
    private JPanel list_side;
    private GroupLayout.ParallelGroup horizontalGroup;
    private GroupLayout.SequentialGroup verticalGroup;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddMemberWindow frame = new AddMemberWindow(1, 1);
            frame.setVisible(true);
        });
    }
    //constructor
    public AddMemberWindow(int gID, int uID) {
        uid = uID;
        gid = gID;
        JPanel menu = new JPanel();
        menu.setBackground(new Color(255, 255, 255));
        menu.setFocusable(false);
        menu.setPreferredSize(new Dimension(620, 500));

        JPanel navigator = setupNavigatorLayout();
        JScrollPane list_scroll = createMemberList();

        GroupLayout menuLayout = new GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
                menuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(list_scroll, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
                menuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(menuLayout.createSequentialGroup()
                                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(list_scroll, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension panelSize = menu.getPreferredSize();
        add(menu);
        setResizable(false);
        setLocation(620, 200);
        setSize(panelSize);
    }
    
    private JPanel setupNavigatorLayout() {
        JPanel navigator = new JPanel();
        JLabel title = new JLabel("Add Member Menu");

        navigator.setBackground(new Color(153, 204, 255));
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Segoe UI", 1, 24));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(title)
                .addGap(18, 18, 18)))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addContainerGap())
        );
        return navigator;
    }

    private JScrollPane createMemberList() {
        list_side = new JPanel();
        list_side.setBackground(new Color(255, 255, 255));

        GroupLayout list_sideLayout = new GroupLayout(list_side);
        list_side.setLayout(list_sideLayout);

        horizontalGroup = list_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        verticalGroup = list_sideLayout.createSequentialGroup();

        list_sideLayout.setHorizontalGroup(
            list_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(horizontalGroup)
        );

        list_sideLayout.setVerticalGroup(
            list_sideLayout.createSequentialGroup()
                .addGroup(verticalGroup)
        );

        JScrollPane list_scroll = new JScrollPane(list_side);
        list_scroll.setBorder(null);
        loadUsers();
        return  list_scroll;
    }
    //load friend not in group
    private void loadUsers() {
        GroupMembersDAO groupMembersDAO = new GroupMembersDAO();
        List<GroupMembersDTO> memberList = groupMembersDAO.getAll(gid);
        FriendListDAO friendListDAO = new FriendListDAO();
        List<Integer> idList = friendListDAO.getFriends(uid);

        Set<Integer> memberUIDs = memberList.stream()
                .map(GroupMembersDTO::getUID)
                .collect(Collectors.toSet());

        List<Integer> result = idList.stream()
                .filter(friendId -> !memberUIDs.contains(friendId))
                .collect(Collectors.toList());

        UsersBUS usersBUS = new UsersBUS();
        for (int id : result) {
            UsersDTO friend = usersBUS.getById(id);
            addFriendToList(friend);
        }
    }
    //add loaded friend to list
    private void addFriendToList(UsersDTO user) {
        JPanel user_panel = new JPanel();
        user_panel.setPreferredSize(new Dimension(0, 85));

        JLabel user_name = new JLabel(user.getuName());
        user_name.setFont(new Font("Segoe UI", 1, 18));

        JLabel user_status = new JLabel("<html> Status: " + (user.getStatus().equals("online") ? "<span style='color: green; font-weight: bold;'>Online" : "<span style='color: red; font-weight: bold;'>Offline") + "</span></html>");

        JButton add_button = new JButton("Add");
        add_button.addActionListener(e -> {
            GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
            groupMembersBUS.addMember(gid, user.getuID());
            list_side.remove(user_panel);
            list_side.revalidate();
            list_side.repaint();
        });
        add_button.setFont(new Font("Segoe UI", 1, 12));

        GroupLayout user_panelLayout = new GroupLayout(user_panel);
        user_panel.setLayout(user_panelLayout);
        user_panelLayout.setHorizontalGroup(
            user_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(user_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(user_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(user_status, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                    .addComponent(user_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(add_button)
                .addGap(45, 45, 45))
        );
        user_panelLayout.setVerticalGroup(
            user_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(user_panelLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(user_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_status, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(user_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(add_button)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalGroup.addComponent(user_panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE);
        verticalGroup.addComponent(user_panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);

        list_side.add(user_panel);
        list_side.revalidate();
        list_side.repaint();
    }
}
