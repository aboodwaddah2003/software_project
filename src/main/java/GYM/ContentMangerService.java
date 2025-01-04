package GYM;

import java.util.ArrayList;

public class ContentMangerService {
    public static ArrayList<ContentManger>contentMangers=new ArrayList<ContentManger>();





public static void showAllContent()
{
    for(ContentManger contentManger : contentMangers)
        System.out.println(contentManger);
}

    public static void showApprovedContent() {
        if (contentMangers != null && !contentMangers.isEmpty()) {
            boolean hasApprovedContent = false;

            for (ContentManger contentManger : contentMangers) {
                if (contentManger.getStatus().equals("approve")) {
                    System.out.println(contentManger);
                    hasApprovedContent = true;
                }
            }


            if (!hasApprovedContent) {
                System.out.println("No approved content found.");
            }
        } else {
            System.out.println("No content available.");
        }
    }


    public static void showRejectedContent() {
        if (contentMangers != null && !contentMangers.isEmpty()) {
            boolean hasRejectedContent = false;

            for (ContentManger contentManger : contentMangers) {
                if (contentManger.getStatus().equals("rejected")) {
                    System.out.println(contentManger);
                    hasRejectedContent = true;
                }
            }


            if (!hasRejectedContent) {
                System.out.println("No rejected content found.");
            }
        } else {
            System.out.println("No content available.");
        }
    }

}
