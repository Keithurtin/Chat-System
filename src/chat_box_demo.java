import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chat_box_demo extends JFrame {
 
    private JPanel chatPanel;
    private CardLayout cardLayout;                      
    private final JButton friend_chat_more_button;
    private final JPanel chat_navigator;
    private final JScrollPane chat_scroll;
    private final JPanel chat_side;
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
    private final JScrollPane friend_request_scroll;
    private final JPanel friend_request_side;
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
    private final JScrollPane group_chat_scroll;
    private final JPanel group_chat_side;
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
    private final JPanel user_container;
    private final JPanel side_panel;
    private final JScrollPane side_scroll;
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
    private final JPanel group_list_side;
    private final JScrollPane group_list_scroll;

    public chat_box_demo() {

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
        group_list_side = new JPanel();

        group_chat_panel = new JPanel();
        group_chat_navigator = new JPanel();
        group_chat_report_button = new JButton();
        group_chat_name = new JLabel();
        group_chat_manage = new JButton();
        group_chat_change_name_button = new JButton();
        group_chat_number_member = new JLabel();
        group_chat_side = new JPanel();
        group_chat_send_message = new JPanel();
        group_chat_input_message = new JTextField();
        group_chat_send_button = new JButton();
        friend_chat_panel = new JPanel();
        chat_navigator = new JPanel();
        report_user_button = new JButton();
        name_chat_label = new JLabel();
        status_chat_label = new JLabel();
        friend_chat_more_button = new JButton();
        send_message = new JPanel();
        friend_chat_input_message = new JTextField();
        friend_chat_send_button = new JButton();
        chat_side = new JPanel();
        friend_request_panel = new JPanel();
        friend_request_navigator = new JPanel();
        friend_request_search_input = new JTextField();
        friend_request_search_button = new JButton();
        friend_request_title = new JLabel();
        friend_request_sort_button = new JButton();
        friend_request_side = new JPanel();
        friend_request_friend1_panel = new JPanel();
        friend1_request_name = new JLabel();
        friend1_request_status = new JLabel();
        friend1_request_approve_button = new JButton();
        friend1_request_reject_button = new JButton();
        friend_request_friend2_panel = new JPanel();
        friend2_request_name = new JLabel();
        friend2_request_status = new JLabel();
        friend2_request_reject_button = new JButton();
        friend2_request_approve_button = new JButton();
        side_panel = new JPanel();
        side_navigator = new JPanel();
        side_search_input = new JTextField();
        side_search_button = new JButton();
        side_sort_button = new JButton();
        side_more_button = new JButton();
        friend_panel = new JPanel();
        friend_name = new JLabel();
        friend_status = new JLabel();
        group_panel = new JPanel();
        group_chat_label = new JLabel();
        group_member_label = new JLabel();
        not_friend_panel = new JPanel();
        not_friend_name_label = new JLabel();
        not_friend_send_request_button = new JButton();
        user_container = new JPanel();
        blank_chat_panel = new JPanel();
        blank_chat_navigator = new JPanel();
        blank_chat_label = new JLabel();
        blank_chat_description = new JLabel();
        profile_panel = new JPanel();
        profile_navigator = new JPanel();
        profile_title = new JLabel();
        profile_name_label = new JLabel();
        profile_email_label = new JLabel();
        profile_num_friend_label = new JLabel();
        profile_manage_name_button = new JButton();
        profile_change_password_button = new JButton();
        profile_password_label = new JLabel();
        profile_manage_email_button = new JButton();

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

        group_chat_number_member.setText("Member: ");

        GroupLayout group_chat_navigatorLayout = new GroupLayout(group_chat_navigator);
        group_chat_navigator.setLayout(group_chat_navigatorLayout);
        group_chat_navigatorLayout.setHorizontalGroup(
            group_chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_chat_navigatorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(group_chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(group_chat_number_member, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(group_chat_name, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_change_name_button)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(group_chat_manage)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_report_button)
                .addContainerGap())
        );
        group_chat_navigatorLayout.setVerticalGroup(
            group_chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, group_chat_navigatorLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(group_chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, group_chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(group_chat_change_name_button)
                        .addComponent(group_chat_manage)
                        .addComponent(group_chat_report_button))
                    .addComponent(group_chat_name, GroupLayout.Alignment.TRAILING))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_number_member)
                .addGap(32, 32, 32))
        );

        group_chat_send_message.setBackground(new java.awt.Color(204, 204, 204));

        group_chat_input_message.setText("Text....");

        group_chat_send_button.setBackground(new java.awt.Color(153, 204, 255));
        group_chat_send_button.setText("Send");

        GroupLayout group_chat_send_messageLayout = new GroupLayout(group_chat_send_message);
        group_chat_send_message.setLayout(group_chat_send_messageLayout);
        group_chat_send_messageLayout.setHorizontalGroup(
            group_chat_send_messageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_chat_send_messageLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(group_chat_input_message, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_send_button, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        group_chat_send_messageLayout.setVerticalGroup(
            group_chat_send_messageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_chat_send_messageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(group_chat_send_messageLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(group_chat_input_message, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_chat_send_button, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        GroupLayout group_chat_sideLayout = new GroupLayout(group_chat_side);
        group_chat_side.setLayout(group_chat_sideLayout);
        group_chat_sideLayout.setHorizontalGroup(
            group_chat_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );

        group_chat_sideLayout.setVerticalGroup(
            group_chat_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        group_chat_side.setBackground(new java.awt.Color(255, 255, 255));
        group_chat_side.setLayout(new BoxLayout(group_chat_side, BoxLayout.Y_AXIS));

        group_chat_scroll = new JScrollPane(group_chat_side);
        group_chat_scroll.setBorder(null);
        group_chat_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
        group_chat_scroll.getVerticalScrollBar().setValue(group_chat_scroll.getVerticalScrollBar().getMaximum());

        group_chat_scroll.setViewportView(group_chat_side);

        GroupLayout group_chat_panelLayout = new GroupLayout(group_chat_panel);
        group_chat_panel.setLayout(group_chat_panelLayout);
        group_chat_panelLayout.setHorizontalGroup(
            group_chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(group_chat_navigator, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addComponent(group_chat_send_message, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(group_chat_scroll)
        );
        group_chat_panelLayout.setVerticalGroup(
            group_chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_chat_panelLayout.createSequentialGroup()
                .addComponent(group_chat_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_scroll, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_send_message, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

        GroupLayout chat_navigatorLayout = new GroupLayout(chat_navigator);
        chat_navigator.setLayout(chat_navigatorLayout);
        chat_navigatorLayout.setHorizontalGroup(
            chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, chat_navigatorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(name_chat_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status_chat_label, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(friend_chat_more_button)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(report_user_button)
                .addContainerGap())
        );
        chat_navigatorLayout.setVerticalGroup(
            chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(chat_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(name_chat_label)
                    .addComponent(friend_chat_more_button)
                    .addComponent(report_user_button))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status_chat_label)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        send_message.setBackground(new java.awt.Color(204, 204, 204));

        friend_chat_input_message.setText("Text....");
        friend_chat_send_button.setBackground(new java.awt.Color(153, 204, 255));
        friend_chat_send_button.setText("Send");

        GroupLayout send_messageLayout = new GroupLayout(send_message);
        send_message.setLayout(send_messageLayout);
        send_messageLayout.setHorizontalGroup(
            send_messageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(send_messageLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(friend_chat_input_message, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friend_chat_send_button, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        send_messageLayout.setVerticalGroup(
            send_messageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(send_messageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(send_messageLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(friend_chat_input_message, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend_chat_send_button, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        chat_side.setBackground(new java.awt.Color(255, 255, 255));
        chat_side.setLayout(new BoxLayout(chat_side, BoxLayout.Y_AXIS));

        chat_scroll = new JScrollPane(chat_side);
        chat_scroll.setBorder(null);
        chat_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
        chat_scroll.getVerticalScrollBar().setValue(chat_scroll.getVerticalScrollBar().getMaximum());

        chat_scroll.setViewportView(chat_side);

        GroupLayout chat_panelLayout = new GroupLayout(friend_chat_panel);
        friend_chat_panel.setLayout(chat_panelLayout);
        chat_panelLayout.setHorizontalGroup(
            chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(chat_navigator, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addComponent(send_message, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chat_scroll)
        );
        chat_panelLayout.setVerticalGroup(
            chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(chat_panelLayout.createSequentialGroup()
                .addComponent(chat_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chat_scroll, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send_message, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        group_list_panel.setBackground(new java.awt.Color(255, 255, 255));
        group_list_panel.setFocusable(false);
        group_list_panel.setPreferredSize(new java.awt.Dimension(660, 550));

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

        GroupLayout group_list_navigatorLayout = new GroupLayout(group_list_navigator);
        group_list_navigator.setLayout(group_list_navigatorLayout);
        group_list_navigatorLayout.setHorizontalGroup(
            group_list_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_list_navigatorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(group_list_navigatorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(group_list_title)
                    .addGroup(group_list_navigatorLayout.createSequentialGroup()
                        .addComponent(group_list_sort_button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(group_list_search_input, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_list_search_button)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_list_add_button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );
        group_list_navigatorLayout.setVerticalGroup(
            group_list_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, group_list_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(group_list_title)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(group_list_navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(group_list_search_input, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_list_search_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_list_sort_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_list_add_button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        group_list_side.setBackground(new java.awt.Color(255, 255, 255));
        group_list_side.setLayout(new BoxLayout(group_list_side, BoxLayout.Y_AXIS));


        member1_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        member1_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        member1_name.setText("XYZ");

        member1_status.setText("status");

        member1_remove_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        member1_remove_button.setText("Remove");

        GroupLayout member1_panelLayout = new GroupLayout(member1_panel);
        member1_panel.setLayout(member1_panelLayout);
        member1_panelLayout.setHorizontalGroup(
            member1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(member1_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(member1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(member1_panelLayout.createSequentialGroup()
                        .addComponent(member1_status, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(379, Short.MAX_VALUE))
                    .addGroup(member1_panelLayout.createSequentialGroup()
                        .addComponent(member1_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(member1_remove_button)
                        .addGap(47, 47, 47))))
        );
        member1_panelLayout.setVerticalGroup(
            member1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(member1_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(member1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(member1_panelLayout.createSequentialGroup()
                        .addComponent(member1_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(GroupLayout.Alignment.TRAILING, member1_panelLayout.createSequentialGroup()
                        .addComponent(member1_remove_button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(member1_status, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        member2_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        member2_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        member2_name.setText("ABC");

        member2_status.setText("status");

        member2_remove_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        member2_remove_button.setText("Remove");

        GroupLayout member2_panelLayout = new GroupLayout(member2_panel);
        member2_panel.setLayout(member2_panelLayout);
        member2_panelLayout.setHorizontalGroup(
            member2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(member2_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(member2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(member2_panelLayout.createSequentialGroup()
                        .addComponent(member2_status, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(379, Short.MAX_VALUE))
                    .addGroup(member2_panelLayout.createSequentialGroup()
                        .addComponent(member2_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(member2_remove_button)
                        .addGap(47, 47, 47))))
        );
        member2_panelLayout.setVerticalGroup(
            member2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(member2_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(member2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(member2_panelLayout.createSequentialGroup()
                        .addComponent(member2_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(GroupLayout.Alignment.TRAILING, member2_panelLayout.createSequentialGroup()
                        .addComponent(member2_remove_button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(member2_status, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        GroupLayout group_list_sideLayout = new GroupLayout(group_list_side);
        group_list_side.setLayout(group_list_sideLayout);
        group_list_sideLayout.setHorizontalGroup(
            group_list_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_list_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(group_list_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(member1_panel, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addComponent(member2_panel, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                .addContainerGap())
        );
        group_list_sideLayout.setVerticalGroup(
            group_list_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_list_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(member1_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(member2_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        group_list_scroll = new JScrollPane(group_list_side);
        group_list_scroll.setBorder(null);

        group_list_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
        group_list_scroll.getVerticalScrollBar().setValue(group_list_scroll.getVerticalScrollBar().getMaximum());

        GroupLayout group_list_panelLayout = new GroupLayout(group_list_panel);
        group_list_panel.setLayout(group_list_panelLayout);
        group_list_panelLayout.setHorizontalGroup(
            group_list_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(group_list_navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(group_list_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(group_list_scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        group_list_panelLayout.setVerticalGroup(
            group_list_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_list_panelLayout.createSequentialGroup()
                .addComponent(group_list_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(group_list_scroll, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE))
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

        GroupLayout friend_request_navigatorLayout = new GroupLayout(friend_request_navigator);
        friend_request_navigator.setLayout(friend_request_navigatorLayout);
        friend_request_navigatorLayout.setHorizontalGroup(
            friend_request_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_navigatorLayout.createSequentialGroup()
                .addGroup(friend_request_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(friend_request_navigatorLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(friend_request_sort_button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friend_request_search_input, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friend_request_search_button))
                    .addGroup(friend_request_navigatorLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(friend_request_title)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        friend_request_navigatorLayout.setVerticalGroup(
            friend_request_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, friend_request_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_request_title)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(friend_request_navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(friend_request_search_input, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend_request_search_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend_request_sort_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        friend_request_side.setBackground(new java.awt.Color(255, 255, 255));
        friend_request_side.setLayout(new BoxLayout(friend_request_side, BoxLayout.Y_AXIS));

        friend_request_friend1_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        friend1_request_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        friend1_request_name.setText("XYZ");

        friend1_request_status.setText("status");

        friend1_request_approve_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        friend1_request_approve_button.setText("Approve");
        friend1_request_reject_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        friend1_request_reject_button.setText("Reject");

        GroupLayout friend_request_friend1_panelLayout = new GroupLayout(friend_request_friend1_panel);
        friend_request_friend1_panel.setLayout(friend_request_friend1_panelLayout);
        friend_request_friend1_panelLayout.setHorizontalGroup(
            friend_request_friend1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_friend1_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(friend_request_friend1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(friend1_request_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend1_request_status, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addGroup(friend_request_friend1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(friend1_request_approve_button)
                    .addComponent(friend1_request_reject_button, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        friend_request_friend1_panelLayout.setVerticalGroup(
            friend_request_friend1_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_friend1_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friend_request_friend1_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(friend1_request_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend1_request_approve_button))
                .addGap(16, 16, 16)
                .addGroup(friend_request_friend1_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(friend1_request_status, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend1_request_reject_button))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        friend_request_friend2_panel.setPreferredSize(new java.awt.Dimension(0, 85));

        friend2_request_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        friend2_request_name.setText("DEF");

        friend2_request_status.setText("status:");

        friend2_request_reject_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        friend2_request_reject_button.setText("Reject");

        friend2_request_approve_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        friend2_request_approve_button.setText("Approve");
        GroupLayout friend_request_friend2_panelLayout = new GroupLayout(friend_request_friend2_panel);
        friend_request_friend2_panel.setLayout(friend_request_friend2_panelLayout);
        friend_request_friend2_panelLayout.setHorizontalGroup(
            friend_request_friend2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_friend2_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(friend_request_friend2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(friend2_request_status, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend2_request_name, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(friend_request_friend2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(friend2_request_reject_button, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend2_request_approve_button, GroupLayout.Alignment.TRAILING))
                .addGap(42, 42, 42))
        );
        friend_request_friend2_panelLayout.setVerticalGroup(
            friend_request_friend2_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_friend2_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friend_request_friend2_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(friend2_request_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend2_request_approve_button))
                .addGap(18, 18, 18)
                .addGroup(friend_request_friend2_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(friend2_request_status, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend2_request_reject_button))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        GroupLayout friend_request_sideLayout = new GroupLayout(friend_request_side);
        friend_request_side.setLayout(friend_request_sideLayout);
        friend_request_sideLayout.setHorizontalGroup(
            friend_request_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friend_request_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(friend_request_friend1_panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addComponent(friend_request_friend2_panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
                .addContainerGap())
        );
        friend_request_sideLayout.setVerticalGroup(
            friend_request_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_request_friend1_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friend_request_friend2_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        friend_request_scroll = new JScrollPane(friend_request_side);
        friend_request_scroll.setBorder(null);
        friend_request_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
        friend_request_scroll.getVerticalScrollBar().setValue(chat_scroll.getVerticalScrollBar().getMaximum());

        friend_request_scroll.setViewportView(friend_request_side);

        GroupLayout friend_request_panelLayout = new GroupLayout(friend_request_panel);
        friend_request_panel.setLayout(friend_request_panelLayout);
        friend_request_panelLayout.setHorizontalGroup(
            friend_request_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(friend_request_navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(friend_request_scroll)
        );
        friend_request_panelLayout.setVerticalGroup(
            friend_request_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_request_panelLayout.createSequentialGroup()
                .addComponent(friend_request_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friend_request_scroll, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
        );

        profile_panel.setBackground(new java.awt.Color(255, 255, 255));
        profile_panel.setPreferredSize(new java.awt.Dimension(400, 370));
        profile_panel.setRequestFocusEnabled(false);

        profile_navigator.setBackground(new java.awt.Color(153, 204, 255));
        profile_navigator.setPreferredSize(new java.awt.Dimension(400, 70));

        profile_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        profile_title.setForeground(new java.awt.Color(255, 255, 255));
        profile_title.setText("Personal Profile");

        GroupLayout profile_navigatorLayout = new GroupLayout(profile_navigator);
        profile_navigator.setLayout(profile_navigatorLayout);
        profile_navigatorLayout.setHorizontalGroup(
            profile_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(profile_navigatorLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(profile_title)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        profile_navigatorLayout.setVerticalGroup(
            profile_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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

        GroupLayout profile_panelLayout = new GroupLayout(profile_panel);
        profile_panel.setLayout(profile_panelLayout);
        profile_panelLayout.setHorizontalGroup(
            profile_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(profile_navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(profile_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(profile_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(profile_panelLayout.createSequentialGroup()
                        .addComponent(profile_email_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profile_manage_email_button))
                    .addComponent(profile_num_friend_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(profile_panelLayout.createSequentialGroup()
                        .addComponent(profile_name_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profile_manage_name_button))
                    .addGroup(profile_panelLayout.createSequentialGroup()
                        .addComponent(profile_password_label)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(profile_change_password_button)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profile_panelLayout.setVerticalGroup(
            profile_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(profile_panelLayout.createSequentialGroup()
                .addComponent(profile_navigator, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(profile_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(profile_name_label)
                    .addComponent(profile_manage_name_button))
                .addGap(31, 31, 31)
                .addGroup(profile_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(profile_email_label)
                    .addComponent(profile_manage_email_button))
                .addGap(30, 30, 30)
                .addComponent(profile_num_friend_label)
                .addGap(30, 30, 30)
                .addGroup(profile_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(profile_password_label)
                    .addComponent(profile_change_password_button))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        side_panel.setBackground(new java.awt.Color(255, 255, 255));

        side_navigator.setBackground(new java.awt.Color(153, 204, 255));
        side_navigator.setPreferredSize(new java.awt.Dimension(218, 70));

        side_more_button.setText("...");
        JPopupMenu side_more_menu = new JPopupMenu();

        JMenuItem friend_request_button = new JMenuItem("Friend Request");
        JMenuItem profile_button = new JMenuItem("Profile");

        friend_request_button.addActionListener(e -> openFriendRequest());
        profile_button.addActionListener(e -> openProfile());

        side_more_menu.add(friend_request_button);
        side_more_menu.add(profile_button);
        
        side_more_button.addActionListener(e -> side_more_menu.show(side_more_button, 0, side_more_button.getHeight()));

        side_sort_button.setText("Sort");

        side_search_input.setText("search");

        side_search_button.setText("Search");

        javax.swing.GroupLayout side_navigatorLayout = new javax.swing.GroupLayout(side_navigator);
        side_navigator.setLayout(side_navigatorLayout);
        side_navigatorLayout.setHorizontalGroup(
            side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_navigatorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_more_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_sort_button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        side_navigatorLayout.setVerticalGroup(
            side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_sort_button)
                    .addComponent(side_more_button, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(side_search_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_search_button))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        user_container.setBackground(new java.awt.Color(255, 255, 255));
        user_container.setLayout(new BoxLayout(user_container, BoxLayout.Y_AXIS));

        friend_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        friend_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        friend_name.setText("ABC");

        friend_status.setText("Status:");

        GroupLayout friend_panelLayout = new GroupLayout(friend_panel);
        friend_panel.setLayout(friend_panelLayout);
        friend_panelLayout.setHorizontalGroup(
            friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(friend_name, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friend_status, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        friend_panelLayout.setVerticalGroup(
            friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(friend_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_name)
                .addComponent(friend_status)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        group_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        group_chat_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        group_chat_label.setText("Group ABC");

        group_member_label.setText("Member:");

        GroupLayout group_panelLayout = new GroupLayout(group_panel);
        group_panel.setLayout(group_panelLayout);
        group_panelLayout.setHorizontalGroup(
            group_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(group_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(group_chat_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(group_member_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        group_panelLayout.setVerticalGroup(
            group_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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

        GroupLayout not_friend_panelLayout = new GroupLayout(not_friend_panel);
        not_friend_panel.setLayout(not_friend_panelLayout);
        not_friend_panelLayout.setHorizontalGroup(
            not_friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(not_friend_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(not_friend_name_label, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(not_friend_send_request_button)
                .addContainerGap())
        );
        not_friend_panelLayout.setVerticalGroup(
            not_friend_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(not_friend_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(not_friend_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(not_friend_name_label)
                    .addComponent(not_friend_send_request_button))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        GroupLayout user_containerLayout = new GroupLayout(user_container);
        user_container.setLayout(user_containerLayout);
        user_containerLayout.setHorizontalGroup(
            user_containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(friend_panel, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
            .addComponent(group_panel, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
            .addComponent(not_friend_panel, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        user_containerLayout.setVerticalGroup(
            user_containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(user_containerLayout.createSequentialGroup()
                .addComponent(friend_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(not_friend_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );

        side_scroll = new JScrollPane(user_container);
        side_scroll.setBorder(null);
        
        side_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
        
        side_scroll.getVerticalScrollBar().setValue(side_scroll.getVerticalScrollBar().getMaximum());

        side_scroll.setViewportView(user_container);

        GroupLayout side_panelLayout = new GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(side_navigator, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addComponent(side_scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addComponent(side_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(side_scroll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        blank_chat_panel.setBackground(new java.awt.Color(255, 255, 255));

        blank_chat_navigator.setBackground(new java.awt.Color(153, 204, 255));
        blank_chat_navigator.setPreferredSize(new java.awt.Dimension(390, 70));

        GroupLayout blank_chat_navigatorLayout = new GroupLayout(blank_chat_navigator);
        blank_chat_navigator.setLayout(blank_chat_navigatorLayout);
        blank_chat_navigatorLayout.setHorizontalGroup(
            blank_chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        blank_chat_navigatorLayout.setVerticalGroup(
            blank_chat_navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        blank_chat_label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        blank_chat_label.setText("Blank Chat...");

        blank_chat_description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        blank_chat_description.setText("Please choose one chat room or create new chat");

        GroupLayout blank_chat_panelLayout = new GroupLayout(blank_chat_panel);
        blank_chat_panel.setLayout(blank_chat_panelLayout);
        blank_chat_panelLayout.setHorizontalGroup(
            blank_chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(blank_chat_navigator, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(blank_chat_panelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(blank_chat_description)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, blank_chat_panelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(blank_chat_label)
                .addGap(196, 196, 196))
        );
        blank_chat_panelLayout.setVerticalGroup(
            blank_chat_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(blank_chat_panelLayout.createSequentialGroup()
                .addComponent(blank_chat_navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(blank_chat_label, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blank_chat_description)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        
        cardLayout = new CardLayout();
        chatPanel = new JPanel(cardLayout);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(side_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(side_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chatPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(chatPanel);
        setResizable(false); 
        setLocation(400, 150);
        pack();
    }// </editor-fold>                        


    private void openFriendRequest() {
        JFrame newWindow = new JFrame("Friend Request");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = friend_request_panel.getPreferredSize();
        newWindow.add(friend_request_panel);
        newWindow.setResizable(false); 
        newWindow.setLocation(600, 180);
        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    private void openProfile() {
        JFrame newWindow = new JFrame("User Profile");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = profile_panel.getPreferredSize();
        newWindow.add(profile_panel);
        newWindow.setResizable(false); 
        newWindow.setLocation(600, 180);
        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    private void openGroupList() {
        JFrame newWindow = new JFrame("Group List");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension panelSize = group_list_panel.getPreferredSize();
        newWindow.add(group_list_panel);
        newWindow.setResizable(false); 
        newWindow.setLocation(600, 180);
        newWindow.setSize(panelSize);
        newWindow.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_box_demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new chat_box_demo().setVisible(true);
        });
    }       
}