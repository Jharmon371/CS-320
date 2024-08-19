// Jason Harmon
// CS-320
// Professor Tuft
// AppointmentServiceTest Class
// 7/27/24
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	private String ID, desc, longDesc;
	private Date date, pastDate;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		ID = "1234567890";
	    desc = "The appointment must have a required description..";
	    date = new Date(3024, Calendar.JULY, 27);
	    longDesc = "This description is too long for the appointment requirements and works good for testing.";
	    pastDate = new Date(0);
	}

	@Test
	void testNewAppt() {
		AppointmentService service = new AppointmentService();
		
	    service.newAppt();
	    assertNotNull(service.getApptList().get(0).getApptID());
	    assertNotNull(service.getApptList().get(0).getApptDate());
	    assertNotNull(service.getApptList().get(0).getDesc());

	    service.newAppt(date);
	    assertNotNull(service.getApptList().get(1).getApptID());
	    assertEquals(date, service.getApptList().get(1).getApptDate());
	    assertNotNull(service.getApptList().get(1).getDesc());

	    service.newAppt(date, desc);
	    assertNotNull(service.getApptList().get(2).getApptID());
	    assertEquals(date, service.getApptList().get(2).getApptDate());
	    assertEquals(desc, service.getApptList().get(2).getDesc());

	    assertNotEquals(service.getApptList().get(0).getApptID(), service.getApptList().get(1).getApptID());
	    assertNotEquals(service.getApptList().get(0).getApptID(), service.getApptList().get(2).getApptID());
	    assertNotEquals(service.getApptList().get(1).getApptID(), service.getApptList().get(2).getApptID());

	    assertThrows(IllegalArgumentException.class, () -> service.newAppt(pastDate));
	    assertThrows(IllegalArgumentException.class, () -> service.newAppt(date, longDesc));
	}

	@Test
	void deleteAppt() throws Exception {
		AppointmentService service = new AppointmentService();

	    service.newAppt();
	    service.newAppt();
	    service.newAppt();

	    String firstID = service.getApptList().get(0).getApptID();
	    String secondID = service.getApptList().get(1).getApptID();
	    String thirdID = service.getApptList().get(2).getApptID();

	    assertNotEquals(firstID, secondID);
	    assertNotEquals(firstID, thirdID);
	    assertNotEquals(secondID, thirdID);
	    assertNotEquals(ID, firstID);
	    assertNotEquals(ID, secondID);
	    assertNotEquals(ID, thirdID);

	    assertThrows(Exception.class, () -> service.deleteAppt(ID));

	    service.deleteAppt(firstID);
	    assertThrows(Exception.class, () -> service.deleteAppt(firstID));
	    assertNotEquals(firstID, service.getApptList().get(0).getApptID());
	}
}
