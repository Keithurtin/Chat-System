package presentation.User;

import bus.GroupChatBUS;
import bus.GroupMembersBUS;
import dao.GroupMembersDAO;
import dto.GroupChatDTO;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class createOrAddGroupWindow extends JFrame{
    private JPanel list_side;
    private static int uid;
    private static int uid2;
    private GroupLayout.ParallelGroup horizontalGroup;
    private GroupLayout.SequentialGroup verticalGroup;

    public static void main(String[] args) {
        JFrame window = new createOrAddGroupWindow(1, 2);
        window.setVisible(true);
    }

    public createOrAddGroupWindow(int uID, int uID2) {
        uid = uID;
        uid2 = uID2;
        initComponents();
    }

    private void initComponents() {
        JPanel menu = new JPanel();
        menu.setBackground(new Color(255, 255, 255));
        menu.setFocusable(false);
        menu.setPreferredSize(new Dimension(620, 500));

        JPanel navigator = setupNavigatorLayout();
        JScrollPane list_scroll = createGroupList();

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

        JButton newGroup = new JButton("New");
        newGroup.addActionListener(_ -> addNewGroup());

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);

        navigatorLayout.setHorizontalGroup(
                navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navigatorLayout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(title)
                                .addGap(18, 18, 18)
                                .addComponent(newGroup))
        );

        navigatorLayout.setVerticalGroup(
                navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(newGroup, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(14, 14, 14)
                                .addContainerGap())
        );

        return navigator;
    }

    private JScrollPane createGroupList() {
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
        loadGroup();
        return  list_scroll;
    }

    private void loadGroup() {
        GroupMembersDAO groupMembersDAO = new GroupMembersDAO();
        List<Integer> groups1 = groupMembersDAO.getGroupID(uid);
        List<Integer> groups2 = groupMembersDAO.getGroupID(uid2);

        Set<Integer> idSet = new HashSet<>(groups2);

        List<Integer> result = groups1.stream()
                .filter(id -> !idSet.contains(id))
                .collect(Collectors.toList());


        GroupChatBUS groupChatBUS = new GroupChatBUS();
        for (int id : result) {
            GroupChatDTO group = groupChatBUS.getById(id);
            addGroupToList(group);
        }
    }

    private void addGroupToList(GroupChatDTO group) {
        JPanel user_panel = new JPanel();
        user_panel.setPreferredSize(new Dimension(0, 85));

        JLabel user_name = new JLabel(group.getName());
        user_name.setFont(new Font("Segoe UI", 1, 18));

        JButton add_button = new JButton("Add");
        add_button.addActionListener(e -> {
            GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
            groupMembersBUS.addMember(group.getGID(), uid2);
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
                                        .addComponent(user_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                .addComponent(add_button)
                                .addGap(45, 45, 45))
        );
        user_panelLayout.setVerticalGroup(
                user_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(user_panelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(user_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
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

    public void addNewGroup() {
        JFrame frame = new JFrame("Name Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocation(730, 300);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        panel.setLayout(null);
        JLabel nameLabel = new JLabel("Enter group name:");
        nameLabel.setBounds(10, 20, 120, 25);
        panel.add(nameLabel);
        JTextField nameText = new JTextField(20);
        nameText.setBounds(140, 20, 150, 25);
        panel.add(nameText);
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(_ -> {
            GroupChatBUS groupChatBUS = new GroupChatBUS();
            if(nameText.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter group name", "Fail", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int gid = groupChatBUS.addNewGroup(nameText.getText(), uid);
            if(gid != -1) {
                GroupMembersBUS groupMembersBUS = new GroupMembersBUS();
                groupMembersBUS.addMember(gid, uid);
                groupMembersBUS.addMember(gid, uid2);
                JOptionPane.showMessageDialog(this, "You have created new group", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            frame.dispose();
        });
        submitButton.setBounds(100, 60, 80, 25);
        panel.add(submitButton);
        frame.setVisible(true);
    }
}
