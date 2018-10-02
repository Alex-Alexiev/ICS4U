package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<Contact> search(String lastName) {
		List<Contact> foundContacts = new ArrayList<Contact>();
		for (String key : contacts.keySet()) {
			if (key.indexOf(lastName) > -1) {
				foundContacts.add(contacts.get(key));
			}
		}
		return foundContacts;
	}
	
	public String toString() {
		String ret = "";
		for (String key : contacts.keySet()) {
			Contact curr = contacts.get(key);
			ret += curr.getLastName() +", "+ curr.getFirstName() +", "+ curr.getPhone() +"\n";
		}
		return ret;
	}
	
	public void sort() {
		//Arrays.sort(contacts);
	}
}
