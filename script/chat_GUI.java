import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class chat_GUI extends javax.swing.JFrame {

    
    private JPanel chatPanel;
    private CardLayout cardLayout;                      
    private JButton add_new_group;
    private JPanel chat_navigator;
    private JScrollBar chat_scroll_bar;
    private JPanel friend_panel;
    private JPanel friend_chat_panel;
    private JLabel friend_name;
    private JLabel friend_status;
    private JButton group_chat_chagne_name_button;
    private JTextField group_chat_input_message;
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
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton6;
    private JLabel jLabel9;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JLabel name_chat_label;
    private JButton report_user_button;
    private JPanel send_message;
    private JPanel side_navigator;
    private JPanel side_panel;
    private JScrollBar side_scroll_bar;
    private JLabel status_chat_label;      

    public chat_GUI() {
        initComponents();
    }
      
    private void initComponents() {

        group_chat_panel = new javax.swing.JPanel();
        group_chat_navigator = new javax.swing.JPanel();
        group_chat_report_button = new javax.swing.JButton();
        group_chat_name = new javax.swing.JLabel();
        group_chat_manage = new javax.swing.JButton();
        group_chat_chagne_name_button = new javax.swing.JButton();
        group_chat_number_member = new javax.swing.JLabel();
        group_chat_scroll_bar = new javax.swing.JScrollBar();
        group_chat_send_message = new javax.swing.JPanel();
        group_chat_input_message = new javax.swing.JTextField();
        group_chat_send_button = new javax.swing.JButton();
        side_panel = new javax.swing.JPanel();
        side_navigator = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        friend_panel = new javax.swing.JPanel();
        friend_name = new javax.swing.JLabel();
        friend_status = new javax.swing.JLabel();
        group_panel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        side_scroll_bar = new javax.swing.JScrollBar();
        friend_chat_panel = new javax.swing.JPanel();
        chat_navigator = new javax.swing.JPanel();
        report_user_button = new javax.swing.JButton();
        name_chat_label = new javax.swing.JLabel();
        status_chat_label = new javax.swing.JLabel();
        add_new_group = new javax.swing.JButton();
        send_message = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        chat_scroll_bar = new javax.swing.JScrollBar();

        group_chat_panel.setBackground(new java.awt.Color(255, 255, 255));
        group_chat_panel.setPreferredSize(new java.awt.Dimension(593, 450));
        group_chat_panel.setVerifyInputWhenFocusTarget(false);

        group_chat_navigator.setBackground(new java.awt.Color(102, 204, 255));

        group_chat_report_button.setText("Report!");
        group_chat_report_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                group_chat_report_buttonActionPerformed(evt);
            }
        });

        group_chat_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        group_chat_name.setText("ABC");

        group_chat_manage.setText("Manage");
        group_chat_manage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                group_chat_manageActionPerformed(evt);
            }
        });

        group_chat_chagne_name_button.setText("Chagne");
        group_chat_chagne_name_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                group_chat_chagne_name_buttonActionPerformed(evt);
            }
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
                .addComponent(group_chat_chagne_name_button)
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
                .addGroup(group_chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(group_chat_name)
                    .addComponent(group_chat_chagne_name_button)
                    .addComponent(group_chat_manage)
                    .addComponent(group_chat_report_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(group_chat_number_member)
                .addGap(12, 12, 12))
        );

        group_chat_send_message.setBackground(new java.awt.Color(204, 204, 204));

        group_chat_input_message.setText("Text....");
        group_chat_input_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                group_chat_input_messageActionPerformed(evt);
            }
        });

        group_chat_send_button.setText("Send");
        group_chat_send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                group_chat_send_buttonActionPerformed(evt);
            }
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
            .addComponent(group_chat_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(group_chat_scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_chat_send_message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        side_panel.setBackground(new java.awt.Color(255, 255, 255));

        side_navigator.setBackground(new java.awt.Color(153, 204, 255));

        jTextField1.setText("Search");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("search");

        jButton3.setText("New chat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("...");

        javax.swing.GroupLayout side_navigatorLayout = new javax.swing.GroupLayout(side_navigator);
        side_navigator.setLayout(side_navigatorLayout);
        side_navigatorLayout.setHorizontalGroup(
            side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(side_navigatorLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(side_navigatorLayout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        side_navigatorLayout.setVerticalGroup(
            side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_navigatorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)))
        );

        friend_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        friend_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        friend_name.setText("ABC");

        friend_status.setText("Status:");

        javax.swing.GroupLayout firend_panelLayout = new javax.swing.GroupLayout(friend_panel);
        friend_panel.setLayout(firend_panelLayout);
        firend_panelLayout.setHorizontalGroup(
            firend_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firend_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(firend_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friend_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        firend_panelLayout.setVerticalGroup(
            firend_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firend_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friend_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(friend_status)
                .addContainerGap())
        );

        group_panel.setPreferredSize(new java.awt.Dimension(162, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Group ABC");

        javax.swing.GroupLayout group_panelLayout = new javax.swing.GroupLayout(group_panel);
        group_panel.setLayout(group_panelLayout);
        group_panelLayout.setHorizontalGroup(
            group_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        group_panelLayout.setVerticalGroup(
            group_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(side_scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friend_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(group_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap())
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addComponent(side_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(side_panelLayout.createSequentialGroup()
                        .addComponent(friend_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(group_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(side_scroll_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        friend_chat_panel.setBackground(new java.awt.Color(255, 255, 255));
        friend_chat_panel.setVerifyInputWhenFocusTarget(false);

        chat_navigator.setBackground(new java.awt.Color(153, 204, 255));

        report_user_button.setText("Report!");
        report_user_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                report_user_buttonActionPerformed(evt);
            }
        });

        name_chat_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name_chat_label.setText("ABC");

        status_chat_label.setBackground(new java.awt.Color(153, 204, 255));
        status_chat_label.setText("Status: ");

        add_new_group.setText("Add new Group");
        add_new_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_groupActionPerformed(evt);
            }
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
                .addComponent(add_new_group)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(report_user_button)
                .addContainerGap())
        );
        chat_navigatorLayout.setVerticalGroup(
            chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chat_navigatorLayout.createSequentialGroup()
                .addGroup(chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chat_navigatorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(name_chat_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status_chat_label))
                    .addGroup(chat_navigatorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(chat_navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(report_user_button)
                            .addComponent(add_new_group))))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        send_message.setBackground(new java.awt.Color(204, 204, 204));

        jTextField2.setText("Text....");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton4.setText("Send");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout send_messageLayout = new javax.swing.GroupLayout(send_message);
        send_message.setLayout(send_messageLayout);
        send_messageLayout.setHorizontalGroup(
            send_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(send_messageLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        send_messageLayout.setVerticalGroup(
            send_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(send_messageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(send_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout friend_chat_panelLayout = new javax.swing.GroupLayout(friend_chat_panel);
        friend_chat_panel.setLayout(friend_chat_panelLayout);
        friend_chat_panelLayout.setHorizontalGroup(
            friend_chat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chat_navigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chat_scroll_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send_message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardLayout = new CardLayout();
        chatPanel = new JPanel(cardLayout);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        // cardLayout.show(chatPanel, "friendChat");

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void report_user_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void add_new_groupActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void group_chat_report_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }                                                        

    private void group_chat_manageActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void group_chat_chagne_name_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        // TODO add your handling code here:
    }                                                             

    private void group_chat_input_messageActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }                                                        

    private void group_chat_send_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chat_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_GUI().setVisible(true);
            }
        });
    }       
}

