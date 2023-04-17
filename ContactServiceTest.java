package App_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import App_Service.Contact;
import App_Service.ContactService;

class ContactServiceTest {

	@Test
	void testAddContactMethod() {
		ContactService contactService = new ContactService();
		String testId = contactService.genUniqueId();
		Contact contact = new Contact(testId, "John", "Doe", "1234567890", "Banana Man Lane");
		
		contactService.addContact(contact);
		
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService.getContactList().elementAt(0).getId().equals(testId));
		assertTrue(contactService.getContactNum() > 0);
	}
	
	@Test
	void testRemoveContactMethod() {
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Banana Man Lane");
		
		// Remove with null id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.removeContact("");
		});
		
		// Remove with id greater than character limit
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			contactService.removeContact("123456789010");
		});
		
		// Remove with empty list. No contact has been added yet
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			contactService.removeContact("1234567890");
		});
		
		// Add contact for further testing
		contactService.addContact(contact);
		
		// Remove contact not in list
		contactService.removeContact("123456");
		
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService.getContactNum() != 0);
		
		// Remove the correct contact
		contactService.removeContact("12345");
		
		assertTrue(contactService.getContactNum() == 0);
		assertTrue(contactService.getContactList().isEmpty());
	}
	
	@Test
	void testUpdateContactMethodMenu() {
		ContactService contactService = new ContactService();
		
		// Contact list is empty
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("12345", "John", 1);
		});
		
		Contact contact = new Contact("123456", "John", "Doe", "1234567890", "Banana Man Lane");
		contactService.addContact(contact);
		
		assertTrue(!contactService.getContactList().isEmpty());
		
		// ID is too long test
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			contactService.updateContact("12345678901", "John", 1);
		});
		
		// ID is null test
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			contactService.updateContact(null, "John", 1);
		});
		
		// Selection value < 0 test
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			contactService.updateContact("123456", "John", -1);
		});
		
		// Desired information needing changed is null (backup measure if first check fails somehow)
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			contactService.updateContact("123456", null, 1);
		});
		
		// Contact not found error check
		contactService.updateContact("123457", "John", 1);
		
		// Contact not updated error check
		contactService.updateContact("123456", "John", 5);
	}
	
	@Test
	void testUpdateContactMethod() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("1234567", "John", "Doe", "1234567890", "Banana Man Lane");
		contactService.addContact(contact);;
		assertTrue(!contactService.getContactList().isEmpty());
		
		// Update first name in contact
		contactService.updateContact("1234567", "Johnathan", 1);
		assertTrue(contactService.getContactList().elementAt(0).getFirstName().equals("Johnathan"));
		
		// Update last name in contact
		contactService.updateContact("1234567", "Carmack", 2);
		assertTrue(contactService.getContactList().elementAt(0).getLastName().equals("Carmack"));
		
		// Update phone number in contact
		contactService.updateContact("1234567", "0987654321", 3);
		assertTrue(contactService.getContactList().elementAt(0).getNumber().equals("0987654321"));
		
		// Update Address
		contactService.updateContact("1234567", "Banana Man Drive", 4);
		assertTrue(contactService.getContactList().elementAt(0).getAddress().equals("Banana Man Drive"));
		
		// Update first name too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("1234567", "Nebuchadnezzar", 1);
		});
		
		// Update last name too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("1234567", "Barthalemune", 2);
		});
		
		// Update number too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("1234567", "12345678910", 3);
		});
		
		// Update number too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("1234567", "1234", 3);
		});
		
		// Update Address too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("1234567", "Do you know the muffin man, the muffin man that lives of drewery lane? Yes, well she is married to... the Muffin man. The Muffin Man?! THE-E MUFFIN MAN!!!", 4);
		});
		
		assertTrue(contactService.getContactNum() == 1);
		assertTrue(contactService.getContactList().elementAt(0).getFirstName().equals("Johnathan"));
		assertTrue(contactService.getContactList().elementAt(0).getLastName().equals("Carmack"));
	}


}
