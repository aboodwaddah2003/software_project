package GYM;

import java.util.ArrayList;

public class ContentMangerService {
    public static ArrayList<ContentManger>contentMangers=new ArrayList<ContentManger>();



   public void ContentMangerServiceFill()
   {
       ContentManger contentManager1 = new ContentManger("10 Healthy Recipes", "John Doe", "pending", "12/10/2024");
       contentManager1.setContent("You should eat egg and don't eat meat.");


       ContentManger contentManager2 = new ContentManger("Fitness Tips", "Jane Smith", "pending", "12/12/2024");
       contentManager2.setContent("Morning walks and stretching help you stay active.");


       ContentManger contentManager3 = new ContentManger("Meditation Benefits", "Alice Johnson", "pending", "12/15/2024");
       contentManager3.setContent("Meditation reduces stress and improves mental clarity.");


       ContentManger contentManager4 = new ContentManger("Healthy Breakfast Ideas", "Michael Brown", "pending", "12/18/2024");
       contentManager4.setContent("Include fruits, oats, and nuts in your breakfast for energy.");

       ContentManger contentManager5 = new ContentManger("Strength Training Basics", "Sarah Wilson", "pending", "12/20/2024");
       contentManager5.setContent("Strength training improves muscle health and boosts metabolism.");

       contentMangers.add(contentManager1);
       contentMangers.add(contentManager2);
       contentMangers.add(contentManager3);
       contentMangers.add(contentManager4);
       contentMangers.add(contentManager5);

   }
    public static void addContent()
    {
        if(User.currentUser.getType().equals("Instructor") )
        {
           for(ContentManger contentManger : contentMangers)
            if(contentManger.getStatus().equals("approve"))
              contentMangers.add(contentManger);
        }
    }

public void showAllContent()
{
    for(ContentManger contentManger : contentMangers)
        System.out.println(contentManger);
}

public void showApprovedContent()
{
  for(  ContentManger contentManger : contentMangers)
  {
      if (contentManger.getStatus().equals("approve"))
          System.out.println(contentManger);
  }
}

    public void showRejectedContent()
    {
        for(  ContentManger contentManger : contentMangers)
        {
            if (contentManger.getStatus().equals("rejected"))
                System.out.println(contentManger);
        }
    }

}
