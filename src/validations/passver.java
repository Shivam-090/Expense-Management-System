package src.validations; // Initializing packages

// Importing other packages
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import src.exceptions.*;

public class passver {
    boolean lenpass(String s) {//length of the password should be more that 6 
        if (s.length() < 6) {
            return false;
        } else
            return true;
    }

    boolean specialCharacter(String s) {//the password must contain atleast one special character
        Pattern patternGet = Pattern.compile("[!@#$%^&(,)]");
        Matcher check = patternGet.matcher(s);
        boolean finalValue = check.find();
        if (finalValue == false) {
            return false;
        } else
            return true;
    }

    boolean numpasscheck(String s) {//the password must contain atleast one number
        Pattern patternGet = Pattern.compile("[1234567890]");
        Matcher check = patternGet.matcher(s);
        boolean finalValue = check.find();
        if (finalValue == false) {
            return finalValue;
        } else
            return true;
    }

    boolean upperpass(String s) {
        int i, count = 0;//password must have one letter in uppercase
        for (i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }
        if (count >= 1)
            return true;
        else
            return false;
    }

    boolean lowerpass(String s) {
        int i, count = 0;//password must contain atleast one lowercase
        for (i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                count++;
            }
        }
        if (count >= 1)
            return true;
        else
            return false;
    }

    public boolean passgo(String a) throws IOException 
    { // function to check password for validations 

        boolean b,sc,lc,up,lp;
        Properties prop = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("C:\\Users\\HP\\Desktop\\Project\\configs\\constants\\exceptions.properties");
            prop.load(input);
            b = lenpass(a);
            sc=specialCharacter(a);
            lc=numpasscheck(a);
            up=upperpass(a);
            lp=lowerpass(a);
            if (b == false){
                throw new Passwordlength();
            }
            if(sc==false){
                throw new SpecialCharacterMessageException();
            }
            if(lc==false){
                throw new NumberPasswordException();
            }
            if(up==false){
                throw new upperexceptionpass();
            }
            if(lp==false){
                throw new lowerexceptionpass();
            }
            else
             return true;
        } catch (Passwordlength e) {
            String s = prop.getProperty("SmallpassMessage");
            System.out.println(s);
            return false;
        } catch (SpecialCharacterMessageException e) {
            String s = prop.getProperty("specialcharacterMessage");
            System.out.println(s);
            return false;
        } catch (NumberPasswordException e) {
            String s = prop.getProperty("numbersnotusedMessage");
            System.out.println(s);
            return false;
        } catch (upperexceptionpass e) {
            String s = prop.getProperty("UppercaseMessage");
            System.out.println(s);
            return false;
        } catch (lowerexceptionpass e) {
            String s = prop.getProperty("LowerCaseMessage");
            System.out.println(s);
            return false;
        }
    }
}
