package dao;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import dto.*;

import javax.xml.catalog.Catalog;
import java.sql.*;

public class GroupChatDAO {
    public int addNewGroup(String name, int initMembers) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return -1; // Return -1 to indicate an error
        }

        String query = "INSERT INTO GroupChat (group_name, initial_member) VALUES (?, ?); SELECT SCOPE_IDENTITY();";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, initMembers);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return -1;
    }


    public List<GroupChatDTO> getAll() {
        List<GroupChatDTO> list = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return list;
        }

        String query = "SELECT * FROM GroupChat";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("group_id");
                String name = rs.getString("group_name");
                int init = rs.getInt("initial_member");
                LocalDateTime createTime = rs.getObject("create_time", LocalDateTime.class);
                GroupChatDTO group = new GroupChatDTO(id, name, init, createTime);
                list.add(group);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return list;
        }
        return list;
    }

    public boolean update(GroupChatDTO group) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "update GroupChat set group_name = ? where group_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, group.getName());
            pstmt.setInt(2, group.getGID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteGroup (int gID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "Delete from GroupChat where group_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, gID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteGroup_Member(int uID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "update GroupChat set initial_member = null where initial_member = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, uID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
