package initialAnimation;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class MoviePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int indexOfImage = 1;
	File[] pictures;
	File image;
	
	public MoviePanel(String filename){
		pictures = this.getPictures(filename);
	}
	
	private File[] getPictures(String filename){
		File fileFolder = new File(filename);
		pictures = fileFolder.listFiles();
		return pictures;
	}
	
	public void paint(Graphics g){
		Image image = new ImageIcon(pictures[indexOfImage].getPath()).getImage();
		g.drawImage(image, 0, 166, null);
	}
	
	public void playMovie(){
		while(indexOfImage <= pictures.length){
			this.repaint();
			
			try{
				Thread.sleep(45);
			}catch(Exception e){
				e.printStackTrace();
			}
			indexOfImage++;

			if(indexOfImage == pictures.length)
				this.setVisible(false);
		}
	}
	
}
