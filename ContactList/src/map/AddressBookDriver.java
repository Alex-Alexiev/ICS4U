package map;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class AddressBookDriver {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		AddressBook contacts = new AddressBook(in);

		System.out.println("This is your contact list.");
		System.out.println("Type \"add\" to add a new contact");
		System.out.println("Type \"remove\" to remove a contact");
		System.out.println("Type \"edit\" to edit a sepcified contact");
		System.out.println("Type \"search\" to get a list of all contacts found with search query");
		System.out.println("Type \"show\" to show all the contacts");
		
		while (true) {
			String input = in.nextLine().toLowerCase();
			if (input.equals("add")) {
				contacts.add();
			}
			if (input.equals("remove")) {
				contacts.removeContact();
			}
			if (input.equals("search")) {
				contacts.search();
			}
			if (input.equals("edit")) {
				contacts.edit();
			}
			if (input.equals("show")) {
				System.out.println(contacts);
			}
		}
	}
}