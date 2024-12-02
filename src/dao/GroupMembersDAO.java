package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import dto.*;

public class GroupMembersDAO {
    public boolean addMember(int gID, int uID, boolean isAdmin) {
        UtilityDAO util = new UtilityDAO();
        Connection con = util.getConnection();
        if (con == null) {
            return false;
        }

        String query = "insert into GroupMembers (group_id, user_id, is_admin) values (?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, gID);
            pstmt.setInt(2, uID);
            pstmt.setBoolean(3, isAdmin);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean setAdmin(int gID, int uID, boolean isAdmin) {
        UtilityDAO util = new UtilityDAO();
        Connection con = util.getConnection();
        if (con == null) {
            return false;
        }

        String query = "update GroupMembers set is_admin = ? where group_id = ? and user_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setBoolean(1, isAdmin);
            pstmt.setInt(2, gID);
            pstmt.setInt(3, uID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<GroupMembersDTO> getAll(int gID) {
        List<GroupMembersDTO> list = new ArrayList<>();
        UtilityDAO util = new UtilityDAO();
        Connection con = util.getConnection();
        if (con == null) {
            return list;
        }

        String query = "select * from GroupMembers where group_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, gID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int uID = rs.getInt("user_id");
                boolean isAdmin = rs.getBoolean("is_admin");
                list.add(new GroupMembersDTO(gID, uID, isAdmin));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return list;
        }
        return list;
    }

    public List<GroupMembersDTO> getAdmin(int gID) {
        List<GroupMembersDTO> list = new ArrayList<>();
        UtilityDAO util = new UtilityDAO();
        Connection con = util.getConnection();
        if (con == null) {
            return list;
        }

        String query = "select * from GroupMembers where group_id = ? and is_admin = 1";

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, gID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int uID = rs.getInt("user_id");
                boolean isAdmin = rs.getBoolean("is_admin");
                list.add(new GroupMembersDTO(gID, uID, isAdmin));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return list;
        }
        return list;
    }

    public int getNumMember(int gID) {
        int numMembers = 0;
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return numMembers;
        }

        String query = "SELECT COUNT(*) AS member_count FROM GroupMembers WHERE group_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, gID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                numMembers = rs.getInt("member_count");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return numMembers;
        }
        return numMembers;
    }

    public List<Integer> getGroupID(int uID) {
        List<Integer> groups = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return groups;
        }

        String query = "select * from GroupMembers where user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, uID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int gID = rs.getInt("group_id");
                groups.add(gID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return groups;
        }
        return groups;
    }
}
