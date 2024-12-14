package GYM;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Userlist {
    public static ArrayList<User> users = new ArrayList<>();

    public static void fillData() {
        User u = new User("osama", "osama@gmail.com", "1234", "Admin", " ");
        User u1 = new User("abood", "abood@gmail.com", "1234", "Client", "Basic");
        User u2 = new User("bayan", "bayan@gmail.com", "1234", "Instructor", "Prime");
        User u3 = new User("waddah", "waddah@gmail.com", "1234", "Instructor", "Prime");
        Client c1 = new Client("ammar", "ammar@gmail.com", "1234", "Client", "Basic");
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

    public boolean createClient(String username, String password, String email, String role, String subscription, int age, String goals, String dietaryPreferences) {
        if (search(username) == -1 && searchEmail(email) == -1) {
            if (IsValidUsername(username) && IsValidPass(password) && IsValidEmail(email) && IsValidRole(role) && IsValidSubscriptionPlan(subscription)) {
                Client newClient = new Client(username, email, password, role, subscription);
                users.add(newClient);
                return true;
            }
        }
        return false;
    }

    public boolean updateClientDetails(String username, String newEmail, String newPassword, String newSubscription) {
        int index = search(username);
        if (index != -1) {
            User user = users.get(index);
            if (user instanceof Client)
            {
                Client client = (Client) user;
                if (newEmail != null && IsValidEmail(newEmail)) {
                    client.setEmail(newEmail);
                }
                if (newPassword != null && IsValidPass(newPassword)) {
                    client.setPassword(newPassword);
                }
                if (newSubscription != null && IsValidSubscriptionPlan(newSubscription)) {
                    client.setSubscriptionPlans(newSubscription);
                }
                return true;
            }
        }
        return false;
    }

    public boolean updateDietaryPreferences(String username, String newPreferences) {
        int index = search(username);
        if (index != -1) {
            User user = users.get(index);
            if (user instanceof Client) {
                Client client = (Client) user;
                client.setDietaryPreferences(newPreferences);
                return true;
            }
        }
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



    public boolean IsCanBeUser(String username, String password, String email, String subscriptionPlan) {

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



    private boolean isValidSubscriptionPlan(String subscriptionPlan) {
        return subscriptionPlan != null && (subscriptionPlan.equals("Basic") || subscriptionPlan.equals("Premium")); // تحقق من أن الخطة إما Basic أو Premium
    }

    public boolean allFieldsisIsFull(String field1, String field2, String field3, String field4) {

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

}
