package initialAnimation;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class InitialAnimation {
	
	

	public static void starts() {
		
		JFrame mf = new JFrame();
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setSize(1024, 768);
		mf.setBackground(Color.black);
		mf.setVisible(true);
		
		MoviePanel Opening1 = new MoviePanel("Opening 1");
		mf.getContentPane().add(BorderLayout.CENTER,Opening1);
		Opening1.playMovie();//play the first clip;		
		
		// TODO 自动生成的方法存根
		//display the picture Zou Hanzhen chooses
	}

}
