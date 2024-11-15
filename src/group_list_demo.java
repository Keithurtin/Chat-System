import java.awt.*;
import javax.swing.*;

public class group_list_demo extends JFrame {
    private JPanel navigator;
    private JScrollPane list_scroll;
    private JPanel content_side;
    private GroupLayout.ParallelGroup horizontalGroup;
    private GroupLayout.SequentialGroup verticalGroup;

    public group_list_demo() {
        initComponents();
    }

    private void initComponents() {
        JPanel menu = new JPanel();
        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setFocusable(false);
        menu.setPreferredSize(new java.awt.Dimension(620, 500));

        setupNavigatorLayout();
        createGroupList();

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
        setLocation(600, 180);
        setSize(panelSize);
    }
    
    private void setupNavigatorLayout() {
        navigator = new JPanel();
        navigator.setBackground(new Color(153, 204, 255));
        JLabel title = new JLabel("Spam Report Management");
        title.setFont(new Font("Segoe UI", 1, 24));
        title.setForeground(Color.WHITE);

        JLabel sortLabel = new JLabel("Sort by:");
        sortLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        sortLabel.setForeground(new java.awt.Color(255, 255, 255));
        JComboBox<String> sort_options = new JComboBox<>(new String[]{"Name", "Created Date"});

        sort_options.addActionListener(e -> {
            String selectedOption = (String) sort_options.getSelectedItem();
            System.out.println("Sorting by: " + selectedOption);
        });

        sort_options.setFont(new java.awt.Font("Segoe UI", 0, 14));

        JButton search_button = new JButton("Search");
        search_button.setFont(new java.awt.Font("Segoe UI", 1, 14));

        JTextField search_input = new JTextField("Search");
        search_input.setFont(new java.awt.Font("Segoe UI", 0, 14));

        search_button.addActionListener(e -> {
            String filterText = search_input.getText();
            System.out.println("Filtering by name: " + filterText);
        });

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                        .addComponent(sortLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sort_options, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_button)
                        .addGap(66, 66, 66))))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sortLabel)
                    .addComponent(sort_options)
                    .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(search_button, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }

    private void createGroupList() {
        content_side = new JPanel();
        content_side.setBackground(new java.awt.Color(255, 255, 255));

        GroupLayout content_sideLayout = new GroupLayout(content_side);
        content_side.setLayout(content_sideLayout);

        horizontalGroup = content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        verticalGroup = content_sideLayout.createSequentialGroup();

        content_sideLayout.setHorizontalGroup(
            content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(horizontalGroup)
        );

        content_sideLayout.setVerticalGroup(
            content_sideLayout.createSequentialGroup()
                .addGroup(verticalGroup)
        );

        list_scroll = new JScrollPane(content_side);
        list_scroll.setBorder(null);

        addGroupToList("Group 1", "12/12/2004");
        addGroupToList("Group 2", "14/12/2004");
        addGroupToList("Group 3", "14/12/2004");
    }

    private void addGroupToList(String name, String createdDate) {
        JPanel group_panel = new JPanel();
        group_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        JLabel group_name = new JLabel(name);
        group_name.setFont(new java.awt.Font("Segoe UI", 1, 18));

        JLabel group_created_date = new JLabel("created date: " + createdDate);

        JButton group_information_button = new JButton("Information");
        group_information_button.setFont(new java.awt.Font("Segoe UI", 1, 12));
        group_information_button.addActionListener(e -> openGroupInformation(name));

        GroupLayout group_panelLayout = new GroupLayout(group_panel);
        group_panel.setLayout(group_panelLayout);
        group_panelLayout.setHorizontalGroup(
            group_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(group_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(group_created_date, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(group_information_button)
                .addGap(45, 45, 45))
        );
        group_panelLayout.setVerticalGroup(
            group_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(group_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_created_date, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(group_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(group_information_button)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalGroup.addComponent(group_panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE);
        verticalGroup.addComponent(group_panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);

        content_side.add(group_panel);
        content_side.revalidate();
        content_side.repaint();
    }

    private void openGroupInformation(String name) {
        group_manage_demo newWindow = new group_manage_demo(name);
        newWindow.setVisible(true);
    }
}
