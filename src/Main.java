import MVC.Controller;
import MVC.Course;
import MVC.Display;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    //Input Directory
    public static File directory = new File("CourseDirectory");



    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();

        //VERSION 0.4 --------------------------------------
        Display display = new Display();
        Controller controller = new Controller(display);

        controller.addDirectory(directory);


        controller.start();

    }
}