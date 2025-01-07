package GYM;

//import io.cucumber.java.bs.A;
//
//import javax.swing.text.AbstractDocument.Content;
import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//import static GYM.Client.enrolledPrograms;
import static GYM.Userlist.ActivityRecords;

public class Admin  extends User {

    ///
    public Admin(String userName, String email, String password, String type, String subscriptionPlans) {
        super(userName, email, password, type, subscriptionPlans);

    }

    public boolean addAccountClient(String name, String email, String pass, String type, String sub) {
        Client newClient = new Client(name, email, pass, type, sub);
        if (Userlist.search(newClient.getUserName()) == -1) {
            Userlist.users.add(newClient);
            return true;
        }
        return false;
    }

    public boolean addAccountInstructor(String name, String email, String pass, String type, String sub) {
        Instructor instructor = new Instructor(name, email, pass, type, sub);
        if (Userlist.search(instructor.getUserName()) == -1) {
            Userlist.users.add(instructor);
            return true;
        }
        return false;
    }

    public boolean checkAllInput(String name, String email, String pass, String type,String sub) {
        Userlist u = new Userlist();
        if(Userlist.search(name)==-1)
        {
            if(u.IsValidUsername(name) &&u.IsValidPass(pass)&&u.IsValidEmail(email)&&u.IsValidRole(type)&&u.IsValidSubscriptionPlan(sub))
            {
                return true;
            }
        }
        return  false;
    }

    public boolean UpdateUserName(String newUserName, String oldUserName) {

        int i = Userlist.search(oldUserName);

        if (i == -1) {
            return false;
        } else {

            if (Userlist.search(newUserName) != -1) {
                return false;
            }

            User user = Userlist.users.get(i);
            user.setUserName(newUserName);
            return true;
        }
    }

    public boolean updateData(String name, String email, String pass, String type, String subPlan) {
        int i = Userlist.search(name);
        if (i == -1) {
            return false;
        }

        User user = Userlist.users.get(i);

        if (isEmailUpdatable(email)) {
            if (Userlist.searchEmail(email) != -1) {
                return false;
            }
            user.setEmail(email);
        }

        if (isNonEmpty(subPlan)) {
            user.setSubscriptionPlans(subPlan);
        }

        if (isValidType(type)) {
            user.setType(type);
        }

        if (isValidPassword(pass)) {
            user.setPassword(pass);
        }

        return true;
    }

    private boolean isEmailUpdatable(String email) {
        return email != null && !email.isEmpty() && Userlist.IsValidEmail(email);
    }

    private boolean isNonEmpty(String input) {
        return input != null && !input.isEmpty();
    }

    private boolean isValidType(String type) {
        return isNonEmpty(type) && Userlist.IsValidRole(type);
    }

    private boolean isValidPassword(String pass) {
        return isNonEmpty(pass) && Userlist.IsValidPass(pass);
    }

    public  static boolean  setAccountStatus(String userName, boolean activate) {

        int i = Userlist.search(userName);
        if (i == -1) {
            return false;
        }


        User user = Userlist.users.get(i);
        if(activate==user.isActive())
            return false;

        user.setActive(activate);


        return true;
    }

    public static  boolean approveNewInstructor(String name) {

        int i = ManageAccountHelper.search(name);
        if (i == -1) {
            return false;
        }

        Instructor instructor = ManageAccountHelper.instructors.get(i);

        if(Userlist.search(name) != -1)
            return false;

        if ("pending".equals(instructor.getStatus())) {
            instructor.setStatus("Approved");
            Userlist.users.add(instructor);
            System.out.println("successful add instructor to the system");
            return true;
        }

        return false;
    }

    public static boolean ShowUserAction(String userName) {

        boolean userFound = false;
        if(Userlist.search(userName)==-1)
            return false;

        for (String record : ActivityRecords) {
            if (record.contains(userName)) {
                System.out.println(record);
                userFound = true;
            }
        }

        return userFound;
    }

    public static  boolean ShowDateAction(String date) {


        if(ManageAccountHelper.isValidFormatDate(date)) {

            for (String record : ActivityRecords) {
                if (record.contains(date)) {
                    System.out.println(record);

                }
            }
        }


        else
            return false;

        return true;
    }

    public boolean showProgramsStatistics()
    {
        if(ProgramService.allPrograms.isEmpty())
            return  false;
        for(Program p : ProgramService.allPrograms)
        {
            String s= p.getName()+"the number of enroll client is "+p.numOfClientSub();
            System.out.println(s);
        }
        return true;
    }

    public static double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Program program : ProgramService.allPrograms) {
            totalRevenue += program.getPrice() * program.numOfClientSub();

        }

        return totalRevenue;
    }

    public static  void generateRevenueReport()
    {
        System.out.println("The total Revenue is "+calculateTotalRevenue());
        System.out.println("************************************************");
        System.out.println("This is detail for revenue for each program");
        for (Program program : ProgramService.allPrograms) {
            System.out.println(program.getName()+"The total revenue is "+program.numOfClientSub()*program.getPrice()+" the number of subscriber is "+program.numOfClientSub());
        }

    }






    public boolean  countActivePrograms(LocalDate d)
    {
        int activeProgramCount=0;
        for( Program program :ProgramService.allPrograms)
        {
            if(!program.isCompleted(d))
                activeProgramCount++;
        }
        if (activeProgramCount==0 )
            return false;

        return true;
    }


    public static void showActivePrograms(LocalDate d) {
        int count=0;
        for (Program program : ProgramService.allPrograms) {
            if (!program.isCompleted(d))
                System.out.println(" id program "+program.getId() +")"+program.getName() + "is active program The start date for program is  " + program.getStartDate() + " the duration for program is " + program.getDuration());
        }
    }

    public  static  void showCompletedPrograms(LocalDate d) {

        for (Program program : ProgramService.allPrograms) {
            if (program.isCompleted(d))
                System.out.println(program.getName() + "is completed program The start date for program is  " + program.getStartDate() + " the duration for program is " + program.getDuration());
        }
    }


    public static boolean updateContentStatus(String title, String newStatus) {
        if (ContentMangerService.contentMangers.isEmpty()) {
            return false;
        }

        boolean found = false;
        for (ContentManger content : ContentMangerService.contentMangers) {
            if (content.getTitle().equals(title)) {
                content.setStatus(newStatus);
                found = true;
            }
        }

        return found;
    }


    public static boolean resolveComplaint(int id)
    {
        if(id>0)
        {
            FeedbackService.resolveComplaint(id);
            return true;
        }
        return false;
    }




}
