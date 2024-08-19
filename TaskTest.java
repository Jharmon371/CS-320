// Jason Harmon
// CS-320
// Professor Tuft
// TaskTest Class
// 7/27/24
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
	private String ID, name, desc;
	private String longID, longName, longDesc;
		
	@BeforeEach
	void setUp() {
		ID = "1234567890";
		name = "This is the max char";
		desc = "The task object must have the required description";
		longID = "111222333444555666777888999";
		longName = "The task name is too long and is invalid";
		longDesc = "The description can not be null and has to remain under or equal to 50 char.";
	}
	
	@Test
	void getTaskIDTest() {
		Task task = new Task(ID);
		Assertions.assertEquals(ID, task.getTaskID());
	}
		
	@Test
	void getNameTest() {
		Task task = new Task(ID, name);
		Assertions.assertEquals(name, task.getName());
	}
		
	@Test
	void getDescTest() {
		Task task = new Task(ID, name, desc);
		Assertions.assertEquals(desc, task.getDesc());
	}
		
	@Test
	void setNameTest() {
		Task task = new Task();
		task.setName(name);
		Assertions.assertEquals(name, task.getName());
	}
		
	@Test
	void setDescTest() {
		Task task = new Task();
		task.setDesc(desc);
		Assertions.assertEquals(desc, task.getDesc());
	}
		
	@Test
	void TaskIDLongTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(longID));
	}	
		
	@Test
	void setLongNameTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(longName));
	}	
		
	@Test
	void setLongDescTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDesc(longDesc));
	}	
		
	@Test
	void TaskIdNullTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null));
	}	
		
	@Test
	void TaskNameNullTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,	() -> task.setName(null));
	}	
	
	@Test
	void TaskDescNullTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDesc(null));
	}
}
	
	
