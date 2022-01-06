package logic;

public class GuildMember {
	private String name;
	private String jobTitle;
	private String myDepartment = "Unassigned";
	private int salary = 0;

	public GuildMember(String name, String jobTitle, int salary) {
		// TODO: Value constructor. Instantiates a member with the given values.
		this.setName(name);
		this.setJobTitle(jobTitle);
		this.setSalary(salary);
	}

	public String getName() {
		// TODO: Return member's name here.
		return this.name;
	}

	public void setName(String name) {
		// TODO: Set the member's name. If it's blank, set is as "Anon".
		String val = name;
		if (name.isBlank()) {
			val = "Anon";
		}
		this.name = val;
	}

	public String getJobTitle() {
		// TODO: Return the member's job title.
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		// TODO: Set the member's job title. If it's blank, set it as "Adventurer".
		String val = jobTitle;
		if (jobTitle.isBlank()) {
			val = "Adventurer";
		}
		this.jobTitle = val;
	}

	public String getMyDepartment() {
		// TODO: Return the member's department.
		return this.myDepartment;
	}

	public void setMyDepartment(String myDepartment) {
		// TODO: Set the member's department.
		this.myDepartment = myDepartment;
	}

	public int getSalary() {
		// TODO: Get the member's salary.
		return this.salary;
	}

	public void setSalary(int salary) {
		// TODO: Set the member's salary.
		// If it is less than 0, set is as 0.
		// If it is greater than 100000, set is as 100000.
		int val = salary;
		if (salary < 0) {
			val = 0;
		} else if (salary > 100000) {
			val = 100000;
		}
		this.salary = val;
	}

	// ------------------------------------------
	// ---do not edit anything below this line---
	// ----but feel free to look at the code!----
	// ------------------------------------------

	public String toString() {
		return name + " the " + jobTitle + " of the " + myDepartment + " Department (Salary: " + salary + ")";
	}
}
