import java.util.Arrays;

public class AddressBook {

	private Contact[] contacts;
	
	public AddressBook() {
		contacts = new Contact[0];
	}
	
	public void addContact(Contact c) {
		Contact[] newContacts = new Contact[contacts.length+1];
		for (int i = 0; i < contacts.length; i++) {
			newContacts[i] = contacts[i];
		}
		newContacts[newContacts.length-1] = c;
		contacts = newContacts;
	}
	
	public void removeContact(Contact c) {
		Contact[] newContacts = new Contact[contacts.length-1];
		for (int i = 0; i < contacts.length-1; i++) {
			newContacts[i] = contacts[i];
		}
		contacts = newContacts;
	}
	
	public Contact[] search(String lastName) {
		Contact[] foundContacts = new Contact[contacts.length]; 
		int ind = 0;
		for (int i = 0; i < foundContacts.length; i++) {
			if (contacts[i].getLastName().equals(lastName)) {
				foundContacts[ind] = contacts[i];
				ind++;
			}
		}
		for (int i = 0; i < foundContacts.length; i++) {
			if (foundContacts[i] == null) {
				Contact[] ret = new Contact[i+1];
				for (int j = 0; j < ret.length; j++) {
					ret[j] = foundContacts[j];
				}
				return ret;
			}
		}
		return null;
	}
	
	public String toString() {
		String ret = "";
		for (Contact c : contacts) {
			ret += c+"\n";
		}
		return ret;
	}
	
	public void sort() {
		Arrays.sort(contacts);
	}
}
