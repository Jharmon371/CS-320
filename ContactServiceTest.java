// Jason Harmon
// CS-320
// Professor Tuft
// ContactServiceTest Class
// 7/20/24
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest { //declaring Variables 
	protected String contactID, firstTest, lastTest, numTest,addrTest;
	protected String longID, longFirst, longLast, longNum, longAddr, shortNum;

	@BeforeEach
	void setUp() {// assigns the test variables
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
	void newIDTest() { // tests the creation of ID
    	ContactService service = new ContactService();
    	service.newContact();
    	assertAll( "service",
    			() -> assertNotNull(service.getIDList().get(0).getID()),
    			() -> assertEquals("Initial", service.getIDList().get(0).getFirst()),
    			() -> assertEquals("Initial", service.getIDList().get(0).getLast()),
    			() -> assertEquals("1234567890", service.getIDList().get(0).getNum()),
    			() -> assertEquals("Initial", service.getIDList().get(0).getAddr()));
    	service.newContact(firstTest);
   		assertAll( "service",
		        () -> assertNotNull(service.getIDList().get(1).getID()),
		        () -> assertEquals(firstTest, service.getIDList().get(1).getFirst()),
		        () -> assertEquals("Initial", service.getIDList().get(1).getLast()),
		        () -> assertEquals("1234567890", service.getIDList().get(1).getNum()),
		        () -> assertEquals("Initial", service.getIDList().get(1).getAddr()));
   		service.newContact(firstTest, lastTest);
   		assertAll("service",
		        () -> assertNotNull(service.getIDList().get(2).getID()),
		        () -> assertEquals(firstTest, service.getIDList().get(2).getFirst()),
		        () -> assertEquals(lastTest, service.getIDList().get(2).getLast()),
		        () -> assertEquals("1234567890", service.getIDList().get(2).getNum()),
		        () -> assertEquals("Initial", service.getIDList().get(2).getAddr()));
   		service.newContact(firstTest, lastTest, numTest);
   		assertAll("service",
		   		() -> assertNotNull(service.getIDList().get(3).getID()),
		        () -> assertEquals(firstTest, service.getIDList().get(3).getFirst()),
		        () -> assertEquals(lastTest, service.getIDList().get(3).getLast()),
		        () -> assertEquals(numTest, service.getIDList().get(3).getNum()),
		        () -> assertEquals("Initial", service.getIDList().get(3).getAddr()));
		   		service.newContact(firstTest, lastTest, numTest, addrTest);
   		assertAll("service",
		        () -> assertNotNull(service.getIDList().get(4).getID()),
		        () -> assertEquals(firstTest, service.getIDList().get(4).getFirst()),
		        () -> assertEquals(lastTest, service.getIDList().get(4).getLast()),
		        () -> assertEquals(numTest, service.getIDList().get(4).getNum()),
		        () -> assertEquals(addrTest, service.getIDList().get(4).getAddr()));
 	}

	@Test
	void deleteIDTest() { // tests the remove function
		ContactService service = new ContactService();
   		service.newContact();
   		assertThrows(Exception.class, () -> service.deleteID(contactID));
   		assertAll(()-> service.deleteID(service.getIDList().get(0).getID()));
	}

	@Test
	void updateFirstTest() throws Exception {// changes the testing variable
		ContactService service = new ContactService();
		service.newContact();
		service.updateFirst(service.getIDList().get(0).getID(), firstTest);
		assertEquals(firstTest, service.getIDList().get(0).getFirst());
		assertThrows(IllegalArgumentException.class,
                () -> service.updateFirst(service.getIDList().get(0).getID(),longFirst));
		assertThrows(IllegalArgumentException.class,
                () -> service.updateFirst(service.getIDList().get(0).getID(), null));
		assertThrows(Exception.class,
                () -> service.updateFirst(contactID, firstTest));
	}

	@Test
	void updateLastTest() throws Exception { // changes the testing variable
		ContactService service = new ContactService();
		service.newContact();
		service.updateLast(service.getIDList().get(0).getID(), lastTest);
   		assertEquals(lastTest, service.getIDList().get(0).getLast());
   		assertThrows(IllegalArgumentException.class,
                () -> service.updateLast(service.getIDList().get(0).getID(),longLast));
   		assertThrows(IllegalArgumentException.class,
                () -> service.updateLast(service.getIDList().get(0).getID(), null));
   		assertThrows(Exception.class,
                () -> service.updateLast(contactID, lastTest));
	}

	@Test
	void updateNumTest() throws Exception { // changes the testing variable
		ContactService service = new ContactService();
		service.newContact();
		service.updateNum(service.getIDList().get(0).getID(), numTest);
		assertEquals(numTest, service.getIDList().get(0).getNum());
		assertThrows(IllegalArgumentException.class,
                () -> service.updateNum(service.getIDList().get(0).getID(), longNum));
		assertThrows(IllegalArgumentException.class,
                () -> service.updateNum(service.getIDList().get(0).getID(), shortNum));
		assertThrows(IllegalArgumentException.class,
		   		() -> service.updateNum(service.getIDList().get(0).getID(), contactID));
		assertThrows(IllegalArgumentException.class,
                () -> service.updateNum(service.getIDList().get(0).getID(), null));
		assertThrows(Exception.class,
                () -> service.updateNum(contactID, lastTest));
	}

	@Test
	void updateAddrTest() throws Exception { // changes the testing variable
		ContactService service = new ContactService();
		service.newContact();
	    service.updateAddr(service.getIDList().get(0).getID(), addrTest);
	    assertEquals(addrTest, service.getIDList().get(0).getAddr());
	    assertThrows(IllegalArgumentException.class,
	                () -> service.updateAddr(service.getIDList().get(0).getID(), longAddr));
	    assertThrows(IllegalArgumentException.class,
	                () -> service.updateAddr(service.getIDList().get(0).getID(), null));
	    assertThrows(Exception.class,
	                () -> service.updateAddr(contactID, addrTest));
	}
}
