package nl.hsleiden.inf;

import java.util.Date;

public class Preference {

	private Student student;
	private Module module;
	private Period preferedPeriod;
	private Choice choice;
	private Date registrationDate;
	
	public Preference(Student student, Module module, Period preferedPeriod, Choice choice, Date registrationDate) {
		this.student = student;
		this.module = module;
		this.preferedPeriod = preferedPeriod;
		this.choice = choice;
		this.registrationDate = registrationDate;
	}

	
	public String toString(){
		return student + " - " + module + " " + preferedPeriod + " " + choice + " " + registrationDate;
	}
	
	public Student getStudent(){
		return this.student;
	}
	
	public Module getModule(){
		return this.module;
	}
	
	public Period getPreferedPeriod(){
		return preferedPeriod;
	}
}

