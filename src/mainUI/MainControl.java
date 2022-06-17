package src.mainUI;

import java.io.IOException;
import java.util.Scanner;

public class MainControl{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Control c = new Control();
		c.start();
	}
}