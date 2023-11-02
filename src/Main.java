import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console console = System.console();
        FileManager fileCreator = new FileManager();
        fileCreator.makeFiles();
        boolean adminExists = false;
        Users admin = new Users();

        System.out.println("Hello there! Come for books have ya'? \nNew here? (y/n)");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        switch (userInput) {
            case "y":
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("And your name is?(choose a unique name)");
                String userName = input.nextLine();
                Users user = new Users(userName);
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;
            case "n":
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Lovely to see you back!\nWhat was your name again?");
                userName = input.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("And your library ID Number? Should be 8 digits");
                char[] charArray = console.readPassword("Enter your password: ");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                String pwd = new String(charArray);

                Users prevUser = new Users(userName, pwd);

                boolean hasAuth = prevUser.getAuth(userName, pwd);

                if (hasAuth == true) {
                    Library access = new Library(prevUser.fullName, prevUser.hasBook);
                    while (hasAuth) {
                        if (!(userName.equals("admin"))) {
                            System.out.println("What do you wish to do?\n1) Get a new book\n2) Return your current book\n3) Checkout current book selection and if available\n0) Quit");
                            String usrInput = input.nextLine();
                            switch (usrInput) {
                                case "1":
                                    access.displayBooks();
                                    System.out.println("Input the name of the book:");
                                    String bookRequested = input.nextLine();
                                    if (access.requestBook(bookRequested) == true) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        access.markTaken(bookRequested, prevUser.fullName);
                                    } else {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        System.out.println("Invalid selection");
                                    }
                                    break;
                                case "2":
                                        access.markReturned();
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                        System.out.println("You have returned your currently owned book! You can now request a new one.");
                                    break;
                                case "3":
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    access.displayUsrBook();
                                    break;
                                case "0":
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println("See you some other time!");
                                    hasAuth = false;
                                    break;
                                default:
                                    System.out.println("Invalid  choice.");
                                    break;
                            }
                        } else if (userName.equals("admin") && hasAuth == true) {
                            System.out.println("Wagwan Admin brah, what admin shit you up to today?\n1)Add book to library\n2)Check current list of books.\n3)Check list of patrons and books assigned\n0) Quit");
                            String usrInput = input.nextLine();
                            switch (usrInput) {
                                case "1":
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Books book = new Books();
                                    Scanner input0 = new Scanner(System.in);
                                    System.out.println("Name of book:");
                                    String nameOfBook = input0.nextLine();
                                    System.out.println("Year of release:");
                                    String yearOfRelease = input0.nextLine();
                                    book.writeBooksDatabase(nameOfBook, yearOfRelease);
                                    break;
                                case "2":
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    access.displayBooks();
                                    break;
                                case "3":
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    access.displayUsrBookAdmin();
                                    break;
                                case "0":
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println("See you some other time!");
                                    hasAuth = false;
                                    break;
                                default:
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println("Invalid  choice.");
                                    break;
                            }
                        }
                    }
                }
        }
    }
}
