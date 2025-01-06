package GYM;

import java.util.List;

public class Message {
    private String type;
    private String recipient;
    private String content;

    public Message(String type, String recipient, String content) {
        this.type=type;
        this.recipient = recipient;
        this.content = content;
    }

    @Override
    public String toString() {
        return "From: " + Instructor.currentUser.getUserName() + "\nTo: " + recipient + "\nMessage: " + content;
    }




    public String getType() {
        return type;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
    return content;
    }

}
