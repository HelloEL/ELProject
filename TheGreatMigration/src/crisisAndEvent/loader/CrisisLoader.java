package crisisAndEvent.loader;

import java.util.ArrayList;

import crisisAndEvent.Crisis;
import crisisAndEvent.Option;


public class CrisisLoader {
	
	
	public void loadCrisis(ArrayList<String> formula) {

		Crisis crisis = new Crisis();
		
//		�ҵ�crisis������ÿ���ֽڵ��λ��
		int firstSpace = formula.get(0).indexOf(' ', 3);
		int firstParenthesis = formula.get(0).indexOf('|');
		int secondParenthesis = formula.get(0).indexOf('|', firstParenthesis + 1 );
		int thirdParenthesis = formula.get(0).indexOf('|', secondParenthesis + 1 );
		
//		��formula���й�crisis���������ص�crisis��
		crisis.setID(Integer.parseInt(formula.get(0).substring(3, firstSpace)));
		crisis.setTitle(formula.get(0).substring(firstSpace + 1, firstParenthesis));
		crisis.setDescription(formula.get(0).substring(firstParenthesis + 1, secondParenthesis));
		crisis.setPlace(formula.get(0).substring(secondParenthesis + 1, thirdParenthesis));
		
//		ͨ��ѭ����һ���Ը�����option��ֵ
		for(int count = 0 ; count < Crisis.NUMBER_OF_OPTION;count ++){//count��ʾoption�ı��
			
//			�ҵ�option������ÿ���ֽڵ��λ��
			int firstInterruption = formula.get(count+1).indexOf('|', 0 );//Ӧ����7
			int secondInterruption = formula.get(count+1).indexOf('|', firstInterruption + 1 );
			int thirdInterruption = formula.get(count+1).indexOf('|', secondInterruption + 1 );
			int forthInterruption = formula.get(count+1).indexOf('|', thirdInterruption + 1 );
			
			Option option = new Option();
			
//			����option����ϸ������description��
			option.setDescription(formula.get(count+1).substring(firstInterruption + 1, secondInterruption));
			
//			����Option��Change����ϸ��Ϣ
			String changeInfo = formula.get(count+1).substring(secondInterruption + 1, thirdInterruption).concat(" ");
			
			for(int evenSpacePosition = -1, oddSpacePosition = changeInfo.indexOf(' ', 0);;){
				
				if(changeInfo.length() <= 2){//�������û���ݣ��Ͳ���������Ϣ������ѭ��
					break;
				}
				int nESPosition = changeInfo.indexOf(' ', oddSpacePosition + 1);
				
				switch(changeInfo.substring(evenSpacePosition + 1, oddSpacePosition)){
				case "sf":option.setSfChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
				case "lszz":option.setLszzChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
				case "lsxx":option.setLsxxChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
				case "lscb":option.setLscbChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
				case "sl":option.setSlChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
				case "jk":option.setJkChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
				case "my":option.setMyChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
				case "popu":option.setPopuChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
				default:System.out.println("format error (in xxxxchange) in option with description: "+option.getDescription());
				}
				
//				����һ��ż����λ�õ�����ĩ��ʱ��˵��������
				if(nESPosition == changeInfo.length() - 1){
					break;
				}
				
//				ÿһ�Σ�ż���ո��λ�ú������ո��λ��ͬʱ��ǰ��λŲ��
				evenSpacePosition = nESPosition;
				oddSpacePosition = changeInfo.indexOf(' ', nESPosition + 1);
			}
			
//			ͨ��ѭ����һ��������option�����С���һ���¼���Σ����
			for(int spacePosition = thirdInterruption;
					spacePosition <= forthInterruption;
					spacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1)){
				
				int nextSpacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1);
				
				if(nextSpacePosition == -1){//�����һ���ո񲻴��ڣ�˵���ѵ������һ���ո�
					nextSpacePosition = forthInterruption;
				}
				
//				�����������ӵ�arraylist��
				option.getNextEvOrCrList().add(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));
				
				if(nextSpacePosition == forthInterruption){//�����һ���ո񲻴��ڣ�˵���ѵ������һ���ո�
					break;
				}				
			}
//			�����option��ӵ�crisis����ȥ
			crisis.getOptionList().add(option);
		}
		
//		����crisis���Է��ԣ�����crisis��id�Ƿ�Ϊ����ȷ���Ƿ��Է�
		crisis.setSpontaneity();

//		�����crisis��ӵ�gameMainBody�е�crisisList��ȥ
		LoaderController.gameMainBody.getCrisisList().add(crisis);
//		Ӧ����MainPanel�д����������,����Ϊ�˷�����ԣ��ȴ�����֮���ٻ���Mainpanel�е� TODO
		
	}
}
