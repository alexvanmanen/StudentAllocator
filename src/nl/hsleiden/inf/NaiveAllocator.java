package nl.hsleiden.inf;

import java.util.List;

public class NaiveAllocator implements Allocator {

	
	public Groups createGroups(List<Lectures> lecturesList, List<Preference> preferences) {
		Groups groups = new Groups();
		for(Lectures lectures: lecturesList){
			Group group = new Group(lectures);
			group.addStudent(preferences.get(0).getStudent());
			groups.add(group);
			
		}
		
		
		
		
		
		
		return groups;
		
	}

}
