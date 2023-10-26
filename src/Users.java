import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Users {
    String fullName;

    String pwd;

    boolean hasBook;

    String nameOfBookOwned;

    String role;

    public Users(String fullName) {
        this.fullName = fullName;
        this.pwd = createPassword();
        this.hasBook = hasBook;
        this.nameOfBookOwned = "";
        this.role = "Guest";
        if (firstCheck(fullName) == true) {
            writeUsersDatabase();
        }
    }

    public Users(String fullName, String pwd) {
        this.fullName = fullName;
        this.pwd = pwd;
        this.hasBook = hasBook;
        this.nameOfBookOwned = "";
        this.role = "Guest";
    }

    public Users() {
        this.fullName = "admin";
        this.pwd = "admin111";
        this.role = "Admin";
        writeUsersDatabase();
    }

    public void changeHasBook() {
        if (hasBook == false) {
            hasBook = true;
        } else {
            hasBook = false;
        }
    }

    private String createPassword() {
        String pwd = "";
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            int password = rnd.nextInt(9);
            pwd = pwd + String.valueOf(password);
        }
        return pwd;
    }


    private void setRole() {
        if(fullName == "admin"){
        System.out.println("ARE YOU ABSOLUTELY 100% SURE YOU WANNA DO THIS?\n(y/n)");
        Scanner input = new Scanner(System.in);
        String userInput = input.next();
        switch (userInput) {
            case "y":
                if (this.role == "Admin") {
                    this.role = "Guest";
                } else {
                    this.role = "Admin";
                }
                break;
            case "n":
                System.out.println("Good.");
                break;
            default:
                System.out.println("Invalid option");
                break;
            }
        }
        else {
            System.out.println("Naughty Naughty");
        }
    }

    private void writeUsersDatabase() {

        if(this.fullName.equals("admin")){
            return;
        }
        else {
            try {
                BufferedWriter fw = new BufferedWriter(new FileWriter("users.txt", true));
                File obj = new File("users.txt");
                Scanner reader = new Scanner(obj);
                fw.write(this.fullName + "/" + this.pwd);
                fw.newLine();
                System.out.println("Success! You're now allowed to use the library");
                fw.close();
                System.out.println("Your new ID Number is: " + pwd + "\n!!!!!!!!!!!!!!!!!!Don't lose it!!!!!!!!!!!!!!!!!!");
            } catch (IOException e) {
                System.out.println("Error creating the user login details.");
            }
        }
    }

    public boolean firstCheck(String fullName) {
        Scanner input = new Scanner(System.in);
        if (fullName.equals("admin")) {
            System.out.println("TskTskTsk. You're not an admin you pesky roach");
            return false;
        } else {
            try {
                File obj = new File("users.txt");
                Scanner reader = new Scanner(obj);
                while (reader.hasNextLine()) {
                    if (reader.nextLine().contains(fullName)) {
                        System.out.println("User already exists. Please use the login page by pressing 'n' on the first page.");
                        reader.close();
                        return false;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("oh no");
            }

        }
        return true;
    }

    public boolean getAuth(String userName, String pwd) {
        try {
            File obj = new File("users.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String userDetails = reader.nextLine();
                if (userDetails.contains(userName)) {
                    if (userDetails.substring(userDetails.indexOf("/") + 1).equals(pwd)) {
                        System.out.println("Welcome back " + userName + "!");
                        reader.close();
                        return true;
                    } else {
                        System.out.println("Wrong ID. Access denied.");
                        reader.close();
                        return false;
                    }
                }
            }
            System.out.println("You're not in the database, try registering");

        } catch (FileNotFoundException e) {
            System.out.println("Come on. Don't be trynna get into other peoples accounts");
        }
        return false;
    }


}
