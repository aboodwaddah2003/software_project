package GYM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedbackService {
    public static List<Feedback> feedbackList = new ArrayList<>();
    public static List<Complaint> complaints = new ArrayList<>();



    public static   void fillDataFeedback()
    {
        Client  u1=new Client("waddah", "waddah@gmail.com", "1234", "Instructor", "Prime");
        u1.submitFeedback("Muscle Gain Program", 4, "very good", "improve the tools");
        u1.submitFeedback("Weight Loss Program", 5, "excellent", "add more meal plans");
        u1.submitFeedback("Flexibility Program", 3, "average", "include advanced stretches");
        u1.submitFeedback("Yoga Program", 4, "good", "provide video instructions");
        u1.submitFeedback("Muscle Gain Program", 3, "very good", "improve the tools");
        u1.submitFeedback("Muscle Gain Program", 2, " good", "improve the tools");
        u1.submitFeedback("Muscle Gain Program", 1, " good", "improve the tools");
        u1.submitFeedback("Muscle Gain Program", 4, "very good", "improve the tools");
    }
    public static   void fillDataComplements()
    {
        Client  u1=new Client("waddah", "waddah@gmail.com", "1234", "Instructor", "Prime");
        u1.submitComplaint("The gym equipment is outdated and needs maintenance.");
        u1.submitComplaint("The air conditioning in the gym is not working properly.");
        u1.submitComplaint("The gym's opening hours are not convenient for my schedule.");
        u1.submitComplaint("There is not enough space for stretching and yoga activities.");
        u1.submitComplaint("The gym is overcrowded during peak hours, making it difficult to use machines.");
    }



    public List<Feedback> getFeedbacksForProgram(Program program) {
        List<Feedback> programFeedbacks = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            if (feedback.getProgram().equals(program)) {
                programFeedbacks.add(feedback);
            }
        }
        System.out.println("Found feedbacks for program: " + program.getName());
        return programFeedbacks;
    }


    public List<Program> getPrograms() {
        List<Program> programsWithFeedback = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            Program program = feedback.getProgram();
            if (!programsWithFeedback.contains(program)) {
                programsWithFeedback.add(program);
            }
        }
        return programsWithFeedback;
    }

    public static void submitComplaint(Client client ,String details) {

        Complaint complaint = new Complaint(client.getUserName(),details);
       complaints.add(complaint);
    }


    public static void submitFeedback(Feedback feedback) {
        feedbackList.add(feedback);
       // System.out.println("Feedback submitted for program: " + feedback.getProgram().getName());


        if (feedbackList.contains(feedback)) {
          //  System.out.println("Feedback successfully added to list.");
        } else {
            System.out.println("Error: Feedback was not added.");
        }
    }


    public static void displayAllFeedbacks() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
            return;
        }

        Map<String, List<Feedback>> feedbackByProgram = new HashMap<>();

        for (Feedback feedback : feedbackList) {
            String programName = feedback.getProgram().getName();
            feedbackByProgram
                    .computeIfAbsent(programName, k -> new ArrayList<>())
                    .add(feedback);
        }

        System.out.println("All Feedbacks:");
        for (Map.Entry<String, List<Feedback>> entry : feedbackByProgram.entrySet()) {
            String programName = entry.getKey();
            List<Feedback> feedbacks = entry.getValue();

            double averageRating = feedbacks.stream()
                    .mapToInt(Feedback::getRating)
                    .average()
                    .orElse(0.0);

            StringBuilder comments = new StringBuilder();
            for (Feedback feedback : feedbacks) {
                comments.append(feedback.getImprovementSuggestions()).append("; ");
            }

            System.out.println("Program: " + programName);
            System.out.println("Average Rating: " + String.format("%.2f", averageRating));
            System.out.println("Comments: " + comments.toString());
            System.out.println("----------------------------");
        }
    }

    public static  void displayAllComplaints() {
        if(complaints.isEmpty())
            return;
        System.out.println("All Complaints:");
        for (Complaint complaint : complaints) {
            System.out.println("Id: " + complaint.getId());
            System.out.println("User: " + complaint.getUserName());
            System.out.println("Details: " + complaint.getDetails());
            System.out.println("Status: " + complaint.getStatus());
            System.out.println("-----------------------------");
        }
    }

    public static boolean resolveComplaint(int id) {
        for (Complaint complaint : complaints) {
            if (complaint.getId() == id) {
                complaint.setStatus("Resolved");
                System.out.println("Complaint has been resolved: " + id);
                return true;
            }
        }
        System.out.println("Complaint not found: " + id);
        return false;
    }



}


