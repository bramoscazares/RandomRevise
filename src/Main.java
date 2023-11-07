import MVC.Controller;
import MVC.Display;
import MVC.System;

public class Main {

    public static void main(String[] args) {
        System.out.println();

        System system = new System();
        Display display = new Display();
        Controller controller = new Controller(system,display);

    }
}