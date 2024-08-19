// Jason Harmon
// CS-320
// Professor Tuft
// Task Class
// 7/27/24
public class Task {
	private String taskID;
	private String name;
	private String desc;

	Task() {
		taskID = "Initial";
	    name = "Initial";
	    desc = "Initial desc";
	}

	Task(String taskID) {
		checkTaskID(taskID);
	    name = "Initial";
	    desc = "Initial desc";
	}

	Task(String taskID, String name) {
	    checkTaskID(taskID);
	    setName(name);
	    desc = "Initial desc";
	}

	Task(String taskID, String name, String desc) {
	    checkTaskID(taskID);
	    setName(name);
	    setDesc(desc);
	}

	public final String getTaskID() {
		return taskID;
	}

	public final String getName() {
		return name;
	}

	protected void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Name must not be blank and must be no longer than 20 characters");
	    } else {
	    	this.name = name;
	    }
	}

	public final String getDesc() { 
		return desc;	
	}

	protected void setDesc(String taskDesc) {
	    if (taskDesc == null || taskDesc.length() > 50) {
	    	throw new IllegalArgumentException("Description must not be blank and must be no longer than 50 characters");
	    } else {
	    	this.desc = taskDesc;
	    }
	}

	private void checkTaskID(String taskID) {
	    if (taskID == null || taskID.length() > 10) {
	    	throw new IllegalArgumentException("Error: The task ID was blank or longer than 10 characters");
	    } else {
	      this.taskID = taskID;
	    }
	}
}

