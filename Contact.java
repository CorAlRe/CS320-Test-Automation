package ContactService;

public class Contact {
	// private fields
	String id;
	String firstName;
	String lastName;
	String phone;
	String address;
	
	// constructors
	// no default constructor because Id is required to be supplied and unique in a collection

	public Contact(String id) {
		this(id, "", "", "          ", ""); // initialize with id and empty or required length strings.
	}
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	// accessors
	public String getId() {
		return this.id;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getAddress() {
		return this.address;
	}
	
	// mutators
	// all mutators return Contact instance to support method chaining
	
	// the id field is not publicly updatable
	private Contact setId(String id) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid argument 'id'.");
		}
		this.id = id;
		return this;
	}
	public Contact setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid argument 'firstName'.");
		}
		this.firstName = firstName;
		return this;
	}
	public Contact setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid argument 'lastName'.");
		}
		this.lastName = lastName;
		return this;
	}
	public Contact setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid argument 'phone'.");
		}
		this.phone = phone;
		return this;
	}
	public Contact setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid argument 'address'.");
		}
		this.address = address;
		return this;
	}
	
	// overrrides
	
	@Override
	public int hashCode() {
		return id.hashCode(); // will match other objects if id hash code is the same
	}
	
	// support equality 
	@Override
	public boolean equals(Object o) {
		if (this == o) return true; // object references match therefore same object
		if (o == null || getClass() != o.getClass()) return false; // different types, so not equal
		Contact contact = (Contact) o; // cast object to Contact
		return id.equals(contact.getId()) // compare fields, only equal if all equal
				&& firstName.equals(contact.getFirstName()) 
				&& lastName.equals(contact.getLastName())
				&& phone.equals(contact.getPhone())
				&& address.equals(contact.address);
	}
	
	// support displaying object in debugger watch
	@Override
	public String toString() {
		return "Id: " + this.id + "; Name: " + firstName + " " + lastName + ";";
	}
}
