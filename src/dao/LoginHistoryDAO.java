package dao;

import dto.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class LoginHistoryDAO {
    public boolean addLoginHistory(int uID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "insert into LoginHistory (user_id) values (?)";

        try(PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, uID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<LoginHistoryDTO> getLoginHistory(int uID) {
        List<LoginHistoryDTO> list = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return list;
        }

        String query = "select * from LoginHistory where user_id = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, uID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("user_id");
                LocalDateTime loginTime = rs.getObject("login_time", LocalDateTime.class);
                LoginHistoryDTO dto = new LoginHistoryDTO(id, loginTime);
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return list;
        }
        return list;
    }

    public List<LoginHistoryDTO> getAll() {
        List<LoginHistoryDTO> list = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return list;
        }

        String query = "select * from LoginHistory";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("user_id");
                LocalDateTime loginTime = rs.getObject("login_time", LocalDateTime.class);
                LoginHistoryDTO dto = new LoginHistoryDTO(id, loginTime);
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return list;
        }
        list.sort((o1, o2) -> o2.getLoginTime().compareTo(o1.getLoginTime()));
        return list;
    }

    public boolean deleteLoginHistory(int uID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "delete from LoginHistory where user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, uID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
