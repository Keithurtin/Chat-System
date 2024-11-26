package bus;

import java.util.List;
import dao.*;
import dto.*;

public class FriendListBUS {
    public void addFriend(int user, int friend) {
        FriendListDAO dao = new FriendListDAO();
        dao.addFriend(user, friend);
    }

    public void acceptFriend(int user, int friend) {
        FriendListDAO dao = new FriendListDAO();
        dao.acceptFriend(user, friend);
    }

    public List<Integer> getFriends(int user) {
        FriendListDAO dao = new FriendListDAO();
        return dao.getFriends(user);
    }
}
