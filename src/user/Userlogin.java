package src.user;
import src.mainUI.*;
import src.clr.*;

import java.util.*;

import javax.swing.text.PlainDocument;

import java.io.*;
import src.time.*;
import src.user.*;
import src.admin.*;

public class Userlogin extends Control {
    Scanner sc;
    public Userlogin(Scanner sc){
        this.sc = sc;
    }
    public void login() {
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
        System.out.println("\t\t\t\t\t\t\t|            USER PORTAL            |");
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t|                                   |");
        System.out.println("\t\t\t\t\t\t\t-------------------------------------\n\n\n");

        System.out.println("Press 1, if you are existing user.\n Press 2, if you want to add new account.\n\n");
        int u = sc.nextInt();
        switch (u) {
            case 1:
                System.out.println("\n\n\nEnter Your Existing Username : ");
                String username = sc.next();
                System.out.println("Enter Your Existing Password : ");
                String password = sc.next();
                verifyUser(username, password);
                break;
            case 2:
                System.out.println("\n\n\nEnter Your New Username : ");
                String uname = sc.next();
                System.out.println("Enter Your New Password : ");
                String upass = sc.next();
                createUser(uname,upass);
            default:
                System.out.println("Wrong Entry Try Again");
                try {
                    cls.screen();
                    login();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
        }
    }

    public void createUser(String uname, String upass) {
        
    }

    public void verifyUser(String username, String password){

    }
}
