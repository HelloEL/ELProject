package initialAnimation;

import java.awt.*;

import javax.swing.*;

public class ShowPictures extends JPanel{
	
	String filename = null;
	
	public ShowPictures(String filename){
		filename = this.filename;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g){
		Image image = new ImageIcon(filename).getImage();
		g.drawImage(image, 0, 0, this);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void go(){
		this.repaint();
	}

}
