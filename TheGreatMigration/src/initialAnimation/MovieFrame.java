package initialAnimation;

import javax.swing.JFrame;

import java.awt.*;


public class MovieFrame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void setUp(){
	
		JFrame movieFrame = new JFrame();
		movieFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		movieFrame.setSize(1024, 768);
		movieFrame.setVisible(true);
		
		movieFrame.getContentPane().add(BorderLayout.CENTER,MoviePanel);
	}
}
