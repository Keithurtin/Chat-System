import javax.swing.*;

public class groupManageWindow extends JPanel {
    private final JPanel group_list_panel;
    private final JPanel member1_panel;
    private final JPanel member2_panel;
    private final JPanel group_list_navigator;
    private final JLabel group_list_title;
    private final JLabel member1_name;
    private final JLabel member2_name;
    private final JLabel member1_status;
    private final JLabel member2_status;
    private final JButton member1_remove_button;
    private final JButton member2_remove_button;
    private final JButton group_list_sort_button;
    private final JButton group_list_search_button;
    private final JButton group_list_add_button;
    private final JTextField group_list_search_input;
    private final JScrollBar group_list_scroll_bar;

    public groupManageWindow(){
        group_list_panel = new JPanel();
        member1_panel = new JPanel();
        member2_panel = new JPanel();
        group_list_navigator  = new JPanel();
        group_list_title = new JLabel();
        member1_name = new JLabel();
        member2_name = new JLabel();
        member1_status = new JLabel();
        member2_status = new JLabel();
        member1_remove_button = new JButton();
        member2_remove_button = new JButton();
        group_list_sort_button = new JButton();
        group_list_search_button = new JButton();
        group_list_add_button = new JButton();
        group_list_search_input = new JTextField();
        group_list_scroll_bar = new JScrollBar();

         group_list_panel.setBackground(new java.awt.Color(255, 255, 255));
        group_list_panel.setPreferredSize(new java.awt.Dimension(620, 500));

        group_list_navigator.setBackground(new java.awt.Color(153, 204, 255));

        group_list_search_input.setText("Search...");

        group_list_search_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        group_list_search_button.setText("Search");

        group_list_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        group_list_title.setForeground(new java.awt.Color(255, 255, 255));
        group_list_title.setText("Group member list");

        group_list_sort_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        group_list_sort_button.setText("Sort ");

        group_list_add_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        group_list_add_button.setText("Add");

        javax.swing.GroupLayout group_list_navigatorLayout = new javax.swing.GroupLayout(group_list_navigator);
        group_list_navigator.setLayout(group_list_navigatorLayout);
        group_list_navigatorLayout.setHorizontalGroup(
            group_list_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_list_navigatorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(group_list_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(group_list_title)
                    .addGroup(group_list_navigatorLayout.createSequentialGroup()
                        .addComponent(group_list_sort_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(group_list_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_list_search_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_list_add_button, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );
        group_list_navigatorLayout.setVerticalGroup(
            group_list_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, group_list_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(group_list_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(group_list_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(group_list_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_list_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_list_sort_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_list_add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        member1_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        member1_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        member1_name.setText("ABC");

        member1_remove_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        member1_remove_button.setText("Remove");

        member1_status.setText("status");

        javax.swing.GroupLayout member1_panelLayout = new javax.swing.GroupLayout(member1_panel);
        member1_panel.setLayout(member1_panelLayout);
        member1_panelLayout.setHorizontalGroup(
            member1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(member1_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(member1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(member1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(member1_status, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(member1_remove_button)
                .addGap(20, 20, 20))
        );
        member1_panelLayout.setVerticalGroup(
            member1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(member1_panelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(member1_remove_button)
                .addGap(31, 31, 31))
            .addGroup(member1_panelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(member1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(member1_status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        member2_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        member2_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        member2_name.setText("DEF");

        member2_remove_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        member2_remove_button.setText("Remove");

        member2_status.setText("status");

        javax.swing.GroupLayout member2_panelLayout = new javax.swing.GroupLayout(member2_panel);
        member2_panel.setLayout(member2_panelLayout);
        member2_panelLayout.setHorizontalGroup(
            member2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(member2_panelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(member2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(member2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(member2_status, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(member2_remove_button)
                .addGap(19, 19, 19))
        );
        member2_panelLayout.setVerticalGroup(
            member2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(member2_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(member2_remove_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, member2_panelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(member2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(member2_status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout group_list_panelLayout = new javax.swing.GroupLayout(group_list_panel);
        group_list_panel.setLayout(group_list_panelLayout);
        group_list_panelLayout.setHorizontalGroup(
            group_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(group_list_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(group_list_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(group_list_scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(group_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(member1_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addComponent(member2_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                .addContainerGap())
        );
        group_list_panelLayout.setVerticalGroup(
            group_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_list_panelLayout.createSequentialGroup()
                .addComponent(group_list_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(group_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(group_list_scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(group_list_panelLayout.createSequentialGroup()
                        .addComponent(member1_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(member2_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 227, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }
}