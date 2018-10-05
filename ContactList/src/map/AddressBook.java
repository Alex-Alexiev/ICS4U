package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Uses a TreeMap<String, Contact> to store 
 * all the contacts in the AddressBook
 */

public class AddressBook {

	private Map<String, Contact> contacts;

	public AddressBook() {
		contacts = new TreeMap<String, Contact>();
	}

	public void add(Contact c) {
		contacts.put(c.getKey(), c);
	}

	public Contact remove(Contact c) {
		return contacts.remove(c.getKey());
	}
	
	public void remove(String key) {
		contacts.remove(key);
	}

	public int size() {
		return contacts.size();
	}
	
	/*
	 * Returns a List<Contact> of contacts whose key's have
	 * the searchParam inside of them
	 */
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
		if (contacts.size() <= 0) {
			return "There are no contacts in your contact list";
		}
		String ret = "";
		for (String key : contacts.keySet()) {
			ret += "" + contacts.get(key) + "\n";
		}
		return ret;
	}
}
