package GYM;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private int age;
    private String fitnessGoals;
    private String dietaryPreferences;
    private List<Program> enrolledPrograms;

    public Client(String userName) {
        super(userName, "default_email@example.com", "default_password", "Client", "Basic");
        this.enrolledPrograms = new ArrayList<>();
    }

    // Constructor
    public Client(String userName, String email, String password, String type, String subscriptionPlan) {
        super(userName, email, password, type, subscriptionPlan);
        this.enrolledPrograms = new ArrayList<>();
    }

    // Getters and Setters
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

    // Enroll client in a program
    public  void enrollInProgram(Program program) {
        if (!isEnrolledInProgram(program)) {
            enrolledPrograms.add(program);
            System.out.println("Client successfully enrolled in: " + program.getName());
        } else {
            System.out.println("Client is already enrolled in this program.");
        }
    }

    // Check if client is enrolled in a program
    public boolean isEnrolledInProgram(Program program) {
        return enrolledPrograms.contains(program);
    }

    // Get enrolled programs
    public List<Program> getEnrolledPrograms() {
        return new ArrayList<>(enrolledPrograms); // Return a copy to maintain encapsulation
    }

    // View the schedule of a specific program
    public void viewSchedule(Program program) {
        if (isEnrolledInProgram(program)) {
            System.out.println("Displaying schedule for: " + program.getName());
            System.out.println("Schedule: Monday 10AM, Wednesday 10AM, Friday 10AM"); // Example schedule
        } else {
            System.out.println("Client is not enrolled in this program.");
        }
    }

    // Display all enrolled programs
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

    public void addContent(String Title,String Author,String Status,String SubmissionDate,String content )
    {
        ContentManger contentManager1 = new ContentManger(Title, Author, Status, SubmissionDate);
        contentManager1.setContent(content);
        ContentMangerService.contentMangers.add(contentManager1);
    }



}
