package MVC;

import java.util.ArrayList;
import java.util.Set;

public class Display {

    // VIEW CLASS

    public void printCouseInfo(Course course){
        System.out.println("This is the " + course.getCourseName() + " course.\n");
        System.out.println("This course contains the following topics: ");
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        for(String key : course.getChapters()){
            System.out.println(key + ": ");
            ArrayList<String> topics = course.getChapterContents(key);
            for (String topic : topics){
                System.out.println((topics.indexOf(topic) + 1) + ") " + topic);
            }
        }


    }

}
