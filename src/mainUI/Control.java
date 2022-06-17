package src.mainUI;

import src.time.*;
import src.user.*;
import src.admin.*;
import src.clr.*;
import java.io.*;
import java.util.*;

public class Control {
	Cls cls = new Cls();
	Waiting waiting = new Waiting();

	public void start() {
		try {
			cls.screen(); // calling static method screen() to clear the cmd screen
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n\n\n\n\n\n\n");

		waiting.load(); // Calling static method load() for a loading message

		try {
			cls.screen();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n\n\n");
		System.out.println("\t\t\t\t\t\t-------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t|                                                     |");
		System.out.println("\t\t\t\t\t\t|                                                     |");
		System.out.println("\t\t\t\t\t\t|         WELCOME TO EXPENSE MANAGEMENT PORTAL        |");
		System.out.println("\t\t\t\t\t\t|                                                     |");
		System.out.println("\t\t\t\t\t\t|                                                     |");
		System.out.println("\t\t\t\t\t\t-------------------------------------------------------");

		System.out.println("\n\n\t\t\t\tPlease Choose !\n");
		Scanner sc = new Scanner(System.in);
		int input;

		System.out.println("\t\t\t\t\t\t1.USER" + "\n" + "\t\t\t\t\t\t2.ADMIN\n\n");
		System.out.println("\t\t\t\t\tPress 1 for User access or Press 2 for Admin access\n");
		System.out.print("\t\t\t\t\t");
		input = sc.nextInt();
		switch (input) {
			case 1:
				Userlogin uslogin = new Userlogin(sc);
				uslogin.login();
				break;
			case 2:
				AdminLogin adlogin = new AdminLogin(sc);
				try {
					adlogin.login();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Input Value is Wrong!");
				break;
		}

	}
}