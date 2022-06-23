package src.user; // Initializing package

// Importing other packages
import java.io.File;
import java.io.*;

public class create {
    public boolean fcreate(String uname){ // Function to create new folder (User)
        String path = "C:\\Users\\HP\\Desktop\\Project\\text_files\\users\\";
        try {
            File dir = new File(path + uname);
            dir.mkdirs(); // main function to create file
            File fi = new File(dir, "daily.txt"); // Name of child file of parent folder
            FileWriter f1 = new FileWriter(fi, true);
            f1.write("Expense Amount" + "," + "Item" + "\n"); // Default Text of the file
            f1.close(); // Closing file
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
