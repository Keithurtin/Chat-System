package bus;

import java.util.List;
import dao.*;
import dto.*;

public class GroupMembersBUS {
    public boolean addMember(int gID, int uID, boolean isAdmin) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.addMember(gID, uID, isAdmin);
    }

    public boolean setAdmin(int gID, int uID, boolean isAdmin) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.setAdmin(gID, uID, isAdmin);
    }

    public List<GroupMembersDTO> getAll(int gID) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.getAll(gID);
    }

    public List<GroupMembersDTO> getAdmin(int gID) {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.getAdmin(gID);
    }
}
