package App_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import App_Service.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Banana Man Lane");
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Doe"));
		assertTrue(contact.getNumber().equals("1234567890"));
		assertTrue(contact.getAddress().equals("Banana Man Lane"));
		assertTrue(contact.getId().equals("12345"));
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Nebuchadnezzar", "Doe", "1234567890", "Banana Man Lane");
		}); 	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Barthalemune", "1234567890", "Banana Man Lane");
		}); 	}
	
	@Test
	void testContactNumberNotCorrect() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Doe", "12345678910", "Banana Man Lane");
			new Contact("12345", "John", "Doe", "123", "Banana Man Lane");
		}); 	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Doe", "1234567890", "Do you konw, the muffin man? THe Muffin man? The one that lives of Drewery Lane? Well she is married to, the Muffin Man. The Muffin Man? THE-E MUFFIN MAN!!");
		}); 	}
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345670910","John", "Doe", "1234567890", "Banana Man Lane");
		}); 	}


}
