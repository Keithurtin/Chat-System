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
}
