// Jason Harmon
// CS-320
// Professor Tuft
// Appointment Class
// 7/27/24
import java.util.Date;

public class Appointment {
	final private byte ID_Length;
	final private byte desc_Length;
	final private String Initializer;
	private String apptID;
	private Date apptDate;
	private String desc;
	
	{
		ID_Length = 10;
		desc_Length = 50;
		Initializer = "Initial";
	}	
	
	Appointment() {
		Date today = new Date();
		apptID = Initializer;
		apptDate = today;
		desc = Initializer;
	}

	Appointment(String ID) {
	    Date today = new Date();
	    updateApptID(ID);
	    apptDate = today;
	    desc = Initializer;
	}

	Appointment(String ID, Date date) {
	    updateApptID(ID);
	    updateDate(date);
	    desc = Initializer;
	}

	Appointment(String ID, Date date, String desc) {
	    updateApptID(ID);
	    updateDate(date);
	    updateDesc(desc);
	}

	public void updateApptID(String ID) {
		if (ID == null) {
			throw new IllegalArgumentException("Appointment ID cannot be blank.");
	    } else if (ID.length() > ID_Length) {
	    	throw new IllegalArgumentException("Appointment ID cannot be more than " + ID_Length + " characters.");
	    } else {
	    	this.apptID = ID;
	    }
	}

	public String getApptID() {
		return apptID;
	}

	public void updateDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Appointment date cannot be blank.");
	    } else if (date.before(new Date())) {
	    	throw new IllegalArgumentException("Cannot make appointment in the past.");
	    } else {
	    	this.apptDate = date;
	    }
	}

	public Date getApptDate() {
		return apptDate; 
	}

	public void updateDesc(String desc) {
	    if (desc == null) {
	    	throw new IllegalArgumentException("Appointment description cannot be blank.");
	    } else if (desc.length() > desc_Length) {
	    	throw new IllegalArgumentException("Appointment description cannot be more than " + desc_Length + " characters.");
	    } else {
	    	this.desc = desc;
	    }
	}

	public String getDesc() {
		return desc;
	}
	
}
