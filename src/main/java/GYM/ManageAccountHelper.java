package GYM;

import java.util.ArrayList;

import static GYM.Userlist.users;

public class ManageAccountHelper {

    public static ArrayList<Instructor> instructors=new ArrayList<Instructor>();
    public static void fillData2() {
        Instructor n1 = new Instructor("alaa22", "alaa22@gmail.com", "1234", "Instructor", "Silver");
        Instructor n2 = new Instructor("mohammedK", "mohammed.k@gmail.com", "5678", "Instructor", "Gold");
        Instructor n3 = new Instructor("mahmoud","moh@gmail.com","10203040","Instructor","Gold");
        Instructor n4 = new Instructor("ahmed87", "ahmed.87@hotmail.com", "121314", "Instructor", "Basic");
        Instructor n5 = new Instructor("layla99", "layla.99@gmail.com", "151617", "Instructor", "Premium");


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



}
