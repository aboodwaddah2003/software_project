package GYM;

public class loginHelper
{
    private boolean login;
    private String message;


    public String getMessage() {
        return message;
    }
    public  boolean  UserPass(String userName,String password)
    {
        if(Userlist.search(userName)!=-1)
        {
            int i=Userlist.search(userName);
            User user= Userlist.users.get(i);
            if(password.equals(user.getPassword())) {
                login = true;
                message = "success";
            }
            else {
                login = false;
                message = "filed";
            }
        }
        return login;
    }

    public boolean allFieldsAreFilled(String username, String pass) {
        return !username.trim().isEmpty() && !pass.trim().isEmpty();
    }

}