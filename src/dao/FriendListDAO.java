package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendListDAO {
    public boolean addFriend(int userID, int friendID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String insertUserQuery  = "INSERT INTO FriendList (user_id, friend_id, requested) VALUES (?, ?, 1)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertUserQuery)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, friendID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        String insertFriendQuery  = "INSERT INTO FriendList (user_id, friend_id, requesting) VALUES (?, ?, 1)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertFriendQuery)) {
            pstmt.setInt(1, friendID);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean acceptFriend(int userID, int friendID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "update FriendList set requested = 0, requesting = 0 where user_id = ? and friend_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, friendID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        String query2 = "update FriendList set requested = 0, requesting = 0 where user_id = ? and friend_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query2)) {
            pstmt.setInt(1, friendID);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public boolean rejectFriend(int userID, int friendID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "delete from FriendList where user_id = ? and friend_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, friendID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        String query2 = "delete from FriendList where user_id = ? and friend_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query2)) {
            pstmt.setInt(1, friendID);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static int getRelationship(int userID, int friendID) {
        int relationship = -1; //no relation
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return relationship;
        }

        String query = "select * from FriendList where user_id = ? and friend_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, friendID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int requesting = rs.getInt("requesting");
                int requested = rs.getInt("requested");
                relationship = requesting == requested ? 2 : requesting; //1 is requesting (no requested), 2 is friend
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return relationship;
        }
        return relationship;
    }

    public List<Integer> getFriends(int userID) {
        List<Integer> friends = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return friends;
        }

        String query = "select * from FriendList where user_id = ? and requested = 0 and requesting = 0";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int uID = rs.getInt("friend_id");
                friends.add(uID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return friends;
        }
        return friends;
    }

    public List<Integer> getFriendsRequesting(int userID) {
        List<Integer> friends = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return friends;
        }

        String query = "select * from FriendList where user_id = ? and requested = 0 and requesting = 1";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int uID = rs.getInt("friend_id");
                friends.add(uID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return friends;
        }
        return friends;
    }

    public boolean deleteFriend(int userID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "delete from FriendList where user_id = ? or friend_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
