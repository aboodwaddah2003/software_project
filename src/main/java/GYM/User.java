package GYM;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User {
    private static int onlineUsers = 0;
    public  int count;
    private String userName;
    private int id;
    private String email;
    private String password;

    private boolean isActive;

    private String type;
 public static ArrayList<String> loginRecords =new ArrayList<String>();


    public static User currentUser;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String status;

    private  String subscriptionPlans;

    public  User()
    {

    }
    public User(String userName, String email, String password, String type,String subscriptionPlans)
    {
        this.email=email;
        this.userName=userName;
        this.password=password;
        this.type=type;
        this.count=0;
        this.subscriptionPlans=subscriptionPlans;
        this.isActive=true;
        this.status="pending";
    }




//getters

    public String getType(){
        return type;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }
//setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public  String getSubscriptionPlans() {
        return subscriptionPlans;
    }

    public void setSubscriptionPlans(String subscriptionPlans) {
        this.subscriptionPlans = subscriptionPlans;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public void login()
    {
onlineUsers++;
  this.count++;
        LocalDateTime now = LocalDateTime.now();
        String formattedTime = now.format(formatter);
       String record = "User: " +this.getUserName() + ", Login Order: " + this.count + ", Time: " + now.format(formatter);
        loginRecords.add(record);
    }

    public void logout()
    {
        onlineUsers--;
        LocalDateTime now = LocalDateTime.now();
        String formattedTime = now.format(formatter);
        String record = "User: " +this.getUserName()+" is logout form system " + now.format(formatter);
        loginRecords.add(record);
    }

public static void  printLoginRecords()
{
    System.out.println("the number of activity user is "+onlineUsers);
    for (String s:loginRecords)
        System.out.println(s);
}

    @Override
    public String toString() {
        return "User{" +
                " userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", type='" + type + '\'' +
                '}';
    }

}