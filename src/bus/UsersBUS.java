package bus;

import dao.*;
import dto.*;
import java.util.*;

public class UsersBUS {
    public List<UsersDTO> getAll() {
        UsersDAO userDAO = new UsersDAO();
        return userDAO.getAll();
    }

    public List<UsersDTO> getByUserName(String userName) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        List<UsersDTO> ans = new ArrayList<>();
        for (UsersDTO user : list) {
            if (user.getuName().equals(userName)) {
                ans.add(user);
            }
        }
        return ans;
    }

    public List<UsersDTO> getByName(String name) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        List<UsersDTO> ans = new ArrayList<>();
        for (UsersDTO user : list) {
            if (user.getFullname().equals(name)) {
                ans.add(user);
            }
        }
        return ans;
    }

    public List<UsersDTO> getByStatus(String status) {
        UsersDAO userDAO = new UsersDAO();
        List<UsersDTO> list = userDAO.getAll();
        List<UsersDTO> ans = new ArrayList<>();
        for (UsersDTO user : list) {
            if (user.getStatus().equals(status)) {
                ans.add(user);
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
}