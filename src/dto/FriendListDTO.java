package dto;

public class FriendListDTO {
    int uID;
    int fID;
    boolean requesting;
    boolean requested;

    public FriendListDTO() {}

    public FriendListDTO(int uID, int fID, boolean requesting, boolean requested) {
        this.uID = uID;
        this.fID = fID;
        this.requesting = requesting;
        this.requested = requested;
    }

    public FriendListDTO(int uID, int fID, boolean requesting) {
        this(uID, fID, requesting, false);
    }

    public FriendListDTO(int uID, int fID) {
        this(uID, fID, false, false);
    }

    public int getuID() {
        return uID;
    }

    public int getfID() {
        return fID;
    }

    public boolean isRequesting() {
        return requesting;
    }

    public boolean isRequested() {
        return requested;
    }
}
