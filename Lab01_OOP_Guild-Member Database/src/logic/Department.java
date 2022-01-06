package logic;

import java.util.ArrayList;

public class Department {
	private String name;
	private ArrayList<GuildMember> departmentMembers;

	public Department(String name) {
		// TODO: Write a constructor here. Initialize a new ArrayList of
		// departmentMembers and set the name of the department.
		this.name = name;
		this.departmentMembers = new ArrayList<>();
	}

	public boolean setName(String name) {
		// TODO: Set name of the department. If the name is blank, return false.
		if (!name.isBlank()) {
			this.name = name;
			return true;
		}
		return false;
	}

	public String getName() {
		// TODO: Return the name of the department.
		return this.name;
	}

	public void addMember(GuildMember m) {
		// TODO: Add the a guild member to the guild and set their department to this
		// one.
		this.departmentMembers.add(m);
		m.setMyDepartment(this.name);
	}

	public void addMultipleMembers(ArrayList<GuildMember> memberList) {
		// TODO: Add all guild members in memberList to this department. Don't forget to
		// set the department as well.
		this.departmentMembers.addAll(memberList);
	}

	public GuildMember removeMember(int index) {
		// TODO: Remove a member from a given index, and returns the removed member.
		return this.departmentMembers.remove(index);
	}

	public GuildMember getMember(int index) {
		// TODO: Get a member from a given index.
		return this.departmentMembers.get(index);
	}

	public ArrayList<GuildMember> getAllMembers() {
		// TODO: Return all members in this department.
		return this.departmentMembers;
	}

	// ------------------------------------------
	// ---do not edit anything below this line---
	// ----but feel free to look at the code!----
	// ------------------------------------------

	public void printMembers() {
		if (departmentMembers.size() <= 0) {
			System.out.println("This department is empty!");
			return;
		}

		int i = 0;
		for (GuildMember m : departmentMembers) {
			System.out.println(i + ") " + m);
			i++;
		}
	}

	public void clearDepartment() {
		departmentMembers.clear();
	}

	public String toString() {
		return name + " Department";
	}

	public int memberCount() {
		return departmentMembers.size();
	}
}
