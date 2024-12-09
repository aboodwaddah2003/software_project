package GYM;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Userlist {
    public static void fillData() {
        User u = new User("osama", "osama@gmail.com", "1234", "Admin"," " );
        User u1 = new User("abood", "abood@gmail.com", "1234", "Client","Basic");
        User u2 = new User("bayan", "bayan@gmail.com", "1234", "Instructor","Prime");
        User u3 = new User("waddah", "waddah@gmail.com", "1234", "Instructor","Prime");
        Client c1=new Client("ammar","ammar@gmail.com","1234","Client","Basic");
        Instructor n1=new Instructor("mahmoud","moh@gmail.com","10203040","Instructor","Gold");
        Instructor n2=new Instructor("alaa22", "alaa22@gmail.com", "1234", "Instructor", "Silver");

        if(search(u.getUserName())==-1)

            Userlist.users.add(u);

        if(search(u1.getUserName())==-1)

            Userlist.users.add(u1);

        if(search(u2.getUserName())==-1)

            Userlist.users.add(u2);

        if(search(u3.getUserName())==-1)

            Userlist.users.add(u3);

        if(search(c1.getUserName())==-1)
            Userlist.users.add(c1);

        if(search(n1.getUserName())==-1)
            Userlist.users.add(n1);

        if(search(n2.getUserName())==-1)
            Userlist.users.add(n2);
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

    public static int searchEmail(String email) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user != null && email.equals(user.getEmail())) {
                return i;
            }

        }
        return -1;
    }

    public boolean IsCanBeUser(String user,String pass,String email,String role,String sub)
    {
    if(search(user)==-1)
    {
        if(IsValidUsername(user) &&IsValidPass(pass)&&IsValidEmail(email)&&IsValidRole(role))
        {
            User u=new User(user,pass,email,role,sub);
            users.add(u);
            return true;
        }
    }
    return  false;

    }

    public boolean IsValidUsername(String user) {




        if (user.length() >= 5 && user.length() <= 15 && Character.isLetter(user.charAt(0))) {
            return true;
        }

        return false;
    }


    public static boolean IsValidPass(String pass)
    {

        if(pass.length()>=8 && pass.length()<=18)
            return true;

            return false;
    }

    public static boolean IsValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static  boolean  IsValidRole(String role)
    {
        if(role.equals("Admin")  || role.equals("Client") || role.equals("Instructor "))
            return true;


        return false;
    }

    public static boolean IsValidSubscriptionPlan(String sub)
    {
        if(sub.equals("Basic")  || sub.equals("Premium") || sub.equals("Gold ") || sub.equals("Silver"))
            return true;

        return false;
    }

    public boolean allFieldsisIsFull(String s1,String s2,String s3,String s4)
    {
        return !s1.isEmpty() && !s2.isEmpty() &&!s3.isEmpty()&&!s4.isEmpty();
    }




}




