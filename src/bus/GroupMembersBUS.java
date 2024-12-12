package bus;

import java.util.ArrayList;
import java.util.List;
import dao.*;
import dto.*;

public class GroupMembersBUS {
    public boolean addMember(int gID, int uID) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.addMember(gID, uID);
    }

    public boolean setAdmin(int gID, int uID, boolean isAdmin) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.setAdmin(gID, uID, isAdmin);
    }

    public boolean deleteAll(int gID) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.deleteAll(gID);
    }

    public boolean deleteMember(int gID, int uID) {
        GroupMembersDAO dao = new GroupMembersDAO();
        dao.deleteMember(gID, uID);
        List<GroupMembersDTO> list = getAdmin(gID);
        if(list.isEmpty()){
            list = getAll(gID);
            if(list.size() < 2){
                GroupChatBUS groupChatBUS = new GroupChatBUS();
                groupChatBUS.deleteGroup(gID);
                return true;
            }
            GroupMembersDTO groupMembersDTO = list.getFirst();
            setAdmin(groupMembersDTO.getGID(), groupMembersDTO.getUID(), true);
        }
        return true;
    }

    public List<GroupMembersDTO> getAll(int gID) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.getAll(gID);
    }

    public List<GroupMembersDTO> getAdmin(int gID) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.getAdmin(gID);
    }

    public List<GroupChatDTO> getGroups(int uID) {
        GroupMembersDAO dao = new GroupMembersDAO();
        List<Integer> idList = dao.getGroupID(uID);
        List<GroupChatDTO> groupList = new ArrayList<>();
        GroupChatBUS groupsBUS = new GroupChatBUS();
        for (int id : idList) {
            GroupChatDTO friend = groupsBUS.getById(id);
            groupList.add(friend);
        }
        return groupList;
    }

    public boolean deleteGroupMember(int uID) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.deleteGroupMember(uID);
    }
}
