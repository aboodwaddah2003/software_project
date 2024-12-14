package GYM;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private int age;
    private String fitnessGoals;
    private String dietaryPreferences;
    private List<Program> enrolledPrograms; // قائمة لتخزين البرامج المسجل فيها العميل


    public Client(String userName, String email, String password, String type, String subscriptionPlan) {
        super(userName, email, password, type, subscriptionPlan);
        this.enrolledPrograms = new ArrayList<>(); // إنشاء القائمة عند إنشاء العميل
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


    public void enrollInProgram(Program program) {
        if (!enrolledPrograms.contains(program)) {
            enrolledPrograms.add(program);
            System.out.println("Client successfully enrolled in: " + program.getName());
        } else {
            System.out.println("Client is already enrolled in this program.");
        }
    }


    public List<Program> getEnrolledPrograms() {
        return enrolledPrograms;
    }


    public void viewSchedule(Program program) {
        if (enrolledPrograms.contains(program)) {
            System.out.println("Displaying schedule for: " + program.getName());

        } else {
            System.out.println("Client is not enrolled in this program.");
        }
    }
}
