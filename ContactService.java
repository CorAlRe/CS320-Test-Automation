package ContactService;

import java.util.*;

public class ContactService {

	private List<Contact> contacts = new ArrayList<Contact>();
	
	public ContactService() {
	}
	
	public void add(Contact contact) {
		Contact existingContact = get(contact.getId());
		
		if (existingContact == null) {
			contacts.add(contact);
		}
		else {
			throw new IllegalArgumentException("'contact' already in service.");
		}
	}
	
	public void delete(String id) {
		Contact contact = this.get(id);
		
		if (contact != null) { // found
			contacts.remove(contact);
		}
		else {
			throw new IllegalArgumentException("'contact' not found in service.");
		}
	}
	
	public Contact get(String id) {
		Iterator<Contact> contactIter = contacts.iterator();
		Contact foundContact = null;
		
		while (contactIter.hasNext()) {
			Contact contact = contactIter.next();
			if (contact.getId().equals(id)) {
				foundContact = contact;
				break;
			}
		}
		
		return foundContact;
	}
	public Contact get(int index) {
		return contacts.get(index);
	}

	public void update(Contact contact) {
		Contact existingContact = this.get(contact.getId()); 
		
		if (existingContact != null) { // if found 
			existingContact.setAddress(contact.getAddress());
			existingContact.setFirstName(contact.getFirstName());
			existingContact.setLastName(contact.getLastName());
			existingContact.setPhone(contact.getPhone());
		}
		else { // if not found
			throw new IllegalArgumentException("'contact' not found in service.");
		}
	}
	
	public int size() {
		return contacts.size();
	}
}