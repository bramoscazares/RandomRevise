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
    public void start() throws FileNotFoundException {
        display.RandomReviveIntro();

        display.mainMenu();
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
    public void processCommand(String input) throws FileNotFoundException {
        //This method processes user input and takes it to the corresponding command


        if (input.equals("quit")){
            quit();
        } else if(input.equals("next")|| input.isEmpty()){
            //User selects a course and how many random chapters to generate

            selectCourse();
        } else if(input.equals("view")){

            display.printDirectory(courseList);
        } else if(input.equals("random")){
            //User gets a full random study guide of all courses in directory
            //Prompt user for amount

            fullStudyGuide(getInt());
        } else if(input.equals("menu")){
            display.mainMenu();
        } else {
            display.invalidInput();
        }
    }

    private void quit() {
        this.continueApp = false;
    }

    private void selectCourse() throws FileNotFoundException {
        display.selectCourse(courseList);
        int courseInt;

        do {
            while (!userInput.hasNextLine()) {
                display.invalidInput();
                userInput.next(); // Consume the invalid input
            }
            courseInt = Integer.parseInt(userInput.nextLine());
        } while (courseInt < 0 || courseInt >= courseList.size());

        setCourse(courseList.get(courseInt));
        display.selectedCourse(this.course);

        generateTopics(this.course,getInt());
        quit();
    }

    private void fullStudyGuide(int anInt) throws FileNotFoundException {
        for(Course c : courseList){
            generateTopics(c,anInt);
        }
        quit();
    }

    private int getInt() {
        System.out.println("Enter an integer amount: ");
        while (true){
            try {
                int anInt = Integer.parseInt(userInput.nextLine());
                return anInt;
            } catch (Exception e){
                display.invalidInput();
            }
        }
    }


    public void generateTopics(Course course, int amount) throws FileNotFoundException {
        display.printCouseHeader(course);
        String key = course.getChapter();
        LinkedHashSet<String> topics = course.randomTopics(course.topics.get(key),amount);
        display.printGeneratedGuide(key,topics);
    }

    private void test() throws FileNotFoundException {
        //Method to test Stuff
    }



}
