package hashmap;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookDriver {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		AddressBook contacts = new AddressBook();

		System.out.println("This is your contact list.");
		System.out.println("Type \"add\" to add a new contact");
		System.out.println("Type \"remove\" to remove a contact");
		System.out.println("Type \"edit\" to edit a sepcified contact");
		System.out.println("Type \"search\" to get a list of all contacts found with search query");
		System.out.println("Type \"show\" to show all the contacts");

		while (true) {
			String input = in.nextLine().toLowerCase();
			if (input.equals("add")) {
				System.out.println("Enter the first name, last name, and phone number each on a new line:");
				Contact c = new Contact();
				c.setFirstName(in.next());
				c.setLastName(in.next());
				c.setPhone(in.next());
				contacts.addContact(c);
				System.out.println(c + " has been added to the contact list.");
			}

			if (input.equals("remove")) {
				contacts.removeContact(in);
			}
			if (input.equals("search")) {
				contacts.showSearch(in);
			}
			if (input.equals("edit")) {
				
			}
			if (input.equals("show")) {
				System.out.println(contacts);
			}
		}
	}
}