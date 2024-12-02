package dto;

import java.time.LocalDateTime;
import dao.GroupMembersDAO;

public class GroupChatDTO {
    int gID;
    String name;
    int initMembers;
    LocalDateTime createTime;

    public GroupChatDTO() {}

    public GroupChatDTO(int gID, String name, int initMembers, LocalDateTime createTime) {
        this.gID = gID;
        this.name = name;
        this.initMembers = initMembers;
        this.createTime = createTime;
    }

    public GroupChatDTO(String name, int initMembers) {
        this.name = name;
        this.initMembers = initMembers;
    }

    public int getGID() {
        return gID;
    }
    public String getName() {
        return name;
    }
    public int getInitMembers() {
        return initMembers;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    public int getNumMember() {
        GroupMembersDAO dao = new GroupMembersDAO();
        return dao.getNumMember(gID);
    }

    public void setName(String name) {
        this.name = name;
    }

}
