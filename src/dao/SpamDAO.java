package dao;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import dto.*;

public class SpamDAO {
    public boolean addSpamReport(int uID, String username) {
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection  conn = utilityDAO.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "insert into Spam (reported_user_id, username) values (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, uID);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<SpamDTO> getAll() {
        List<SpamDTO> list = new ArrayList<>();
        UtilityDAO utilityDAO = new UtilityDAO();
        Connection  conn = utilityDAO.getConnection();
        if (conn == null) {
            return list;
        }

        String query = "select * from Spam";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int uID = rs.getInt("reported_user_id");
                String uName = rs.getString("username");
                LocalDateTime createTime = rs.getObject("report_time", LocalDateTime.class);
                SpamDTO spam = new SpamDTO(uID, uName, createTime);
                list.add(spam);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
