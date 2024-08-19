// Jason Harmon
// CS-320
// Professor Tuft
// Contact Class
// 7/20/24
public class Contact { //declaring Variables 
	private static final int Contact_Num_Length = 10;
	private static final byte Contact_ID_Length = 10;
	private static final byte Contact_First_Length = 10;
	private static final byte Contact_Last_Length = 10;
	private static final byte Contact_Addr_Length = 30;
	private static final String Initial = "Initial";
	private static final String Initial_Num = "1234567890";
	private String contactID;
	private String first;
	private String last;
	private String num;
	private String Addr;
	
	Contact() { // assigning variables
		this.contactID = Initial;
	    this.first = Initial;
	    this.last = Initial;
	    this.num = Initial_Num;
	    this.Addr = Initial;
	}

	Contact(String contactID) { 
		updateID(contactID);
	    this.first = Initial;
	    this.last = Initial;
	    this.num = Initial_Num;
	    this.Addr = Initial;
	}

	Contact(String contactID, String first) {
		updateID(contactID);
	    updateFirst(first);
	    this.last = Initial;
	    this.num = Initial_Num;
	    this.Addr = Initial;
	}

	Contact(String contactID, String first, String last) {
		updateID(contactID);
	    updateFirst(first);
	    updateLast(last);
	    this.num = Initial_Num;
	    this.Addr = Initial;
	}

	Contact(String contactID, String first, String last, String num) {
		updateID(contactID);
	    updateFirst(first);
	    updateLast(last);
	    updateNum(num);
	    this.Addr = Initial;
	}

	Contact(String contactID, String first, String last, String num, String Addr) {
		updateID(contactID);
	    updateFirst(first);
	    updateLast(last);
	    updateNum(num);
	    updateAddr(Addr);
	}

	protected final String getID() {
		return contactID;
	}

	protected final String getFirst() {
		return first;
	}

	protected final String getLast() {
		return last;
	}

	protected final String getNum() {
		return num;
	}

	protected final String getAddr() {
		return Addr;
	}

	protected void updateFirst(String first) {
	    if (first == null) {
	    	throw new IllegalArgumentException("Must have a first name!");
	    } else if (first.length() > Contact_First_Length) {
	    	throw new IllegalArgumentException("First name cannot be longer than " + Contact_First_Length + " characters");
	    } else {
	    	this.first = first;
	    }
	}

	protected void updateLast(String last) {
	    if (last == null) {
	    	throw new IllegalArgumentException("Must have a last name!");
	    } else if (last.length() > Contact_Last_Length) {
	    	throw new IllegalArgumentException("Last name cannot be longer than " + Contact_Last_Length + " characters!");
	    } else {
	    	this.last = last;
	    }
	}

	protected void updateNum(String num) {
	    String regex = "[0-9]+";
	    if (num == null) {
	    	throw new IllegalArgumentException("Must have a phone number!");
	    } else if (num.length() != Contact_Num_Length) {
	    	throw new IllegalArgumentException("Phone number length invalid it has to be " + Contact_Num_Length + " digits.");
	    } else if (!num.matches(regex)) {
	    	throw new IllegalArgumentException("Phone number cannot have anything but numbers");
	    } else {
	    	this.num = num;
	    }
	}

	 protected void updateAddr(String Addr) {
	    if (Addr == null) {
	    	throw new IllegalArgumentException("Address cannot be empty");
	    } else if (Addr.length() > Contact_Addr_Length) {
	    	throw new IllegalArgumentException("Address cannot be longer than " + Contact_Addr_Length + " characters");
	    } else {
	    	this.Addr = Addr;
	    }
	 }

	 protected void updateID(String contactID) {
	    if (contactID == null) {
	    	throw new IllegalArgumentException("Contact ID cannot be empty");
	    } else if (contactID.length() > Contact_ID_Length) {
	    	throw new IllegalArgumentException("Contact ID cannot be longer than " + Contact_ID_Length + " characters");
	    } else {
	    	this.contactID = contactID;
	    }
	 }
}

