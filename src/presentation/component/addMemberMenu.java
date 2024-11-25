package component;

import java.awt.*;
import javax.swing.*;

public class addMemberMenu extends JFrame {
    private JPanel navigator;
    private JScrollPane list_scroll;
    private JPanel list_side;
    private GroupLayout.ParallelGroup horizontalGroup;
    private GroupLayout.SequentialGroup verticalGroup;

    public addMemberMenu() {
        initComponents();
    }

    private void initComponents() {
        JPanel menu = new JPanel();
        menu.setBackground(new Color(255, 255, 255));
        menu.setFocusable(false);
        menu.setPreferredSize(new Dimension(620, 500));
        
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

        Dimension panelSize = menu.getPreferredSize();
        add(menu);
        setResizable(false);
        setLocation(620, 200);
        setSize(panelSize);
    }
    
    private void setupNavigatorLayout() {
        navigator = new JPanel();

        JTextField search_input = new JTextField();
        JButton search_button = new JButton("Search");
        JLabel title = new JLabel("Add Member Menu");

        navigator.setBackground(new Color(153, 204, 255));
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Segoe UI", 1, 24));
        search_button.setFont(new Font("Segoe UI", 1, 14));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(title)
                    .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(search_button)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        addGroupToList("ABD", true);
        addGroupToList("XYC", false);
        addGroupToList("ASC", true);
    }

    private void addGroupToList(String name, boolean isOn) {
        JPanel user_panel = new JPanel();
        user_panel.setPreferredSize(new Dimension(0, 85));

        JLabel user_name = new JLabel(name);
        user_name.setFont(new Font("Segoe UI", 1, 18));

        JLabel user_status = new JLabel("<html> Status: " + (isOn ? "<span style='color: green; font-weight: bold;'>Online" : "<span style='color: red; font-weight: bold;'>Offline") + "</span></html>");

        JButton group_information_button = new JButton("Add");
        group_information_button.setFont(new Font("Segoe UI", 1, 12));

        GroupLayout user_panelLayout = new GroupLayout(user_panel);
        user_panel.setLayout(user_panelLayout);
        user_panelLayout.setHorizontalGroup(
            user_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(user_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(user_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(user_status, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                    .addComponent(user_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(group_information_button)
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
                .addComponent(group_information_button)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalGroup.addComponent(user_panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE);
        verticalGroup.addComponent(user_panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);

        list_side.add(user_panel);
        list_side.revalidate();
        list_side.repaint();
    }
}
