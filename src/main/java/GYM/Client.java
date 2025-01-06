package GYM;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private int age;
    private String fitnessGoals;
    private String dietaryPreferences;
    static  List<Program> enrolledPrograms;

    public static ArrayList<Message> messages= new ArrayList<>();

    public static List<Milestone> milestones;
    private FeedbackSubmissionService feedbackService;
    public Client(String userName) {
        super(userName, "default_email@example.com", "default_password", "Client", "Basic");
        this.enrolledPrograms = new ArrayList<>();
    }


    public Client(String userName, String email, String password, String type, String subscriptionPlan) {
        super(userName, email, password, type, subscriptionPlan);
        this.enrolledPrograms = new ArrayList<>();
        this.feedbackService = new FeedbackService();
        this.milestones=new ArrayList<>();
    }
    public List<Milestone> getMilestones() {
        return milestones;
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

    public boolean submitComplaint(String details) {
        if (details != null && !details.isEmpty()) {
            FeedbackSubmissionService.submitComplaint(this, details);
            return true;
        }
        return false;
    }

    public static Client getClientByName(String name) {
        int i = Userlist.search(name);
        if (i == -1) {
            return null;
        } else {
            return (Client) Userlist.users.get(i);
        }
    }
    public void addMilestone(Milestone milestone) {
        milestones.add(milestone);
    }

    public double getAttendancePercentage(int programId) {
        int attendedCount = 0;
        int totalMilestones = 0;

        for (Milestone milestone : milestones) {
            if (milestone.getProgramId() == programId) {
                totalMilestones++;
                if (milestone.getAttendance().equalsIgnoreCase("Present")) {
                    attendedCount++;
                }
            }
        }
        if (totalMilestones == 0) {
            return 0.0;
        }

        return (double) attendedCount / totalMilestones * 100;
    }
    public void displayEnrolledPrograms() {
        if (enrolledPrograms.isEmpty()) {
            System.out.println("Client is not enrolled in any programs.");
        } else {
            System.out.println("Enrolled programs:");
            for (Program program : enrolledPrograms) {
                System.out.println("- " + program.getName());
            }
        }
    }

    public void receiveMessage(Message message) {
        messages.add(message);
    }
}