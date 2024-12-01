package bus;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.*;
import dao.*;

public class GroupChatBUS {
    public boolean addNewGroup(String name, int initMembers) {
        GroupChatDAO dao = new GroupChatDAO();
        return dao.addNewGroup(name, initMembers);
    }

    public List<GroupChatDTO> getAll() {
        GroupChatDAO dao = new GroupChatDAO();
        return dao.getAll();
    }

    public GroupChatDTO getById(int id) {
        GroupChatDAO dao = new GroupChatDAO();
        List<GroupChatDTO> list = dao.getAll();
        for (GroupChatDTO group : list) {
            if (group.getGID() == id) {
                return group;
            }
        }
        return null;
    }

    public List<GroupChatDTO> getByName(String name) {
        GroupChatDAO dao = new GroupChatDAO();
        List<GroupChatDTO> list = dao.getAll();
        List<GroupChatDTO> ans = new ArrayList<>();
        String regex = ".*" + Pattern.quote(name) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (GroupChatDTO group : list) {
            Matcher matcher = pattern.matcher(group.getName());
            if (matcher.matches()) {
                ans.add(group);
            }
        }
        return ans;
    }

    public List<GroupChatDTO> sortByName() {
        GroupChatDAO dao = new GroupChatDAO();
        List<GroupChatDTO> list = dao.getAll();
        list.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return list;
    }

    public List<GroupChatDTO> sortByCreateTime() {
        GroupChatDAO dao = new GroupChatDAO();
        List<GroupChatDTO> list = dao.getAll();
        list.sort((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()));
        return list;
    }
}
