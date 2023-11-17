package MVC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Controller {
    //CONTROLLER CLASS

    protected ArrayList<File> courses = new ArrayList<>();
    protected ArrayList<Course> courseList = new ArrayList<>();
    protected Display display;
    protected Course course;
    protected Scanner userInput = new Scanner(System.in);

    public Controller(Course course, Display display) {
        this.display = display;
        this.course = course;
    }

    // FILE SETUP======================================================================================
    public void addFile(File file){this.courses.add(file);}

    public void addDirectory(File folder){
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    addFile(file);
                }
            }
        }
    }

    public void generateTopics() throws FileNotFoundException {
        test();
        System.out.println("Good morning!\nThese are the topics you will be handling today");
        String key = course.getChapter();
        System.out.println("\n"+key+"\n--------------------------------------");
        LinkedHashSet<String> topics = course.randomTopics(course.topics.get(key),3);
        for (String i: topics){
            System.out.println(i);
        }
    }

    private void test() throws FileNotFoundException {
        course.setUpCourse(courses.get(0));
    }



}
