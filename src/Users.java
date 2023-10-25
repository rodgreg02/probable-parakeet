import java.io.BufferedWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Users {

    String fullName;

    String pwd;

    boolean hasBookAlready;

    String nameOfBookOwned;

    private String role;

    public Users(String fullName) {
        this.fullName = fullName;
        this.pwd = createPassword();
        this.hasBookAlready = false;
        this.nameOfBookOwned = "";
        this.role = "Guest";
        writeUsersDatabase();
    }

    public void changeHasBook() {
        if (hasBookAlready == false) {
            hasBookAlready = true;
        } else {
            hasBookAlready = false;
        }
    }

    public String createPassword() {
        String pwd ="";
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            int password = rnd.nextInt(10);
            pwd = pwd + String.valueOf(password);
        }
        return pwd;
    }



    private void setRole(){
        System.out.println("ARE YOU ABSOLUTELY 100% SURE YOU WANNA DO THIS?\n(y/n)");
        Scanner input = new Scanner(System.in);
        String userInput = input.next();
        switch (userInput){
            case "y":
                if(this.role == "Admin"){
                    this.role = "Guest";
                }else{
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

    private void writeUsersDatabase(){
        try{
            BufferedWriter fw = new BufferedWriter(new FileWriter("users.txt", true));
            fw.write(  this.fullName + "/" + this.pwd );
            System.out.println("Success! You're now allowed to use the library");
            fw.newLine();
            fw.close();
        }
        catch(Exception e){
            System.out.println("Error creating the user login details.");
        }
    }

}
