package component;

import javax.swing.*;
import java.awt.*;
import dto.*;
import bus.*;
import java.util.List;

public class groupManageWindow extends JFrame {

    private JPanel navigator;
    private int gid;
    private static int uid;
    private static boolean isAdmin;
    private JPanel list_side;
    private JScrollPane list_scroll;
    private GroupLayout.ParallelGroup horizontalGroup;
    private GroupLayout.SequentialGroup verticalGroup;

    public groupManageWindow(int gID, int uID) {
        gid = gID;
        uid = uID;
        JPanel menu = new JPanel();

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setFocusable(false);
        menu.setPreferredSize(new java.awt.Dimension(620, 500));

        setupNavigatorLayout();
        createMemberList();

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
        loadMember();
        Dimension panelSize = menu.getPreferredSize();
        add(menu);
        setResizable(false);
        setLocation(600, 180);
        setSize(panelSize);
    }

    private void setupNavigatorLayout() {
        JLabel title = new JLabel("Group Members List");
        JButton add_button = new JButton("Add Member");

        navigator = new JPanel();
        navigator.setBackground(new Color(153, 204, 255));

        title.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new Color(255, 255, 255));
        add_button.setFont(new Font("Segoe UI", 1, 12));
        add_button.addActionListener(e -> openAddMemberWindow());

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);

        navigatorLayout.setHorizontalGroup(
                navigatorLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(add_button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(title)
                        .addContainerGap(120, Short.MAX_VALUE)
        );

        navigatorLayout.setVerticalGroup(
                navigatorLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(add_button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE) // Button
                                .addComponent(title)
                        )
                        .addGap(15, 15, 15)
        );
    }

    private void createMemberList() {
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

        list_scroll = new JScrollPane(list_side);
        list_scroll.setBorder(null);
    }

    private void loadMember() {
        list_side.removeAll();
        GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
        List<GroupMembersDTO> memberList = groupMembersBUS.getAll(gid);
        for(GroupMembersDTO member : memberList) {
            if(uid == member.getUID()) {
                isAdmin = member.isAdmin();
            }
        }
        for(GroupMembersDTO member : memberList) {
            addMemberToList(member);
        }
        list_side.revalidate();
        list_side.repaint();
    }

    private void addMemberToList(GroupMembersDTO member) {
        UsersBUS usersBUS = new UsersBUS();
        UsersDTO user = usersBUS.getById(member.getUID());

        JPanel member_panel = new JPanel();
        member_panel.setPreferredSize(new Dimension(0, 85));

        JLabel member_name = new JLabel("<html>" + user.getuName() + (member.isAdmin() ? " <span style='color: red; font-weight: bold;'>ADMIN</span></html>" : "</html>"));
        member_name.setFont(new Font("Segoe UI", 1, 14));

        JLabel member_status = new JLabel("<html> Status:" + ((user.getStatus()).equals("online") ? "<span style='color: green; font-weight: bold;'>Online" : "<span style='color: red; font-weight: bold;'>Offline") + "</span></html>");

        JButton more_button = new JButton("More");
        more_button.setFont(new Font("Segoe UI", 1, 12));

        JPopupMenu more_menu = new JPopupMenu();

        JMenuItem chat_button = new JMenuItem("Chat");
        more_menu.add(chat_button);

        if(isAdmin){
            JMenuItem kick_button = new JMenuItem("Kick");
            JMenuItem assign_button = new JMenuItem("Assign Admin");

            more_menu.add(kick_button);
            more_menu.add(assign_button);
        }

        more_button.addActionListener(e -> more_menu.show(more_button, 0, more_button.getHeight()));

        GroupLayout member_panelLayout = new GroupLayout(member_panel);
        member_panel.setLayout(member_panelLayout);
        member_panelLayout.setHorizontalGroup(
                member_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(member_panelLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(member_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(member_status, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(member_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                                .addComponent(more_button)
                                .addGap(45, 45, 45))
        );
        member_panelLayout.setVerticalGroup(
                member_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(member_panelLayout.createSequentialGroup()
                                .addContainerGap(9, Short.MAX_VALUE)
                                .addComponent(member_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(member_status, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                        .addGroup(member_panelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(more_button)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Update the GroupLayout groups
        horizontalGroup.addComponent(member_panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE);
        verticalGroup.addComponent(member_panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);
    }

    private void openAddMemberWindow() {
        component.addMemberMenu newWindow = new component.addMemberMenu(gid, uid);
        newWindow.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            groupManageWindow frame = new groupManageWindow(1, 1);
            frame.setVisible(true);
        });
    }
}
