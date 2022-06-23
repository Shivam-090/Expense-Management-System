package src.mainUI; // Main Package 
// Initializing main package

// importing packages
import java.io.IOException;
import java.util.Scanner;

public class MainControl{ // MAIN CLASS
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Control c = new Control(); // initializing control.java file
		c.start();
	}
}