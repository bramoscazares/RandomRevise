import MVC.Controller;
import MVC.Course;
import MVC.Display;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static File topic = new File("SystemsAnaylsisAndDesign.txt");
    public static File directory = new File("CourseDirectory");
    public static File testFile = new File("CourseDirectory/SystemsAnaylsisAndDesign.txt");

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();

        //VERSION 0.3 --------------------------------------
        Display display = new Display();
        Controller controller = new Controller(display);

        controller.addDirectory(directory);

//        Course test = new Course(testFile);
//        display.printCouseInfo(test);


        controller.start();

    }
}