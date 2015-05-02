package initialAnimation;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class MoviePanel extends JPanel{
	private int indexOfImage = 0;
	
	public void MoviePanel(String filename){
		File[] images = this.getFiles(filename);
	}
	
	public File[] getFiles(String filepath){
		File fileFolder = new File(filepath);
		File[] pictures = fileFolder.listFiles();
		return pictures;
	}
	
	public void paint(Graphics g){
		
	}
	
	public void playmovie(){
		
	}
}
