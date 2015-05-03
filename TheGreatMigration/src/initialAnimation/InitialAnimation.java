package initialAnimation;

public class InitialAnimation {
	
	

	public static void starts() {
		
		ShowPictures showPicture1 = new ShowPictures("OpeningImage/OpeningImage1");
		
		showPicture1.go();
		
		MoviePanel Opening1 = new MoviePanel("Opeing1");
		
		Opening1.playMovie();//play the first clip;
		
		ShowPictures showPicture2 = new ShowPictures("OpeningImage/OpeningImage2");
		
		MoviePanel Opening2 = new MoviePanel("Opeing2");
		
		Opening2.playMovie();//play the second clip;
		
		MoviePanel Opening3 = new MoviePanel("Opeing3");
		
		Opening3.playMovie();//play the third clip;
		// TODO 自动生成的方法存根
		//display the picture Zou Hanzhen chooses
	}

}
