package crisisAndEvent.loader;

import java.util.ArrayList;

import crisisAndEvent.CrisisEngenderingEvent;

public class CEEventLoader {

	public void loadCEEvent(ArrayList<String> formula) {

//		创建新的对象
		CrisisEngenderingEvent ceEvent = new CrisisEngenderingEvent();
		
//		确定formula中的分节点
		int firstSpace = formula.get(0).indexOf(' ');
		int secondSpace = formula.get(0).indexOf(' ', firstSpace + 1);
		int firstParenthesis = formula.get(0).indexOf('|');
		int secondParenthesis = formula.get(0).indexOf('|',firstParenthesis + 1);
		int thirdParenthesis = formula.get(0).indexOf('|',secondParenthesis + 1);
		int forthParenthesis = formula.get(0).indexOf('|',thirdParenthesis + 1);
		int fifthParenthesis = formula.get(0).indexOf('|',forthParenthesis + 1);
		int sixthParenthesis = formula.get(0).indexOf('|',fifthParenthesis + 1);
		
//		设置ceEvent中的参数
		ceEvent.setTitle(formula.get(0).substring(secondSpace + 1, firstParenthesis));
		ceEvent.setDescription(formula.get(0).substring(firstParenthesis + 1, secondParenthesis));
		ceEvent.setPlace(formula.get(0).substring(secondParenthesis + 1, thirdParenthesis));
		ceEvent.setIdentifier(Integer.parseInt((formula.get(0).substring(firstSpace + 1, secondSpace))));
		
//		以下是设置ceEvent的边界信息的代码
		String brimInfo = formula.get(0).substring(forthParenthesis + 1, fifthParenthesis).concat(" ");
		
		for(int evenSpacePosition = -1, oddSpacePosition = brimInfo.indexOf(' ', 0);;){
			
//			如果brimInfo太短，说明用户没有设置边界信息，跳出循环，不设置
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
			
//			当下一个偶数的位置到达最末的时候，说明结束了
			if(nESPosition == brimInfo.length() - 1){
				break;
			}
			
//			每一次，偶数空格的位置和奇数空格的位置同时向前间位挪动
			evenSpacePosition = nESPosition;
			oddSpacePosition = brimInfo.indexOf(' ', nESPosition + 1);
		}
		
		
		
		//通过循环来一次性设置reEvent的所有“下一个触发的事件或危机”
		for(int spacePosition = fifthParenthesis;
				spacePosition <= sixthParenthesis;
				spacePosition = formula.get(0).indexOf(' ', spacePosition + 1)){
			
			int nextSpacePosition = formula.get(0).indexOf(' ', spacePosition + 1);
			
			if(nextSpacePosition == -1){//如果下一个空格不存在，说明已到达最后一个空格
				nextSpacePosition = sixthParenthesis;
			}
			
			//将这个数字添加到Arraylist中
			ceEvent.getNextEvOrCrList().add(Integer.parseInt(formula.get(0).
					substring(spacePosition+1, nextSpacePosition)));
			
			if(nextSpacePosition == sixthParenthesis){//如果下一个空格不存在，说明已到达最后一个空格
				break;
			}				
		}
		
		
		
//		设置CEEvent的change信息
		String changeInfo = formula.get(0).substring(thirdParenthesis + 1, forthParenthesis).concat(" ");
		
		for(int evenSpacePosition = -1, oddSpacePosition = changeInfo.indexOf(' ', 0);;){
			
			if(changeInfo.length() <= 2){//如果里面没内容，就不用设置信息，跳出循环
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
			
//			当下一个偶数的位置到达最末的时候，说明结束了
			if(nESPosition == changeInfo.length() - 1){
				break;
			}
			
//			每一次，偶数空格的位置和奇数空格的位置同时向前间位挪动
			evenSpacePosition = nESPosition;
			oddSpacePosition = changeInfo.indexOf(' ', nESPosition + 1);
		}
		

		
		
		
		
		
		
//		检测ceEvent的各项下边界是否有大于上边界的情况，如果有，就报错，然后不导入这个ceEvent
		if(!ceEvent.inspectUpIsBiggerThanDown()){
			System.out.println("the crisis-engendering event with description: " + ceEvent.getDescription());
			System.out.println("have error: the down prim is bigger than the up prim");
			return;
		}
		
//		设置ceEvent的自发性，根据ceEvent的id是否为零来确定是否自发
		ceEvent.setSpontaneity();
		
//		将这个ceEvent添加到gameMainBody中的crisisList中去
		LoaderController.gameMainBody.getCrisisEngenderingEventList().add(ceEvent);
		//应该在MainPanel中创建这个对象,这里为了方便测试，先创建，之后再换成Mainpanel中的 TODO
	}

}
