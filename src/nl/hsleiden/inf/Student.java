package nl.hsleiden.inf;

public class Student {

	
	private StudentNumber number;
	private StudyYear studyYear;
	
	public Student(String number, StudyYear studyYear) {
		this.number = new StudentNumber(number);
		this.studyYear = studyYear;
	}

	public String toString(){
		return number.toString();
	}
}
