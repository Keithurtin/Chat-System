package presentation.User;

import dto.GroupChatDTO;
import dto.UsersDTO;

import java.awt.*;
// class contain tab and chat
public class UserPanel {
    public TabPanel tab;
    public GroupChatSection groupChat = null;
    public FriendChatSection friendChat = null;
    // individual user
    public UserPanel(int uid, UsersDTO user) {
        tab = new TabPanel(uid, user);
        friendChat = new FriendChatSection(uid, user);
        friendChat.setDeletionListener(() -> {
            Container parent = tab.getParent();
            if(parent != null) {
                parent.remove(tab);
                parent.revalidate();
                parent.repaint();
            }

            Container parent2 = friendChat.getParent();
            if(parent != null) {
                parent2.remove(friendChat);
                parent2.revalidate();
                parent2.repaint();
            }
        });
    }
    // group
    public UserPanel(int uid, GroupChatDTO group) {
        tab = new TabPanel(uid, group);
        groupChat = new GroupChatSection(uid, group);
        groupChat.setDeletionListener(() -> {
            Container parent = tab.getParent();
            if (parent != null) {
                parent.remove(tab);
                parent.revalidate();
                parent.repaint();
            }

            Container parent2 = groupChat.getParent();
            if (parent != null) {
                parent2.remove(groupChat);
                parent2.revalidate();
                parent2.repaint();
            }
        });
    }
}
