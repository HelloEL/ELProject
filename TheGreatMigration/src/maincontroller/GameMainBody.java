package maincontroller;

import mainPanel.MainPanel;
import crisisAndEvent.CrisisLoader;
import crisisAndEvent.EventLoader;
import finalAnimation.FinalAnimation;

public class GameMainBody {

	static final int SECOND_PER_DAY = 3;
	
	void gameMainThread(){
		
		CrisisLoader.loadCrisis();
		EventLoader.loadEvent();
		
		askForInitialPolicy();//such as migration speed
		
		//time begin to pass
		for(int i = 0;i<365;i++){//this should be replaced by a timer,every second will loop one time
		
		Parameter.inspection();
		
		//set a random choice to determine if there is a event.
		//also influenced by parameter inspection
		
		//show new time
//		MainPanel.updateTimeShown(time); 
		}
	
	FinalAnimation.starts();
	}

	private void askForInitialPolicy() {
		// TODO 自动生成的方法存根
		
	}

	public static void timeContinue() {
		// TODO 自动生成的方法存根
		
	}

	public static void timePause() {
		// TODO 自动生成的方法存根
		
	}
}
