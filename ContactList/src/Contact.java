import java.util.Comparator;

public class Contact implements Comparable<Contact>{
	private String firstName;
	private String lastName;
	private String phone;
	
	public Contact(){
		
	}
	
	public Contact(String firstName, String lastName, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
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
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString() {
		return "First Name: "+getFirstName()+" Last Name: "+getLastName()+" Phone Number: "+getPhone();
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