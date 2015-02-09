package cs495.winatwaiting.task;

import java.util.ArrayList;

public class Task implements Comparable<Task>{

	private int timeNeeded = 0;
	private String name = "", location = "", description = "";
	private boolean interruptable = false, situation = false;
	private ArrayList<String> people = new ArrayList<String>(),
			needs = new ArrayList<String>();

	public Task(String name, int timeNeeded, boolean situationn,
			String location, boolean interruptable, String people,
			String needs, String description) {
		setName(name);
		setTimeNeeded(timeNeeded);
		setSituation(situationn);
		setLocation(location);
		setInterruptable(interruptable);
		setPeople(people);
		setNeeds(needs);
		setDescription(description);
	}
	
	public Task(String s){
		String[] sa = s.split("-");
		setName(sa[0]);
		setTimeNeeded(Integer.parseInt(sa[1]));
		setLocation(sa[2]);
		setDescription(sa[3]);
		setInterruptable((sa[4].equals("true")?true:false));
		setSituation((sa[5].equals("true")?true:false));
		setPeople(sa[6]);
		setNeeds(sa[7]);
	}

	public String getTimeNeeded() {
		return timeNeeded + " minutes";
	}

	public void setTimeNeeded(int timeNeeded) {
		this.timeNeeded = isNull(timeNeeded) ? 0 : timeNeeded;
	}

	public String getSituation() {
		return situation ? "public" : "private";
	}

	public void setSituation(boolean situationn) {
		this.situation = isNull(situationn) ? false : situationn;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location.equals("") ? "Unspecified Location" : location;
	}

	public String isInterruptable() {
		return interruptable ? "Interruptable" : "Not interruptable";
	}

	public void setInterruptable(boolean interruptable) {
		this.interruptable = interruptable;
	}

	public String getPeople() {
		String s = "With: ";
		for (String p : people) {
			s += p + " ";
		}
		return s;
	}

	public void setPeople(String string) {
		if (isNull(string))
			this.people = null;
		else
			for (String s : string.split(" "))
				people.add(s);
	}

	public String getNeeds() {
		String s = "Need: ";
		for (String n : needs) {
			s += n + " ";
		}
		return s;
	}

	public void setNeeds(String string) {
		if (isNull(string))
			this.needs = null;
		else
			for (String s : string.split(" "))
				needs.add(s);
	}

	private boolean isNull(Object o) {
		return o.equals(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.equals("") ? "No name" : name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.equals("") ? "No description" : description;
	}

	public String getTask() {
		return "" + name + "-" + timeNeeded + "-" + location + "-" + description + "-" + interruptable + "-" + situation + "-" + getPeople() + "-" + getNeeds();
	}

	@Override
	public int compareTo(Task t) {
		if (name.equals(t.getName()))
			if (location.equals(t.getLocation()))
				if (description.equals(t.getDescription()))
					return 0;
		return 1;
	}
	
}
