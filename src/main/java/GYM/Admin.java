package GYM;

import io.cucumber.java.bs.A;
import java.util.ArrayList;

public class Admin  extends User {

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
        if (i == -1)
            return false;
        else {
            User user = Userlist.users.get(i);
            if (email != null && !email.isEmpty() && Userlist.IsValidEmail(email)) {
                if (Userlist.searchEmail(email) != -1)
                    return false;
                user.setEmail(email);
            }
            if (subPlan != null && !subPlan.isEmpty()) {
                user.setSubscriptionPlans(subPlan);
            }

            if (type != null && !type.isEmpty() && Userlist.IsValidRole(type)) {
                user.setType(type);
            }
            if (pass != null && !pass.isEmpty() && Userlist.IsValidPass(pass)) {
                user.setPassword(pass);
            }
            return true;
        }
    }

    public boolean setAccountStatus(String userName, boolean activate) {

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

    public boolean approveNewInstructor(String name) {

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
            return true;
        }

        return false;
    }



}

