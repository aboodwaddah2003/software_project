package GYM;

public class Instructor extends User {

    public Instructor(String userName, String email, String password, String type,String subscriptionPlan) {
        super(userName, email, password, type,subscriptionPlan);

    }

    public void addContent(String Title,String Author,String Status,String SubmissionDate,String content )
    {
        ContentManger contentManager1 = new ContentManger(Title, Author, Status, SubmissionDate);
        contentManager1.setContent(content);
     ContentMangerService.contentMangers.add(contentManager1);
    }
}
