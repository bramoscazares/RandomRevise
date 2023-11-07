package MVC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    //CONTROLLER CLASS

    protected ArrayList<File> courses = new ArrayList<>();
    protected Display display;
    protected System system;
    protected Scanner userInput = new Scanner(System.in);

    public Controller(System system, Display display) {
        this.display = display;
        this.system = system;
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
        } else {
            System.out.println("The specified path is not a directory or doesn't exist.");
        }
    }










}
