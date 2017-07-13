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
	public void testAllocatorOneStudent() {

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
		// Assert.assertEquals(null, groups.getStudents(idepa).get(0));
	}

	@Test
	public void testAllocatorOneStudentTwoCoursesInTwoPeriods() {

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
		Assert.assertEquals(john, groups.getStudents(idepa).get(0));
	}

	@Test
	public void testAllocatorOneStudentTwoCoursesInOnePeriod() {

		StudyYear[] two = { StudyYear.SECOND };
		Module ikopr = new Module("IKOPR", two);
		Module idepa = new Module("IDEPA", two);
		Student john = new Student("1234567", StudyYear.SECOND);

		Preference perference1 = new Preference(john, ikopr, Period.FIRST, Choice.FIRST, new Date(14994142));
		Preference perference2 = new Preference(john, idepa, Period.FIRST, Choice.FIRST, new Date(14994142));
		preferences.add(perference1);
		preferences.add(perference2);

		Lectures lecturesIkopr = new Lectures(ikopr, 24, Period.FIRST);
		Lectures lecturesIdepa = new Lectures(idepa, 24, Period.FIRST);

		lecturesList.add(lecturesIkopr);
		lecturesList.add(lecturesIdepa);

		Allocator allocator = new NaiveAllocator();
		Groups groups = allocator.createGroups(lecturesList, preferences);

		Assert.assertEquals(john, groups.getStudents(ikopr).get(0));
		Assert.assertEquals(true, groups.getStudents(idepa).isEmpty());
	}

	@Test
	public void testAllocatorTwoStudentsTwoCoursesInOnePeriod() {

		StudyYear[] two = { StudyYear.SECOND };
		StudyYear[] third = { StudyYear.THIRD };
		Module ikopr = new Module("IKOPR", two);
		Module idepa = new Module("IDEPA", two);
		Module ifp2 = new Module("ifp2", two);
		Module icp = new Module("icp", third);
		Student john = new Student("1234567", StudyYear.SECOND);
		Student jack = new Student("2872738", StudyYear.SECOND);

		
		Preference perference1a = new Preference(john, ikopr, Period.FIRST, Choice.FIRST, new Date(14994142));
		Preference perference1b = new Preference(john, idepa, Period.FIRST, Choice.SECOND, new Date(14994142));
		Preference perference1c = new Preference(john, idepa, Period.THIRD, Choice.FIRST, new Date(14994142));
		Preference perference2a = new Preference(jack, ikopr, Period.FIRST, Choice.FIRST, new Date(14994142));
		Preference perference2b = new Preference(jack, idepa, Period.FIRST, Choice.FIRST, new Date(14994142));
		Preference perference2c = new Preference(jack, ifp2, Period.FOURTH, Choice.FIRST, new Date(14994142));
		
		
		preferences.add(perference1a);
		preferences.add(perference1b);
		preferences.add(perference1c);
		preferences.add(perference2a);
		preferences.add(perference2b);
		preferences.add(perference2c);
		

		Lectures lecturesIkopr = new Lectures(ikopr, 24, Period.FIRST);
		Lectures lecturesIdepaFirst = new Lectures(idepa, 24, Period.FIRST);
		//Lectures lecturesIdepaThird = new Lectures(idepa, 24, Period.THIRD);

		Lectures lecturesifp2 = new Lectures(ifp2, 24, Period.SECOND);
		Lectures lecturesicp = new Lectures(icp, 24, Period.FOURTH);

		lecturesList.add(lecturesIkopr);
		lecturesList.add(lecturesIdepaFirst);
		//lecturesList.add(lecturesIdepaThird);
		lecturesList.add(lecturesifp2);
		lecturesList.add(lecturesicp);

		Allocator allocator = new NaiveAllocator();
		Groups groups = allocator.createGroups(lecturesList, preferences);

		Assert.assertEquals(true, groups.getStudents(ikopr).contains(john));
		Assert.assertEquals(true, groups.getStudents(ikopr).contains(jack));
		Assert.assertEquals(false, groups.getStudents(idepa).contains(john));
		
		
		
		//Assert.assertEquals(true, groups.getStudents(idepa).isEmpty());
	}

}
