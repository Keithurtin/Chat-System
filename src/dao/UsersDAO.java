package dao;

import dto.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class UsersDAO {
    public List<UsersDTO> getAll() {
        List<UsersDTO> list = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return list;
        }

        String query = "select user_id, username, is_admin, full_name, address, birth_date, gender, email, password, user_status, create_time from Users";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int uID = rs.getInt("user_id");
                String uName = rs.getString("username");
                Boolean isAdmin = rs.getBoolean("is_admin");
                String fullname = rs.getString("full_name");
                String address = rs.getString("address");
                java.sql.Date birthDate = rs.getDate("birth_date");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String uStatus = rs.getString("user_status");
                LocalDateTime createTime = rs.getObject("create_time", LocalDateTime.class);
                UsersDTO user = new UsersDTO(uID, uName, isAdmin, fullname, address, birthDate, gender, email, password, uStatus, createTime);
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean insert(UsersDTO user) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "insert into Users (username, full_name, address, birth_date, gender, email, password) values (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getuName());
            pstmt.setString(2, user.getFullname());
            pstmt.setString(3, user.getAddress());
            pstmt.setDate(4, user.getBirthDate());
            pstmt.setString(5, user.getGender());
            pstmt.setString(6, user.getEmail());
            pstmt.setString(7, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean update(UsersDTO user) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "update Users set username = ?, is_locked = ?, full_name = ?, address = ?, birth_date = ?, gender = ?, email = ?, password = ? where user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getuName());
            pstmt.setBoolean(2, user.getIsLocked());
            pstmt.setString(3, user.getFullname());
            pstmt.setString(4, user.getAddress());
            pstmt.setDate(5, user.getBirthDate());
            pstmt.setString(6, user.getGender());
            pstmt.setString(7, user.getEmail());
            pstmt.setString(8, user.getPassword());
            pstmt.setInt(9, user.getuID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}