package map;

import java.util.List;
import java.util.Scanner;

/*
 * This class has an AddressBook and a Scanner
 * 
 * The purpose of this class is to let the user
 * interface with a specific AddressBook using 
 * a specific Scanner.
 * 
 * It does lower level tasks than the UserInterface, such as 
 * selecting specific contacts in an AddressBook and adding and removing them
 */

public class AddressBookDriver {

	private Scanner in;
	private AddressBook addressBook;

	public AddressBookDriver(AddressBook addressBook, Scanner in) {
		this.addressBook = addressBook;
		this.in = in;
	}
	
	/*
	 * Add a contact to the AddressBook using 
	 * User input from the Scanner
	 */
	public void add() {
		System.out.println("Enter the first name, last name, and phone number each on a new line or space seperated:");
		Contact c = new Contact(in.next(), in.next(), in.next());
		addressBook.add(c);
		System.out.println(c + "\nhas been added to the contact list");
	}
	
	/*
	 * Remove a contact from the AddressBook using user 
	 * input to select the contact (askForContact()) 
	 */
	public void remove() {
		Contact foundContact = askForContact();
		if (foundContact != null) {
			System.out.println(addressBook.remove(foundContact) + " removed");
		} 
	}
	
	/*
	 * Show a list of contacts that have the 
	 * key search term entered by the user
	 */
	public void search() {
		System.out.println("Enter a key search term such as first name, last name, or phone number");
		List<Contact> foundContacts = addressBook.search(in.next().toLowerCase());
		if (foundContacts.size() > 0) {
			for (Contact con : foundContacts) {
				System.out.println(con);
			}
		} else {
			System.out.println("No contacts with that key term");
		}
	}
	
	/*
	 * User Scanner to select a contact (askForContact())
	 * and then edit its first or last name or phone number
	 */
	public void edit() {
		Contact contactToEdit = askForContact();
		if (contactToEdit != null) {
			addressBook.remove(contactToEdit.getKey());
			System.out.println("Enter the field that would you like to change, first name, last name, or phone number?");
			String field = in.next().toLowerCase();
			if (field.indexOf("first") > -1) {
				System.out.println("Enter the new first name");
				contactToEdit.setFirstName(in.next());
			}
			else if (field.indexOf("last") > -1) {
				System.out.println("Enter the new last name");
				contactToEdit.setLastName(in.next());
			}
			else if (field.indexOf("phone") > -1) {
				System.out.println("Enter the new phone number");
				contactToEdit.setPhone(in.next());
			} else {
				System.out.println("Invalid input");
				return;
			}
			addressBook.add(contactToEdit);
			System.out.println(contactToEdit + " has been updated.");
		} else {
			return;
		}
	}
	
	/*
	 * Uses the Scanner to select a specific contact which can then be used by other methods
	 * It first prints out a list of contacts that meet the search criteria and then 
	 * lets you select one of the contacts from that list
	 */
	public Contact askForContact() {
		System.out.println("Enter in a key word to select a contact");
		List<Contact> foundContacts = addressBook.search(in.next().toLowerCase());
		if (foundContacts.size() > 0) {
			for (int i = 0; i < foundContacts.size(); i++) {
				System.out.println(i + ": " + foundContacts.get(i));
			}
			System.out.println("Enter the index of the contact you would like to select");
			try {
				int index = in.nextInt();
				if (index >= 0 && index < foundContacts.size()) {
					return foundContacts.get(index);
				} else {
					return null;
				}
			} catch (Exception e) {
				System.out.println("Invalid input");
				return null;
			}

		} else {
			System.out.println("No contact found with that keyword");
			return null;
		}
	}	
	
	/*
	 * Prints all the contacts in the addressBook
	 * Not a toString method because it doesn't make 
	 * sense to print out a driver class
	 */
	public void show() {
		System.out.println(addressBook);
	}
}
