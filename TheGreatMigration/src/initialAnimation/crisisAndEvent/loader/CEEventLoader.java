package crisisAndEvent.loader;

import java.util.ArrayList;

import crisisAndEvent.CrisisEngenderingEvent;

public class CEEventLoader {

	public void loadCEEvent(ArrayList<String> formula) {

//		�����µĶ���
		CrisisEngenderingEvent ceEvent = new CrisisEngenderingEvent();
		
//		ȷ��formula�еķֽڵ�
		int firstSpace = formula.get(0).indexOf(' ');
		int secondSpace = formula.get(0).indexOf(' ', firstSpace + 1);
		int firstParenthesis = formula.get(0).indexOf('|');
		int secondParenthesis = formula.get(0).indexOf('|',firstParenthesis + 1);
		int thirdParenthesis = formula.get(0).indexOf('|',secondParenthesis + 1);
		int forthParenthesis = formula.get(0).indexOf('|',thirdParenthesis + 1);
		int fifthParenthesis = formula.get(0).indexOf('|',forthParenthesis + 1);
		int sixthParenthesis = formula.get(0).indexOf('|',fifthParenthesis + 1);
		
//		����ceEvent�еĲ���
		ceEvent.setTitle(formula.get(0).substring(secondSpace + 1, firstParenthesis));
		ceEvent.setDescription(formula.get(0).substring(firstParenthesis + 1, secondParenthesis));
		ceEvent.setPlace(formula.get(0).substring(secondParenthesis + 1, thirdParenthesis));
		ceEvent.setIdentifier(Integer.parseInt((formula.get(0).substring(firstSpace + 1, secondSpace))));
		
//		����������ceEvent�ı߽���Ϣ�Ĵ���
		String brimInfo = formula.get(0).substring(forthParenthesis + 1, fifthParenthesis).concat(" ");
		
		for(int evenSpacePosition = -1, oddSpacePosition = brimInfo.indexOf(' ', 0);;){
			
//			���brimInfo̫�̣�˵���û�û�����ñ߽���Ϣ������ѭ����������
			if(brimInfo.length() <= 2){
				break;
			}
			int nESPosition = brimInfo.indexOf(' ', oddSpacePosition + 1);
			
			switch(brimInfo.substring(evenSpacePosition + 1, oddSpacePosition)){
			case "lszzdown":ceEvent.setLszzDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lsxxdown":ceEvent.setLsxxDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lscbdown":ceEvent.setLscbDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "sldown":ceEvent.setSlDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "jkdown":ceEvent.setJkDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "mydown":ceEvent.setMyDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "popudown":ceEvent.setPopuDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lszzup":ceEvent.setLszzUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lsxxup":ceEvent.setLsxxUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lscbup":ceEvent.setLscbUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "slup":ceEvent.setSlUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "jkup":ceEvent.setJkUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "myup":ceEvent.setMyUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "popuup":ceEvent.setPopuUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			default:System.out.println("format error (in xxxxup or xxxxdown) in CEEvent with description: "
			                                       +ceEvent.getDescription());
			}
			
//			����һ��ż����λ�õ�����ĩ��ʱ��˵��������
			if(nESPosition == brimInfo.length() - 1){
				break;
			}
			
//			ÿһ�Σ�ż���ո��λ�ú������ո��λ��ͬʱ��ǰ��λŲ��
			evenSpacePosition = nESPosition;
			oddSpacePosition = brimInfo.indexOf(' ', nESPosition + 1);
		}
		
		
		
		//ͨ��ѭ����һ��������reEvent�����С���һ���������¼���Σ����
		for(int spacePosition = fifthParenthesis;
				spacePosition <= sixthParenthesis;
				spacePosition = formula.get(0).indexOf(' ', spacePosition + 1)){
			
			int nextSpacePosition = formula.get(0).indexOf(' ', spacePosition + 1);
			
			if(nextSpacePosition == -1){//�����һ���ո񲻴��ڣ�˵���ѵ������һ���ո�
				nextSpacePosition = sixthParenthesis;
			}
			
			//�����������ӵ�Arraylist��
			ceEvent.getNextEvOrCrList().add(Integer.parseInt(formula.get(0).
					substring(spacePosition+1, nextSpacePosition)));
			
			if(nextSpacePosition == sixthParenthesis){//�����һ���ո񲻴��ڣ�˵���ѵ������һ���ո�
				break;
			}				
		}
		
		
		
//		����CEEvent��change��Ϣ
		String changeInfo = formula.get(0).substring(thirdParenthesis + 1, forthParenthesis).concat(" ");
		
		for(int evenSpacePosition = -1, oddSpacePosition = changeInfo.indexOf(' ', 0);;){
			
			if(changeInfo.length() <= 2){//�������û���ݣ��Ͳ���������Ϣ������ѭ��
				break;
			}
			int nESPosition = changeInfo.indexOf(' ', oddSpacePosition + 1);
			
			switch(changeInfo.substring(evenSpacePosition + 1, oddSpacePosition)){
			case "lszz":ceEvent.setLszzChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lsxx":ceEvent.setLsxxChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lscb":ceEvent.setLscbChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "sl":ceEvent.setSlChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "jk":ceEvent.setJkChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "my":ceEvent.setMyChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "popu":ceEvent.setPopuChange(Integer.parseInt(changeInfo.substring(oddSpacePosition+1, nESPosition)));break;
			default:System.out.println("format error (in xxxxchange) in CEEvent with description: "+ceEvent.getDescription());
			}
			
//			����һ��ż����λ�õ�����ĩ��ʱ��˵��������
			if(nESPosition == changeInfo.length() - 1){
				break;
			}
			
//			ÿһ�Σ�ż���ո��λ�ú������ո��λ��ͬʱ��ǰ��λŲ��
			evenSpacePosition = nESPosition;
			oddSpacePosition = changeInfo.indexOf(' ', nESPosition + 1);
		}
		

		
		
		
		
		
		
//		���ceEvent�ĸ����±߽��Ƿ��д����ϱ߽�����������У��ͱ���Ȼ�󲻵������ceEvent
		if(!ceEvent.inspectUpIsBiggerThanDown()){
			System.out.println("the crisis-engendering event with description: " + ceEvent.getDescription());
			System.out.println("have error: the down prim is bigger than the up prim");
			return;
		}
		
//		����ceEvent���Է��ԣ�����ceEvent��id�Ƿ�Ϊ����ȷ���Ƿ��Է�
		ceEvent.setSpontaneity();
		
//		�����ceEvent��ӵ�gameMainBody�е�crisisList��ȥ
		LoaderController.gameMainBody.getCrisisEngenderingEventList().add(ceEvent);
		//Ӧ����MainPanel�д����������,����Ϊ�˷�����ԣ��ȴ�����֮���ٻ���Mainpanel�е� TODO
	}

}
