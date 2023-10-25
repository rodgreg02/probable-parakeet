import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        FileManager fileCreator = new FileManager();
        fileCreator.makeFiles();

        System.out.println("Hello there! Come for books have ya'? \nNew here? (y/n)");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            switch (userInput) {
                case "y":
                    System.out.println("And your name is?(choose a unique name)");
                    Users user = new Users(input.nextLine());
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


