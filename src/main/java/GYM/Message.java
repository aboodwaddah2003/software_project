package GYM;

import java.util.List;

public class Message {
    private String type;//Message, notify,FeedBack
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

    public void sendMessage(String type, List<Client> clients, String messageContent){

        for (Client client : clients) {

            Message message = new Message(type, client.getUserName() +
                    " (" + client.getEmail() + ")", messageContent);
            System.out.println("Message sent:\n" + message);
        }

    }




    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getRecipient() {
        return recipient;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getContent() {
    return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
