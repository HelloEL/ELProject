package crisisAndEvent;

import java.util.ArrayList;

public class Crisis {

	private boolean automaticlyHappen = false;
	private String title;
	private String description;
	private ArrayList<Option> optionList;//改成三个option感觉好一些，四个太难想
	private String place;
	private int id;
	
	public static final int NUMBER_OF_OPTION = 3;
	
	Crisis(){
		optionList = new ArrayList<Option>();
	}

	public void setID(int parseInt) {
		
		id = parseInt;
	}

	public void setTitle(String substring) {
		
		title = substring;
	}

	public void setSpontaneity() {

		if(id == 0)
			automaticlyHappen = true;
		else
			automaticlyHappen = false;
	}

	public int getID() {

		return id;
	}

	public boolean getSpontaneity() {

		return automaticlyHappen;
	}

	public String getTitle() {

		return title;
	}

	public void setDescription(String substring) {

		description = substring;
	}

	public void setPlace(String substring) {

		place = substring;
	}

	public ArrayList<Option> getOptionList() {

		return optionList;
	}
	public String getDescription(){
		
		return description;
	}

	public String getPlace() {

		return place;
	}
}
