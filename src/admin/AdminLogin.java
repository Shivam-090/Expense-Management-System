package src.admin;

import java.io.*;
import java.util.Scanner;
import src.clr.*;
import src.mainUI.*;
import src.time.*;

public class AdminLogin extends Control {
    public Scanner sc;
    public AdminLogin(Scanner sc){
        this.sc = sc;
    }
    public void login() throws IOException {
        Cls cls = new Cls();
        Waiting waiting = new Waiting();
        loginf login = new loginf();
        try {
            cls.screen(); // calling the screen function to clear the screen of cmd
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n\n\n\n\n\n\n");
        waiting.load(); // calling the method load() to print the loading message

        try {
            cls.screen();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("\n\n\n\n\n\n\t\t\t\t\t\t\t-------------------------------------");
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t|           ADMIN PORTAL            |");
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t-------------------------------------\n\n\n");
        Console console = System.console();
        String adusername;
        System.out.print("Enter the ID : ");
        adusername = sc.next();
        System.out.print("Enter Password : ");
        char[] adminpass = console.readPassword();
        String adpass = String.valueOf(adminpass);
        login.log(adusername,adpass);
    }
}