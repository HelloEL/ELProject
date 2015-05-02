package crisisAndEvent.loader;

import java.util.ArrayList;

import crisisAndEvent.RandomEvent;

public class REEventLoader {

	public void loadREEvent(ArrayList<String> formula) {
		
//		创建reEvent对象
		RandomEvent reEvent = new RandomEvent();
		
//		确定formula中的分节点
		int firstSpace = formula.get(0).indexOf(' ');
		int firstParenthesis = formula.get(0).indexOf('|');
		int secondParenthesis = formula.get(0).indexOf('|',firstParenthesis + 1);
		int thirdParenthesis = formula.get(0).indexOf('|',secondParenthesis + 1);
		int forthParenthesis = formula.get(0).indexOf('|',thirdParenthesis + 1);
		int fifthParenthesis = formula.get(0).indexOf('|',forthParenthesis + 1);
		
//		设置reEvent中的参数
		reEvent.setTitle(formula.get(0).substring(firstSpace + 1, firstParenthesis));
		reEvent.setDescription(formula.get(0).substring(firstParenthesis + 1, secondParenthesis));
		reEvent.setPlace(formula.get(0).substring(secondParenthesis + 1, thirdParenthesis));
		reEvent.setPossibility(Double.parseDouble(formula.get(0).substring(forthParenthesis + 1, fifthParenthesis)));
		
//		以下是设置reEvent的边界信息的代码
		String brimInfo = formula.get(0).substring(thirdParenthesis + 1, forthParenthesis).concat(" ");
		
		for(int evenSpacePosition = -1, oddSpacePosition = brimInfo.indexOf(' ', 0);;){
			
//			如果brimInfo太短，说明用户没有设置边界信息，跳出循环，不设置
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

//			当下一个偶数的位置到达最末的时候，说明结束了
			if(nESPosition == brimInfo.length() - 1){
				break;
			}
			
//			每一次，偶数空格的位置和奇数空格的位置同时向前间位挪动
			evenSpacePosition = nESPosition;
			oddSpacePosition = brimInfo.indexOf(' ', nESPosition + 1);
		}
		
//		检测reEvent的各项下边界是否有大于上边界的情况，如果有，就报错，然后不导入这个reEvent
		if(!reEvent.inspectUpIsBiggerThanDown()){
			System.out.println("the random event with description: " + reEvent.getDescription());
			System.out.println("have error: the down prim is bigger than the up prim");
			return;
		}
		
//		将这个reEvent添加到gameMainBody中的RandomEventList中去
		LoaderController.gameMainBody.getRandomEventList().add(reEvent);
		//应该在MainPanel中创建这个对象,这里为了方便测试，先创建，之后再换成Mainpanel中的 TODO

	}

}
