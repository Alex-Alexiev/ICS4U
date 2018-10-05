package map;

import java.util.Scanner;

/*
 * This class has an AddressBook and an AddressBookDriver
 * 
 * The main method takes commands from the input stream
 * and then tells the AddressBookDriver what to do
 * based on the commands.
 * 
 * This class has the main method so it allows any implementation for dealing with the AddressBook, 
 * while letting the AddressBookDriver class do the interfacing with the user for 
 * lower level tasks such as selecting, adding and removing contacts.
 */

public class UserInterface {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		AddressBook contacts = new AddressBook();
		AddressBookDriver driver = new AddressBookDriver(contacts, in);

		System.out.println("This is your contact list");
		System.out.println("Type \"add\" to add a new contact");
		System.out.println("Type \"remove\" to remove a contact");
		System.out.println("Type \"edit\" to edit a sepcified contact");
		System.out.println("Type \"search\" to get a list of all contacts found with search query");
		System.out.println("Type \"show\" to show all the contacts");
		
		while (true) {
			String input = in.nextLine().toLowerCase();
			if (input.equals("add")) {
				driver.add();
			}
			if (input.equals("remove")) {
				driver.remove();
			}
			if (input.equals("search")) {
				driver.search();
			}
			if (input.equals("edit")) {
				driver.edit();
			}
			if (input.equals("show")) {
				driver.show();
			}
		}
	}
}
