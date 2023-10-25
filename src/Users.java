import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Users {
    String fullName;

    String pwd;

    boolean hasBookAlready;

    String nameOfBookOwned;

    private String role;

    public Users(String fullName) {
        this.fullName = fullName;
        this.pwd = createPassword();
        this.hasBookAlready = hasBookAlready;
        this.nameOfBookOwned = "";
        this.role = "Guest";
        firstCheck(fullName);
        writeUsersDatabase();
    }

    public Users() {
        this.fullName = "admin";
        this.pwd = "admin111";
        this.role = "Admin";
        writeUsersDatabase();
    }

    public void changeHasBook() {
        if (hasBookAlready == false) {
            hasBookAlready = true;
        } else {
            hasBookAlready = false;
        }
    }

    private String createPassword() {
        String pwd = "";
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            int password = rnd.nextInt(10);
            pwd = pwd + String.valueOf(password);
        }
        return pwd;
    }


    private void setRole() {
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

    private void writeUsersDatabase() {

        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("users.txt", true));
            File obj = new File("users.txt");
            Scanner reader = new Scanner(obj);
            if (fullName != "admin") {
                fw.write(this.fullName + "/" + this.pwd);
                fw.newLine();
                System.out.println("Success! You're now allowed to use the library");
                fw.close();
            } else {
                System.out.println("Oy you scoundrel! You don't belong there!");
            }
        } catch (IOException e) {
            System.out.println("Error creating the user login details.");
        }
    }

    public void firstCheck(String fullName) {
        Scanner input = new Scanner(System.in);
        if (fullName == "admin") {
            System.out.println("TskTskTsk. You're not an admin you pesky roach");
            return;
        } else {
            try {
                File obj = new File("users.txt");
                Scanner reader = new Scanner(obj);
                while (reader.hasNextLine()) {
                    if (reader.nextLine().contains(fullName)) {
                        System.out.println("User already exists. Please use the login page by pressing 'n' on the first page.");
                        return;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("oh no");
            }

        }
    }

}
