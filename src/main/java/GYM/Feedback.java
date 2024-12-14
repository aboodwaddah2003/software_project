package GYM;

public class Feedback {
    private Program program;
    private int rating;
    private String review;
    private String improvementSuggestions;

    public Feedback(Program program, int rating, String review, String improvementSuggestions) {
        this.program = program;
        this.rating = rating;
        this.review = review;
        this.improvementSuggestions = improvementSuggestions;
    }

    public Program getProgram() {
        return program;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public String getImprovementSuggestions() {
        return improvementSuggestions;
    }
}
