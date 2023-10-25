import java.io.File;
import java.io.IOException;

public class FileManager {
    public void makeFiles(){

        try{
            File dataStore = new File("Book.txt");
            if (dataStore.createNewFile()) {
                System.out.println("No previous database found. Creating a new one.");
            } else {
                System.out.println("Loading previous database...");
            }
        } catch (IOException e) {
            System.out.println("Something went terribly wrong");
        }
        try{
            File dataStore = new File("users.txt");
            if (dataStore.createNewFile()) {
                System.out.println("No previous user database found. Creating a new one.");
            } else {
                System.out.println("Loading previous user database...");
            }
        } catch (IOException e) {
            System.out.println("Something went terribly wrong");
        }


    }
}
