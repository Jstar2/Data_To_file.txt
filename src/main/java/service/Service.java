package service;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Service {

	public Scanner scan = new Scanner(System.in);

	private String name;
	private String lastName;
	private String department;
	private String email;
	private String password;
	private int mailCapacity = 500;
	private String alertnativeEmail;

	public Service(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
		System.out.println("New employee:" + this.name + " " + this.lastName);
		this.department = this.setDept();
		this.password = this.randomPasswordGenaration(10);
		this.email = this.genarateEmail();

	}

	public String randomPasswordGenaration(int lenghtOfPassword) {
		String password = null;
		Random random = new Random();
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String samllLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symboles = "!£$%^&*#~@':;/|`¬+*-.=";
		String values = capitalLetters + samllLetters + numbers + symboles;
		for (int i = 0; i < lenghtOfPassword; i++) {
			password = password + values.charAt(random.nextInt(values.length()));
		}
		return password;
	}

	private String genarateEmail() {
		String emailGen = null;
		emailGen = name + lastName + "@" + department + ".bolton.com";
		return emailGen.toLowerCase();
	}

	private String setDept() {
		String deptName = null;

		System.out
				.println("Choose Department \n" + "1- Teachers\n" + "2- Students\n" + "3- Managment\n" + "4- Security");

		int option = scan.nextInt();

		switch (option) {
		case 1: {
			System.out.println("Teaching");
			deptName = "Teaching";
		}
			break;
		case 2: {
			System.out.println("Students");
			deptName = "Students";
		}
			break;
		case 3: {
			System.out.println("Managment");
			deptName = "Managment";
		}
			break;
		case 4: {
			System.out.println("Security");
			deptName = "Security";
		}
			break;
		default: {
			System.out.println("Wrong Option");
		}
			break;
		}

		return deptName;
	}

	public void readFile() {
		try {
			FileReader fR = new FileReader("C:\\Users\\Public\\Desktop\\Email_Data");// change path to your preference
			int i;
			while ((i = fR.read()) != -1) {
				System.out.println((char) i);
			}
			System.out.println();
			fR.close();
		} catch (Exception e) {

		}
	}

	public void storeDataToFile() {
		try {
			FileWriter in = new FileWriter("C:\\Users\\Public\\Desktop\\Email_Data"); // change path to your preference
			in.write("First name: " + this.name);
			in.append("\nLast Name: " + this.lastName);
			in.append("\nEmail: " + this.email);
			in.append("\nPassword: " + this.password);
			in.append("\nCapacity: " + this.mailCapacity);
			in.append("\nAlternate Email: " + this.alertnativeEmail);
			in.close();
			System.out.println("Data stored");

		} catch (Exception e) {

			System.out.println();
		}

	}

	public void getInformation() {
		System.out.println("New: " + this.name + " " + this.lastName);
		System.out.println("\nDepartment: " + this.department);
		System.out.println("\nEmail: " + this.email);
		System.out.println("\nPassword: " + this.password);
		System.out.println("\nMailBox cap: " + this.mailCapacity + "mb");
		System.out.println("\nAlternate Email:" + this.alertnativeEmail);
		System.out.println();
	}

	public void alternatEmail() {
		System.out.println("Current alternate Eamil is " + this.alertnativeEmail);
		System.out.println("Enter new alternate email: ");
		String newAlternateEmail = scan.nextLine();
		this.alertnativeEmail = newAlternateEmail;
		System.out.println("New alternate Email is set to " + this.alertnativeEmail);
	}

	public void mailCap() {
		System.out.println("Currunt main capacity " + this.mailCapacity);
		System.out.println("Enter new mail capacity: ");
		int newMailCap = scan.nextInt();
		if (newMailCap > Integer.MIN_VALUE && newMailCap > Integer.MAX_VALUE) {
			this.mailCapacity = newMailCap;
			System.out.println("New Email capacity is set to " + newMailCap);
		} else {
			System.out.println("Wrong input, value should be a number");
		}
	}

}