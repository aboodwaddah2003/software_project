package GYM;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static GYM.Client.enrolledPrograms;


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


    public void SendMessage(Message m1)
    {
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

    public boolean addMilestone(int programId, String clientName, String weight, String bmi, String attendance, String date) {
        if (isInvalidInput(clientName, weight, bmi, attendance, date)) {
            System.out.println("Invalid input. All fields are required.");
            return false ;
        }

        Client client = Client.getClientByName(clientName);
        if (client == null) {
            System.out.println("Client not found: " + clientName);
            return false;
        }

        Milestone milestone = new Milestone(weight, bmi, attendance, clientName, date, programId);

        client.addMilestone(milestone);

        boolean programFound = false;
        for (Program program : client.getEnrolledPrograms()) {
            if (program.getId() == programId) {
                program.addMilestone(milestone);
                programFound = true;
                break;
            }
        }
        if (programFound) {
            System.out.println("Milestone added: " + milestone);
            return true;
        } else {
            System.out.println("Program with ID " + programId + " not found for client: " + clientName);
            return false;
        }

    }

    private static boolean isInvalidInput(String... fields) {
        for (String field : fields) {
            if (field == null || field.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean displayMilestones(String clientName) {

        Client client = Client.getClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return false;
        }

        if (client.getMilestones().isEmpty()) {
            System.out.println("No milestones available for " + clientName + ".");
        } else {
            System.out.println("All Milestones for " + clientName + ":");
            for (Milestone milestone : client.getMilestones()) {
                System.out.println(milestone);
            }
        }
        return true;
    }


}
