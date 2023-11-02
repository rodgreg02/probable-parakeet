import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    String currentUser;
    boolean hasBook;

    public Library(String currentUser, boolean hasBook) {
        this.currentUser = currentUser;
        this.hasBook = hasBook;
    }


    public void displayBooks() {
        try {
            File obj = new File("books.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String currentLine = reader.nextLine();
                System.out.println(currentLine);
            }
            reader.close();
        } catch (IOException o) {
            System.out.println("FOR THE MOTHER OF GOD");
        }
    }

    public boolean requestBook(String bookRequested) {
        try {
            File obj = new File("usrbook.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String currentLine = reader.nextLine();
                if (currentLine.contains(bookRequested) || currentLine.contains(this.currentUser)) {
                    System.out.println("Sorry, you can't have that");
                    return false;
                }
            }
        }
    catch(IOException e){
        System.out.println("OH GOD IT HURTS");
    }
return true;
}


    public void markTaken(String bookName, String userName) {
        try {
            File obj = new File("Books.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String currentLine = reader.nextLine();
                if (currentLine.contains(bookName)) {
                    BufferedWriter fw = new BufferedWriter(new FileWriter("usrbook.txt", true));
                    fw.newLine();
                    fw.write(currentLine + "|" + userName);
                    System.out.println("Congrats, you now have " + bookName);
                    fw.close();
                    break;
                }

            }
            reader.close();
        } catch (IOException o) {
            System.out.println("FOR THE MOTHER OF GOD");
        }
    }


    public void markReturned() {
        try {
            File obj = new File("usrbook.txt");
            Scanner reader = new Scanner(obj);
            List<String> linesToKeep = new ArrayList<>();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.contains(this.currentUser)) {
                    linesToKeep.add(line);
                }
            }

            try (BufferedWriter fw = new BufferedWriter(new FileWriter("usrbook.txt"))) {
                for (String line : linesToKeep) {
                    fw.write(line);
                    fw.newLine();
                }
            }

        } catch (IOException e) {
            System.err.println("Whoops");
        }
    }

    public void displayUsrBookAdmin() {
        try {
            File obj = new File("usrbook.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String currentLine = reader.nextLine();
                System.out.println(currentLine);
            }
            reader.close();
        } catch (IOException o) {
            System.out.println("FOR THE MOTHER OF GOD");
        }
    }

    public void displayUsrBook() {
        try {
            File obj = new File("usrbook.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String currentLine = reader.nextLine();

                int pipeIndex = currentLine.indexOf("|");

                if (pipeIndex != -1) {
                    String substring = currentLine.substring(pipeIndex);
                    System.out.println(currentLine.replace(substring, "Taken"));
                } else {
                    System.out.println("");
                }
            }
            reader.close();
        } catch (IOException o) {
            System.out.println("FOR THE MOTHER OF GOD");
        }
    }
}
