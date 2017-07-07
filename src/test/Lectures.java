package test;

import nl.hsleiden.inf.Module;
import nl.hsleiden.inf.Period;

public class Lectures {

	private Module module;
	private int maximumCapacity;
	private Period period;
	
	
	public Lectures(Module module, int maximumCapacity, Period period) {
		this.module = module;
		this.maximumCapacity = maximumCapacity;
		this.period = period;
	}

}
