package src.data;

import java.util.*;
import java.io.*;
import src.clr.*;

public class delete {

    public void deleteData(String username) {
        try {
            Cls cls = new Cls();
            cls.screen(); // calling the screen function to clear the screen of cmd
        } catch (Exception e) {
            System.out.println(e);
        }
        show sh = new show();
        File temp = new File("text_files/users/" + username + "/temp.txt");// we copy every line of the user file into this file
        File old = new File("text_files/users/" + username + "/daily.txt");// this is the original file for the user
        int n, count = 0;
        Scanner sc = new Scanner(System.in);
        try {
            FileReader fr = new FileReader(old);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(temp, true);
            String s;

            while ((s = br.readLine()) != null) {// here we are copying every single line of our original file to this
                                                 // temporary file
                count++;// count is used in this so that the user doesn't enter any number that is not
                        // in the file
                fw.write(s + "\n");
                fw.flush();
            }
            fr.close();
            br.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sh.showData(username); // here we show the original file and ask the user which item they want to edit or update
        System.out.print("\nEnter the item number you want to delete: ");
        do {
            n = sc.nextInt();
            if (n == 0 || n > count) {

                System.out.print(count + "\nERROR! \nEnter a valid item number you want to delete: ");
                // until the user enters a number in range this will show this error
            }
        } while (n == 0 || n > count);
        try {
            FileReader fr = new FileReader(temp);
            BufferedReader br = new BufferedReader(fr); // here we are copying all the line back to the original file
            FileWriter fw = new FileWriter(old, false);// and won't be copying the item the user wants to delete
            String s;
            int i = 0;
            while ((s = br.readLine()) != null) {
                if (i == n) {
                    i++;
                } else {
                    i++;
                    fw.write(s + "\n");
                    fw.flush();
                }
            }
            fr.close();
            br.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        temp.delete();//at the end the temporary file will be deleted
    }
    
}
