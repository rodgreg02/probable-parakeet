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
                String userName = input.nextLine();
                Users user = new Users(userName);
                break;
            case "n":
                System.out.println("Lovely to see you back!\nWhat was your name again?");
                userName = input.nextLine();
                System.out.println("And your library ID Number? Should be 8 digits");
                String  pwd = input.nextLine();

                Users prevUser = new Users(userName, pwd);

                boolean hasAuth = prevUser.getAuth(userName, pwd);

                if(hasAuth = true){
                    Library access = new Library(prevUser.fullName, prevUser.hasBook);
                        while (hasAuth) {
                            if(!(userName.equals("admin"))){
                                System.out.println("What do you wish to do?\n1) Get a new book\n2) Return your current book\n3) Checkout current book selection\n0) Quit");
                                String usrInput = input.nextLine();
                                switch (usrInput) {
                                    case "1":
                                        System.out.println("henlo");
                                        break;
                                    case "2":
                                        System.out.println("papaya");
                                        break;
                                    case "3":
                                        System.out.println("orange");
                                        break;
                                    case "0":
                                        System.out.println("See you some other time!");
                                        hasAuth = false;
                                        break;
                                    default:
                                        System.out.println("Invalid  choice.");
                                        break;
                            }
                        }

                        }
                }
                break;
            default:
                break;
        }
    }
}