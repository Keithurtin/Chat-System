import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chat_GUI extends javax.swing.JFrame {

    
    private JPanel chatPanel;
    private CardLayout cardLayout;                      
    private JButton friend_chat_more_button;
    private JPanel chat_navigator;
    private JScrollBar chat_scroll_bar;
    private JButton friend1_block_button;
    private JLabel friend1_name;
    private JPanel friend1_panel;
    private JButton friend1_request_approve_button;
    private JLabel friend1_request_name;
    private JButton friend1_request_reject_button;
    private JLabel friend1_request_status;
    private JLabel friend1_status;
    private JButton friend1_unfriend_button;
    private JButton friend2_send_request_button;
    private JLabel friend2_name;
    private JPanel friend2_panel;
    private JButton friend2_request_approve_button;
    private JLabel friend2_request_name;
    private JButton friend2_request_reject_button;
    private JLabel friend2_request_status;
    private JPanel friend_list_navigator;
    private JPanel friend_list_panel;
    private JScrollBar friend_list_scroll_bar;
    private JButton friend_list_search_button;
    private JTextField friend_list_search_input;
    private JButton friend_list_sort_button;
    private JLabel friend_list_title;
    private JPanel friend_request_friend1_panel;
    private JPanel friend_request_friend2_panel;
    private JPanel friend_request_navigator;
    private JPanel friend_request_panel;
    private JScrollBar friend_request_scroll_bar;
    private JButton friend_request_search_button;
    private JTextField friend_request_search_input;
    private JButton friend_request_sort_button;
    private JLabel friend_request_title;
    private JTextField friend_chat_input_message;
    private JPanel friend_chat_panel;
    private JButton friend_chat_send_button;
    private JLabel friend_name;
    private JPanel friend_panel;
    private JLabel friend_status;
    private JButton group_chat_change_name_button;
    private JTextField group_chat_input_message;
    private JLabel group_chat_label;
    private JButton group_chat_manage;
    private JLabel group_chat_name;
    private JPanel group_chat_navigator;
    private JLabel group_chat_number_member;
    private JPanel group_chat_panel;
    private JButton group_chat_report_button;
    private JScrollBar group_chat_scroll_bar;
    private JButton group_chat_send_button;
    private JPanel group_chat_send_message;
    private JPanel group_panel;
    private JLabel name_chat_label;
    private JButton new_chat_button;
    private JButton report_user_button;
    private JPanel send_message;
    private JButton side_more_button;
    private JPanel side_navigator;
    private JPanel side_panel;
    private JScrollBar side_scroll_bar;
    private JButton side_search_button;
    private JTextField side_search_input;
    private JLabel status_chat_label;  
    private JLabel blank_chat_description;
    private JLabel blank_chat_label;
    private JPanel blank_chat_panel;
    private JPanel blank_chat_navigator;


    public chat_GUI() {
        initComponents();
    }
      
    private void initComponents() {

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
        friend_list_panel = new javax.swing.JPanel();
        friend_list_navigator = new javax.swing.JPanel();
        friend_list_search_input = new javax.swing.JTextField();
        friend_list_search_button = new javax.swing.JButton();
        friend_list_title = new javax.swing.JLabel();
        friend_list_sort_button = new javax.swing.JButton();
        friend_list_scroll_bar = new javax.swing.JScrollBar();
        friend1_panel = new javax.swing.JPanel();
        friend1_name = new javax.swing.JLabel();
        friend1_status = new javax.swing.JLabel();
        friend1_unfriend_button = new javax.swing.JButton();
        friend1_block_button = new javax.swing.JButton();
        friend2_panel = new javax.swing.JPanel();
        friend2_name = new javax.swing.JLabel();
        friend2_send_request_button = new javax.swing.JButton();
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
        new_chat_button = new javax.swing.JButton();
        side_more_button = new javax.swing.JButton();
        friend_panel = new javax.swing.JPanel();
        friend_name = new javax.swing.JLabel();
        friend_status = new javax.swing.JLabel();
        group_panel = new javax.swing.JPanel();
        group_chat_label = new javax.swing.JLabel();
        side_scroll_bar = new javax.swing.JScrollBar();
        blank_chat_panel = new javax.swing.JPanel();
        blank_chat_navigator = new javax.swing.JPanel();
        blank_chat_label = new javax.swing.JLabel();
        blank_chat_description = new javax.swing.JLabel();

        group_chat_panel.setBackground(new java.awt.Color(255, 255, 255));
        group_chat_panel.setPreferredSize(new java.awt.Dimension(593, 450));
        group_chat_panel.setVerifyInputWhenFocusTarget(false);

        group_chat_navigator.setBackground(new java.awt.Color(153, 204, 255));
        group_chat_navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        group_chat_report_button.setForeground(new java.awt.Color(255, 51, 51));
        group_chat_report_button.setText("Report!");
        group_chat_report_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            group_chat_report_buttonActionPerformed(evt);
        });

        group_chat_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        group_chat_name.setText("Group ABC");

        group_chat_manage.setText("Manage");
        group_chat_manage.addActionListener((java.awt.event.ActionEvent evt) -> {
            group_chat_manageActionPerformed(evt);
        });

        group_chat_change_name_button.setText("change");
        group_chat_change_name_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            group_chat_change_name_buttonActionPerformed(evt);
        });

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
        group_chat_input_message.addActionListener((java.awt.event.ActionEvent evt) -> {
            group_chat_input_messageActionPerformed(evt);
        });

        group_chat_send_button.setBackground(new java.awt.Color(153, 204, 255));
        group_chat_send_button.setText("Send");
        group_chat_send_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            group_chat_send_buttonActionPerformed(evt);
        });

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
        report_user_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            report_user_buttonActionPerformed(evt);
        });

        name_chat_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name_chat_label.setText("ABC");

        status_chat_label.setBackground(new java.awt.Color(153, 204, 255));
        status_chat_label.setText("Status: ");

        friend_chat_more_button.setText("...");
        friend_chat_more_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            friend_chat_more_buttonActionPerformed(evt);
        });

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
        friend_chat_input_message.addActionListener((java.awt.event.ActionEvent evt) -> {
            friend_chat_input_messageActionPerformed(evt);
        });

        friend_chat_send_button.setBackground(new java.awt.Color(153, 204, 255));
        friend_chat_send_button.setText("Send");
        friend_chat_send_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            friend_chat_send_buttonActionPerformed(evt);
        });

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

        friend_list_panel.setBackground(new java.awt.Color(255, 255, 255));
        friend_list_panel.setPreferredSize(new java.awt.Dimension(620, 500));

        friend_list_navigator.setBackground(new java.awt.Color(153, 204, 255));

        friend_list_search_input.setText("Search...");

        friend_list_search_button.setText("Search");

        friend_list_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        friend_list_title.setForeground(new java.awt.Color(255, 255, 255));
        friend_list_title.setText("Friend list");

        friend_list_sort_button.setText("Sort ");
        friend_list_sort_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            friend_list_sort_buttonActionPerformed(evt);
        });

        javax.swing.GroupLayout friend_list_navigatorLayout = new javax.swing.GroupLayout(friend_list_navigator);
        friend_list_navigator.setLayout(friend_list_navigatorLayout);
        friend_list_navigatorLayout.setHorizontalGroup(
            friend_list_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend_list_navigatorLayout.createSequentialGroup()
                .addGroup(friend_list_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friend_list_navigatorLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(friend_list_sort_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friend_list_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friend_list_search_button))
                    .addGroup(friend_list_navigatorLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(friend_list_title)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        friend_list_navigatorLayout.setVerticalGroup(
            friend_list_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friend_list_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_list_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(friend_list_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend_list_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend_list_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend_list_sort_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        friend1_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        friend1_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        friend1_name.setText("ABC");

        friend1_status.setText("status");

        friend1_unfriend_button.setText("Unfriend");
        friend1_unfriend_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            friend1_unfriend_buttonActionPerformed(evt);
        });

        friend1_block_button.setText("Block");

        javax.swing.GroupLayout friend1_panelLayout = new javax.swing.GroupLayout(friend1_panel);
        friend1_panel.setLayout(friend1_panelLayout);
        friend1_panelLayout.setHorizontalGroup(
            friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend1_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend1_status, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(friend1_block_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friend1_unfriend_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        friend1_panelLayout.setVerticalGroup(
            friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend1_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend1_unfriend_button))
                .addGap(18, 18, 18)
                .addGroup(friend1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(friend1_status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend1_block_button))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        friend2_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        friend2_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        friend2_name.setText("DEF");

        friend2_send_request_button.setText("Send Request");
        friend2_send_request_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            friend2_send_request_buttonActionPerformed(evt);
        });

        javax.swing.GroupLayout friend2_panelLayout = new javax.swing.GroupLayout(friend2_panel);
        friend2_panel.setLayout(friend2_panelLayout);
        friend2_panelLayout.setHorizontalGroup(
            friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friend2_panelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(friend2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(friend2_send_request_button)
                .addGap(19, 19, 19))
        );
        friend2_panelLayout.setVerticalGroup(
            friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend2_panelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(friend2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend2_send_request_button)
                    .addComponent(friend2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout friend2_Layout = new javax.swing.GroupLayout(friend_list_panel);
        friend_list_panel.setLayout(friend2_Layout);
        friend2_Layout.setHorizontalGroup(
            friend2_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(friend_list_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(friend2_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_list_scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(friend2_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend1_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addComponent(friend2_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                .addContainerGap())
        );
        friend2_Layout.setVerticalGroup(
            friend2_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friend2_Layout.createSequentialGroup()
                .addComponent(friend_list_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(friend2_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend_list_scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(friend2_Layout.createSequentialGroup()
                        .addComponent(friend1_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friend2_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 229, Short.MAX_VALUE)))
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
        friend_request_sort_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            friend_request_sort_buttonActionPerformed(evt);
        });

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
        friend1_request_approve_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            friend1_request_approve_buttonActionPerformed(evt);
        });

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
        friend2_request_approve_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            friend2_request_approve_buttonActionPerformed(evt);
        });

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        side_panel.setBackground(new java.awt.Color(255, 255, 255));

        side_navigator.setBackground(new java.awt.Color(153, 204, 255));
        side_navigator.setPreferredSize(new java.awt.Dimension(218, 70));

        side_search_input.setText("Search");
        side_search_input.addActionListener((java.awt.event.ActionEvent evt) -> {
            side_search_inputActionPerformed(evt);
        });

        side_search_button.setText("search");

        new_chat_button.setText("New chat");
        new_chat_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            new_chat_buttonActionPerformed(evt);
        });

        side_more_button.setText("...");

        JPopupMenu dropdownMenu = new JPopupMenu();

        JMenuItem friend_request_button = new JMenuItem("Friend List");
        JMenuItem friend_list_button = new JMenuItem("Friend Request");

        friend_request_button.addActionListener(e -> openFriendRequest());
        friend_list_button.addActionListener(e -> openFriendList());

        dropdownMenu.add(friend_request_button);
        dropdownMenu.add(friend_list_button);

        side_more_button.addActionListener(e -> dropdownMenu.show(side_more_button, 0, side_more_button.getHeight()));

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
                        .addComponent(new_chat_button)))
                .addContainerGap())
        );
        side_navigatorLayout.setVerticalGroup(
            side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(side_more_button)
                    .addComponent(new_chat_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_search_button)
                    .addComponent(side_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        friend_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        friend_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        group_chat_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        group_chat_label.setText("Group ABC");

        javax.swing.GroupLayout group_panelLayout = new javax.swing.GroupLayout(group_panel);
        group_panel.setLayout(group_panelLayout);
        group_panelLayout.setHorizontalGroup(
            group_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(group_chat_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        group_panelLayout.setVerticalGroup(
            group_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(group_chat_label)
                .addContainerGap(24, Short.MAX_VALUE))
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
                    .addComponent(group_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
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
                        .addComponent(group_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private void side_search_inputActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void new_chat_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void friend_chat_send_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void report_user_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void friend_chat_more_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void friend_chat_input_messageActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }                                                         

    private void group_chat_report_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }                                                        

    private void group_chat_manageActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void group_chat_change_name_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        // TODO add your handling code here:
    }                                                             

    private void group_chat_input_messageActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }                                                        

    private void group_chat_send_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void friend_list_sort_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void friend1_unfriend_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void friend2_send_request_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void friend_request_sort_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        // TODO add your handling code here:
    }                                                          

    private void friend1_request_approve_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                               
        // TODO add your handling code here:
    }                                                              

    private void friend2_request_approve_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                               
        // TODO add your handling code here:
    }

    private void openFriendList() {
        JFrame newWindow = new JFrame("Friend List");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = friend_list_panel.getPreferredSize();

        newWindow.setSize(panelSize);
        
        newWindow.add(friend_list_panel);

        newWindow.setVisible(true);
    }

    private void openFriendRequest() {
        JFrame newWindow = new JFrame("Friend Request");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = friend_request_panel.getPreferredSize();
        newWindow.add(friend_request_panel);

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
            java.util.logging.Logger.getLogger(chat_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new chat_GUI().setVisible(true);
        });
    }       
}

