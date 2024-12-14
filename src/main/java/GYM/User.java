package GYM;

public class User {
    public static int count=0;
    private String userName;
    private int id;
    private String email;
    private String password;



    private boolean isActive;

    private String type;



    private String status;

    private  String subscriptionPlans;

    public User(String userName, String email, String password, String type,String subscriptionPlans)
    {
        this.email=email;
        this.userName=userName;
        this.password=password;
        this.type=type;
        count++;
        this.id=count;
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

    public String getSubscriptionPlans() {
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
}