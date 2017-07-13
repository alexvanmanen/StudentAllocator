package nl.hsleiden.inf;

import java.util.ArrayList;
import java.util.List;

public class Groups {
	private List<Group> groupList = new ArrayList<Group>();

	public List<Student> getStudents(Module module) {
		for (Group group : groupList) {
			Lectures lectures = group.getLectures();
			if (lectures.getModule() == module) {
				return group.getStudents();
			}
		}
		return null;
	}

	public void add(Group group) {
		groupList.add(group);
	}

	public boolean isStudentAllocated(Student student, Period period) {
		for (Group group : getGroupsFromPeriod(period)) {
			if (group.getStudents().contains(student)) {
				return true;
			}
		}
		return false;
	}

	public List<Group> getGroupsFromPeriod(Period period) {
		List<Group> result = new ArrayList<Group>();
		for (Group group : groupList) {

			if (group.getLectures().getPeriod().equals(period)) {
				result.add(group);
			}
		}
		return result;
	}

	public Group getGroup(Module module) {
		for (Group group : groupList) {
			if (group.getLectures().getModule().getAbbreviation().equalsIgnoreCase(module.getAbbreviation())) {
				return group;
			}
		}
		return null;
	}

}
