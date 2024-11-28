package dto;

public class GroupMembersDTO {
    int gID;
    int uID;
    boolean isAdmin;

    public GroupMembersDTO() {}

    public GroupMembersDTO(int gID, int uID, boolean isAdmin) {
        this.gID = gID;
        this.uID = uID;
        this.isAdmin = isAdmin;
    }

    public int getGID() {
        return gID;
    }

    public void setGID(int gID) {
        this.gID = gID;
    }

    public int getUID() {
        return uID;
    }

    public void setUID(int uID) {
        this.uID = uID;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
