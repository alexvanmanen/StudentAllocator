package test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.hsleiden.inf.Allocator;
import nl.hsleiden.inf.Choice;
import nl.hsleiden.inf.Groups;
import nl.hsleiden.inf.Lectures;
import nl.hsleiden.inf.Module;
import nl.hsleiden.inf.NaiveAllocator;
import nl.hsleiden.inf.Period;
import nl.hsleiden.inf.Preference;
import nl.hsleiden.inf.Student;
import nl.hsleiden.inf.StudyYear;

public class TestAllocator {

	List<Preference> preferences = new ArrayList<Preference>();
	List<Lectures> lecturesList = new ArrayList<Lectures>();
	
	
	@Before
	public void setUp() throws Exception {
		

	}

	@Test
	public void test() {
		
		StudyYear[] two = { StudyYear.SECOND };
		Module ikopr = new Module("IKOPR", two);
		Module idepa = new Module("IDEPA", two);
		Student john = new Student("1234567", StudyYear.SECOND);

		Preference perference1 = new Preference(john, ikopr, Period.FIRST, Choice.FIRST, new Date(14994142));
		Preference perference2 = new Preference(john, idepa, Period.THIRD, Choice.FIRST, new Date(14994142));
		preferences.add(perference1);
		preferences.add(perference2);

		Lectures lecturesIkopr = new Lectures(ikopr, 24, Period.FIRST);
		Lectures lecturesIdepa = new Lectures(idepa, 24, Period.FIRST);


		lecturesList.add(lecturesIkopr);
		lecturesList.add(lecturesIdepa);
	
		
		
		Allocator allocator = new NaiveAllocator();
		Groups groups = allocator.createGroups(lecturesList, preferences);

		
		Assert.assertEquals(john, groups.getStudents(ikopr).get(0));
		//Assert.assertEquals(null, groups.getStudents(idepa).get(0));
		

	

	}

}
