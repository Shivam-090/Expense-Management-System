package src.user;

import src.mainUI.*;
import src.validations.*;
import src.clr.*;
import src.data.*;
import java.util.*;
import java.io.*;
import src.time.*;
import src.user.*;
import src.admin.*;

public class Userlogin extends Control {
    Scanner sc;

    public Userlogin(Scanner sc) {
        this.sc = sc;
    }

    public void login() throws IOException {
        Cls cls = new Cls();
        Waiting waiting = new Waiting();
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

        System.out.println("Press 1, if you are existing user.\nPress 2, if you want to add new account.\n\n");
        int u = sc.nextInt();
        passver pc = new passver();
        namever nv = new namever();
        String uname, upass;
        switch (u) {
            case 1:
                System.out.println("Enter Your Existing Username : ");
                String username = sc.next();
                System.out.println("Enter Your Existing Password : ");
                String password = sc.next();
                verifyUser(username, password);
                break;
            case 2:
                do {
                    System.out.println("\nEnter Your New Username : ");
                    uname = sc.next();
                } while (!nv.namego(uname));
                do {
                    System.out.println("Enter Your New Password : ");
                    upass = sc.next();
                } while (!pc.passgo(upass));
                createUser(uname, upass);
                break;
            default:
                System.out.println("Wrong Entry Try Again");
                try {
                    login();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
        }
    }

    public void verifyUser(String username, String password) {
        int found = 0;
        try {
            FileReader fr = new FileReader("C:\\Users\\HP\\Desktop\\Project\\text_files\\data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    found = 1;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (found == 1) {
            System.out.println("---------------LOGGED IN----------------\n\n");
            UserChoices(username);
        } else {
            System.out.println("Verification Not Completed");
        }
    }

    public void createUser(String uname, String upass) throws IOException {
        String phoneno;
        try {
            boolean exist = false;
            numver nc = new numver();
            create cr = new create();
            do {
                System.out.println("Enter Your Phone Number :");
                phoneno = sc.next();
            } while (!nc.numgo(phoneno));
            FileReader fr = new FileReader("C:\\Users\\HP\\Desktop\\Project\\text_files\\data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataline = line.split(",");
                if (dataline[0].equals(uname)) {// here it checks whether the username has been used before or not
                    exist = false;
                    break;
                } else {
                    exist = true;
                }
            }
            fr.close();
            if (!exist) {
                System.out.println("\nUser already exists!!! Try again!! ");
            } else {
                cr.fcreate(uname);
                File fir = new File("C:\\Users\\HP\\Desktop\\Project\\text_files\\data.txt");
                FileWriter fw = new FileWriter(fir, true);
                fw.write("\n" + uname + "," + upass + "," + phoneno);
                fw.close();
            }
        } catch (Exception e) {
            System.out.println("\n\n\n\n\t\t\t-------PRESS ENTER TO CONTINUE TO LOGIN SCREEN-------------\n");
        }
        login();
    }

    public void UserChoices(String username) {
        Cls cls = new Cls();
        Waiting waiting = new Waiting();
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

        add add = new add();
        delete del = new delete();
        update up = new update();
        show sh = new show();

        int d;

        do {
            System.out.println("\n\n-----------------------------------");
            System.out.println("     DAILY EXPENSES MANAGEMENT     ");
            System.out.println("-----------------------------------\n\n");
            System.out.println(" ----------------------------------------------------");
            System.out.println("|             SELECT THE FOLLOWING OPTION            |");
            System.out.println(" ----------------------------------------------------");
            System.out.println("|                   PRESS 1 TO ADD                   |");
            System.out.println("|                   PRESS 2 TO UPDATE                |");
            System.out.println("|                   PRESS 3 TO DELETE DATA           |");
            System.out.println("|                   PRESS 4 TO SHOW YOUR DATA        |");
            System.out.println("|                   PRESS 5 TO EXIT                  |");
            System.out.println(" ----------------------------------------------------\n");
            d = sc.nextInt();

            switch (d) {
                case 1:
                    try {
                        cls.screen(); // calling the screen function to clear the screen of cmd
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    add.addData(username);
                    break;
                case 2:
                    try {
                        cls.screen(); // calling the screen function to clear the screen of cmd
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    up.updateData(username);
                    break;
                case 3:
                    try {
                        cls.screen(); // calling the screen function to clear the screen of cmd
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    del.deleteData(username);
                    break;
                case 4:
                    try {
                        cls.screen(); // calling the screen function to clear the screen of cmd
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    sh.showData(username);
                    System.out.println("------------PRESS ENTER TO CONTINUE--------------\n");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        } while (d == 1 || d == 2 || d == 3 || d == 4);

    }

}
