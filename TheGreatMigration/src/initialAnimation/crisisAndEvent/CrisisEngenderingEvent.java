package crisisAndEvent;

import java.util.ArrayList;

public class CrisisEngenderingEvent extends Event{

	private int id;
	private boolean automaticlyHappen = false;
	//增加参数，表示某些事件会引起参数变化，比如粮仓大火会降低粮食储备
	private int sfChange;//失分
	private int lscbChange;//粮食储备
	private int lszzChange;//粮食增长
	private int lsxxChange;//粮食消耗
	private int jkChange;//健康
	private int slChange;//骚乱
	private int myChange;//满意
	private int popuChange;//人口
	
	private ArrayList<Integer> nextEvOrCrList;
	
	public CrisisEngenderingEvent() {
		setNextEvOrCrList(new ArrayList<Integer>());
	}
	public void setSpontaneity() {

		if(id == 0)
			automaticlyHappen = true;
		else
			automaticlyHappen = false;
	}

	public int getIdentifier() {
		return id;
	}

	public void setIdentifier(int identifier) {
		this.id = identifier;
	}

	public int getSfChange() {
		return sfChange;
	}

	public void setSfChange(int sfChange) {
		this.sfChange = sfChange;
	}

	public int getLscbChange() {
		return lscbChange;
	}

	public void setLscbChange(int lscbChange) {
		this.lscbChange = lscbChange;
	}

	public int getPopuChange() {
		return popuChange;
	}

	public void setPopuChange(int popuChange) {
		this.popuChange = popuChange;
	}

	public int getMyChange() {
		return myChange;
	}

	public void setMyChange(int myChange) {
		this.myChange = myChange;
	}

	public int getSlChange() {
		return slChange;
	}

	public void setSlChange(int slChange) {
		this.slChange = slChange;
	}

	public int getJkChange() {
		return jkChange;
	}

	public void setJkChange(int jkChange) {
		this.jkChange = jkChange;
	}

	public ArrayList<Integer> getNextEvOrCrList() {
		return nextEvOrCrList;
	}

	public void setNextEvOrCrList(ArrayList<Integer> nextEvOrCrList) {
		this.nextEvOrCrList = nextEvOrCrList;
	}

	public int getLsxxChange() {
		return lsxxChange;
	}

	public void setLsxxChange(int lsxxChange) {
		this.lsxxChange = lsxxChange;
	}

	public int getLszzChange() {
		return lszzChange;
	}

	public void setLszzChange(int lszzChange) {
		this.lszzChange = lszzChange;
	}

	public boolean isAutomaticlyHappen() {
		return automaticlyHappen;
	}

	public void setAutomaticlyHappen(boolean automaticlyHappen) {
		this.automaticlyHappen = automaticlyHappen;
	}
}
