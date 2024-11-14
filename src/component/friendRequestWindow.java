import javax.swing.*;

public class friendRequestWindow extends JPanel {

    private final JPanel main_panel;

    private final JPanel navigator;
    private final JLabel title;
    private final JButton search_button;
    private final JTextField search_input;
    private final JButton sort_button;
    
    private JScrollPane friend_scroll;
    private JPanel friend_side;

    public friendRequestWindow() {
        main_panel = new JPanel();
        navigator = new JPanel();
        search_input = new JTextField();
        search_button = new JButton();
        title = new JLabel();
        sort_button = new JButton();
        friend_side = new JPanel();

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setPreferredSize(new java.awt.Dimension(620, 500));

        navigator.setBackground(new java.awt.Color(153, 204, 255));

        search_input.setText("Search...");
        search_input.addActionListener(this::inputSearch);

        search_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search_button.setText("Search");
        search_button.addActionListener(this::searchFriendRequest);

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Friend Request");

        sort_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sort_button.setText("Sort ");
        sort_button.addActionListener(this::sortFriendRequest);

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

        friend_side.setLayout(new BoxLayout(friend_side, BoxLayout.Y_AXIS));

        friend_scroll = new JScrollPane(friend_side);
        friend_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
        friend_scroll.getVerticalScrollBar().setValue(friend_scroll.getVerticalScrollBar().getMaximum());

        friend_scroll.setViewportView(friend_side);

        GroupLayout main_panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(friend_scroll)
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friend_scroll, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
        );
    }

    private void sortFriendRequest(java.awt.event.ActionEvent evt) {} 

    private void inputSearch(java.awt.event.ActionEvent evt) {}

    private void searchFriendRequest(java.awt.event.ActionEvent evt) {}

    private void createFriendRequest(String name, String status) {

    }
}