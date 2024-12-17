package GYM;

import java.util.ArrayList;

public class ContentMangerService {
    public static ArrayList<ContentManger>contentMangers=new ArrayList<ContentManger>();



   public ContentMangerService()
   {


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
