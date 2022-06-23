package src.time; // Initializing Package

// Importing other packages
import java.util.concurrent.*;
public class Waiting { 
	public void load() // function made to dispay the loading message
	{
		try {
			int i = 0;
			System.out.print("\t\t\t\t\t\t\t\t\t Loading Please Wait");
			do {
				TimeUnit.MILLISECONDS.sleep(135);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(135);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(135);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(135);
				System.out.print("."); // Using inbuilt method to provide delay
				TimeUnit.MILLISECONDS.sleep(135);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(135);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(135);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(135);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(135);
				System.out.print(".");
				if (i == 0) {
					System.out.print("\b\b\b\b\b\b\b\b\b");
					System.out.print("         ");
					System.out.print("\b\b\b\b\b\b\b\b\b");
				}
				i++;
			} while (i <= 1);
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}