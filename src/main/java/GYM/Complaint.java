package GYM;

public class Complaint {

    private static int idCounter = 0;
    private int id=0;
    private String userName;
    private String details;
    private String status;

    public Complaint(String userName,String details) {
        this.id = ++idCounter;
        this.userName=userName;
        this.details = details;
        this.status = "Pending";
    }

    public String getUserName() { return userName; }
    public String getDetails() { return details; }
    public String getStatus() { return status; }
    public int getId() {return id;}

    public void setStatus(String status) { this.status = status; }
}