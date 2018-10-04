package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
		String ret = "";
		for (String key : contacts.keySet()) {
			ret += "" + contacts.get(key) + "\n";
		}
		return ret;
	}
}
