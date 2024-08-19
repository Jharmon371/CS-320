// Jason Harmon
// CS-320
// Professor Tuft
// ContactTest Class
// 7/20/24
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest { //declaring Variables 
	protected String contactID, firstTest, lastTest, numTest,addrTest;
	protected String longID, longFirst, longLast, longNum, longAddr, shortNum;

	@BeforeEach
	void setUp() { // assigns the test variables
		contactID = "12E4567B9O";
		firstTest = "Jason";
    	lastTest = "Harmon";
    	numTest = "1234567890";
    	addrTest = "30 Pine Ln Troy NY 12345";
    	longID = "112233445566778899";
    	longFirst = "Jason Jason Jason";
    	longLast = "Harmon Harmon Harmon";
    	longNum = "1234567890987654321";
    	longAddr = "123456 Pine Lane Apt 123456 Schenectady Ny 12345 ";
    	shortNum = "12345";
	}

	@Test
	void IDTest() { // tests the ID input
		Contact contact = new Contact();
		assertAll("constructor",
	            () -> assertNotNull(contact.getID()),
	            () -> assertNotNull(contact.getFirst()),
	            () -> assertNotNull(contact.getLast()),
	            () -> assertNotNull(contact.getNum()),
	            () -> assertNotNull(contact.getAddr()));
	}

	@Test
	void IDConstructorTest() { // tests the ID constructor
		Contact contact = new Contact(contactID);
		assertAll("constructor one",
	            () -> assertEquals(contactID, contact.getID()),
	            () -> assertNotNull(contact.getFirst()),
	            () -> assertNotNull(contact.getLast()),
	            () -> assertNotNull(contact.getNum()),
	            () -> assertNotNull(contact.getAddr()));
	}

	@Test
	void IDFirstConstructorTest() { // tests the ID with first name constructor
		Contact contact = new Contact(contactID, firstTest);
		assertAll("constructor two",
				() -> assertEquals(contactID, contact.getID()),
				() -> assertEquals(firstTest, contact.getFirst()),
				() -> assertNotNull(contact.getLast()),
				() -> assertNotNull(contact.getNum()),
				() -> assertNotNull(contact.getAddr()));
	}

	@Test
	void IDFullNameConstructorTest() { // tests the ID with the first and last name
		Contact contact = new Contact(contactID, firstTest, lastTest);
		assertAll("constructor three",
				() -> assertEquals(contactID, contact.getID()),
				() -> assertEquals(firstTest, contact.getFirst()),
				() -> assertEquals(lastTest, contact.getLast()),
				() -> assertNotNull(contact.getNum()),
				() -> assertNotNull(contact.getAddr()));
	}

	@Test
	void IDFullNameNumConstructorTest() { // tests the ID with full name and number
		Contact contact = new Contact(contactID, firstTest, lastTest, numTest);
		assertAll("constructor four",
				() -> assertEquals(contactID, contact.getID()),
            	() -> assertEquals(firstTest, contact.getFirst()),
            	() -> assertEquals(lastTest, contact.getLast()),
            	() -> assertEquals(numTest, contact.getNum()),
            	() -> assertNotNull(contact.getAddr()));
	}

	@Test
	void AllConstructorTest() { // tests all of the constructors together
		Contact contact = new Contact(contactID, firstTest, lastTest, numTest, addrTest);
		assertAll("constructor all",
				() -> assertEquals(contactID, contact.getID()),
            	() -> assertEquals(firstTest, contact.getFirst()),
            	() -> assertEquals(lastTest, contact.getLast()),
            	() -> assertEquals(numTest, contact.getNum()),
            	() -> assertEquals(addrTest, contact.getAddr()));
	}

	@Test
	void updateFirstTest() { // changes the testing variable
		Contact contact = new Contact();
		contact.updateFirst(firstTest);
		assertAll("first name",
				() -> assertEquals(firstTest, contact.getFirst()),
				() -> assertThrows(IllegalArgumentException.class,
                () -> contact.updateFirst(null)),
				() -> assertThrows(IllegalArgumentException.class,
                () -> contact.updateFirst(longFirst)));
	}

	@Test
	void updateLastTest() {// changes the testing variable
		Contact contact = new Contact();
		contact.updateLast(lastTest);
		assertAll("last name",
				() -> assertEquals(lastTest, contact.getLast()),
	          	() -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateLast(null)),
	          	() -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateLast(longFirst)));
	}
	
	@Test
	void updateNumTest() {// changes the testing variable
		Contact contact = new Contact();
		contact.updateNum(numTest);
		assertAll("phone number",
	            () -> assertEquals(numTest, contact.getNum()),
	            () -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateNum(null)),
	            () -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateNum(longNum)),
	            () -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateNum(shortNum)),
	            () -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateNum(contactID)));
	}
	
	@Test
	void updateAddressTest() {// changes the testing variable
		Contact contact = new Contact();
		contact.updateAddr(addrTest);
		assertAll("phone number",
	            () -> assertEquals(addrTest, contact.getAddr()),
	            () -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateAddr(null)),
	            () -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateAddr(longAddr)));
	}
	
	@Test
	void updateContactIdTest() {// changes the testing variable
		Contact contact = new Contact();
		contact.updateID(contactID);
		assertAll("contact ID",
				() -> assertEquals(contactID, contact.getID()),
	          	() -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateID(null)),
	      		() -> assertThrows(IllegalArgumentException.class,
	            () -> contact.updateID(longID)));
	}
}
	
