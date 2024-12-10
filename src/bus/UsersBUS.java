package bus;

import dao.*;
import dto.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsersBUS {
    public List<UsersDTO> getAll() {
        UsersDAO userDAO = new UsersDAO();
        return userDAO.getAll();
    }

    public List<UsersDTO> getByNameOrUName(String query) {
        UsersDAO userDAO = new UsersDAO();
        List<dto.UsersDTO> list = userDAO.getAll();
        List<dto.UsersDTO> ans = new ArrayList<>();
        String regex = ".*" + Pattern.quote(query) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (dto.UsersDTO user : list) {
            Matcher matcher1 = pattern.matcher(user.getFullname());
            Matcher matcher2 = pattern.matcher(user.getuName());
            if (matcher1.matches() || matcher2.matches()) {
                ans.add(user);
            }
        }
        return ans;
    }

    public List<UsersDTO> getByUserName(String userName) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        List<UsersDTO> ans = new ArrayList<>();
        String regex = ".*" + Pattern.quote(userName) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (UsersDTO user : list) {
            Matcher matcher = pattern.matcher(user.getuName());
            if (matcher.matches()) {
                ans.add(user);
            }
        }
        return ans;
    }

    public List<UsersDTO> getByName(String name) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        List<UsersDTO> ans = new ArrayList<>();
        String regex = ".*" + Pattern.quote(name) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (UsersDTO user : list) {
            Matcher matcher = pattern.matcher(user.getFullname());
            if (matcher.matches()) {
                ans.add(user);
            }
        }
        return ans;
    }

    public UsersDTO getByIDAndStatus(int id, String status) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        for (UsersDTO user : list) {
            if (user.getuID() == id && (user.getStatus()).equals(status)) {
                return user;
            }
        }
        return null;
    }

    public List<UsersDTO> getByStatus(String status) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        List<UsersDTO> ans = new ArrayList<>();
        String regex = ".*" + Pattern.quote(status) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (UsersDTO user : list) {
            Matcher matcher = pattern.matcher(user.getStatus());
            if (matcher.matches()) {
                ans.add(user);
            }
        }
        return ans;
    }

    public UsersDTO getByMail(String mail) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        String regex = ".*" + Pattern.quote(mail) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (UsersDTO user : list) {
            Matcher matcher = pattern.matcher(user.getEmail());
            if (matcher.matches()) {
                return user;
            }
        }
        return null;
    }

    public List<UsersDTO> getByFriend(int friend, int comp) {
        UsersDAO userDAO = new UsersDAO();
        FriendListBUS friendListBUS = new FriendListBUS();
        List<UsersDTO> list = userDAO.getAll();
        List<UsersDTO> ans = new ArrayList<>();
        if (comp == 0) {
            for (UsersDTO user : list) {
                if (friendListBUS.countFriends(user.getuID()) == friend) {
                    ans.add(user);
                }
            }
        } else if (comp == 1) {
            for (UsersDTO user : list) {
                if (friendListBUS.countFriends(user.getuID()) > friend) {
                    ans.add(user);
                }
            }
        } else if (comp == -1) {
            for (UsersDTO user : list) {
                if (friendListBUS.countFriends(user.getuID()) < friend) {
                    ans.add(user);
                }
            }
        }
        return ans;
    }

    public UsersDTO getById(int id) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        for (UsersDTO user : list) {
            if (user.getuID() == id) {
                return user;
            }
        }
        return null;
    }

    public List<UsersDTO> sortByName() {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        list.sort((o1, o2) -> o1.getuName().compareTo(o2.getuName()));
        return list;
    }

    public List<UsersDTO> sortByCreatedDate() {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        list.sort((o1, o2) -> o1.getCreateTime().compareTo(o2.getCreateTime()));
        return list;
    }

    public UsersDTO addUser(UsersDTO user) {
        UsersDAO userDAO = new UsersDAO();
        return userDAO.insert(user);
    }

    public boolean updateUser(UsersDTO user) {
        UsersDAO userDAO = new UsersDAO();
        return userDAO.update(user);
    }

    public boolean deleteUser(int id) {
        UsersDAO userDAO = new UsersDAO();
        return userDAO.delete(id);
    }

    public boolean banUser(int id) {
        UsersDAO userDAO = new UsersDAO();
        return userDAO.banUser(id);
    }

    public List<UsersDTO> getByRegisterTime(LocalDateTime from, LocalDateTime to) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        List<UsersDTO> ans = new ArrayList<>();
        for (UsersDTO user : list) {
            if (user.getCreateTime().isAfter(from) && user.getCreateTime().isBefore(to)) {
                ans.add(user);
            }
        }
        return ans;
    }

    public List<UsersDTO> filterByUsername(List<UsersDTO> list, String uName) {
        if (uName == null || uName.isEmpty()) {
            return list;
        }
        List<UsersDTO> ans = new ArrayList<>();
        String regex = ".*" + Pattern.quote(uName) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (UsersDTO user : list) {
            Matcher matcher = pattern.matcher(user.getuName());
            if (matcher.matches()) {
                ans.add(user);
            }
        }
        return ans;
    }

    public List<Integer> countByRegisterYear(int year) {
        UsersDAO userDAO = new UsersDAO();
        return userDAO.countByRegisterYear(year);
    }
}