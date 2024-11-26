package dto;

import java.sql.*;
import java.time.LocalDateTime;

public class LoginHistoryDTO {
    int uId;
    LocalDateTime loginTime;

    public LoginHistoryDTO() {
    }

    public LoginHistoryDTO(int uId, LocalDateTime loginTime) {
        this.uId = uId;
        this.loginTime = loginTime;
    }

    public int getUId() {
        return uId;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }
}
