package src.admin;

import java.io.IOException;
import java.util.Scanner;
import src.clr.Cls;
import src.mainUI.Control;
import src.time.Waiting;

public class AdminLogin extends Control {
    Scanner sc;
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
        
        System.out.print("Enter the ID : ");
        String adusername = sc.next();
        System.out.print("Enter Password : ");
        String adpass = sc.next();
        login.log(adusername,adpass);
    }
}