package GYM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Instructor extends User {

    public static ArrayList<Milestone> milestones= new ArrayList<>();
    private List<Milestone> programMilestones;

    public Instructor(String userName, String email, String password, String type,String subscriptionPlan) {
        super(userName, email, password, type,subscriptionPlan);

    }

    public void addContent(String Title,String Author,String Status,String SubmissionDate,String content )
    {
        ContentManger contentManager1 = new ContentManger(Title, Author, Status, SubmissionDate);
        contentManager1.setContent(content);
        ContentMangerService.contentMangers.add(contentManager1);
    }


    public boolean ClientTracking(String Name) {
        if (Instructor.searchClient(Name)){
            Instructor.printMilestoneByName(Name);
            return true;
        }else
            System.out.println(Name+" does not exist");
        return false;

    }

    public static boolean searchClient(String name) {
        for (Milestone milestone : milestones) {
            if (name==milestone.getClientName())
                return true;
        }
        return false;
    }


    public boolean sendMessage(Client client, String content) {
        if (content==null || content.equals(""))
            return false;
        else {
            Message message = new Message(getUserName(), content);
            client.receiveMessage(message);
            return true;
        }
    }

    public boolean NotifyAll(Client client, String content) {
        if (content==null || content.equals(""))
            return false;
        else {
            for ( Client client1: ClientRepository.clients){
                Message message = new Message(getUserName(), content);
                client1.receiveMessage(message);

            }
            return true;
        }
    }





    public void addMilestone(Milestone milestone) {
        programMilestones.add(milestone);
    }

    public static void displayMilestones() {
        if (milestones.isEmpty()) {
            System.out.println("No milestones available.");
        } else {
            System.out.println("All Milestones:");
            for (Milestone milestone : milestones) {
                System.out.println(milestone);
            }
        }
    }

    public static void printMilestoneByName(String name){
        for (Milestone milestone : milestones) {
            if (name==milestone.getClientName()){
                System.out.println(milestone.toString());
                return;
            }

        }


    }

    public boolean CreateNewProgram(Program p){
        if (p.getName()==null || p.getName()==""){
            System.out.println("Program name cannot be empty");
            return false;
        } else if (ProgramIsEmpty(p)) return false;

        ProgramService.allPrograms.add(p);
        System.out.println("Program added");
        return true;
    }

    //the name of the program can't be updated .
    public boolean UpdateProgram(String name,  String difficultylevel,  String focusarea,
                                 double price,int duration) {
        for (int i = 0; i < ProgramService.allPrograms.size(); i++) {
            if(Objects.equals(name, ProgramService.allPrograms.get(i).getName())){
                if (ProgramIsEmpty(ProgramService.getProgramByName(name))) return false;

                ProgramService.allPrograms.get(i).setName(name);
                ProgramService.allPrograms.get(i).setDifficultyLevel(difficultylevel);
                ProgramService.allPrograms.get(i).setFocusArea(focusarea);
                ProgramService.allPrograms.get(i).setPrice(price);
                ProgramService.allPrograms.get(i).setDuration(duration);
                System.out.println("Program updated successfully");
                return true;

            }

        }
        System.out.println("Program does not exist(you can't update the Name)");
        return false;
    }

    public boolean Delete(Program p,LocalDate fake) {
        for (int i = 0; i < ProgramService.allPrograms.size(); i++) {
            if(Objects.equals(p.getName(), ProgramService.allPrograms.get(i).getName())){
                if (!p.isCompleted(fake)){
                    System.out.println("program assigned to active gym members(Program Uncompleted)");
                    return false;
                }
                ProgramService.allPrograms.remove(p);
                System.out.println("Program deleted successfully!");
                return true;

            }
        }
        System.out.println("Program does not exist");
        return false;

    }
    //used in updateProgram function
    private boolean ProgramIsEmpty(Program p) {
        if (p.getDifficultyLevel()==null ||p.getDifficultyLevel()=="") {
            System.out.println("Program difficulty level cannot be empty");
            return true;
        } else if (p.getPrice()==0) {
            System.out.println("Program focus area cannot be empty or zero");
            return true;
        } else if (p.getDuration()==0) {
            System.out.println("Program duration cannot be empty or zero");
            return true;
        } else if (p.getFocusArea()==null ||p.getFocusArea()=="") {
            System.out.println("Program goals cannot be empty");
            return true;
        }
        return false;
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
}
