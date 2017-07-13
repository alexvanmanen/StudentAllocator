package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.hsleiden.inf.Group;
import nl.hsleiden.inf.Groups;
import nl.hsleiden.inf.Lectures;
import nl.hsleiden.inf.Module;
import nl.hsleiden.inf.Period;
import nl.hsleiden.inf.Student;
import nl.hsleiden.inf.StudyYear;

public class TestGroup {

	private StudyYear[] two = { StudyYear.SECOND };
	private Module abc = new Module("ABC", two);
	private Module def = new Module("DEF", two);
	private Module ghi = new Module("GHI", two);

	private Groups groups = new Groups();
	private Lectures l1 = new Lectures(def, 2, Period.FOURTH);
	private Lectures l2 = new Lectures(ghi, 2, Period.FOURTH);

	private Group group1 = new Group(new Lectures(abc, 2, Period.THIRD));
	private Group group2 = new Group(l1);
	private Group group3 = new Group(l2);

	@Before
	public void setUp() throws Exception {
		groups.add(group1);
		groups.add(group2);
		groups.add(group3);
	}

	@Test
	public void testGetGroupsFromPeriod() {

		Assert.assertEquals(2, groups.getGroupsFromPeriod(Period.FOURTH).size());
		Assert.assertEquals(l1, groups.getGroupsFromPeriod(Period.FOURTH).get(0).getLectures());
		Assert.assertEquals(l2, groups.getGroupsFromPeriod(Period.FOURTH).get(1).getLectures());

	}

	@Test
	public void testIsStudentAllocated(){
		Student s = new Student("131232123", StudyYear.SECOND);
		group1.addStudent(s);
		Assert.assertEquals(true, groups.isStudentAllocated(s, Period.THIRD));
		Assert.assertEquals(false, groups.isStudentAllocated(s, Period.FOURTH));
		
	}
}
