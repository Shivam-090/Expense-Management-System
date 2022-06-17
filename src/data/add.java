package src.data;

import java.util.*;
import java.io.*;
import src.clr.*;

public class add {
    public void addData(String username){
        try {
            Cls cls = new Cls();
            cls.screen(); // calling the screen function to clear the screen of cmd
        } catch (Exception e) {
            System.out.println(e);
        }
        String amount;
        String item;
        Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t\t\t-------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t|                                                     |");
		System.out.println("\t\t\t\t\t\t|         DAILY EXPENSE MANAGEMENT SYSTEM             |");
		System.out.println("\t\t\t\t\t\t|                                                     |");
		System.out.println("\t\t\t\t\t\t-------------------------------------------------------");
        System.out.println("Enter the cost of the item is : ");
        amount = sc.nextLine();
        System.out.println("\nEnter the name of item : ");
        item = sc.nextLine();
        try {
            int amount1 = Integer.parseInt(amount);
            if (amount1 < 0) {
                throw new Exception("Positive number required ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File f1 = new File("C:\\Users\\HP\\Desktop\\Project\\text_files\\users\\" + username + "/daily.txt");
            FileWriter fw = new FileWriter(f1, true);
            fw.append(amount + "," + item + "\n");
            fw.close();
            System.out.println("\n Data Added.............");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}