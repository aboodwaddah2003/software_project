package GYM;

public interface FeedbackSubmissionService {
    static void submitComplaint(Client client, String details)
    {
        FeedbackService.submitComplaint(client,details);
    }


}
