package map;

import java.util.List;
import java.util.Scanner;

public class AddressBookDriver {

	private Scanner in;
	private AddressBook ab;

	public AddressBookDriver(AddressBook ab, Scanner in) {
		this.ab = ab;
		this.in = in;
	}

	public void add() {
		System.out.println("Enter the first name, last name, and phone number each on a new line:");
		Contact c = new Contact();
		c.setFirstName(in.next());
		c.setLastName(in.next());
		c.setPhone(in.next());
		ab.add(c);
		System.out.println(c + " has been added to the contact list.");
	}

	public void remove() {
		Contact foundContact = askForContact();
		if (foundContact != null) {
			System.out.println(ab.remove(foundContact) + " removed");
		} else {
			System.out.println("Invalid input");
		}
	}
	
	public void search() {
		System.out.println("Enter a key search term such as first name, last name, or phone number");
		List<Contact> foundContacts = ab.search(in.next().toLowerCase());
		if (foundContacts.size() > 0) {
			for (Contact con : foundContacts) {
				System.out.println(con);
			}
		} else {
			System.out.println("No contacts with that key term");
		}
	}

	public void edit() {
		Contact contactToEdit = askForContact();
		System.out.println("Enter the field that would you like to change, first name, last name, or phone number?");
		String field = in.next().toLowerCase();
		if (field.indexOf("first") > -1) {
			System.out.println("Enter the new first name");
			ab.remove(contactToEdit.getKey());
			contactToEdit.setFirstName(in.next());
		}
		if (field.indexOf("last") > -1) {
			ab.remove(contactToEdit.getKey());
			System.out.println("Enter the new last name");
			contactToEdit.setLastName(in.next());
		}
		if (field.indexOf("phone") > -1) {
			ab.remove(contactToEdit.getKey());
			System.out.println("Enter the new phone number");
			contactToEdit.setPhone(in.next());
		} else {
			System.out.println("invalid input");
			return;
		}
		ab.add(contactToEdit);
	}

	public void show() {
		if (ab.size() > 0) {
			System.out.println(ab);
		} else {
			System.out.println("There are no contacts in your address book");
		}
	}

	public Contact askForContact() {
		System.out.println("Enter in a key word for the contact you would like to remove");
		List<Contact> foundContacts = ab.search(in.next());
		if (foundContacts.size() > 0) {
			for (int i = 0; i < foundContacts.size(); i++) {
				System.out.println(i + " " + foundContacts.get(i));
			}
			System.out.println("Which index");
			int index = in.nextInt();
			if (index >= 0 && index < foundContacts.size()) {
				return foundContacts.get(index);
			} else {
				return null;
			}
		} else {
			System.out.println("No contact found with that keyword");
			return null;
		}
	}
}
