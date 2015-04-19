package maincontroller;

import mainPanel.Frame;
import mainPanel.MainPanel;
import initialAnimation.InitialAnimation;
import crisisAndEvent.CrisisLoader;
public class GameLauncher {

	public static void main(String args[]){
		
		Frame.setUp();
		InitialAnimation.starts();
		
		MainPanel.setUp();
	}
}
