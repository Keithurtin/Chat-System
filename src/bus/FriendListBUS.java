package bus;

import java.util.ArrayList;
import java.util.List;
import dao.*;
import dto.*;

public class FriendListBUS {
    public boolean addFriend(int user, int friend) {
        FriendListDAO dao = new FriendListDAO();
        return dao.addFriend(user, friend);
    }

    public boolean acceptFriend(int user, int friend) {
        FriendListDAO dao = new FriendListDAO();
        return dao.acceptFriend(user, friend);
    }

    public List<UsersDTO> getFriends(int user) {
        FriendListDAO dao = new FriendListDAO();
        List<Integer> idList = dao.getFriends(user);
        List<UsersDTO> friendList = new ArrayList<>();
        UsersBUS usersBUS = new UsersBUS();
        for (int id : idList) {
            UsersDTO friend = usersBUS.getById(id);
            friendList.add(friend);
        }
        return friendList;
    }

    public int countFriends(int user) {
        FriendListDAO dao = new FriendListDAO();
        List<Integer> NoF = dao.getFriends(user);
        return NoF.size();
    }

    public int countFriendsOfFriend(int user) {
        int FoF = 0;
        FriendListDAO dao = new FriendListDAO();
        List<Integer> friendID = dao.getFriends(user);
        for (int id : friendID) {
            FoF += this.countFriends(id);
        }
        return FoF;
    }
}
