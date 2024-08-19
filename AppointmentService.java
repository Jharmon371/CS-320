// Jason Harmon
// CS-320
// Professor Tuft
// AppointmentService  Class
// 7/27/24
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	final private List<Appointment> apptList = new ArrayList<>();

	private String newUniqueID() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}

	public void newAppt() {
	    Appointment appt = new Appointment(newUniqueID());
	    apptList.add(appt);
	}

	public void newAppt(Date date) {
	    Appointment appt = new Appointment(newUniqueID(), date);
	    apptList.add(appt);
	}

	public void newAppt(Date date, String desc) {
	    Appointment appt = new Appointment(newUniqueID(), date, desc);
	    apptList.add(appt);
	}

	public void deleteAppt(String ID) throws Exception {
		apptList.remove(searchForAppt(ID));
	}

	protected List<Appointment> getApptList() {
		return apptList;
	}

	private Appointment searchForAppt(String ID) throws Exception {
	    int index = 0;
	    while (index < apptList.size()) {
	    	if (ID.equals(apptList.get(index).getApptID())) {
	    		return apptList.get(index);
	    	}
	    	index++;
	    }
	    throw new Exception("The appointment does not exist!");
	}
}

