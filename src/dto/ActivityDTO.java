package dto;

import java.time.LocalDateTime;

public class ActivityDTO {
    int uID;
    String username;
    LocalDateTime lastActive;
    int openApp;
    int chatDM;
    int chatGroup;

    public ActivityDTO() {}

    public ActivityDTO(int uID, LocalDateTime lastActive) {
        this.uID = uID;
        this.lastActive = lastActive;
    }

    public ActivityDTO(int uID, String username, LocalDateTime lastActive, int openApp, int chatDM, int chatGroup) {
        this.uID = uID;
        this.username = username;
        this.lastActive = lastActive;
        this.openApp = openApp;
        this.chatDM = chatDM;
        this.chatGroup = chatGroup;
    }

    public int getuID() {
        return uID;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getLastActive() {
        return lastActive;
    }

    public int getOpenApp() {
        return openApp;
    }

    public int getChatDM() {
        return chatDM;
    }

    public int getChatGroup() {
        return chatGroup;
    }

    public void setOpenApp(int openApp) {
        this.openApp = openApp;
    }

    public void setChatDM(int chatDM) {
        this.chatDM = chatDM;
    }

    public void setChatGroup(int chatGroup) {
        this.chatGroup = chatGroup;
    }
}
