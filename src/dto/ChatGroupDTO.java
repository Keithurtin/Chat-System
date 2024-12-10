package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatGroupDTO {
    private final int id;
    private final int sender_id;
    private final int receiver_id;
    private final String message_content;
    LocalDateTime send_time;

    public ChatGroupDTO(int uid, int gid, String msg) {
        id = -1;
        sender_id = uid;
        receiver_id = gid;
        message_content = msg;
        send_time = LocalDateTime.now();
    }

    public ChatGroupDTO(int id, int uid, int gid, String msg, LocalDateTime time) {
        this.id = id;
        sender_id = uid;
        receiver_id = gid;
        message_content = msg;
        send_time = time;
    }

    public int getId() {return id;}
    public int getSenderID() {return sender_id;}
    public int getGroupID() {return receiver_id;}
    public String getMessage() {return message_content;}
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        if(send_time != null){
            return send_time.format(formatter);
        }
        return "";
    }

}
