package presentation.User;

import dto.GroupChatDTO;
import dto.UsersDTO;

import java.awt.*;

public class UserPanel {
    private final int id1;
    private final int id2;
    private final boolean isGroup;
    public TabPanel tab;
    public GroupChatSection groupChat = null;
    public FriendChatSection friendChat = null;

    public UserPanel(int uid, UsersDTO user) {
        isGroup = false;
        id1 = uid;
        id2 = user.getuID();
        tab = new TabPanel(uid, user);
        friendChat = new FriendChatSection(uid, user);
        friendChat.setDeletionListener(() -> {
            Container parent = tab.getParent();
            parent.remove(tab);
            parent.revalidate();
            parent.repaint();
        });
    }

    public UserPanel(int uid, GroupChatDTO group) {
        isGroup = true;
        id1 = uid;
        id2 = group.getGID();
        tab = new TabPanel(uid, group);
        groupChat = new GroupChatSection(uid, group);
        groupChat.setDeletionListener(() -> {
            Container parent = tab.getParent();
            parent.remove(tab);
            parent.revalidate();
            parent.repaint();
        });
    }
}
