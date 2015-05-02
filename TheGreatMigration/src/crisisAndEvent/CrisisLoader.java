package crisisAndEvent;

import java.util.ArrayList;


public class CrisisLoader {
	
	
	public void loadCrisis(ArrayList<String> formula) {
		// TODO �Զ����ɵķ������

		Crisis crisis = new Crisis();
		
		//�ҵ�crisis������ÿ���ֽڵ��λ��
		int firstSpace = formula.get(0).indexOf(' ', 3);
		int firstParenthesis = formula.get(0).indexOf('|');
		int secondParenthesis = formula.get(0).indexOf('|', firstParenthesis + 1 );
		int thirdParenthesis = formula.get(0).indexOf('|', secondParenthesis + 1 );
		
		//��formula���й�crisis���������ص�crisis��
		crisis.setID(Integer.parseInt(formula.get(0).substring(3, firstSpace)));
		crisis.setTitle(formula.get(0).substring(firstSpace + 1, firstParenthesis));
		crisis.setDescription(formula.get(0).substring(firstParenthesis + 1, secondParenthesis));
		crisis.setPlace(formula.get(0).substring(secondParenthesis + 1, thirdParenthesis));
		
		//ͨ��ѭ����һ���Ը�����option��ֵ
		for(int count = 0 ; count < Crisis.NUMBER_OF_OPTION;count ++){//count��ʾoption�ı��
			
			//�ҵ�option������ÿ���ֽڵ��λ��
			int firstInterruption = formula.get(count+1).indexOf('|', 0 );//Ӧ����7
			int secondInterruption = formula.get(count+1).indexOf('|', firstInterruption + 1 );
			int thirdInterruption = formula.get(count+1).indexOf('|', secondInterruption + 1 );
			int forthInterruption = formula.get(count+1).indexOf('|', thirdInterruption + 1 );
			
			Option option = new Option();
			
			//����option����ϸ����
			option.setDescription(formula.get(count+1).substring(firstInterruption + 1, secondInterruption));
			
//			ͨ��ѭ����һ���Ը����еĲ����ı�����ֵ
			for(int spacePosition = formula.get(count+1).indexOf(' ', secondInterruption), counter = 0;
					spacePosition <= thirdInterruption;
					spacePosition = formula.get(count+1).indexOf(' ', formula.get(count+1).
							indexOf(' ', spacePosition + 1) + 1)){
				
//				˳���������� ��sf -0 lszz +0 lscb +0 lsxx -0 jk -1 sl +10 my -0 popu -0
//				˳�����ң�����
				
				int nextSpacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1);
				
//				counter�����Ƹ��ĸ�������ֵ����˳��ķ�ʽ���������ƶ�
				switch(counter){
				case 0:option.setSFChange(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));break;
				case 1:option.setLSZZChange(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));break;
				case 2:option.setLSCBChange(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));break;
				case 3:option.setLSXXChange(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));break;
				case 4:option.setJKChange(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));break;
				case 5:option.setSLChange(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));break;
				case 6:option.setMYChange(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));break;
				case 7:option.setPOPUChange(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));break;
				}
				
				counter ++;
//				������һ���ո��λ�ý�����������|������ô˵��������ȫ������ϣ�����ѭ��
				if(nextSpacePosition + 1 == thirdInterruption){
					break;
				}				
			}
			
			//ͨ��ѭ����һ��������option�����С���һ���¼���Σ����
			for(int spacePosition = thirdInterruption;
					spacePosition <= forthInterruption;
					spacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1)){
				
				int nextSpacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1);
				if(nextSpacePosition == -1){//�����һ���ո񲻴��ڣ�˵���ѵ������һ���ո�
					nextSpacePosition = forthInterruption;
				}
				
				//�����������ӵ�arraylist��
				option.getNextEvOrCrList().add(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));
				
				if(nextSpacePosition == forthInterruption){//�����һ���ո񲻴��ڣ�˵���ѵ������һ���ո�
					break;
				}				
			}
			//�����option��ӵ�crisis����ȥ
			crisis.getOptionList().add(option);
		}
		
		crisis.setSpontaneity();

//		�����crisis��ӵ�gameMainBody�е�crisisList��ȥ
		LoaderController.gameMainBody.getCrisisList().add(crisis);
		//Ӧ����MainPanel�д����������,����Ϊ�˷�����ԣ��ȴ�����֮���ٻ���Mainpanel�е� TODO
		
	}
}
