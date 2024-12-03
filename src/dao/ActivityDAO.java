package dao;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.sql.*;
import dto.*;

public class ActivityDAO {
    public List<ActivityDTO> getAll() {
        UtilityDAO utilityDAO = new UtilityDAO();
        UsersDAO usersDAO = new UsersDAO();
        List<UsersDTO> users = usersDAO.getAll();
        List<ActivityDTO> list = new ArrayList<>();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return list;
        }

        for (UsersDTO user : users) {
            int id = user.getuID();
            String username = user.getuName();
            LocalDateTime lastActive = null;

            int openApp = 0;
            String query = "select login_time from LoginHistory where user_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    LocalDateTime activeTime = rs.getObject("login_time", LocalDateTime.class);
                    if (lastActive == null) {
                        lastActive = activeTime;
                    } else if (lastActive.isBefore(activeTime)) {
                        lastActive = activeTime;
                    }
                    openApp++;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }

            int chatDM = 0;
            query = "select send_time from ChatDM where sender_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    LocalDateTime activeTime = rs.getObject("send_time", LocalDateTime.class);
                    if (lastActive == null) {
                        lastActive = activeTime;
                    } else if (lastActive.isBefore(activeTime)) {
                        lastActive = activeTime;
                    }
                    chatDM++;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }

            int chatGroup = 0;
            query = "select send_time from ChatGroup where sender_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    LocalDateTime activeTime = rs.getObject("send_time", LocalDateTime.class);
                    if (lastActive == null) {
                        lastActive = activeTime;
                    } else if (lastActive.isBefore(activeTime)) {
                        lastActive = activeTime;
                    }
                    chatGroup++;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }

            ActivityDTO activity = new ActivityDTO(id, username, lastActive, openApp, chatDM, chatGroup);
            list.add(activity);
        }

        return list;
    }

    public List<ActivityDTO> getByTime(LocalDateTime from, LocalDateTime to) {
        UtilityDAO utilityDAO = new UtilityDAO();
        UsersDAO usersDAO = new UsersDAO();
        List<UsersDTO> users = usersDAO.getAll();
        List<ActivityDTO> list = new ArrayList<>();
        Connection conn = utilityDAO.getConnection();
        if (conn == null) {
            return list;
        }

        for (UsersDTO user : users) {
            int id = user.getuID();
            String username = user.getuName();
            LocalDateTime lastActive = null;

            int openApp = 0;
            String query = "select login_time from LoginHistory where user_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    LocalDateTime activeTime = rs.getObject("login_time", LocalDateTime.class);
                    if (activeTime.isAfter(from) && activeTime.isBefore(to)) {
                        if (lastActive == null) {
                            lastActive = activeTime;
                        } else if (lastActive.isBefore(activeTime)) {
                            lastActive = activeTime;
                        }
                        openApp++;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }

            int chatDM = 0;
            query = "select send_time from ChatDM where sender_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    LocalDateTime activeTime = rs.getObject("send_time", LocalDateTime.class);
                    if (activeTime.isAfter(from) && activeTime.isBefore(to)) {
                        if (lastActive == null) {
                            lastActive = activeTime;
                        } else if (lastActive.isBefore(activeTime)) {
                            lastActive = activeTime;
                        }
                        chatDM++;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }

            int chatGroup = 0;
            query = "select send_time from ChatGroup where sender_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    LocalDateTime activeTime = rs.getObject("send_time", LocalDateTime.class);
                    if (activeTime.isAfter(from) && activeTime.isBefore(to)) {
                        if (lastActive == null) {
                            lastActive = activeTime;
                        } else if (lastActive.isBefore(activeTime)) {
                            lastActive = activeTime;
                        }
                        chatGroup++;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }

            ActivityDTO activity = new ActivityDTO(id, username, lastActive, openApp, chatDM, chatGroup);
            list.add(activity);
        }

        return list;
    }
}
