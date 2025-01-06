package GYM;

import java.util.ArrayList;
import java.util.Date;

import static GYM.Userlist.ActivityRecords;

public class ManageAccountHelper {

    public static ArrayList<Instructor> instructors=new ArrayList<Instructor>();
    private static final String INSTRUCTOR_ROLE = "Instructor"; // Constant for the role
    private static final String USER_ROLE = "alaa22"; // Constant for the role
    private static boolean isActivityFilled = false;
    public static void fillData2() {
        Instructor n1 = new Instructor("alaa22", "alaa22@gmail.com", "1234", INSTRUCTOR_ROLE, "Silver");
        Instructor n2 = new Instructor("mohammedK", "mohammed.k@gmail.com", "5678", INSTRUCTOR_ROLE, "Gold");
        Instructor n3 = new Instructor("mahmoud", "moh@gmail.com", "10203040", INSTRUCTOR_ROLE, "Gold");
        Instructor n4 = new Instructor("ahmed87", "ahmed.87@hotmail.com", "121314", INSTRUCTOR_ROLE, "Basic");
        Instructor n5 = new Instructor("layla99", "layla.99@gmail.com", "151617", INSTRUCTOR_ROLE, "Premium");


        if (search(n1.getUserName()) == -1) {
            instructors.add(n1);
        }
        if (search(n2.getUserName()) == -1) {
            instructors.add(n2);
        }
        if (search(n3.getUserName()) == -1) {
            instructors.add(n3);
        }
        if (search(n4.getUserName()) == -1) {
            instructors.add(n4);
        }
        if (search(n5.getUserName()) == -1) {
            instructors.add(n5);
        }
    }




    public static int search(String username) {
        for (int i = 0; i < instructors.size(); i++) {
            Instructor instructor = instructors.get(i);
            if (instructor != null && username.equals(instructor.getUserName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean fetchUserActivityPanel() {

        if (User.loginRecords.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

public  static  void fillRecordActivity()
{
    if (!isActivityFilled) {
        Userlist.recordActivity(USER_ROLE, "update profile","15-09-2024");
        Userlist.recordActivity(USER_ROLE, "add publication","12-09-2024");
        Userlist.recordActivity(USER_ROLE, " delete publication","14-09-2013");
        Userlist.recordActivity(USER_ROLE, "update profile","14-09-2013");


        isActivityFilled = true;
    }
}

public static boolean isValidFormatDate(String date)  ///15-09-2024
{

    if (date.length() != 10)
        return false;

    for (int i = 0; i < date.length(); i++) {
        char s = date.charAt(i);
        if (i == 2 || i == 5) {
            if (s != '-' && s != '/')
                return false;
        } else if (!Character.isDigit(s))
            return false;


    }
    try {

        int day = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6));


        if (year < 2018 || year > 2024) {
            return false;
        }


        if (month < 1 || month > 12) {
            return false;
        }


        if (day < 1 || day > 30) {
            return false;
        }


        return true;

    } catch (NumberFormatException | StringIndexOutOfBoundsException e) {

        return false;
    }
}

    public  static void showAllInstructorRequest() {
    for (Instructor user : instructors) {
      {

            if (user.getStatus().equals("pending")) {
                System.out.println(user);
            }
        }
    }
}

}






