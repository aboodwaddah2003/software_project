package GYM;


import java.util.ArrayList;

public class Userlist {
    public static void fillData() {
        User u = new User("osama", "osama@gmail.com", "1234", "Admin");
        User u1 = new User("abood", "abood@gmail.com", "1234", "Admin");
        if(search(u.getUserName())==-1)
        {
            Userlist.users.add(u);
        }
        if(search(u1.getUserName())==-1)
        {
            Userlist.users.add(u1);
        }

    }

    public static ArrayList<User> users = new ArrayList<User>();

    public static int search(String username) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user != null && username.equals(user.getUserName())) {
                return i;
            }

        }
        return -1;
    }
}




