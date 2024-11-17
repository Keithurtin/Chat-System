package component;

import java.awt.*;
import javax.swing.*;

public class friendRequestWindow extends JFrame {
    private JPanel navigator;
    
    private JScrollPane list_scroll;
    private JPanel list_side;
    private GroupLayout.ParallelGroup horizontalGroup;
    private GroupLayout.SequentialGroup verticalGroup;

    public friendRequestWindow() {
        JPanel main_panel = new JPanel();
        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setPreferredSize(new java.awt.Dimension(620, 500));

        setupNavigatorLayout();

        createListSide();

        GroupLayout main_panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(list_scroll)
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list_scroll, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
        );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension panelSize = main_panel.getPreferredSize();
        add(main_panel);
        setResizable(false);
        setLocation(600, 180);
        setSize(panelSize);
    }

    private void setupNavigatorLayout() {
        navigator = new JPanel();
        navigator.setBackground(new java.awt.Color(153, 204, 255));

        JTextField search_input = new JTextField("Search...");
        search_input.addActionListener(e -> inputSearch());

        JButton search_button = new JButton("Search");
        search_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search_button.addActionListener(e -> searchFriendRequest());

        JLabel title = new JLabel("Friend Request");
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));

        JButton sort_button = new JButton("Sort");
        sort_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sort_button.addActionListener(e -> sortFriendRequest());

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(navigatorLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(sort_button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_button))
                    .addGroup(navigatorLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(title)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sort_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void createListSide() {
        list_side = new JPanel();
        list_side.setBackground(new java.awt.Color(255, 255, 255));

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
        
        addFriendRequest("ABC", false);
        addFriendRequest("XYC", true);
        addFriendRequest("XYV", false);
    }

    private void addFriendRequest(String name, boolean status) {
        JPanel newRequest = new friendRequest(name, status);
        horizontalGroup.addComponent(newRequest, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE);
        verticalGroup.addComponent(newRequest, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);

        list_side.add(newRequest);
        list_side.revalidate();
        list_side.repaint();
    }

    private void sortFriendRequest() {} 

    private void inputSearch() {}

    private void searchFriendRequest() {}

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new friendRequestWindow().setVisible(true));
    }
}