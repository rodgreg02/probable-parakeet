import java.io.*;
import java.util.Scanner;

public class Books {
    String nameOfBook;

    int yearOfRelease;

    public void writeBooksDatabase(String nameOfBook,String yearOfRelease) {
         try {
                    BufferedWriter fw = new BufferedWriter(new FileWriter("Books.txt" ));
                    File obj = new File("Books.txt");
                    Scanner reader = new Scanner(obj);
                    fw.write(nameOfBook + "/" + yearOfRelease);
                    fw.newLine();
                    System.out.println("Success! Added " + nameOfBook + " to your library");
                    fw.close();
                } catch (IOException o) {
                    System.out.println("Error adding book to library");
                }
            }
}
