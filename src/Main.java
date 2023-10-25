import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Users admin =new Users();

        FileManager fileCreator = new FileManager();
        fileCreator.makeFiles();

        System.out.println("Hello there! Come for books have ya'? \nNew here? (y/n)");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            switch (userInput) {
                case "y":
                    System.out.println("And what is your name? *This will be used for later login*");
                    String nameOfUser = input.nextLine();

                    try{
                    File obj = new File("users.txt");
                    Scanner reader = new Scanner(obj);
                    while(reader.hasNextLine()) {
                        if (reader.nextLine().contains(nameOfUser)) {
                            System.out.println("User already exists. Please use the login page by pressing 'n' on the first page.");
                            return;
                        }
                    }
                    }
                catch(FileNotFoundException e){
                    System.out.println("oh no");
                        }
                    Users user = new Users(nameOfUser);
                    System.out.println("Your new pasword is: " + user.pwd + "\n!!!!!!!!!!!!!!!!!!Don't lose it!!!!!!!!!!!!!!!!!!");
                    break;
                case "n":
                    break;
                default:
                    break;
            }
        }
        private int getAuth(String username, String pwd){

        return 0;
        }
    }


