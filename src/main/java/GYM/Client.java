package GYM;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private int age;
    private String fitnessGoals;
    private String dietaryPreferences;
    private List<Program> enrolledPrograms;

    public static ArrayList<Milestone> milestones= new ArrayList<>();

    public Client(String userName) {
        super(userName, "default_email@example.com", "default_password", "Client", "Basic");
        this.enrolledPrograms = new ArrayList<>();
    }


    public Client(String userName, String email, String password, String type, String subscriptionPlan) {
        super(userName, email, password, type, subscriptionPlan);
        this.enrolledPrograms = new ArrayList<>();
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public String getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }


    public  void enrollInProgram(Program program) {
        if (!isEnrolledInProgram(program)) {
            enrolledPrograms.add(program);
        } else {
            System.out.println("Client is already enrolled in this program.");
        }
    }


    public boolean isEnrolledInProgram(Program program) {
        return enrolledPrograms.contains(program);
    }


    public  List<Program> getEnrolledPrograms() {
        return  enrolledPrograms;
    }




    public void addContent(String Title,String Author,String Status,String SubmissionDate,String content )
    {
        ContentManger contentManager1 = new ContentManger(Title, Author, Status, SubmissionDate);
        contentManager1.setContent(content);
        ContentMangerService.contentMangers.add(contentManager1);
    }

    public boolean submitFeedback(String program, int rating, String review, String improvementSuggestions)
    {
        Program program1=ProgramService.getProgramByName(program);
        if(program1 !=null) {
            Feedback feedback = new Feedback(program1, rating, review, improvementSuggestions);
            FeedbackService.submitFeedback(feedback);
            return true;
        }
        return  false;
    }

    public boolean submitComplaint(String details)
    {
        if(!details.isEmpty() && details!=null) {
            FeedbackService.submitComplaint(this,details);
            return  true;
        }
        return false;
    }


    public static void addMilestone( String weight, String bmi, String attendance,String clientName){
        Milestone milestone = new Milestone(weight, bmi, attendance,clientName);
        milestones.add(milestone);
        System.out.println("Milestone added: " + milestone);


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

    public static boolean searchClient(String name) {
        for (Milestone milestone : milestones) {
            if (name.equals(milestone.getClientName())) {
                return true;
            }
        }
        return false;
    }


    public static void printMilestoneByName(String name) {
        for (Milestone milestone : milestones) {
            if (name.equals(milestone.getClientName())) {
                System.out.println(milestone.toString());
                return;
            }
        }
        System.out.println("No milestone found with the client name: " + name);
    }


}