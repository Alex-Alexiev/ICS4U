package hashmap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookDriver {
	
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		AddressBook contacts = new AddressBook();
		
		while(true) {
			String input = in.nextLine();
			if (input.toLowerCase().equals("add")) { 
				System.out.println("Enter the first name, last name, and phone number each on a new line:");
				Contact c = new Contact();
				c.setFirstName(in.next());
				c.setLastName(in.next());
				c.setPhone(in.next());
				contacts.addContact(c);
			}
			
			if (input.toLowerCase().equals("remove")) {
				List<Contact> foundContacts = contacts.search(in.nextLine());
				if (foundContacts != null) {
					for (int i = 0; i < foundContacts.size(); i++) {
						System.out.println(i + " " + foundContacts.get(i));
					}
					System.out.println("Which index");
					int index = in.nextInt();
					if (index >= 0 && index < foundContacts.size()) {
						System.out.println(contacts.removeContact(foundContacts.get(index)).getFirstName() + " removed");
					}
				} else { 
					System.out.println("ivalid input");
				}
			} 
			if (input.toLowerCase().equals("search")) {
				List<Contact> foundContacts = contacts.search(in.next());
				if (foundContacts != null) {
					for (Contact con : foundContacts) {
						System.out.println(con);
					}
				}
			}
			if (input.toLowerCase().equals("show")) {
				contacts.sort();
				System.out.println(contacts);
			}
		}
	}
}