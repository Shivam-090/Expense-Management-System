package src.admin; // Initializing package name

// importing required packages
import java.io.*;
import java.util.Scanner;
import src.clr.*;
import src.mainUI.*;
import src.time.*;

public class AdminLogin extends Control {
    public Scanner sc; // Initialize scanner object
    public AdminLogin(Scanner sc){ // calling default constructor for object.
        this.sc = sc;
    }
    public void login() throws IOException {
        Cls cls = new Cls(); // importing cls file for screen function
        Waiting waiting = new Waiting(); // waiting file for loading page
        loginf login = new loginf(); // login file for admin login page
        try {
            cls.screen(); // calling the screen function to clear the screen of terminal
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n\n\n\n\n\n\n");
        waiting.load(); // calling the method load() to print the loading message

        try {
            cls.screen(); // calling the screen function to clear the screen of terminal
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("\n\n\n\n\n\n\t\t\t\t\t\t\t-------------------------------------"); // Admin Menu
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t|           ADMIN PORTAL            |");
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t-------------------------------------\n\n\n");
        Console console = System.console(); // Creating console object
        String adusername; // Initializing variable for admin username
        System.out.print("Enter the ID : ");
        adusername = sc.next();
        System.out.print("Enter Password : ");
        char[] adminpass = console.readPassword();
        String adpass = String.valueOf(adminpass); // Initializing variable for admin password
        login.log(adusername,adpass); // Passing values of username and password to method.
    }
}