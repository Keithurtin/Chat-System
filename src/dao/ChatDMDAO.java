package dao;

import dto.ChatDMDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatDMDAO {
    public List<ChatDMDTO> getChatHistory(int uid, int uid2) {
        List<ChatDMDTO> chat = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return chat;
        }

        String query = "SELECT * FROM ChatDM WHERE (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, uid);
            pstmt.setInt(2, uid2);
            pstmt.setInt(3, uid2);
            pstmt.setInt(4, uid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int mID = rs.getInt("message_id");
                int senderId = rs.getInt("sender_id");
                int receiverId = rs.getInt("receiver_id");
                String msg = rs.getString("message_content");
                LocalDateTime time = rs.getObject("send_time", LocalDateTime.class);
                ChatDMDTO dto = new ChatDMDTO(mID, senderId, receiverId, msg, time);
                chat.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return chat;
        }
        return chat;
    }

    public boolean addChat(int uid, int uid2, String message) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }
        String query = "INSERT INTO ChatDM (sender_id, receiver_id, message_content) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, uid);
            pstmt.setInt(2, uid2);
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

        String query = "delete from ChatDM where message_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, message_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteAllChat(int uid, int uid2) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "delete from ChatDM where (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, uid);
            pstmt.setInt(2, uid2);
            pstmt.setInt(3, uid2);
            pstmt.setInt(4, uid);
            ResultSet rs = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
