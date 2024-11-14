import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chat_GUI_demo extends javax.swing.JFrame {
 
    private JPanel chatPanel;
    private CardLayout cardLayout;                      
    private final JButton friend_chat_more_button;
    private final JPanel chat_navigator;
    private final JScrollBar chat_scroll_bar;
    private final JButton friend1_request_approve_button;
    private final JLabel friend1_request_name;
    private final JButton friend1_request_reject_button;
    private final JLabel friend1_request_status;
    private final JButton friend2_request_approve_button;
    private final JLabel friend2_request_name;
    private final JButton friend2_request_reject_button;
    private final JLabel friend2_request_status;
    private final JPanel friend_request_friend1_panel;
    private final JPanel friend_request_friend2_panel;
    private final JPanel friend_request_navigator;
    private final JPanel friend_request_panel;
    private final JScrollBar friend_request_scroll_bar;
    private final JButton friend_request_search_button;
    private final JTextField friend_request_search_input;
    private final JButton friend_request_sort_button;
    private final JLabel friend_request_title;
    private final JTextField friend_chat_input_message;
    private final JPanel friend_chat_panel;
    private final JButton friend_chat_send_button;
    private final JLabel friend_name;
    private final JPanel friend_panel;
    private final JLabel friend_status;
    private final JLabel group_member_label;
    private final JButton group_chat_change_name_button;
    private final JTextField group_chat_input_message;
    private final JLabel group_chat_label;
    private final JButton group_chat_manage;
    private final JLabel group_chat_name;
    private final JPanel group_chat_navigator;
    private final JLabel group_chat_number_member;
    private final JPanel group_chat_panel;
    private final JButton group_chat_report_button;
    private final JScrollBar group_chat_scroll_bar;
    private final JButton group_chat_send_button;
    private final JPanel group_chat_send_message;
    private final JPanel group_panel;
    private final JPanel not_friend_panel;
    private final JLabel not_friend_name_label;
    private final JButton not_friend_send_request_button;
    private final JLabel name_chat_label;
    private final JButton side_sort_button;
    private final JButton report_user_button;
    private final JPanel send_message;
    private final JButton side_more_button;
    private final JPanel side_navigator;
    private final JPanel side_panel;
    private final JScrollBar side_scroll_bar;
    private final JButton side_search_button;
    private final JTextField side_search_input;
    private final JLabel status_chat_label;  
    private final JLabel blank_chat_description;
    private final JLabel blank_chat_label;
    private final JPanel blank_chat_panel;
    private final JPanel blank_chat_navigator;
    private final JButton profile_change_password_button;
    private final JLabel profile_email_label;
    private final JButton profile_manage_email_button;
    private final JButton profile_manage_name_button;
    private final JLabel profile_name_label;
    private final JPanel profile_navigator;
    private final JLabel profile_num_friend_label;
    private final JPanel profile_panel;
    private final JLabel profile_password_label;
    private final JLabel profile_title;

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

    public chat_GUI_demo() {

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

        group_chat_panel = new javax.swing.JPanel();
        group_chat_navigator = new javax.swing.JPanel();
        group_chat_report_button = new javax.swing.JButton();
        group_chat_name = new javax.swing.JLabel();
        group_chat_manage = new javax.swing.JButton();
        group_chat_change_name_button = new javax.swing.JButton();
        group_chat_number_member = new javax.swing.JLabel();
        group_chat_scroll_bar = new javax.swing.JScrollBar();
        group_chat_send_message = new javax.swing.JPanel();
        group_chat_input_message = new javax.swing.JTextField();
        group_chat_send_button = new javax.swing.JButton();
        friend_chat_panel = new javax.swing.JPanel();
        chat_navigator = new javax.swing.JPanel();
        report_user_button = new javax.swing.JButton();
        name_chat_label = new javax.swing.JLabel();
        status_chat_label = new javax.swing.JLabel();
        friend_chat_more_button = new javax.swing.JButton();
        send_message = new javax.swing.JPanel();
        friend_chat_input_message = new javax.swing.JTextField();
        friend_chat_send_button = new javax.swing.JButton();
        chat_scroll_bar = new javax.swing.JScrollBar();
        friend_request_panel = new javax.swing.JPanel();
        friend_request_navigator = new javax.swing.JPanel();
        friend_request_search_input = new javax.swing.JTextField();
        friend_request_search_button = new javax.swing.JButton();
        friend_request_title = new javax.swing.JLabel();
        friend_request_sort_button = new javax.swing.JButton();
        friend_request_scroll_bar = new javax.swing.JScrollBar();
        friend_request_friend1_panel = new javax.swing.JPanel();
        friend1_request_name = new javax.swing.JLabel();
        friend1_request_status = new javax.swing.JLabel();
        friend1_request_approve_button = new javax.swing.JButton();
        friend1_request_reject_button = new javax.swing.JButton();
        friend_request_friend2_panel = new javax.swing.JPanel();
        friend2_request_name = new javax.swing.JLabel();
        friend2_request_status = new javax.swing.JLabel();
        friend2_request_reject_button = new javax.swing.JButton();
        friend2_request_approve_button = new javax.swing.JButton();
        side_panel = new javax.swing.JPanel();
        side_navigator = new javax.swing.JPanel();
        side_search_input = new javax.swing.JTextField();
        side_search_button = new javax.swing.JButton();
        side_sort_button = new javax.swing.JButton();
        side_more_button = new javax.swing.JButton();
        friend_panel = new javax.swing.JPanel();
        friend_name = new javax.swing.JLabel();
        friend_status = new javax.swing.JLabel();
        group_panel = new javax.swing.JPanel();
        group_chat_label = new javax.swing.JLabel();
        group_member_label = new javax.swing.JLabel();
        not_friend_panel = new javax.swing.JPanel();
        not_friend_name_label = new javax.swing.JLabel();
        not_friend_send_request_button = new javax.swing.JButton();
        side_scroll_bar = new javax.swing.JScrollBar();
        blank_chat_panel = new javax.swing.JPanel();
        blank_chat_navigator = new javax.swing.JPanel();
        blank_chat_label = new javax.swing.JLabel();
        blank_chat_description = new javax.swing.JLabel();
        profile_panel = new javax.swing.JPanel();
        profile_navigator = new javax.swing.JPanel();
        profile_title = new javax.swing.JLabel();
        profile_name_label = new javax.swing.JLabel();
        profile_email_label = new javax.swing.JLabel();
        profile_num_friend_label = new javax.swing.JLabel();
        profile_manage_name_button = new javax.swing.JButton();
        profile_change_password_button = new javax.swing.JButton();
        profile_password_label = new javax.swing.JLabel();
        profile_manage_email_button = new javax.swing.JButton();

        group_chat_panel.setBackground(new java.awt.Color(255, 255, 255));
        group_chat_panel.setPreferredSize(new java.awt.Dimension(593, 450));
        group_chat_panel.setVerifyInputWhenFocusTarget(false);

        group_chat_navigator.setBackground(new java.awt.Color(153, 204, 255));
        group_chat_navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        group_chat_report_button.setForeground(new java.awt.Color(255, 51, 51));
        group_chat_report_button.setText("Report!");
        group_chat_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        group_chat_name.setText("Group ABC");

        group_chat_manage.setText("Manage");
        group_chat_manage.addActionListener(e -> openGroupList());

        group_chat_change_name_button.setText("change");
        // group_chat_change_name_button.addActionListener();

        group_chat_number_member.setText("Member: ");

        javax.swing.GroupLayout group_chat_navigatorLayout = new javax.swing.GroupLayout(group_chat_navigator);
        group_chat_navigator.setLayout(group_chat_navigatorLayout);
        group_chat_navigatorLayout.setHorizontalGroup(
            group_chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_chat_navigatorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(group_chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(group_chat_number_member, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(group_chat_name, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_change_name_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(group_chat_manage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_report_button)
                .addContainerGap())
        );
        group_chat_navigatorLayout.setVerticalGroup(
            group_chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, group_chat_navigatorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(group_chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, group_chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(group_chat_change_name_button)
                        .addComponent(group_chat_manage)
                        .addComponent(group_chat_report_button))
                    .addComponent(group_chat_name, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_number_member)
                .addGap(32, 32, 32))
        );

        group_chat_send_message.setBackground(new java.awt.Color(204, 204, 204));

        group_chat_input_message.setText("Text....");
        // group_chat_input_message.addActionListener();

        group_chat_send_button.setBackground(new java.awt.Color(153, 204, 255));
        group_chat_send_button.setText("Send");
        // group_chat_send_button.addActionListener();

        javax.swing.GroupLayout group_chat_send_messageLayout = new javax.swing.GroupLayout(group_chat_send_message);
        group_chat_send_message.setLayout(group_chat_send_messageLayout);
        group_chat_send_messageLayout.setHorizontalGroup(
            group_chat_send_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_chat_send_messageLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(group_chat_input_message, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        group_chat_send_messageLayout.setVerticalGroup(
            group_chat_send_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_chat_send_messageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(group_chat_send_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(group_chat_input_message, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_chat_send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout group_chat_panelLayout = new javax.swing.GroupLayout(group_chat_panel);
        group_chat_panel.setLayout(group_chat_panelLayout);
        group_chat_panelLayout.setHorizontalGroup(
            group_chat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(group_chat_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, group_chat_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(group_chat_scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(group_chat_send_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        group_chat_panelLayout.setVerticalGroup(
            group_chat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_chat_panelLayout.createSequentialGroup()
                .addComponent(group_chat_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_send_message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        friend_chat_panel.setBackground(new java.awt.Color(255, 255, 255));
        friend_chat_panel.setVerifyInputWhenFocusTarget(false);

        chat_navigator.setBackground(new java.awt.Color(153, 204, 255));
        chat_navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        report_user_button.setForeground(new java.awt.Color(255, 51, 51));
        report_user_button.setText("Report!");

        name_chat_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name_chat_label.setText("ABC");

        status_chat_label.setBackground(new java.awt.Color(153, 204, 255));
        status_chat_label.setText("Status: ");

        friend_chat_more_button.setText("...");
        JPopupMenu friend_more_menu = new JPopupMenu();

        JMenuItem unfriend_button = new JMenuItem("Unfriend");
        JMenuItem block_button = new JMenuItem("Block");
        JMenuItem add_to_group_button = new JMenuItem("Add Group");

        friend_more_menu.add(unfriend_button);
        friend_more_menu.add(block_button);
        friend_more_menu.add(add_to_group_button);

        friend_chat_more_button.addActionListener(e -> friend_more_menu.show(friend_chat_more_button, 0, friend_chat_more_button.getHeight()));

        javax.swing.GroupLayout chat_navigatorLayout = new javax.swing.GroupLayout(chat_navigator);
        chat_navigator.setLayout(chat_navigatorLayout);
        chat_navigatorLayout.setHorizontalGroup(
            chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chat_navigatorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name_chat_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status_chat_label, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(friend_chat_more_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(report_user_button)
                .addContainerGap())
        );
        chat_navigatorLayout.setVerticalGroup(
            chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chat_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_chat_label)
                    .addComponent(friend_chat_more_button)
                    .addComponent(report_user_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status_chat_label)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        send_message.setBackground(new java.awt.Color(204, 204, 204));

        friend_chat_input_message.setText("Text....");
        friend_chat_send_button.setBackground(new java.awt.Color(153, 204, 255));
        friend_chat_send_button.setText("Send");

        javax.swing.GroupLayout send_messageLayout = new javax.swing.GroupLayout(send_message);
        send_message.setLayout(send_messageLayout);
        send_messageLayout.setHorizontalGroup(
            send_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(send_messageLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(friend_chat_input_message, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friend_chat_send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        send_messageLayout.setVerticalGroup(
            send_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(send_messageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(send_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend_chat_input_message, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend_chat_send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout friend_chat_panelLayout = new javax.swing.GroupLayout(friend_chat_panel);
        friend_chat_panel.setLayout(friend_chat_panelLayout);
        friend_chat_panelLayout.setHorizontalGroup(
            friend_chat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chat_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
            .addComponent(send_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friend_chat_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chat_scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        friend_chat_panelLayout.setVerticalGroup(
            friend_chat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_chat_panelLayout.createSequentialGroup()
                .addComponent(chat_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(chat_scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send_message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        friend_request_panel.setBackground(new java.awt.Color(255, 255, 255));

        friend_request_panel.setPreferredSize(new java.awt.Dimension(620, 500));

        friend_request_navigator.setBackground(new java.awt.Color(153, 204, 255));

        friend_request_search_input.setText("Search...");

        friend_request_search_button.setText("Search");

        friend_request_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        friend_request_title.setForeground(new java.awt.Color(255, 255, 255));
        friend_request_title.setText("Friend Request");

        friend_request_sort_button.setText("Sort ");
        // friend_request_sort_button.addActionListener();

        javax.swing.GroupLayout friend_request_navigatorLayout = new javax.swing.GroupLayout(friend_request_navigator);
        friend_request_navigator.setLayout(friend_request_navigatorLayout);
        friend_request_navigatorLayout.setHorizontalGroup(
            friend_request_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_navigatorLayout.createSequentialGroup()
                .addGroup(friend_request_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friend_request_navigatorLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(friend_request_sort_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friend_request_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friend_request_search_button))
                    .addGroup(friend_request_navigatorLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(friend_request_title)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        friend_request_navigatorLayout.setVerticalGroup(
            friend_request_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friend_request_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_request_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(friend_request_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend_request_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend_request_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend_request_sort_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        friend_request_friend1_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        friend1_request_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        friend1_request_name.setText("XYZ");

        friend1_request_status.setText("status");

        friend1_request_approve_button.setText("Approve");

        friend1_request_reject_button.setText("Reject");

        javax.swing.GroupLayout friend_request_friend1_panelLayout = new javax.swing.GroupLayout(friend_request_friend1_panel);
        friend_request_friend1_panel.setLayout(friend_request_friend1_panelLayout);
        friend_request_friend1_panelLayout.setHorizontalGroup(
            friend_request_friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_friend1_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(friend_request_friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friend_request_friend1_panelLayout.createSequentialGroup()
                        .addComponent(friend1_request_status, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(friend1_request_reject_button))
                    .addGroup(friend_request_friend1_panelLayout.createSequentialGroup()
                        .addComponent(friend1_request_name, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(friend1_request_approve_button)))
                .addGap(18, 18, 18))
        );
        friend_request_friend1_panelLayout.setVerticalGroup(
            friend_request_friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_friend1_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friend_request_friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend1_request_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend1_request_approve_button))
                .addGap(18, 18, 18)
                .addGroup(friend_request_friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(friend1_request_status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend1_request_reject_button))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        friend_request_friend2_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        friend2_request_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        friend2_request_name.setText("DEF");

        friend2_request_status.setText("status:");

        friend2_request_reject_button.setText("Reject");

        friend2_request_approve_button.setText("Approve");
        javax.swing.GroupLayout friend_request_friend2_panelLayout = new javax.swing.GroupLayout(friend_request_friend2_panel);
        friend_request_friend2_panel.setLayout(friend_request_friend2_panelLayout);
        friend_request_friend2_panelLayout.setHorizontalGroup(
            friend_request_friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_friend2_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(friend_request_friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend2_request_status, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend2_request_name, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(friend_request_friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friend_request_friend2_panelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(friend2_request_reject_button))
                    .addComponent(friend2_request_approve_button))
                .addGap(18, 18, 18))
        );
        friend_request_friend2_panelLayout.setVerticalGroup(
            friend_request_friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_friend2_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friend_request_friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friend_request_friend2_panelLayout.createSequentialGroup()
                        .addComponent(friend2_request_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(friend2_request_status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(friend_request_friend2_panelLayout.createSequentialGroup()
                        .addComponent(friend2_request_approve_button)
                        .addGap(18, 18, 18)
                        .addComponent(friend2_request_reject_button)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout friend_request_panelLayout = new javax.swing.GroupLayout(friend_request_panel);
        friend_request_panel.setLayout(friend_request_panelLayout);
        friend_request_panelLayout.setHorizontalGroup(
            friend_request_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(friend_request_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(friend_request_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_request_scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(friend_request_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend_request_friend1_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addComponent(friend_request_friend2_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                .addContainerGap())
        );
        friend_request_panelLayout.setVerticalGroup(
            friend_request_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_panelLayout.createSequentialGroup()
                .addComponent(friend_request_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(friend_request_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend_request_scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(friend_request_panelLayout.createSequentialGroup()
                        .addComponent(friend_request_friend1_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friend_request_friend2_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 229, Short.MAX_VALUE)))
                .addContainerGap())
        );

        profile_panel.setBackground(new java.awt.Color(255, 255, 255));
        profile_panel.setPreferredSize(new java.awt.Dimension(400, 370));
        profile_panel.setRequestFocusEnabled(false);

        profile_navigator.setBackground(new java.awt.Color(153, 204, 255));
        profile_navigator.setPreferredSize(new java.awt.Dimension(400, 70));

        profile_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        profile_title.setForeground(new java.awt.Color(255, 255, 255));
        profile_title.setText("Personal Profile");

        javax.swing.GroupLayout profile_navigatorLayout = new javax.swing.GroupLayout(profile_navigator);
        profile_navigator.setLayout(profile_navigatorLayout);
        profile_navigatorLayout.setHorizontalGroup(
            profile_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_navigatorLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(profile_title)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        profile_navigatorLayout.setVerticalGroup(
            profile_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile_title)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        profile_name_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile_name_label.setText("Name:");

        profile_email_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile_email_label.setText("Email:");

        profile_num_friend_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile_num_friend_label.setText("No. Friends:");

        profile_manage_name_button.setText("Manage");

        profile_change_password_button.setText("Change");

        profile_password_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile_password_label.setText("Change password:");

        profile_manage_email_button.setText("Manage");

        javax.swing.GroupLayout profile_panelLayout = new javax.swing.GroupLayout(profile_panel);
        profile_panel.setLayout(profile_panelLayout);
        profile_panelLayout.setHorizontalGroup(
            profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profile_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(profile_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(profile_panelLayout.createSequentialGroup()
                        .addComponent(profile_email_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profile_manage_email_button))
                    .addComponent(profile_num_friend_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(profile_panelLayout.createSequentialGroup()
                        .addComponent(profile_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profile_manage_name_button))
                    .addGroup(profile_panelLayout.createSequentialGroup()
                        .addComponent(profile_password_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(profile_change_password_button)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profile_panelLayout.setVerticalGroup(
            profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_panelLayout.createSequentialGroup()
                .addComponent(profile_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profile_name_label)
                    .addComponent(profile_manage_name_button))
                .addGap(31, 31, 31)
                .addGroup(profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profile_email_label)
                    .addComponent(profile_manage_email_button))
                .addGap(30, 30, 30)
                .addComponent(profile_num_friend_label)
                .addGap(30, 30, 30)
                .addGroup(profile_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profile_password_label)
                    .addComponent(profile_change_password_button))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        side_panel.setBackground(new java.awt.Color(255, 255, 255));

        side_navigator.setBackground(new java.awt.Color(153, 204, 255));
        side_navigator.setPreferredSize(new java.awt.Dimension(218, 70));

        side_search_input.setText("Search");

        side_search_button.setText("search");

        side_sort_button.setText("  sort   ");

        JPopupMenu sort_menu = new JPopupMenu();

        JMenuItem group_only_button = new JMenuItem("Group");
        JMenuItem friend_only_button = new JMenuItem("Friend");
        JMenuItem sort_by_name_button = new JMenuItem("By Name");

        sort_menu.add(group_only_button);
        sort_menu.add(friend_only_button);
        sort_menu.add(sort_by_name_button);

        side_sort_button.addActionListener(e -> sort_menu.show(side_sort_button, 0, side_sort_button.getHeight()));

        side_more_button.setText("...");

        JPopupMenu side_more_menu = new JPopupMenu();

        JMenuItem friend_request_button = new JMenuItem("Friend Request");
        JMenuItem user_profile_button = new JMenuItem("Profile");

        friend_request_button.addActionListener(e -> openFriendRequest());
        user_profile_button.addActionListener(e -> openProfile());

        side_more_menu.add(friend_request_button);
        side_more_menu.add(user_profile_button);

        side_more_button.addActionListener(e -> side_more_menu.show(side_more_button, 0, side_more_button.getHeight()));

        javax.swing.GroupLayout side_navigatorLayout = new javax.swing.GroupLayout(side_navigator);
        side_navigator.setLayout(side_navigatorLayout);
        side_navigatorLayout.setHorizontalGroup(
            side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(side_navigatorLayout.createSequentialGroup()
                        .addComponent(side_search_input, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(side_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(side_navigatorLayout.createSequentialGroup()
                        .addComponent(side_more_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(side_sort_button)))
                .addContainerGap())
        );
        side_navigatorLayout.setVerticalGroup(
            side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(side_more_button)
                    .addComponent(side_sort_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_search_button)
                    .addComponent(side_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        friend_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        friend_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        friend_name.setText("ABC");

        friend_status.setText("Status:");

        javax.swing.GroupLayout friend_panelLayout = new javax.swing.GroupLayout(friend_panel);
        friend_panel.setLayout(friend_panelLayout);
        friend_panelLayout.setHorizontalGroup(
            friend_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(friend_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friend_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        friend_panelLayout.setVerticalGroup(
            friend_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(friend_status)
                .addContainerGap())
        );

        group_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        group_chat_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        group_chat_label.setText("Group ABC");

        group_member_label.setText("Member:");

        javax.swing.GroupLayout group_panelLayout = new javax.swing.GroupLayout(group_panel);
        group_panel.setLayout(group_panelLayout);
        group_panelLayout.setHorizontalGroup(
            group_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(group_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(group_chat_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(group_member_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        group_panelLayout.setVerticalGroup(
            group_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(group_chat_label)
                .addComponent(group_member_label)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        not_friend_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        not_friend_name_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        not_friend_name_label.setText("XYZ");

        not_friend_send_request_button.setText("Send Request");

        javax.swing.GroupLayout not_friend_panelLayout = new javax.swing.GroupLayout(not_friend_panel);
        not_friend_panel.setLayout(not_friend_panelLayout);
        not_friend_panelLayout.setHorizontalGroup(
            not_friend_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(not_friend_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(not_friend_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(not_friend_send_request_button)
                .addContainerGap())
        );
        not_friend_panelLayout.setVerticalGroup(
            not_friend_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(not_friend_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(not_friend_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(not_friend_name_label)
                    .addComponent(not_friend_send_request_button))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(side_scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(group_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(not_friend_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addContainerGap())
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addComponent(side_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(side_panelLayout.createSequentialGroup()
                        .addComponent(friend_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(group_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)                       
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(not_friend_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(side_scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        blank_chat_panel.setBackground(new java.awt.Color(255, 255, 255));

        blank_chat_navigator.setBackground(new java.awt.Color(153, 204, 255));
        blank_chat_navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        javax.swing.GroupLayout blank_chat_navigatorLayout = new javax.swing.GroupLayout(blank_chat_navigator);
        blank_chat_navigator.setLayout(blank_chat_navigatorLayout);
        blank_chat_navigatorLayout.setHorizontalGroup(
            blank_chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        blank_chat_navigatorLayout.setVerticalGroup(
            blank_chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        blank_chat_label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        blank_chat_label.setText("Blank Chat...");

        blank_chat_description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        blank_chat_description.setText("Please choose one chat room or create new chat");

        javax.swing.GroupLayout blank_chat_panelLayout = new javax.swing.GroupLayout(blank_chat_panel);
        blank_chat_panel.setLayout(blank_chat_panelLayout);
        blank_chat_panelLayout.setHorizontalGroup(
            blank_chat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blank_chat_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(blank_chat_panelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(blank_chat_description)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blank_chat_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(blank_chat_label)
                .addGap(196, 196, 196))
        );
        blank_chat_panelLayout.setVerticalGroup(
            blank_chat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blank_chat_panelLayout.createSequentialGroup()
                .addComponent(blank_chat_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(blank_chat_label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blank_chat_description)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        
        cardLayout = new CardLayout();
        chatPanel = new JPanel(cardLayout);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chatPanel.add(blank_chat_panel, "blankChat");
        chatPanel.add(group_chat_panel, "groupChat");
        chatPanel.add(friend_chat_panel, "friendChat");
    
        friend_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(chatPanel, "friendChat");
            }
        });
        
        group_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(chatPanel, "groupChat");
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(side_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(chatPanel);

        pack();
    }// </editor-fold>                        


    private void openFriendRequest() {
        JFrame newWindow = new JFrame("Friend Request");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = friend_request_panel.getPreferredSize();
        newWindow.add(friend_request_panel);

        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    private void openProfile() {
        JFrame newWindow = new JFrame("User Profile");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = profile_panel.getPreferredSize();
        newWindow.add(profile_panel);

        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    private void openGroupList() {
        JFrame newWindow = new JFrame("Group List");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = group_list_panel.getPreferredSize();
        newWindow.add(group_list_panel);

        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_GUI_demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new chat_GUI_demo().setVisible(true);
        });
    }       
}
