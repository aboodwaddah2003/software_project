package GYM;

import java.util.List;

public class Message {
    private String senderName; // اسم المرسل (المدرب)
    private String content;

    public Message(String senderName, String content) {
        this.senderName = senderName;
        this.content = content;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getContent() {
        return content;
    }
}