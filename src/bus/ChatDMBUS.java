package bus;

import dao.ChatDMDAO;
import dto.ChatDMDTO;
import java.util.List;

public class ChatDMBUS {
    public List<ChatDMDTO> getAll(int uid, int uid2) {
        ChatDMDAO dao = new ChatDMDAO();
        return dao.getChatHistory(uid, uid2);
    }

    public boolean addChat(int uid, int uid2, String msg) {
        ChatDMDAO dao = new ChatDMDAO();
        return dao.addChat(uid, uid2, msg);
    }

    public boolean deleteChat(int msgID) {
        ChatDMDAO dao = new ChatDMDAO();
        return dao.deleteChat(msgID);
    }

    public boolean deleteAllChat(int uid, int uid2) {
        ChatDMDAO dao = new ChatDMDAO();
        return dao.deleteAllChat(uid, uid2);
    }

    public boolean deleteUserChat(int id) {
        ChatDMDAO dao = new ChatDMDAO();
        return dao.deleteUserChat(id);
    }
}
