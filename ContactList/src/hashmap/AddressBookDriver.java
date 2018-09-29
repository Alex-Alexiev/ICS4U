//package hashmap;
//import java.util.Scanner;
//
//public class AddressBookDriver {
//	
//	public static Scanner in = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		AddressBook contacts = new AddressBook();
//		
//		while(true) {
//			String input = in.nextLine();
//			if (input.toLowerCase().equals("add")) {
//				Contact c = new Contact();
//				c.setFirstName(in.next());
//				c.setLastName(in.next());
//				c.setPhone(in.next());
//				contacts.addContact(c);
//			}
//			
//			if (input.toLowerCase().equals("remove")) {
//				Contact[] c = contacts.search(in.nextLine());
//				if (c != null) {
//					for (Contact con : c) {
//						System.out.println(con);
//					}
//					System.out.println("which");
//					Contact temp = c[in.nextInt()-1];
//					contacts.removeContact(temp);
//					System.out.println(temp.getFirstName() + " removed");
//				} else {
//					System.out.println("ivalid input");
//				}
//			} 
//			if (input.toLowerCase().equals("search")) {
//				Contact[] c = contacts.search(in.next());
//				if (c != null) {
//					for (Contact con : c) {
//						System.out.println(con);
//					}
//				}
//			}
//			if (input.toLowerCase().equals("show")) {
//				contacts.sort();
//				System.out.println(contacts);
//			}
//		}
//	}
//}