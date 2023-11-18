package MVC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Display {
    // VIEW CLASS
    private String version = "0.4";


    public void RandomReviveIntro() {
        System.out.println("Welcome to RandomRevive!\n\nDeveloped by Brian Ramos Cazares\nVersion "+ version);
        printSeperator();
    }

    public void inputPropmt(){
        System.out.println("What would you like to do?\n");
    }

    public void mainMenu(){
        System.out.println("Main Menu: ");
        System.out.println("-------------------------------------");
        System.out.println("[next]   Select Course and Generate (single course).");
        System.out.println("[view]   View available courses in your directory.");
        System.out.println("[random] Generate Study Guide (all courses).");
        System.out.println("[menu]   Print main menu.");
        System.out.println("[quit]   Exit program.");
    }

    public void invalidInput(){
        System.out.println("\nWhoops! Invalid input. Try again.");
    }

    public void printCouseInfo(Course course){
        System.out.println(""+course.getCourseName());
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        for(String key : course.getChapters()){
            System.out.println("    <> "+ key + ": ");
            ArrayList<String> topics = course.getChapterContents(key);
            for (String topic : topics){
                System.out.println("    |    " + (topics.indexOf(topic) + 1) + ") " + topic);
            }
            System.out.println();
        }
    }
    public void printSeperator(){ System.out.println("------------------------------------------------------------");}


    public void printDirectory(ArrayList<Course> courseList) {
        printSeperator();
        System.out.println("This All the courses found in your directory:\n");

        for(Course i: courseList){
            printCouseInfo(i);
        }

    }
}
