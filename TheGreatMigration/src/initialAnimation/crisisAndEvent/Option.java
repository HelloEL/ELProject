package crisisAndEvent;

import java.util.ArrayList;

import gameMainGUI.GUICommander;
import maincontroller.Parameter;

public class Option {

	private ArrayList<Integer> nextEvOrCrList;
	
	private String description;
	
	private int sfChange;//失分
	private int lscbChange;//粮食储备
	private int lszzChange;//粮食增长
	private int lsxxChange;//粮食消耗
	private int jkChange;//健康
	private int slChange;//骚乱
	private int myChange;//满意
	private int popuChange;//人口
	
	
	public Option(){
		nextEvOrCrList = new ArrayList<Integer>();
		sfChange = 0;
		lszzChange = 0;
		lsxxChange = 0;
		jkChange = 0;
		slChange = 0;
		myChange = 0;
	}
	
	public void clicked(){
//		在mainpanel中创建GameMainBody实例，然后这边引用那里的实例
//		GameMainBody.timeContinue();
		Parameter.update(sfChange,lszzChange,lsxxChange,jkChange,
				slChange,myChange);
		GUICommander.closeCrisisShown();
		GUICommander.updateParameter();
	}

	public void setDescription(String substring) {
		// TODO 自动生成的方法存根
		description = substring;
	}

	public void setSfChange(int parseInt) {
		// TODO 自动生成的方法存根
		sfChange = parseInt;
	}
	public void setLszzChange(int parseInt) {
		// TODO 自动生成的方法存根
		lszzChange = parseInt;
	}
	public void setLscbChange(int parseInt) {
		// TODO 自动生成的方法存根
		lscbChange = parseInt;
	}
	public void setLsxxChange(int parseInt) {
		// TODO 自动生成的方法存根
		lsxxChange = parseInt;
	}
	public void setPopuChange(int parseInt) {
		// TODO 自动生成的方法存根
		popuChange = parseInt;
	}
	public void setSlChange(int parseInt) {
		// TODO 自动生成的方法存根
		slChange = parseInt;
	}
	public void setMyChange(int parseInt) {
		// TODO 自动生成的方法存根
		myChange = parseInt;
	}
	public void setJkChange(int parseInt) {
		// TODO 自动生成的方法存根
		jkChange = parseInt;
	}
	
	public int getSfChange() {
		// TODO 自动生成的方法存根
		return sfChange ;
	}
	public int getJkChange() {
		// TODO 自动生成的方法存根
		return jkChange ;
	}
	public int getPopuChange() {
		// TODO 自动生成的方法存根
		return popuChange ;
	}
	public int getSlChange() {
		// TODO 自动生成的方法存根
		return slChange ;
	}
	public int getLscbChange() {
		// TODO 自动生成的方法存根
		return lscbChange ;
	}
	public int getLszzChange() {
		// TODO 自动生成的方法存根
		return lszzChange ;
	}
	public int getLsxxChange() {
		// TODO 自动生成的方法存根
		return lsxxChange ;
	}
	public int getMyChange() {
		// TODO 自动生成的方法存根
		return myChange ;
	}
	

	public ArrayList<Integer> getNextEvOrCrList() {
		// TODO 自动生成的方法存根
		return nextEvOrCrList;
	}

	public String getDescription() {
		// TODO 自动生成的方法存根
		return description;
	}
}
