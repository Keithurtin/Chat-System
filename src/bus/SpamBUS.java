package bus;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import dto.*;
import dao.*;

public class SpamBUS {
    public boolean addSpamReport(int uID) {
        UsersBUS userBUS = new UsersBUS();
        UsersDTO user = userBUS.getById(uID);
        SpamDAO dao = new SpamDAO();
        return dao.addSpamReport(uID, user.getuName());
    }

    public List<SpamDTO> getAll() {
        SpamDAO dao = new SpamDAO();
        return dao.getAll();
    }

    public List<SpamDTO> sortByName() {
        SpamDAO dao = new SpamDAO();
        List<SpamDTO> list = dao.getAll();
        list.sort((o1, o2) -> o1.getuName().compareTo(o2.getuName()));
        return list;
    }

    public List<SpamDTO> sortReportTime() {
        SpamDAO dao = new SpamDAO();
        List<SpamDTO> list = dao.getAll();
        list.sort((o1, o2) -> o2.getReportTime().compareTo(o1.getReportTime()));
        return list;
    }

    public List<SpamDTO> getByName(String uName) {
        SpamDAO dao = new SpamDAO();
        List<SpamDTO> list = dao.getAll();
        List<SpamDTO> ans = new ArrayList<>();
        String regex = ".*" + Pattern.quote(uName) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (SpamDTO report : list) {
            Matcher matcher = pattern.matcher(report.getuName());
            if (matcher.matches()) {
                ans.add(report);
            }
        }
        return ans;
    }

    public List<SpamDTO> getByDate(String date) {
        SpamDAO dao = new SpamDAO();
        List<SpamDTO> list = dao.getAll();
        List<SpamDTO> ans = new ArrayList<>();
        String regex = ".*" + Pattern.quote(date) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (SpamDTO report : list) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
            Matcher matcher = pattern.matcher(report.getReportTime().format(formatter));
            if (matcher.matches()) {
                ans.add(report);
            }
        }
        return ans;
    }
}
