package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlockDAO {
    public boolean blockFriend(int userID, int friendID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "INSERT INTO Blocked (user_id, blocked_user_id) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, friendID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        query = "DELETE from FriendList where (user_id = ? and friend_id = ?) or (user_id = ? and friend_id = ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, friendID);
            pstmt.setInt(3, friendID);
            pstmt.setInt(4, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean unblockFriend(int userID, int friendID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "DELETE from Blocked where user_id = ? and blocked_user_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, friendID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public int getRelationship(int userID, int friendID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return 0;
        }

        String query = "select * from Blocked where user_id = ? and blocked_user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, friendID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, friendID);
            pstmt.setInt(2, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 0;
    }

    public List<Integer> getBlocking(int userID) {
        List<Integer> blocking = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return blocking;
        }

        String query = "select * from Blocked where user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int uID = rs.getInt("blocked_user_id");
                blocking.add(uID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return blocking;
        }
        return blocking;
    }

    public List<Integer> getBlocked(int userID) {
        List<Integer> Blocked = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return Blocked;
        }

        String query = "select * from Blocked where blocked_user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int uID = rs.getInt("user_id");
                Blocked.add(uID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Blocked;
        }
        return Blocked;
    }
}
