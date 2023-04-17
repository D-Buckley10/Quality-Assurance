package App_Service;

import java.util.Vector;
import java.util.Random;

public class ContactService {
	
	// Create a vector to store contents
	private Vector<Contact> contactList = new Vector<Contact>();

	// Create integer counter to store number of contacts in vector
	private int contactNum = 0; // Initialize it equal to zero
	
	// Getter methods
	public int getContactNum() {
		return contactNum;
	}
	
	public Vector<Contact> getContactList() {
		return contactList;
	}
	
	// Function to add Contact to list
	public void addContact(String id, String firstName, String lastName, String Number, String Address) {
		// Create the new contact
		Contact newContact = new Contact(id, firstName, lastName, Number, Address);
		
		// Add contact to the list of contacts
		contactList.add(newContact);
		
		// Increase the number of contacts that are in the list
		contactNum++;
	}
	
	public void addContact(Contact contact) {
		contactList.add(contact);
		contactNum++;
	}
	
	// function to remove contact from the list
	public void removeContact(String id) {
		
		// Error message if id is null or greater than 10
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		
		// Error message if no contacts exist in the list (impossible to remove what's not there right?)
		if (contactList.isEmpty()) {
			throw new IllegalArgumentException("There are no contacts saved.");
		}
		
		int index = -1;
		
		for (Contact con: contactList) {
			if (con.getId() == id) {
				index = contactList.indexOf(con);
			}
		}
		
		if (index == -1) {
			System.out.println("No contact found!");
			return;
		}
		
		else {
			contactList.remove(index);
			contactNum--;
			System.out.println("Contact found and removed!");
		}
	}
	
	public void removeContact(Contact contact) {
		contactList.remove(contact);
		contactNum--;
	}
	
	// Update contact
	public void updateContact(String id, String update, int selection) {
		if (id == null || id.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("Invalid option");
		}
		
		if (contactList.isEmpty()) {
			throw new IllegalArgumentException("Contact list is empty, no contacts to update!");
		}
		
		int index =-1;
		
		for (Contact con: contactList) {
			if (con.getId() == id) {
				index = contactList.indexOf(con);
			}
		}
		
		if (index == -1) {
			System.out.println("Contact not found!");
			return;
		}
		
		Contact updatedCon = contactList.get(index);
		
		// Switch case scenario for choosing what to update in the contact
		switch(selection) {
			case 1: {
				updatedCon.setFirstName(update);
				break;
			}
			
			case 2: {
				updatedCon.setLastName(update);
				break;
			}
			
			case 3: {
				updatedCon.setNumber(update);
				break;
			}
			
			case 4: {
				updatedCon.setAddress(update);
				break;
			}
			
			default: {
				removeContact(contactList.elementAt(index));
				addContact(updatedCon);
			}
			
		}
	}
	
	public String genUniqueId() {
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueId = Integer.toString(newID);

		
		System.out.println("New Contact ID created: " + uniqueId);
		return uniqueId;
	}
}

