package dao;

import java.sql.*;

public class UtilityDAO {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=ChatSystem;encrypt=true;trustServerCertificate=true;";
    String username = "sa";
    String password = "sa";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("SQLException");
            conn = null;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            conn = null;
        }
        return conn;
    }
}