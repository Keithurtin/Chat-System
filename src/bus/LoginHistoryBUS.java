package bus;

import dao.*;
import dto.*;

import java.util.ArrayList;
import java.util.List;

public class LoginHistoryBUS {
    public List<LoginHistoryDTO> getLoginHistory(int uID) {
        LoginHistoryDAO dao = new LoginHistoryDAO();
        return dao.getLoginHistory(uID);
    }

    public void addLoginHistory(int uID) {
        LoginHistoryDAO dao = new LoginHistoryDAO();
        dao.addLoginHistory(uID);
    }

    public List<LoginHistoryDTO> getAll() {
        LoginHistoryDAO dao = new LoginHistoryDAO();
        return dao.getAll();
    }
}
