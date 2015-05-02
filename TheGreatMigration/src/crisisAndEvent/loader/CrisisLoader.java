package crisisAndEvent.loader;

import java.util.ArrayList;

import crisisAndEvent.Crisis;
import crisisAndEvent.Option;


public class CrisisLoader {
	
	
	public void loadCrisis(ArrayList<String> formula) {

		Crisis crisis = new Crisis();
		
//		找到crisis描述中每个分节点的位置
		int firstSpace = formula.get(0).indexOf(' ', 3);
		int firstParenthesis = formula.get(0).indexOf('|');
		int secondParenthesis = formula.get(0).indexOf('|', firstParenthesis + 1 );
		int thirdParenthesis = formula.get(0).indexOf('|', secondParenthesis + 1 );
		
//		将formula中有关crisis的描述加载到crisis中
		crisis.setID(Integer.parseInt(formula.get(0).substring(3, firstSpace)));
		crisis.setTitle(formula.get(0).substring(firstSpace + 1, firstParenthesis));
		crisis.setDescription(formula.get(0).substring(firstParenthesis + 1, secondParenthesis));
		crisis.setPlace(formula.get(0).substring(secondParenthesis + 1, thirdParenthesis));
		
//		通过循环来一次性给三个option赋值
		for(int count = 0 ; count < Crisis.NUMBER_OF_OPTION;count ++){//count表示option的编号
			
//			找到option描述中每个分节点的位置
			int firstInterruption = formula.get(count+1).indexOf('|', 0 );//应该是7
			int secondInterruption = formula.get(count+1).indexOf('|', firstInterruption + 1 );
			int thirdInterruption = formula.get(count+1).indexOf('|', secondInterruption + 1 );
			int forthInterruption = formula.get(count+1).indexOf('|', thirdInterruption + 1 );
			
			Option option = new Option();
			
//			设置option的详细描述（description）
			option.setDescription(formula.get(count+1).substring(firstInterruption + 1, secondInterruption));
			
//			设置Option中Change的详细信息
			String changeInfo = formula.get(count+1).substring(secondInterruption + 1, thirdInterruption).concat(" ");
			
			for(int evenSpacePosition = -1, oddSpacePosition = changeInfo.indexOf(' ', 0);;){
				
				if(changeInfo.length() <= 2){//如果里面没内容，就不用设置信息，跳出循环
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
				
//				当下一个偶数的位置到达最末的时候，说明结束了
				if(nESPosition == changeInfo.length() - 1){
					break;
				}
				
//				每一次，偶数空格的位置和奇数空格的位置同时向前间位挪动
				evenSpacePosition = nESPosition;
				oddSpacePosition = changeInfo.indexOf(' ', nESPosition + 1);
			}
			
//			通过循环来一次性设置option的所有“下一个事件或危机”
			for(int spacePosition = thirdInterruption;
					spacePosition <= forthInterruption;
					spacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1)){
				
				int nextSpacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1);
				
				if(nextSpacePosition == -1){//如果下一个空格不存在，说明已到达最后一个空格
					nextSpacePosition = forthInterruption;
				}
				
//				将这个数字添加到arraylist中
				option.getNextEvOrCrList().add(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));
				
				if(nextSpacePosition == forthInterruption){//如果下一个空格不存在，说明已到达最后一个空格
					break;
				}				
			}
//			将这个option添加到crisis当中去
			crisis.getOptionList().add(option);
		}
		
//		设置crisis的自发性，根据crisis的id是否为零来确定是否自发
		crisis.setSpontaneity();

//		将这个crisis添加到gameMainBody中的crisisList中去
		LoaderController.gameMainBody.getCrisisList().add(crisis);
//		应该在MainPanel中创建这个对象,这里为了方便测试，先创建，之后再换成Mainpanel中的 TODO
		
	}
}
