package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AddressBook {

	private Map<String, Contact> contacts;
	private Scanner in;

	public AddressBook(Scanner in) {
		contacts = new TreeMap<String, Contact>();
		this.in = in;
	}

	public void addContact(Contact c) {
		contacts.put(c.getKey(), c);
	}

	public Contact removeContact(Contact c) {
		return contacts.remove(c.getKey());
	}

	public List<Contact> search(String searchParam) {
		List<Contact> foundContacts = new ArrayList<Contact>();
		for (String key : contacts.keySet()) {
			if (key.indexOf(searchParam) > -1) {
				foundContacts.add(contacts.get(key));
			}
		}
		return foundContacts;
	}

	public void add() {
		System.out.println("Enter the first name, last name, and phone number each on a new line:");
		Contact c = new Contact();
		c.setFirstName(in.next());
		c.setLastName(in.next());
		c.setPhone(in.next());
		addContact(c);
		System.out.println(c + " has been added to the contact list.");

	}

	public void removeContact() {
		Contact foundContact = askForContact();
		if (foundContact != null) {
			System.out.println(removeContact(foundContact) + " removed");
		} else {
			System.out.println("Invalid input");
		}
	}

	public Contact askForContact() {
		System.out.println("Enter in a key word for the contact you would like to remove");
		List<Contact> foundContacts = search(in.nextLine());
		if (foundContacts != null) {
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
			return null;
		}
	}

	public void edit() {
		Contact contactToEdit = askForContact();
		System.out.println("Enter the field that would you like to change, first name, last name, or phone number?");
		String field = in.next().toLowerCase();
		if (field.indexOf("first") > -1) {
			System.out.println("Enter the new first name");
			contacts.remove(contactToEdit.getKey());
			contactToEdit.setFirstName(in.next());
		}
		if (field.indexOf("last") > -1) {
			contacts.remove(contactToEdit.getKey());
			System.out.println("Enter the new last name");
			contactToEdit.setLastName(in.next());
		}
		if (field.indexOf("phone") > -1) {
			contacts.remove(contactToEdit.getKey());
			System.out.println("Enter the new phone number");
			contactToEdit.setPhone(in.next());
		} else {
			System.out.println("invalid input");
			return;
		}
		contacts.put(contactToEdit.getKey(), contactToEdit);
	}

	public void search() {
		System.out.println("Enter a key search term such as first name, last name, or phone number");
		List<Contact> foundContacts = search(in.next().toLowerCase());
		if (foundContacts.size() > 0) {
			for (Contact con : foundContacts) {
				System.out.println(con);
			}
		} else {
			System.out.println("No contacts with that key term");
		}
	}

	public String toString() {
		String ret = "";
		for (String key : contacts.keySet()) {
			ret += "" + contacts.get(key) + "\n";
		}
		return ret;
	}
}
