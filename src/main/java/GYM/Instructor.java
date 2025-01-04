package GYM;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Instructor extends User {

    public Instructor(String userName, String email, String password, String type,String subscriptionPlan) {
        super(userName, email, password, type,subscriptionPlan);

    }

    public void addContent(String Title,String Author,String Status,String SubmissionDate,String content )
    {
        ContentManger contentManager1 = new ContentManger(Title, Author, Status, SubmissionDate);
        contentManager1.setContent(content);
     ContentMangerService.contentMangers.add(contentManager1);
    }


    public void ClientTracking(String Name) {
    if (Client.searchClient(Name)){
        Client.printMilestoneByName(Name);
    }else
    System.out.println(Name+" does not exist");

    }


    public void SendMessage(Message m1) {
        if (m1.getContent().isEmpty()) {
        System.out.println("Error... Message is empty ");
        return;
        }
        System.out.println("You Have "+m1.getType()+" From: "+m1.getRecipient()+"\n "+m1.getContent());

    }
    public static void notifiesAll(Program p2) {
        System.out.println("The Program "+p2.getName()+" is updated");
        System.out.println(p2.toString());
    }

    public void AnnounceProgram(Program p2) {
        System.out.println("A new Program(name) "+p2.getName()+" is added");
        System.out.println(p2.toString());
    }

}
