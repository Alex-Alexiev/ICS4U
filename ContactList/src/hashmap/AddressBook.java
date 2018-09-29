//package hashmap;
//public class AddressBook {
//
//	private LinkedList contacts;
//	
//	public AddressBook() {
//		contacts = new LinkedList();
//	}
//	
//	public void addContact(Contact c) {
//		contacts.insert(c);
//	}
//	
//	public void removeContact(Contact c) {
//		contacts.remove(c);
//	}
//	
//	public Contact[] search(String lastName) {
//		Contact[] foundContacts = new Contact[contacts.getLength()]; 
//		int ind = 0;
//		contacts.resetCurrent();
//		while(contacts.getCurrent() != null) {
//			if (contacts.getCurrent().getLastName().equals(lastName)) {
//				foundContacts[ind] = contacts.getCurrent();
//				ind++;
//			}
//			contacts.next();
//		}
//		for (int i = 0; i < foundContacts.length; i++) {
//			if (foundContacts[i] == null) {
//				Contact[] ret = new Contact[i];
//				for (int j = 0; j < ret.length; j++) {
//					ret[j] = foundContacts[j];
//				}
//				return ret;
//			}
//		}
//		return null;
//	}
//	
//	public String toString() {
//		String ret = "";
//		contacts.resetCurrent();
//		while(contacts.getCurrent() != null) {
//			ret += contacts.getCurrent()+"\n";
//			contacts.next();
//		}
//		return ret;
//	}
//	
//	public void sort() {
//		//Arrays.sort(contacts);
//	}
//}
