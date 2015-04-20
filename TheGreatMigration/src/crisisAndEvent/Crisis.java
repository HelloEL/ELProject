package crisisAndEvent;

public class Crisis {

	boolean isAutomaticlyHappen = false;
	private String kind;
	private String description;
	private Option option1,option2,option3,option4;
	private String place;
	
	Crisis(){
		option1 = new Option();
		option2 = new Option();
		option3 = new Option();
		option4 = new Option();
	}
}
