// Jason Harmon
// CS-320
// Professor Tuft
// AppointmentTest Class
// 7/27/24
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
class AppointmentTest {
	private String ID, desc;
	private String longID, longDesc;
	private Date date, pastDate;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		ID = "1234567890";
	    desc = "The appointment must have a required description..";
	    date = new Date(3024, Calendar.JULY, 27);
	    longID = "111222333444555666777888999000";
	    longDesc = "This description is too long for the appointment requirements and works good for testing.";
	    pastDate = new Date(0);
	}

	@Test
	void testUpdateApptID() {
		Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class, () -> appt.updateApptID(null));
	    assertThrows(IllegalArgumentException.class, () -> appt.updateApptID(longID));
	    appt.updateApptID(ID);
	    assertEquals(ID, appt.getApptID());
	}

	@Test
	void testGetApptID() {
	    Appointment appt = new Appointment(ID);
	    assertNotNull(appt.getApptID());
	    assertEquals(appt.getApptID().length(), 10);
	    assertEquals(ID, appt.getApptID());
	}

	@Test
	void testUpdateDate() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDate(pastDate));
	    appt.updateDate(date);
	    assertEquals(date, appt.getApptDate());
	}

	@Test
	void testGetApptDate() {
	    Appointment appt = new Appointment(ID, date);
	    assertNotNull(appt.getApptDate());
	    assertEquals(date, appt.getApptDate());
	}

	@Test
	void testUpdateDesc() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDesc(null));
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDesc(longDesc));
	    appt.updateDesc(desc);
	    assertEquals(desc, appt.getDesc());
	}

	@Test
	void testGetDesc() {
	    Appointment appt = new Appointment(ID, date, desc);
	    assertNotNull(appt.getDesc());
	    assertTrue(appt.getDesc().length() <= 50);
	    assertEquals(desc, appt.getDesc());
	}
}