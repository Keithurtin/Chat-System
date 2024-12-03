package bus;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.*;
import dao.*;

public class ActivityBUS {
    public List<ActivityDTO> getAll() {
        ActivityDAO dao = new ActivityDAO();
        return dao.getAll();
    }

    public List<ActivityDTO> getByTime(LocalDateTime from, LocalDateTime to) {
        ActivityDAO dao = new ActivityDAO();
        return dao.getByTime(from, to);
    }

    public List<ActivityDTO> filterByName(List<ActivityDTO> list, String name) {
        List<ActivityDTO> ans = new ArrayList<>();
        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        for (ActivityDTO active : list) {
            Matcher matcher = pattern.matcher(active.getUsername());
            if (matcher.find()) {
                ans.add(active);
            }
        }
        return ans;
    }

    public List<ActivityDTO> filterByActivities(List<ActivityDTO> list, int num, int comp) {
        List<ActivityDTO> ans = new ArrayList<>();
        for (ActivityDTO active : list) {
            int sum = active.getOpenApp() + active.getChatDM() + active.getChatGroup();
            if (sum == num && comp == 0) {
                ans.add(active);
            } else if (sum < num && comp == -1) {
                ans.add(active);
            } else if (sum > num && comp == 1) {
                ans.add(active);
            }
        }
        return ans;
    }
}
