package src.admin; // Initializing package name

// importing required packages
import src.clr.*;
import src.data.*;
import java.util.*;
import java.io.*;
import src.time.*;

public class loginf {
    public void log(String adusername, String adpass ) { // Using method to use values
        try {

            File ob = new File("C:\\Users\\HP\\Desktop\\Project\\src\\admin\\AdminCredentials.txt"); // Initializing file object with pathname
            FileReader fin = new FileReader(ob); // Attaching file to file reader
            BufferedReader bin = new BufferedReader(fin); // Attaching file reader to buffered reader
            
            // Initializing string
            String str = null; 
            String tempuser, temppass;
            boolean found = false;
            while ((str = bin.readLine()) != null) { // read from FileReader till the end of file
                String[] account = str.split(",");

                // comparing username and password from AdminCredentials.txt file
                tempuser = account[0]; 
                temppass = account[1];
                if (tempuser.equals(adusername) && temppass.equals(adpass)) { // comparing username and password from users input for admin access
                    found = true;
                }
            }
            if (found == true) {
                AdminAccess(); // Admin Menu function 
            }
            bin.close(); // Closing file
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void AdminAccess(){ // Admin Access
        Cls cls = new Cls();
        Waiting waiting = new Waiting();
        try {
            cls.screen(); // calling the screen function to clear the screen of cmd
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n\n\n\n\n\n\n");
        waiting.load(); // calling the method load() to print the loading message
        show sh = new show(); // Creating object to display all users
        try {
            cls.screen();
        } catch (Exception e) {
            System.out.println(e);
        }
        char cont;
        do {
            boolean exist = false;
            try{
                FileReader fr = new FileReader("text_files/data.txt"); // open all the list of users
                BufferedReader br = new BufferedReader(fr);
                System.out.println("\t\t\t\t\t\t-------------------ADMIN LOGIN------------------------");
                System.out.println("\t\t\t\t\t\t-------------------------------------------------------");
                System.out.println("\t\t\t\t\t\t|                                                     |");
                System.out.println("\t\t\t\t\t\t|                                                     |");
                System.out.println("\t\t\t\t\t\t|         WELCOME TO EXPENSE MANAGEMENT PORTAL        |");
                System.out.println("\t\t\t\t\t\t|                                                     |");
                System.out.println("\t\t\t\t\t\t|                                                     |");
                System.out.println("\t\t\t\t\t\t-------------------------------------------------------");
                System.out.println("\nList of users: "); // print the list of all users
                br.readLine();
                br.readLine();
                String line;
                int i = 1;
                while ((line = br.readLine()) != null){//prints usernames of all the users
                    String[] dataLine = line.split(",");
                    System.out.println(i +". "+ dataLine[0]);
                    i++;
                }
                fr.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            String select;
            System.out.print("\nEnter a username to view their transaction history: ");
            Scanner sc = new Scanner(System.in);
            select = sc.next(); //asks for the username from admin that they want to see details.
            try {
                FileReader fr = new FileReader("text_files/data.txt"); // Initializing file object with pathname
                BufferedReader br = new BufferedReader(fr); // Attaching with buffered reader
                br.readLine();
                String line;
                while ((line = br.readLine()) != null) { // read from FileReader till the end of file
                    String[] dataline = line.split(",");
                    if (dataline[0].equals(select)) {
                        exist = true;
                        break;
                    }
                    else
                    exist = false;
                }
                if(exist){
                    cls.screen();
                    sh.showData(select); // calling showdata() function to display list.
                }
                else
                System.out.println("Wrong Username");
                br.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("do you wish to continue press y");
            cont = sc.next().charAt(0);
        }while(cont=='y'||cont=='Y');
    }
}