package hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContactDriver {

	public static void main(String[] args) {
		
		Map<String, Contact> addressBook = new HashMap<String, Contact>();
		
		Contact c = new Contact("Steven", "Ye", "905-555-5555");;
		addressBook.put(c.getKey(), c);

		/*
		 * putting an object into the hashMap
		 */
		Contact x = addressBook.remove("905-555-5555StevenYe");
		x.setFirstName("Steve");
		addressBook.put(x.getKey(), x);

	}

}
