package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

	private Map<String, Contact> contacts;

	public AddressBook() {
		contacts = new HashMap<String, Contact>();
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

	public String toString() {
		sort();
		String ret = "";
		for (String key : contacts.keySet()) {
			Contact curr = contacts.get(key);
			ret += "" + contacts.get(key);
		}
		return ret;
	}
	
	public void removeContact(Scanner in) {
		Contact foundContact = askForContact(in);
		if (foundContact != null) {
			System.out.println(removeContact(foundContact) + " removed");
		} else {
			System.out.println("Invalid input");
		}
	}

	public Contact askForContact(Scanner in) {
		System.out.println("Type in a key word for the contact you would like to remove");
		List<Contact> foundContacts = search(in.nextLine());
		if (foundContacts != null) {
			for (int i = 0; i < foundContacts.size(); i++) {
				System.out.println(i + " " + foundContacts.get(i));
			}
			System.out.println("Which index");
			int index = in.nextInt();
			if (index >= 0 && index < foundContacts.size()) {
				return foundContacts.get(in.nextInt());
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public void showSearch(Scanner in) {
		System.out.println("Type a key search term such as first name, last name, or phone number");
		List<Contact> foundContacts = search(in.next().toLowerCase());
		if (foundContacts != null) {
			for (Contact con : foundContacts) {
				System.out.println(con);
			}
		} else {
			System.out.println("No contacts with that key term");
		}
	}

	public void sort() {
		// Arrays.sort(contacts);
	}
}
