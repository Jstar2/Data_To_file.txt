package main;

import java.util.Scanner;

import service.Service;

public class Main {
	private String name = null;
	private String lastName = null;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		System.out.println("Enter first name: ");
		String name = scan.nextLine();
		System.out.println("Enter second name: ");
		String lastName = scan.nextLine();
		Service serv = new Service(name, lastName);

		do {
			System.out.println("**Choose following**");
			System.out.println(
					"1- Show Info\n2- Change MailBox Capacity\n3- Set Alternate Email\n4- Store data to file \n5- Display data from file\n6- Exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				serv.getInformation();
			}
				break;

			case 2: {
				serv.mailCap();
			}
				break;
			case 3: {
				serv.alternatEmail();
			}
				break;
			case 4: {
				serv.storeDataToFile();
			}
				break;
			case 5: {
				serv.readFile();
			}
				break;
			case 6: {
				System.exit(0);
			}
				break;
			default: {
				System.out.println("Wrong Input");
			}
			}
		} while (!flag);
	}
}