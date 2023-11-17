import MVC.Controller;
import MVC.Course;
import MVC.Display;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static File topic = new File("SystemsAnaylsisAndDesign.txt");
    public static File testFile = new File("CourseDirectory/SystemsAnaylsisAndDesign.txt");

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();

        //VERSION 1 --------------------------------------
//        Course course = new Course();
        Display display = new Display();
//        Controller controller = new Controller(course,display);

//        controller.addFile(topic);
//        controller.generateTopics();

        Course test = new Course(testFile);
        display.printCouseInfo(test);

    }
}