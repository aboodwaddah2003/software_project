package GYM.AcceptanceTest;

import GYM.Feedback;
import GYM.FeedbackService;
import GYM.Program;
import GYM.ProgramService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class FeedbackAndReviewTest {


    private FeedbackService feedbackService;
    private Program selectedProgram;
    private List<Feedback> feedbackList;
    private List<Program> completedPrograms;


    @Given("the client has completed a program {string}")
    public void theClientHasCompletedAProgram(String programName) {
        ProgramService programService = new ProgramService();
        selectedProgram = programService.getProgramByName(programName);


        if (selectedProgram != null) {
            System.out.println("Selected program: " + selectedProgram.getName());
        } else {
            System.out.println("Error: Program " + programName + " not found.");
            Assert.fail("Program " + programName + " not found.");
        }

        feedbackService = new FeedbackService();
        System.out.println("Client has completed program: " + programName);
    }



    @Given("the client has completed the following programs:")
    public void theClientHasCompletedTheFollowingPrograms(DataTable dataTable) {
        List<String> programNames = dataTable.asList(String.class);
        ProgramService programService = new ProgramService();

        completedPrograms = new ArrayList<>();
        for (String programName : programNames) {
            Program program = programService.getProgramByName(programName);
            if (program != null) {
                completedPrograms.add(program);
                System.out.println("Client has completed program: " + programName);
            } else {
                System.out.println("Program " + programName + " not found.");
            }
        }

        feedbackService = new FeedbackService();
    }

    @When("the client submits feedback for each program")
    public void theClientSubmitsFeedbackForEachProgram(DataTable dataTable) {

        if (feedbackService == null) {
            feedbackService = new FeedbackService();
        }

        List<List<String>> feedbackData = dataTable.asLists(String.class);


        for (int i = 1; i < feedbackData.size(); i++) {
            List<String> row = feedbackData.get(i);
            String programName = row.get(0);
            int rating = Integer.parseInt(row.get(1));
            String review = row.get(2);
            String improvementSuggestions = row.get(3);

            ProgramService programService = new ProgramService();
            Program program = programService.getProgramByName(programName);

            if (program != null) {
                feedbackService.submitFeedback(new Feedback(program, rating, review, improvementSuggestions));
                System.out.println("Feedback submitted for program: " + programName);
            } else {
                System.out.println("Error: Program " + programName + " not found.");
            }
        }
    }




    @Then("the system submits the feedback for all the programs successfully")
    public void theSystemSubmitsTheFeedbackForAllTheProgramsSuccessfully() {
        if (completedPrograms != null && !completedPrograms.isEmpty()) {
            for (Program program : completedPrograms) {
                feedbackList = feedbackService.getFeedbacksForProgram(program);
                Assert.assertNotNull("Feedback list should not be null for program: " + program.getName(), feedbackList);
                Assert.assertFalse("Feedback list should not be empty for program: " + program.getName(), feedbackList.isEmpty());
                System.out.println("Feedback successfully submitted for program: " + program.getName());
            }
        } else {
            System.out.println("Error: No programs found to verify feedback submission.");
        }
    }

    @When("the client rates the program {int} and writes a review {string} with improvement suggestions {string}")
    public void theClientRatesTheProgramAndWritesAReviewWithImprovementSuggestions(int rating, String review, String improvementSuggestions) {
        if (selectedProgram != null) {
            if (rating < 1 || rating > 5) {
                System.out.println("Error: Rating must be between 1 and 5.");
                Assert.fail("Invalid rating");
            }
            if (review == null || review.trim().isEmpty()) {
                System.out.println("Error: Review cannot be empty.");
                Assert.fail("Review cannot be empty");
            }
            feedbackService.submitFeedback(new Feedback(selectedProgram, rating, review, improvementSuggestions));
            System.out.println("Feedback submitted with rating: " + rating + ", review: " + review + ", improvement suggestions: " + improvementSuggestions);
        } else {
            System.out.println("Cannot submit feedback. Selected program is null.");
            Assert.fail("Cannot submit feedback for null program");
        }
    }

    @Then("the system submits the feedback for the program {string}")
    public void theSystemSubmitsTheFeedbackForTheProgram(String programName) {
        if (selectedProgram != null) {
            feedbackList = feedbackService.getFeedbacksForProgram(selectedProgram);
            Assert.assertNotNull("Feedback list should not be null", feedbackList);
            Assert.assertFalse("Feedback list should not be empty", feedbackList.isEmpty());
            System.out.println("Feedback successfully submitted for program: " + programName);
        } else {
            System.out.println("Error: Selected program is null. Feedback submission failed.");
        }
    }

    @And("the client has submitted feedback for the program")
    public void theClientHasSubmittedFeedbackForTheProgram() {
        Assert.assertNotNull("Client should have submitted feedback", feedbackService);
    }

    @When("the client requests to view the feedback for {string}")
    public void theClientRequestsToViewTheFeedbackFor(String programName) {
        if (selectedProgram != null) {
            feedbackList = feedbackService.getFeedbacksForProgram(selectedProgram);
            System.out.println("Client requests to view feedback for program: " + programName);
        } else {
            System.out.println("Error: Program " + programName + " is null.");
        }
    }

    @Then("the system displays the feedback for {string}")
    public void theSystemDisplaysTheFeedbackFor(String programName) {
        if (selectedProgram != null) {
            feedbackList = feedbackService.getFeedbacksForProgram(selectedProgram);


            if (feedbackList != null && !feedbackList.isEmpty()) {
                System.out.println("Feedbacks found for program: " + selectedProgram.getName());
                for (Feedback feedback : feedbackList) {
                    System.out.println("Feedback: " + feedback.getReview());
                }
            } else {
                System.out.println("Error: No feedback found for program: " + selectedProgram.getName());
            }
        } else {
            System.out.println("Error: Program " + programName + " is null.");
        }
    }


    @When("the client rates the program {int} and writes a review {string} without improvement suggestions")
    public void theClientRatesTheProgramAndWritesAReviewWithoutImprovementSuggestions(int rating, String review) {
        if (selectedProgram != null) {
            if (rating < 1 || rating > 5) {
                System.out.println("Error: Rating must be between 1 and 5.");
                Assert.fail("Invalid rating");
            }
            if (review == null || review.trim().isEmpty()) {
                System.out.println("Error: Review cannot be empty.");
                Assert.fail("Review cannot be empty");
            }
            feedbackService.submitFeedback(new Feedback(selectedProgram, rating, review, ""));
            System.out.println("Feedback submitted with rating: " + rating + " and review: " + review);
        } else {
            System.out.println("Cannot submit feedback. Selected program is null.");
        }
    }

    @Then("the system should display an error message for {string}")
    public void theSystemShouldDisplayAnErrorMessageFor(String programName) {
        System.out.println("Error message for program: " + programName);
    }
}
