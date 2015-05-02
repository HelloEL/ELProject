package crisisAndEvent.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import maincontroller.GameMainBody;

public class LoaderController {
	
	private CrisisLoader crisisLoader;
	private CEEventLoader ceEventLoader;
	private REEventLoader reEventLoader;
	
	public static GameMainBody gameMainBody;//应该在MainPanel中创建这个对象,这里为了方便测试，先创建，之后再换成Mainpanel中的 TODO
	
	public LoaderController() {//构造方法

		gameMainBody = new GameMainBody();//应该在MainPanel中创建这个对象,这里为了方便测试，先创建，之后再换成Mainpanel中的 TODO
		
		crisisLoader = new CrisisLoader();
		ceEventLoader = new CEEventLoader();
		reEventLoader = new REEventLoader();
	}

	public boolean loadCrisisAndEvent() {
//		设置成boolean是为了junit测试方便，后期可以很快地改为void型，不过boolean型不改也无伤
		
//		To load the file to create crisis
		File file = new File("./src/Crisis.txt");//从这里开始的一段代码是读取文件所必要的
		String encoding="GBK";
		InputStreamReader read;
		BufferedReader br = null;
		try{
			if(file.isFile() && file.exists()){
			
				read = new InputStreamReader(
						new FileInputStream(file),encoding);
				br = new BufferedReader(read);
			}
			else{
				System.out.println("Cannot Find the File");
				return false;
			}
			while(true){
				
//				这一段formula存储了一段信息，传给各个branch loader 去处理
				ArrayList<String> formula = new ArrayList<String>();
				String tempStr = br.readLine();
				
//				把文件中的几行信息读入formula
				do{
					formula.add(tempStr);
					tempStr = br.readLine();
				}while(!tempStr.equals("-") && !tempStr.equals("END"));
				
//				将formula传给branch loader去处理
				switch(formula.get(0).substring(0, 2)){
				case "CR": crisisLoader.loadCrisis(formula);break;
				case "CE": ceEventLoader.loadCEEvent(formula);break;
				case "RE": reEventLoader.loadREEvent(formula);break;
				default: System.out.println("Formula's format ERROR!!");
				try {
					br.close();
				} catch (IOException e) {e.printStackTrace();}
				return false;
				}
				
				if(tempStr.equals("END")){//当读到文件末尾：即END字符串时，结束
					try {
						br.close();
						return false;
					} catch (IOException e) {e.printStackTrace();}
					
				}
			}
		}catch(Exception ex){ System.out.println("读取文件内容出错");ex.printStackTrace();}
		
		try {
			br.close();
		} catch (IOException e) {e.printStackTrace();}
		return false;
	}

	
}
