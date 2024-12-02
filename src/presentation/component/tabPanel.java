package component;

import dao.FriendListDAO;
import dto.GroupChatDTO;
import dto.UsersDTO;

import javax.swing.*;
import java.awt.*;

public class tabPanel extends JPanel{
    private int ID;
    private boolean isGroup;
    private JLabel name_label;
    private JButton send_request_button;

    public tabPanel(int uid, UsersDTO user) {
        ID = user.getuID();
        isGroup = false;

        int relationship = FriendListDAO.getRelationship(uid, ID);
        setLayout(new BorderLayout()); // Set layout for `this`
        setPreferredSize(new Dimension(200, 100)); // Set a default size

        switch (relationship) {
            case -1:
                add(NotFriend(user, false), BorderLayout.CENTER);
                break;
            case 0:
                add(NotFriend(user, true), BorderLayout.CENTER);
                break;
            case 1:
                add(requestingFriend(user), BorderLayout.CENTER);
                break;
            case 2:
                add(friend(user), BorderLayout.CENTER);
                break;
        }

        revalidate();
        repaint();
    }

    public tabPanel(GroupChatDTO group) {
        isGroup = true;
        ID = group.getGID();
        setLayout(new BorderLayout()); // Set layout for `this`
        setPreferredSize(new Dimension(200, 100)); // Set a default size

        add(groupTab(group), BorderLayout.CENTER);

        revalidate();
        repaint();
    }


    private JPanel friend(UsersDTO user){
        JPanel friendPanel = new JPanel();
        name_label = new JLabel(user.getuName());
        setPreferredSize(new Dimension(162, 50));

        name_label.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        JLabel status_label = new JLabel("<html> Status: " + (user.getStatus().equals("online") ? "<span style='color: green; font-weight: bold;'>Online" : "<span style='color: red; font-weight: bold;'>Offline") + "</span></html>");

        GroupLayout panelLayout = new GroupLayout(friendPanel);
        friendPanel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(name_label, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(status_label, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(name_label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(status_label)
                                .addContainerGap())
        );
        return friendPanel;
    }

    private JPanel NotFriend(UsersDTO user, boolean isRequested){
        JPanel friendPanel = new JPanel();
        JLabel name_label = new JLabel(user.getuName());

        JButton send_request_button = new JButton();
        send_request_button.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        send_request_button.setText(isRequested ? "Unsend" : "Send Request");
        send_request_button.addActionListener(e -> sendFriendRequest());

        GroupLayout panelLayout = new GroupLayout(this);
        this.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(name_label, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(send_request_button)
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(name_label)
                                        .addComponent(send_request_button))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        return friendPanel;
    }

    private JPanel requestingFriend(UsersDTO user) {
        JPanel friendPanel = new JPanel();
        setPreferredSize(new Dimension(0, 85));
        JLabel name_label = new JLabel(user.getuName());
        name_label.setFont(new Font("Segoe UI", 1, 18)); // NOI18N

        JLabel status_label = new JLabel("<html> Status:" + ((user.getStatus()).equals("online") ? "<span style='color: green; font-weight: bold;'>Online" : "<span style='color: red; font-weight: bold;'>Offline") + "</span></html>");

        JButton approve_button = new JButton("Approve");
        approve_button.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        approve_button.addActionListener(e -> approveFriendRequest());

        JButton reject_button = new JButton("Reject");
        reject_button.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        reject_button.addActionListener(e -> rejectFriendRequest());

        GroupLayout panelLayout = new GroupLayout(friendPanel);
        friendPanel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(status_label)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(reject_button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(name_label)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(approve_button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(name_label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(approve_button))
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(status_label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(reject_button))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        return friendPanel;
    }

    private JPanel groupTab(GroupChatDTO group) {
        JPanel groupPanel = new JPanel();
        setPreferredSize(new Dimension(162, 50));

        name_label = new JLabel(group.getName());
        name_label.setFont(new Font("Segoe UI", 1, 14));
        JLabel status_label = new JLabel("<html> Members: <span style='color: green; font-weight: bold;'>"+ group.getNumMember() +"</span></html>");

        GroupLayout panelLayout = new GroupLayout(groupPanel);
        groupPanel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(name_label, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(status_label, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(name_label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(status_label)
                                .addContainerGap())
        );
        return groupPanel;
    }


    private void sendFriendRequest() {
        if (send_request_button.getText().equals("Send Request")) {
            send_request_button.setText("Unsend");
        } else{
            send_request_button.setText("Send Request");
        }
    }


    private void approveFriendRequest() {

    }

    private void rejectFriendRequest() {

    }

}