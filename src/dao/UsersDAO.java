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
}