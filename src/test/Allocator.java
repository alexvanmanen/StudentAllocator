package test;

import java.util.List;

import nl.hsleiden.inf.Preference;

public interface Allocator {

	List<Group> createGroups(List<Lectures> lecturesList, List<Preference> preferences);

}
