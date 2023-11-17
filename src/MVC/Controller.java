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

    protected boolean continueApp = true;

    public Controller(Display display) {
        this.display = display;
    }

    //APP START ======================================================================================
    public void start(){
        display.RandomReviveIntro();


        while (continueApp){
            display.inputPropmt();
            String input = userInput.nextLine();
            processCommand(input);
            System.out.println();
            display.printSeperator();

        }


    }

    // FILE SETUP======================================================================================
    public void addFile(File file){this.courses.add(file);}

    public void addDirectory(File folder) throws FileNotFoundException {
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    addFile(file);
                    courseList.add(new Course(file));
                }
            }
        }
    }

    //GETTERS SETTERS ======================================================================================
    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    //CONTROLLER METHODS ======================================================================================
    public void processCommand(String input){
        if (input.equals("quit")){
            continueApp = false;
        } else if(input.equals("all")){
            display.printDirectory(courseList);
        }else {
            display.invalidInput();
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
