package src.user;

import java.io.File;
import java.io.*;

public class create {
    public boolean fcreate(String uname){
        String path = "C:\\Users\\HP\\Desktop\\Project\\text_files\\users\\";
        try {
            File dir = new File(path + uname);
            dir.mkdirs();
            File fi = new File(dir, "daily.txt");
            FileWriter f1 = new FileWriter(fi, true);
            f1.write("Expense Amount" + "," + "Item" + "\n");
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
