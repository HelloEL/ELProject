package mainPanel;

import javax.swing.JFrame;

public class Frame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void setUp() {
		JFrame frame = new JFrame();// TODO �Զ����ɵķ������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 768);
		frame.setVisible(true);//set up basic framework
	}

}
