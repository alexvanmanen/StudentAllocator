package nl.hsleiden.inf;

import java.util.ArrayList;
import java.util.List;

public class Preferences {

	private List<Preference> preferences = new ArrayList<Preference>();
	
	
	public void add(Preference preference){
		preferences.add(preference);
	}
}