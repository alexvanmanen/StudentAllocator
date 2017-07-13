package nl.hsleiden.inf;

public class Lectures {

	private Module module;
	private int maximumCapacity;
	private Period period;
	
	
	public Lectures(Module module, int maximumCapacity, Period period) {
		this.module = module;
		this.maximumCapacity = maximumCapacity;
		this.period = period;
	}

	
	public Module getModule(){
		return module;
	}
	
	public Period getPeriod(){
		return period;
	}
}
