package MVC;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class System {
    // MODEL CLASS

    protected HashMap<String, ArrayList<String>> topics = new HashMap<>();


    public void setUpCourse(File file) throws FileNotFoundException {
        Scanner fileIN = new Scanner(file);

        while (fileIN.hasNext()){
            String[] line = fileIN.nextLine().split("=");
            String key = line[0];
            ArrayList<String> values = new ArrayList<>(Arrays.asList(line[1].split(",")));

            topics.put(key,values);
        }

    }








}
