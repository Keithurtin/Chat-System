import javax.swing.*;

public class groupManageWindow extends JPanel {
    private final JPanel main_panel;
    private final JPanel navigator;
    private final JLabel title;
    private final JButton sort_button;
    private final JButton search_button;
    private final JButton add_button;
    private final JTextField search_input;
    private final JPanel list_side;
    private final JScrollPane list_scroll;

    public groupManageWindow(){
        main_panel = new JPanel();
        navigator  = new JPanel();
        title = new JLabel("Group member list");
        sort_button = new JButton("Sort ");
        search_button = new JButton("Search");
        add_button = new JButton("Add");
        search_input = new JTextField("Search...");
        list_side = new JPanel();

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setPreferredSize(new java.awt.Dimension(620, 500));

        navigator.setBackground(new java.awt.Color(153, 204, 255));

        search_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search_button.addActionListener(e -> searchMember());

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));

        sort_button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        sort_button.addActionListener(e -> sortMember());

        add_button.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add_button.addActionListener(e -> addMember());

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(title)
                    .addGroup(navigatorLayout.createSequentialGroup()
                        .addComponent(sort_button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_button)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add_button, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(46, 46, 46))
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
                    .addComponent(sort_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        list_side.setBackground(new java.awt.Color(255, 255, 255));
        list_side.setLayout(new BoxLayout(list_side, BoxLayout.Y_AXIS));

        list_scroll = new JScrollPane(list_side);
        list_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        list_scroll.getVerticalScrollBar().setValue(list_scroll.getVerticalScrollBar().getMaximum());

        GroupLayout panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list_scroll, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(list_scroll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    private void addMember() {}
    private void searchMember() {}
    private void sortMember() {}
}