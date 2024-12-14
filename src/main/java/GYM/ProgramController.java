package GYM;

import java.util.List;

public class ProgramController {
    private final ProgramService programService;
    private final FeedbackService feedbackService;


    public ProgramController(ProgramService programService, FeedbackService feedbackService) {
        this.programService = programService;
        this.feedbackService = feedbackService;
    }


    public List<Program> browseProgramsByDifficulty(String difficulty) {
        return programService.filterProgramsByDifficulty(difficulty);
    }


    public List<Program> browseProgramsByFocusArea(String focusArea) {
        return programService.filterProgramsByFocusArea(focusArea);
    }


    public String enrollInProgram(Program program) {
        return programService.enrollInProgram(program);
    }


    public String viewSchedule(Program program) {
        return programService.getProgramSchedule(program);
    }


    public void submitProgramFeedback(String programName, int rating, String review, String improvementSuggestions) {

        Program program = programService.getProgramByName(programName);

        if (program != null) {

            Feedback feedback = new Feedback(program, rating, review, improvementSuggestions);
            feedbackService.submitFeedback(feedback);
        } else {
            System.out.println("Program not found for feedback submission.");
        }
    }


    public void getFeedbackForProgram(String programName) {
        Program program = programService.getProgramByName(programName);

        if (program != null) {

            List<Feedback> feedbackList = feedbackService.getFeedbacksForProgram(program);
            if (feedbackList.isEmpty()) {
                System.out.println("No feedback available for the program.");
            } else {
                for (Feedback feedback : feedbackList) {
                    System.out.println("Rating: " + feedback.getRating() + ", Review: " + feedback.getReview() + ", Suggestions: " + feedback.getImprovementSuggestions());
                }
            }
        } else {
            System.out.println("Program not found for viewing feedback.");
        }
    }
}
