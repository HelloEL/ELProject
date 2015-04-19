package crisisAndEvent;

import gameMainGUI.GUICommander;
import maincontroller.GameMainBody;
import maincontroller.Parameter;

public class Option {

	int identifier;
	
	String description;
	
	int sfChange;
	int lszzChange;
	int lsxxChange;
	int jkChange;
	int slChange;
	int myChange;
	
	
	Crisis nextCrisis;
	
	Option(){
		nextCrisis = null;
		sfChange = 0;
		lszzChange = 0;
		lsxxChange = 0;
		jkChange = 0;
		slChange = 0;
		myChange = 0;
	}
	
	public void clicked(){
		GameMainBody.timeContinue();
		Parameter.update(sfChange,lszzChange,lsxxChange,jkChange,
				slChange,myChange);
		GUICommander.closeCrisisShown();
		GUICommander.updateParameter();
	}
}
