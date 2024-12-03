package dto;

public class BlockDTO {
    int uID;
    int bID;

    public BlockDTO() {}

    public BlockDTO(int uID, int bID) {
        this.uID = uID;
        this.bID = bID;
    }


    public int getuID() {
        return uID;
    }

    public int getbID() {
        return bID;
    }
}
