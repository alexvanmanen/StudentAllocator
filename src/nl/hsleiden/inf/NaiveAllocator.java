package nl.hsleiden.inf;

import java.util.List;

public class NaiveAllocator implements Allocator {

	
	public Groups createGroups(List<Lectures> lecturesList, List<Preference> preferences) {
		Groups groups = new Groups();
		for(Lectures lectures: lecturesList){
			Group group = new Group(lectures);
			groups.add(group);
			
		}
		
		for(Preference preference: preferences){
			if(!groups.isStudentAllocated(preference.getStudent(), preference.getPreferedPeriod())){
				groups.getGroup(preference.getModule()).addStudent(preference.getStudent());
			}
			
		}
		
		
		
		
		
		
		
		return groups;
		
	}

}
