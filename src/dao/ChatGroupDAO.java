package dao;

import dto.ChatGroupDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatGroupDAO {
    public List<ChatGroupDTO> getChatHistory(int gid) {
        List<ChatGroupDTO> chat = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return chat;
        }

        String query = "SELECT * FROM ChatGroup WHERE receiver_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, gid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int mID = rs.getInt("message_id");
                int senderId = rs.getInt("sender_id");
                int receiverId = rs.getInt("receiver_id");
                String msg = rs.getString("message_content");
                LocalDateTime time = rs.getObject("send_time", LocalDateTime.class);
                ChatGroupDTO dto = new ChatGroupDTO(mID, senderId, receiverId, msg, time);
                chat.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return chat;
        }
        return chat;
    }

    public boolean addChat(int uid, int gid, String message) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }
        String query = "INSERT INTO ChatGroup (sender_id, receiver_id, message_content) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, uid);
            pstmt.setInt(2, gid);
            pstmt.setString(3, message);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteChat(int message_id) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "delete from ChatGroup where message_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, message_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteAllChat(int gid) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "delete from ChatGroup where receiver_id";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, gid);
            pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
