package GYM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Userlist {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<String> ActivityRecords =new ArrayList<String>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void fillData() {
        Admin u = new Admin("osama", "osama@gmail.com", "1234", "Admin", " ");
        Client u1 = new Client("abood", "abood@gmail.com", "1234", "Client", "Basic");
        User u2 = new User("bayan", "bayan@gmail.com", "1234", "Instructor", "Prime");
        User u3 = new User("waddah", "waddah@gmail.com", "1234", "Instructor", "Prime");
        Client c1 = new Client("ammar");
        Instructor n1 = new Instructor("mahmoud", "moh@gmail.com", "10203040", "Instructor", "Gold");
        Instructor n2 = new Instructor("alaa22", "alaa22@gmail.com", "1234", "Instructor", "Silver");

        addUserIfNotExists(u);
        addUserIfNotExists(u1);
        addUserIfNotExists(u2);
        addUserIfNotExists(u3);
        addUserIfNotExists(c1);
        addUserIfNotExists(n1);
        addUserIfNotExists(n2);
    }

    public static void fillData3()
    {
        User u3 = new User("waddah", "waddah@gmail.com", "1234", "Instructor", "Prime");
        Client c1 = new Client("ammar", "ammar@gmail.com", "1234", "Client", "Basic");
        Instructor n1 = new Instructor("mahmoud", "moh@gmail.com", "10203040", "Instructor", "Gold");
        u3.login();
        c1.login();
        c1.logout();
        n1.login();
        u3.login();
    }


    private static void addUserIfNotExists(User user) {
        if (search(user.getUserName()) == -1) {
            users.add(user);
        }
    }

    public static int search(String username) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user != null && username.equals(user.getUserName())) {
                return i;
            }
        }
        return -1;
    }

    public static int searchEmail(String email) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user != null && email.equals(user.getEmail())) {
                return i;
            }
        }
        return -1;
    }

   /* public boolean createClient(String username, String password, String email, String role, String subscription) {
        if (search(username) != -1) {
            System.out.println("Error: Username already exists.");
            return false;
        }

        if (searchEmail(email) != -1) {
            System.out.println("Error: Email already exists.");
            return false;
        }

        if (!IsValidUsername(username)) {
            System.out.println("Error: Invalid username.");
            return false;
        }

        if (!IsValidPass(password)) {
            System.out.println("Error: Invalid password.");
            return false;
        }

        if (!IsValidEmail(email)) {
            System.out.println("Error: Invalid email.");
            return false;
        }

        if (!IsValidRole(role)) {
            System.out.println("Error: Invalid role.");
            return false;
        }

        if (!IsValidSubscriptionPlan(subscription)) {
            System.out.println("Error: Invalid subscription plan.");
            return false;
        }

        Client newClient = new Client(username);
        users.add(newClient);
        return true;
    }

    */

    public static boolean updateClientDetails(String username, String newEmail, String newPassword, String newSubscription) {
        int index = search(username);
        if (index == -1) {
            System.out.println("Error: Username not found.");
            return false;
        }

        User user = users.get(index);
        if (user instanceof Client || user.getType().equals("Client")) {
            Client client = (Client) user;


            if (newEmail != null) {
                if (IsValidEmail(newEmail)) {
                    client.setEmail(newEmail);
                } else {
                    System.out.println("Error: Invalid email.");
                    return false;
                }
            }


            if (newPassword != null) {
                if (IsValidPass(newPassword)) {
                    client.setPassword(newPassword);
                } else {
                    System.out.println("Error: Invalid password.");
                    return false;
                }
            }


            if (newSubscription != null) {
                if (IsValidSubscriptionPlan(newSubscription)) {
                    client.setSubscriptionPlans(newSubscription);
                } else {
                    System.out.println("Error: Invalid subscription plan.");
                    return false;
                }
            }

            return true;
        }

        System.out.println("Error: The user is not a client.");
        return false;
    }



    public boolean IsValidUsername(String user) {
        return user.length() >= 5 && user.length() <= 15 && Character.isLetter(user.charAt(0));
    }

    public static boolean IsValidPass(String pass) {
        return pass.length() >= 8 && pass.length() <= 18;
    }

    public static boolean IsValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean IsValidRole(String role) {
        return role.equals("Admin") || role.equals("Client") || role.equals("Instructor");
    }

    public static boolean IsValidSubscriptionPlan(String sub) {
        return sub.equals("Basic") || sub.equals("Premium") || sub.equals("Gold") || sub.equals("Silver") || sub.equals("Prime");
    }



    public static boolean IsCanBeUser(String username, String password, String email, String subscriptionPlan) {

        if (!allFieldsisIsFull(username, password, email, subscriptionPlan)) {
            return false;
        }


        if (search(username) != -1) {
            System.out.println("Username already exists.");
            return false;
        }


        if (!IsValidEmail(email)) {
            System.out.println("Invalid email format.");
            return false;
        }



        if (!isValidSubscriptionPlan(subscriptionPlan)) {
            System.out.println("Invalid subscription plan.");
            return false;
        }

        return true;
    }



    private static boolean isValidSubscriptionPlan(String subscriptionPlan) {
        return subscriptionPlan != null && (subscriptionPlan.equals("basic")||subscriptionPlan.equals("silver") || subscriptionPlan.equals("gold")||subscriptionPlan.equals("premium")); // تحقق من أن الخطة إما Basic أو Premium
    }

    public static boolean allFieldsisIsFull(String field1, String field2, String field3, String field4) {

        if (field1 == null || field1.isEmpty()) {
            System.out.println("Field 1 is required.");
            return false;
        }
        if (field2 == null || field2.isEmpty()) {
            System.out.println("Field 2 is required.");
            return false;
        }
        if (field3 == null || field3.isEmpty()) {
            System.out.println("Field 3 is required.");
            return false;
        }
        if (field4 == null || field4.isEmpty()) {
            System.out.println("Field 4 is required.");
            return false;
        }


        return true;
    }
    public static void recordActivity(String userName, String action,String date) {

        String record = "User: " + userName + ", Action: " + action + ",Date: " + date;
        ActivityRecords.add(record);

    }

public static void fillDataClientEnrollInProgram()
{

    Client C1 = new Client("Mahmoud", "moh@gmail.com", "10203040", "Client", "Gold");
    Client C2 = new Client("Alaa", "alaa@yahoo.com", "20304050", "Client", "Silver");
    Client C3 = new Client("Hiba", "hiba@gmail.com", "30405060", "Client", "Platinum");
    Client C4 = new Client("Omar", "omar@hotmail.com", "40506070", "Client", "Bronze");
    Client C5 = new Client("Sara", "sara@gmail.com", "50607080", "Client", "Diamond");

    ProgramService.enrollClientInProgram(C1, "Muscle Gain Program");
    ProgramService.enrollClientInProgram(C2, "Weight Loss Program");
    ProgramService.enrollClientInProgram(C3, "Flexibility Program");
    ProgramService.enrollClientInProgram(C4, "Yoga Program");
    ProgramService.enrollClientInProgram(C5, "Endurance Program");
    }



}
