package crisisAndEvent;

import java.util.ArrayList;


public class CrisisLoader {
	
	
	public void loadCrisis(ArrayList<String> formula) {
		// TODO 自动生成的方法存根

		Crisis crisis = new Crisis();
		
		//找到crisis描述中每个分节点的位置
		int firstSpace = formula.get(0).indexOf(' ', 3);
		int firstParenthesis = formula.get(0).indexOf('|');
		int secondParenthesis = formula.get(0).indexOf('|', firstParenthesis + 1 );
		int thirdParenthesis = formula.get(0).indexOf('|', secondParenthesis + 1 );
		
		//将formula中有关crisis的描述加载到crisis中
		crisis.setID(Integer.parseInt(formula.get(0).substring(3, firstSpace)));
		crisis.setTitle(formula.get(0).substring(firstSpace + 1, firstParenthesis));
		crisis.setDescription(formula.get(0).substring(firstParenthesis + 1, secondParenthesis));
		crisis.setPlace(formula.get(0).substring(secondParenthesis + 1, thirdParenthesis));
		
		//通过循环来一次性给三个option赋值
		for(int count = 0 ; count < Crisis.NUMBER_OF_OPTION;count ++){//count表示option的编号
			
			//找到option描述中每个分节点的位置
			int firstInterruption = formula.get(count+1).indexOf('|', 0 );//应该是7
			int secondInterruption = formula.get(count+1).indexOf('|', firstInterruption + 1 );
			int thirdInterruption = formula.get(count+1).indexOf('|', secondInterruption + 1 );
			int forthInterruption = formula.get(count+1).indexOf('|', thirdInterruption + 1 );
			
			Option option = new Option();
			
			//设置option的详细描述
			option.setDescription(formula.get(count+1).substring(firstInterruption + 1, secondInterruption));
			
//			通过循环来一次性给所有的参数改变量赋值
			for(int spacePosition = formula.get(count+1).indexOf(' ', secondInterruption), counter = 0;
					spacePosition <= thirdInterruption;
					spacePosition = formula.get(count+1).indexOf(' ', formula.get(count+1).
							indexOf(' ', spacePosition + 1) + 1)){
				
//				顺序是这样的 ：sf -0 lszz +0 lscb +0 lsxx -0 jk -1 sl +10 my -0 popu -0
//				顺序不能乱！！！
				
				int nextSpacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1);
				
//				counter来控制给哪个参数赋值，以顺序的方式从左向右移动
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
//				如果最后一个空格的位置接壤第三个‘|’，那么说明参数完全设置完毕，跳出循环
				if(nextSpacePosition + 1 == thirdInterruption){
					break;
				}				
			}
			
			//通过循环来一次性设置option的所有“下一个事件或危机”
			for(int spacePosition = thirdInterruption;
					spacePosition <= forthInterruption;
					spacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1)){
				
				int nextSpacePosition = formula.get(count+1).indexOf(' ', spacePosition + 1);
				if(nextSpacePosition == -1){//如果下一个空格不存在，说明已到达最后一个空格
					nextSpacePosition = forthInterruption;
				}
				
				//将这个数字添加到arraylist中
				option.getNextEvOrCrList().add(Integer.parseInt(formula.get(count+1).
						substring(spacePosition+1, nextSpacePosition)));
				
				if(nextSpacePosition == forthInterruption){//如果下一个空格不存在，说明已到达最后一个空格
					break;
				}				
			}
			//将这个option添加到crisis当中去
			crisis.getOptionList().add(option);
		}
		
		crisis.setSpontaneity();

//		将这个crisis添加到gameMainBody中的crisisList中去
		LoaderController.gameMainBody.getCrisisList().add(crisis);
		//应该在MainPanel中创建这个对象,这里为了方便测试，先创建，之后再换成Mainpanel中的 TODO
		
	}
}
