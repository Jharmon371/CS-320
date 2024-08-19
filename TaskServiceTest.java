// Jason Harmon
// CS-320
// Professor Tuft
// TaskServiceTest Class
// 7/27/24
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	private String ID, name, desc;
	private String longName, longDesc;
	
	@BeforeEach
	void setUp() {
		ID = "1234567890";
	    name = "This is Twenty Chars";
		desc = "The task object must have the required description";
		longDesc = "The description can not be null and has to remain under or equal to 50 char.";
	}

	@Test
	void newTaskTest() {
		TaskService service = new TaskService();
	    service.newTask();
	    Assertions.assertNotNull(service.getTaskList().get(0).getTaskID());
	    Assertions.assertNotEquals("Initial", service.getTaskList().get(0).getTaskID());
	}

	@Test
	void newTaskNameTest() {
	    TaskService service = new TaskService();
	    service.newTask(name);
	    Assertions.assertNotNull(service.getTaskList().get(0).getName());
	    Assertions.assertEquals(name, service.getTaskList().get(0).getName());
	}

	@Test
	void newTaskDescTest() {
	    TaskService service = new TaskService();
	    service.newTask(name, desc);
	    Assertions.assertNotNull(service.getTaskList().get(0).getDesc());
	    Assertions.assertEquals(desc, service.getTaskList().get(0).getDesc());
	}

	@Test
	void newTaskLongNameTest() {
		TaskService service = new TaskService();
	    Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(longName));
	}

	@Test
	void newTaskLongDescTest() {
	    TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class, () -> service.newTask(name, longDesc));
	}

	@Test
	void newTaskNameNullTest() {
		TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class,() -> service.newTask(null));
	}

	@Test
	void newTaskDescNullTest() {
	    TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class,() -> service.newTask(name, null));
	}

	@Test
	void deleteTaskTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertEquals(1, service.getTaskList().size());
	    service.deleteTask(service.getTaskList().get(0).getTaskID());
	    assertEquals(0, service.getTaskList().size());
	}

	@Test
	void deleteTaskNotFoundTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertEquals(1, service.getTaskList().size());
	    assertThrows(Exception.class, () -> service.deleteTask(ID));
	    assertEquals(1, service.getTaskList().size());
	}

	@Test
	void updateNameTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    service.updateName(service.getTaskList().get(0).getTaskID(), name);
	    assertEquals(name, service.getTaskList().get(0).getName());
	}

	@Test
	void updateDescTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    service.updateDesc(service.getTaskList().get(0).getTaskID(), desc);
	    assertEquals(desc, service.getTaskList().get(0).getDesc());
	}

	@Test
	void updateNameNotFoundTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertThrows(Exception.class, () -> service.updateName(ID, name));
	}

	@Test
	void updateDescNotFoundTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertThrows(Exception.class, () -> service.updateDesc(ID, desc));
	}

	@RepeatedTest(4)
	void UuidTest() {
	    TaskService service = new TaskService();
	    service.newTask();
	    service.newTask();
	    service.newTask();
	    assertEquals(3, service.getTaskList().size());
	    assertNotEquals(service.getTaskList().get(0).getTaskID(), service.getTaskList().get(1).getTaskID());
	    assertNotEquals(service.getTaskList().get(0).getTaskID(), service.getTaskList().get(2).getTaskID());
	    assertNotEquals(service.getTaskList().get(1).getTaskID(), service.getTaskList().get(2).getTaskID());
	}
}