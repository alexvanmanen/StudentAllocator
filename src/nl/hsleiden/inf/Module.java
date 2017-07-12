package nl.hsleiden.inf;

public class Module {
	private String abbreviation;
	private StudyYear[] studyYears;

	public Module(String abbreviation, StudyYear[] studyYears) {
		this.abbreviation = abbreviation;
		this.studyYears = studyYears;
	}
	
	public String getAbbreviation(){
		return abbreviation;
	}
	
	public String toString(){
		return abbreviation +" " + studyYears;
	}

}
