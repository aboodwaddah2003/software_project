package GYM;

import javax.swing.text.AbstractDocument.Content;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ContentManger  {

    public ContentManger(String Title,String Author,String Status,String SubmissionDate)
    {
        this.Title=Title;
        this.Author=Author;
        this.Status=Status;
        this.SubmissionDate=SubmissionDate;


    }
    public String getTitle() {
        return Title;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


    public void setContent(String content) {
        Content = content;
    }

    private  String Title;
    private String Author;
    private String Status;
    private String SubmissionDate;

    private  String  Content;




    @Override
    public String toString() {
        return "ContentManager {" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Status='" + Status + '\'' +
                ", SubmissionDate='" + SubmissionDate + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }


}


