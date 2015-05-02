package crisisAndEvent.loader;

import java.util.ArrayList;

import crisisAndEvent.RandomEvent;

public class REEventLoader {

	public void loadREEvent(ArrayList<String> formula) {
		
//		����reEvent����
		RandomEvent reEvent = new RandomEvent();
		
//		ȷ��formula�еķֽڵ�
		int firstSpace = formula.get(0).indexOf(' ');
		int firstParenthesis = formula.get(0).indexOf('|');
		int secondParenthesis = formula.get(0).indexOf('|',firstParenthesis + 1);
		int thirdParenthesis = formula.get(0).indexOf('|',secondParenthesis + 1);
		int forthParenthesis = formula.get(0).indexOf('|',thirdParenthesis + 1);
		int fifthParenthesis = formula.get(0).indexOf('|',forthParenthesis + 1);
		
//		����reEvent�еĲ���
		reEvent.setTitle(formula.get(0).substring(firstSpace + 1, firstParenthesis));
		reEvent.setDescription(formula.get(0).substring(firstParenthesis + 1, secondParenthesis));
		reEvent.setPlace(formula.get(0).substring(secondParenthesis + 1, thirdParenthesis));
		reEvent.setPossibility(Double.parseDouble(formula.get(0).substring(forthParenthesis + 1, fifthParenthesis)));
		
//		����������reEvent�ı߽���Ϣ�Ĵ���
		String brimInfo = formula.get(0).substring(thirdParenthesis + 1, forthParenthesis).concat(" ");
		
		for(int evenSpacePosition = -1, oddSpacePosition = brimInfo.indexOf(' ', 0);;){
			
//			���brimInfo̫�̣�˵���û�û�����ñ߽���Ϣ������ѭ����������
			if(brimInfo.length() <= 2){
				break;
			}
			int nESPosition = brimInfo.indexOf(' ', oddSpacePosition + 1);
			
			switch(brimInfo.substring(evenSpacePosition + 1, oddSpacePosition)){
			case "lszzdown":reEvent.setLszzDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lsxxdown":reEvent.setLsxxDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lscbdown":reEvent.setLscbDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "sldown":reEvent.setSlDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "jkdown":reEvent.setJkDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "mydown":reEvent.setMyDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "popudown":reEvent.setPopuDown(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lszzup":reEvent.setLszzUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lsxxup":reEvent.setLsxxUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "lscbup":reEvent.setLscbUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "slup":reEvent.setSlUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "jkup":reEvent.setJkUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "myup":reEvent.setMyUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			case "popuup":reEvent.setPopuUp(Integer.parseInt(brimInfo.substring(oddSpacePosition+1, nESPosition)));break;
			default:System.out.println("format error (in xxxxup or xxxxdown) in REEvent with description: "
													+reEvent.getDescription());
			}

//			����һ��ż����λ�õ�����ĩ��ʱ��˵��������
			if(nESPosition == brimInfo.length() - 1){
				break;
			}
			
//			ÿһ�Σ�ż���ո��λ�ú������ո��λ��ͬʱ��ǰ��λŲ��
			evenSpacePosition = nESPosition;
			oddSpacePosition = brimInfo.indexOf(' ', nESPosition + 1);
		}
		
//		���reEvent�ĸ����±߽��Ƿ��д����ϱ߽�����������У��ͱ���Ȼ�󲻵������reEvent
		if(!reEvent.inspectUpIsBiggerThanDown()){
			System.out.println("the random event with description: " + reEvent.getDescription());
			System.out.println("have error: the down prim is bigger than the up prim");
			return;
		}
		
//		�����reEvent��ӵ�gameMainBody�е�RandomEventList��ȥ
		LoaderController.gameMainBody.getRandomEventList().add(reEvent);
		//Ӧ����MainPanel�д����������,����Ϊ�˷�����ԣ��ȴ�����֮���ٻ���Mainpanel�е� TODO

	}

}
