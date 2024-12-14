package GYM;

import java.util.ArrayList;
import java.util.List;

public class FeedbackService {
    private final List<Feedback> feedbackList = new ArrayList<>();


    public void submitFeedback(Feedback feedback) {
        feedbackList.add(feedback);
        System.out.println("Feedback submitted for program: " + feedback.getProgram().getName());


        if (feedbackList.contains(feedback)) {
            System.out.println("Feedback successfully added to list.");
        } else {
            System.out.println("Error: Feedback was not added.");
        }
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
}
