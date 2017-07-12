package nl.hsleiden.inf;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private List<Student> studentList = new ArrayList<Student>();
	private Lectures lectures;
	
	public Group(Lectures lecture){
		this.lectures = lecture;
	}
	
	public void addStudent(Student student){
		studentList.add(student);
	}
	
	public List<Student> getStudents(){
		return studentList;
	}

	public Lectures getLectures() {
		return lectures;
		
	}


	
	
}
