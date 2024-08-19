// Jason Harmon
// CS-320
// Professor Tuft
// ContactService Class
// 7/20/24

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	private String uniqueID;
	private List<Contact> IDList = new ArrayList<>();
	{
		uniqueID = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	public void newContact() {
	    Contact contact = new Contact(newUniqueID());
	    IDList.add(contact);
	}

	public void newContact(String first) {
	    Contact contact = new Contact(newUniqueID(), first);
	    IDList.add(contact);
	}

	public void newContact(String first, String last) {
	    Contact contact = new Contact(newUniqueID(), first, last);
	    IDList.add(contact);
	}

	public void newContact(String first, String last, String num) {
	    Contact contact = new Contact(newUniqueID(), first, last, num);
	    IDList.add(contact);
	}

	public void newContact(String first, String last, String num, String Addr) {
	    Contact contact = new Contact(newUniqueID(), first, last, num, Addr);
	    IDList.add(contact);
	}

	public void deleteID(String ID) throws Exception {
		IDList.remove(searchForID(ID));
	}

	public void updateFirst(String ID, String first) throws Exception {
		searchForID(ID).updateFirst(first);
	}

	public void updateLast(String ID, String last) throws Exception {
		searchForID(ID).updateLast(last);
	}
	
	public void updateNum(String ID, String num)
	    throws Exception {
	    searchForID(ID).updateNum(num);
	}

	public void updateAddr(String ID, String Addr) throws Exception {
	    searchForID(ID).updateAddr(Addr);
	}

	protected List<Contact> getIDList() {
		return IDList;
	}

	private String newUniqueID() {
	    return uniqueID = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}

	private Contact searchForID(String ID) throws Exception {
	    int index = 0;
	    while (index < IDList.size()) {
	    	if (ID.equals(IDList.get(index).getID())) {
	    		return IDList.get(index);
	    	}
	    	index++;
	    }
	    throw new Exception("The Task does not exist!");
	}
}
