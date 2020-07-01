package Util;



import java.util.Date;

public class TaskBean {

	private String taskName;
	private String meaning;
	private String example;

	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((meaning == null) ? 0 : meaning.hashCode());
	
		
		result = prime * result + ((example == null) ? 0 : example.hashCode());
		result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskBean other = (TaskBean) obj;
	
		if (meaning == null) {
			if (other.meaning != null)
				return false;
		} else if (!meaning.equals(other.meaning))
			return false;
		
		
		if (example == null) {
			if (other.example != null)
				return false;
		} else if (!example.equals(other.example))
			return false;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TaskBean [taskName=" + taskName + ", meaning=" + meaning + ", example=" + example + "]";
	}
	public TaskBean(String taskName, String meaning, String example) {
		super();
		this.taskName = taskName;
		this.meaning = meaning;
		this.example = example;
		
		
	}
	public TaskBean() {
		super();
	}
	
}
