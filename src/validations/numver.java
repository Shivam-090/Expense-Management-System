package src.validations; // Initailizing package

// importing packages
import src.exceptions.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class numver {
    public boolean numgo(String num) throws numchkcharec, numchkdigi, IOException { // function to check num only  
        Properties prop = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("C:\\Users\\HP\\Desktop\\Project\\configs\\constants\\exceptions.properties");
            prop.load(input);
            //this is the pattern matcher if there is anything present in the phone number
            //that is in this box it will throw an exception
            Pattern patternGet = Pattern.compile("[abcdefghigjklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,./<>?;':{}]|'/*-+!@#$%^&*()'");
            Matcher check = patternGet.matcher(num);
            boolean finalValue = check.find();
            if (finalValue == true) {
                throw new numchkcharec();
            } else{
                //if the number is not 10 digits this shows an exception
                if(num.length()==10) {
                    return true;
                }
                else
                throw new numchkdigi();
            }
        }catch(numchkcharec e){
            String s = prop.getProperty("numchkchr");
            System.out.println(s);
            return false;
        } catch (numchkdigi e) {
            String s = prop.getProperty("numchkdig");
            System.out.println(s);
            return false;
        }
    }
}