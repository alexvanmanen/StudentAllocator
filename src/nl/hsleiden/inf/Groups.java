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
	
	public void add(Group group){
		groupList.add(group);
	}
	


}
