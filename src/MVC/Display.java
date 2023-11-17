package MVC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Display {
    // VIEW CLASS


    public void RandomReviveIntro() {
        System.out.println("Welcome to RandomRevive!\n\nDeveloped by Brian Ramos Cazares\nVersion 0.3");
        printSeperator();
    }

    public void inputPropmt(){
        System.out.println("What would you like to do?\n");
    }

    public void mainMenu(){
        System.out.println("[1] View the main courses in your directory.");
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
