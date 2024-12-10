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

        String query = "select * from Users";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int uID = rs.getInt("user_id");
                String uName = rs.getString("username");
                Boolean isAdmin = rs.getBoolean("is_admin");
                Boolean isLocked = rs.getBoolean("is_locked");
                String fullname = rs.getString("full_name");
                String address = rs.getString("address");
                java.sql.Date birthDate = rs.getDate("birth_date");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String uStatus = rs.getString("user_status");
                LocalDateTime createTime = rs.getObject("create_time", LocalDateTime.class);
                UsersDTO user = new UsersDTO(uID, uName, isAdmin, isLocked, fullname, address, birthDate, gender, email, password, uStatus, createTime);
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public UsersDTO insert(UsersDTO user) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return user;
        }

        String query = "INSERT INTO Users (username, full_name, address, birth_date, gender, email, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getuName());
            pstmt.setString(2, user.getFullname());
            pstmt.setString(3, user.getAddress());
            pstmt.setDate(4, user.getBirthDate());
            pstmt.setString(5, user.getGender());
            pstmt.setString(6, user.getEmail());
            pstmt.setString(7, user.getPassword());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int uID = rs.getInt(1);
                        return new UsersDTO(uID, user.getuName(), user.getIsAdmin(), user.getIsLocked(), user.getFullname(), user.getAddress(), user.getBirthDate(), user.getGender(), user.getEmail(), user.getPassword(), user.getStatus(), user.getCreateTime());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return user;
        }
        return user;
    }


    public boolean update(UsersDTO user) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "update Users set username = ?, is_locked = ?, full_name = ?, address = ?, birth_date = ?, gender = ?, email = ?, password = ?, user_status = ? where user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getuName());
            pstmt.setBoolean(2, user.getIsLocked());
            pstmt.setString(3, user.getFullname());
            pstmt.setString(4, user.getAddress());
            pstmt.setDate(5, user.getBirthDate());
            pstmt.setString(6, user.getGender());
            pstmt.setString(7, user.getEmail());
            pstmt.setString(8, user.getPassword());
            pstmt.setString(9, user.getStatus());
            pstmt.setInt(10, user.getuID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(int uID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "delete from Users where user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, uID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean banUser(int uID) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "update Users set is_locked = 1 where user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, uID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<Integer> countByRegisterYear(int year) {
        UtilityDAO utilityDAO = new UtilityDAO();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 13; i++)
            list.add(0);

        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return list;
        }

        String query = "select create_time from Users where year(create_time) = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                LocalDateTime createTime = rs.getTimestamp("create_time").toLocalDateTime();
                int month = createTime.getMonthValue();
                list.set(month, list.get(month) + 1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return list;
        }
        return list;
    }
}