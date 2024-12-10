package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatDMDTO {
    private int id;
    private final int uID;
    private final int uID2;
    private final String message;
    private LocalDateTime sender_time;

    public ChatDMDTO(int id, int uID, int uID2, String message) {
        this.id = id;
        this.uID = uID;
        this.uID2 = uID2;
        this.message = message;
        sender_time = LocalDateTime.now();
    }

    public ChatDMDTO(int id, int uID, int uID2, String message, LocalDateTime sender_time) {
        this.id = id;
        this.uID = uID;
        this.uID2 = uID2;
        this.message = message;
        this.sender_time = sender_time;
    }

    public int getID() { return id; }

    public int getSenderID() {
        return uID;
    }

    public int getReceiverID() {
        return uID2;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        if(sender_time != null){
            return sender_time.format(formatter);
        }
        return "";
    }
}
