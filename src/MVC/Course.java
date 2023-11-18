package MVC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Course {

    protected String courseName;
    protected HashMap<String, ArrayList<String>> topics = new HashMap<>();
    protected Random random = new Random();

    public Course(File file) throws FileNotFoundException {
        setUpCourse(file);
    }


    //GETTERS + SETTERS ------------------------------------------------------
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public HashMap<String, ArrayList<String>> getTopics() {
        return topics;
    }

    public void setTopics(HashMap<String, ArrayList<String>> topics) {
        this.topics = topics;
    }

    public Set<String> getChapters() {
        return topics.keySet();
    }

    public ArrayList<String> getChapterContents(String key){
        return topics.get(key);
    }


    //COURSE METHODS ------------------------------------------------------
    public void setUpCourse(File file) throws FileNotFoundException {
        Scanner fileIN = new Scanner(file);
        this.courseName = fileIN.nextLine();

        while (fileIN.hasNext()){
            String[] line = fileIN.nextLine().split("=");
            String key = line[0];
            ArrayList<String> values = new ArrayList<>(Arrays.asList(line[1].split(",")));

            topics.put(key,values);
        }

    }
    public String getChapter() {
        //This grabs a random Chapter from this course.

        ArrayList<String> keys = new ArrayList<>(topics.keySet());
        return keys.get(random.nextInt(keys.size()));
    }

    public LinkedHashSet<String> randomTopics(ArrayList<String> strings, int amount) {
        //This will return a list of items

        if (amount >= strings.size()){
            amount = strings.size();
        }

        LinkedHashSet<String> topics = new LinkedHashSet<>();
        while(topics.size() < amount){
            topics.add(strings.get(random.nextInt(strings.size())));
        }
        return topics;
    }
}
