package maincontroller;

import mainPanel.Frame;
import mainPanel.MainPanel;
import initialAnimation.InitialAnimation;
import crisisAndEvent.loader.CrisisLoader;
public class GameLauncher {

	public static void main(String args[]){
		
		Frame.setUp();//��ʼ��GUI���
		InitialAnimation.starts();//���ſ�������
		
		MainPanel.setUp();//�������棬Ȼ������������ƽ�������Ϸ��GameMainBody
	}
}
