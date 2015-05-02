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
	
	public static GameMainBody gameMainBody;//Ӧ����MainPanel�д����������,����Ϊ�˷�����ԣ��ȴ�����֮���ٻ���Mainpanel�е� TODO
	
	public LoaderController() {//���췽��

		gameMainBody = new GameMainBody();//Ӧ����MainPanel�д����������,����Ϊ�˷�����ԣ��ȴ�����֮���ٻ���Mainpanel�е� TODO
		
		crisisLoader = new CrisisLoader();
		ceEventLoader = new CEEventLoader();
		reEventLoader = new REEventLoader();
	}

	public boolean loadCrisisAndEvent() {
//		���ó�boolean��Ϊ��junit���Է��㣬���ڿ��Ժܿ�ظ�Ϊvoid�ͣ�����boolean�Ͳ���Ҳ����
		
//		To load the file to create crisis
		File file = new File("./src/Crisis.txt");//�����￪ʼ��һ�δ����Ƕ�ȡ�ļ�����Ҫ��
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
				
//				��һ��formula�洢��һ����Ϣ����������branch loader ȥ����
				ArrayList<String> formula = new ArrayList<String>();
				String tempStr = br.readLine();
				
//				���ļ��еļ�����Ϣ����formula
				do{
					formula.add(tempStr);
					tempStr = br.readLine();
				}while(!tempStr.equals("-") && !tempStr.equals("END"));
				
//				��formula����branch loaderȥ����
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
				
				if(tempStr.equals("END")){//�������ļ�ĩβ����END�ַ���ʱ������
					try {
						br.close();
						return false;
					} catch (IOException e) {e.printStackTrace();}
					
				}
			}
		}catch(Exception ex){ System.out.println("��ȡ�ļ����ݳ���");ex.printStackTrace();}
		
		try {
			br.close();
		} catch (IOException e) {e.printStackTrace();}
		return false;
	}

	
}
