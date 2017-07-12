package nl.hsleiden.inf;

import java.util.List;

public interface Allocator {

	Groups createGroups(List<Lectures> lecturesList, List<Preference> preferences);

}
