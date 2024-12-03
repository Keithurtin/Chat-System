package bus;

import dao.BlockDAO;
import dto.UsersDTO;

import java.util.ArrayList;
import java.util.List;

public class BlockBUS {
    public boolean blockFriend(int user, int friend) {
        BlockDAO dao = new BlockDAO();
        return dao.blockFriend(user, friend);
    }

    public boolean unblockFriend(int user, int friend) {
        BlockDAO dao = new BlockDAO();
        return dao.unblockFriend(user, friend);
    }

    public List<UsersDTO> getBlocking(int user) {
        BlockDAO dao = new BlockDAO();
        List<Integer> idList = dao.getBlocking(user);
        List<UsersDTO> blockList = new ArrayList<>();
        UsersBUS usersBUS = new UsersBUS();
        for (int id : idList) {
            UsersDTO blocking = usersBUS.getById(id);
            blockList.add(blocking);
        }
        return blockList;
    }

    public List<UsersDTO> getBlocked(int user) {
        BlockDAO dao = new BlockDAO();
        List<Integer> idList = dao.getBlocked(user);
        List<UsersDTO> blockList = new ArrayList<>();
        UsersBUS usersBUS = new UsersBUS();
        for (int id : idList) {
            UsersDTO blocking = usersBUS.getById(id);
            blockList.add(blocking);
        }
        return blockList;
    }
}
