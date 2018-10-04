package hashmap;
import java.util.Comparator;

public class Contact implements Comparable<Contact>{
	private String firstName;
	private String lastName;
	private String phone;
	private String key;
	
	public Contact(){
		
	}
	
	public Contact(String firstName, String lastName, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		updateKey();
	}
	
	public boolean equals(Contact c) {
		if (c.getFirstName().equals(firstName)){
			if (c.getLastName().equals(lastName)) {
				if (c.getPhone().equals(phone)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		updateKey();
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
		updateKey();
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
		updateKey();
	}
	
	public String toString() {
		return getLastName() + ", " + getFirstName() + ", " + getPhone();
	}
	
	public void updateKey() {
		key = phone+firstName+lastName;
	}
	
	public String getKey() {
		return key;
	}
	
	@Override
	public int compareTo(Contact arg0) {
		int ret = this.getLastName().compareTo(arg0.getLastName());
		if (ret == 0) {
			return this.getFirstName().compareTo(arg0.getFirstName());
		}
		return ret;
	}
	
	public static Comparator<Contact> ContactNameComparator = new Comparator<Contact>() {
		@Override
		public int compare(Contact arg0, Contact arg1) {
			return arg0.compareTo(arg1);
		}
	};

	
	
}
