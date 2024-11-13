import javax.swing.*;

public class friendRequestWindow extends javax.swing.JPanel {

    private final JPanel main_panel;

    private final JPanel navigator;
    private final JLabel title;
    private final JButton search_button;
    private final JTextField search_input;
    private final JButton sort_button;
    
    private final JScrollBar scroll_bar;

    public friendRequestWindow() {
        main_panel = new javax.swing.JPanel();
        navigator = new javax.swing.JPanel();
        search_input = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        sort_button = new javax.swing.JButton();
        scroll_bar = new javax.swing.JScrollBar();

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

        javax.swing.GroupLayout navigatorLayout = new javax.swing.GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navigatorLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(sort_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_button))
                    .addGroup(navigatorLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(title)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sort_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                
                .addContainerGap())
        );

        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    private void sortFriendRequest(java.awt.event.ActionEvent evt) {} 

    private void inputSearch(java.awt.event.ActionEvent evt) {}

    private void searchFriendRequest(java.awt.event.ActionEvent evt) {}

    private void createFriendRequest(String name, String status) {

    }
}