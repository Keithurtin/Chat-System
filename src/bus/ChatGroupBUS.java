package bus;

import dao.ChatGroupDAO;
import dto.ChatGroupDTO;
import java.util.List;

public class ChatGroupBUS {
    public List<ChatGroupDTO> getAll(int gid) {
        ChatGroupDAO dao = new ChatGroupDAO();
        return dao.getChatHistory(gid);
    }

    public boolean addChat(int uid, int gid, String msg) {
        ChatGroupDAO dao = new ChatGroupDAO();
        return dao.addChat(uid, gid, msg);
    }

    public boolean deleteChat(int msgID) {
        ChatGroupDAO dao = new ChatGroupDAO();
        return dao.deleteChat(msgID);
    }

    public boolean deleteAllChat(int gid) {
        ChatGroupDAO dao = new ChatGroupDAO();
        return dao.deleteAllChat(gid);
    }

}
