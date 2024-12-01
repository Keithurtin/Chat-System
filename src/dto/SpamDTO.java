package dto;

import java.time.LocalDateTime;

public class SpamDTO {
    int uID;
    String uName;
    LocalDateTime reportTime;

    public SpamDTO() {}

    public SpamDTO(int uID, String uName, LocalDateTime reportTime) {
        this.uID = uID;
        this.uName = uName;
        this.reportTime = reportTime;
    }

    public int getuID() {
        return uID;
    }

    public String getuName() {
        return uName;
    }

    public LocalDateTime getReportTime() {
        return reportTime;
    }
}
