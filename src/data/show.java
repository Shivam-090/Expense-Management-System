package src.data;

import java.util.*;
import src.clr.*;
import java.io.*;

public class show {

    public void showData(String username) {
        try {
            try {
                Cls cls = new Cls();
                cls.screen(); // calling the screen function to clear the screen of cmd
            } catch (Exception e) {
                System.out.println(e);
            }
            String filepath= "text_files/users/" + username + "/daily.txt";//this is the users data file that gets updated
            File file = new File("C:\\Users\\HP\\Desktop\\Project\\text_files\\users\\daily_expense.txt");//this is a common file for every user
            // we copy every thing to this file the txt file but un the format of a table so that it is presentable
            FileWriter fw = new FileWriter(file);
            double x = 0.0;
            int i=0;
            String am;
            String it;
            Scanner r = new Scanner(new File(filepath));
            System.out.println("\n\n-----------------------------------");
            System.out.println("    DAILY EXPENSES MANAGEMENT      ");
            System.out.println("-----------------------------------\n\n\n");
            fw.write("-------------------------------------------------------------------\n");

            r.useDelimiter("[,\n]");//this breaks one line of the from the txt file in diffrent parts on the basis of what comes in between
            am=r.next();
            it=r.next();
            fw.write(String.format("|  %8s|  %20s| %30s|\n","item num",am, it));
            fw.write("-------------------------------------------------------------------\n");
            //this is the part that helps us print in a tabular form
            while(r.hasNext()){
                i++;
                am=r.next();
                it=r.next();
                x = x + Double.parseDouble(am);//here we are converting a strring to double to find out the total expenditure
                fw.write(String.format("|  %8s|  %20s| %30s|\n",i ,am, it));
            }
            fw.write("-------------------------------------------------------------------\n");
            r.close();
            fw.flush();
            fw.close();
            System.out.println("\n\n\t\t\t\t\t\t total expenses = "+x+"\n\n");//this shows the total expenditure
            reader(username);
            System.out.println("\n\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reader(String select) {
        try {
            FileReader usr = new FileReader("text_files/users/daily_expense.txt");
            BufferedReader bin = new BufferedReader(usr);
            System.out.println("------------------------------------------------");
            System.out.println("    The Daily Transactions of " + select + " are:   ");
            System.out.println("------------------------------------------------\n\n");
            String sr;
            sr = bin.readLine();
            System.out.println(sr);
            while ((sr = bin.readLine()) != null) {// this loop reads the complete file and prints it on the screen
                System.out.println(sr);
            }
            bin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
