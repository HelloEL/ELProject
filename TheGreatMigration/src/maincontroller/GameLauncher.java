package maincontroller;

import mainPanel.Frame;
import mainPanel.MainPanel;
import initialAnimation.InitialAnimation;
public class GameLauncher {

	public static void main(String args[]){

		InitialAnimation.starts();//���ſ�������
		
		Frame.setUp();//��ʼ��GUI���		
		MainPanel.setUp();//�������棬Ȼ������������ƽ�������Ϸ��GameMainBody
	}
}
