package maincontroller;

import mainPanel.Frame;
import mainPanel.MainPanel;
import initialAnimation.InitialAnimation;
public class GameLauncher {

	public static void main(String args[]){
		
		Frame.setUp();//初始化GUI框架
		InitialAnimation.starts();//播放开场动画
		
		MainPanel.setUp();//打开主界面，然后由主界面控制进入主游戏类GameMainBody
	}
}
