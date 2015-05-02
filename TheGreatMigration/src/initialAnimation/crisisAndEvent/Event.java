package crisisAndEvent;

public abstract class Event {

	private String description;
	private String place;
	private String title;
	
	private int lszzDown = 0;//粮食增长速率下限
	private int lsxxDown = 0;//粮食消耗速率下限
	private int jkDown = 0;//健康下限
	private int slDown = 0;//骚乱下限
	private int myDown = 0;//满意下限
	private int lscbDown = 0;//事物储备下限
	private int popuDown = 0;//人口下限 单位： 万人
	
	private int lszzUp = 900000000;
	private int lsxxUp = 900000000;
	private int jkUp = 900000000;
	private int slUp = 900000000;
	private int myUp = 900000000;
	private int lscbUp = 900000000;
	private int popuUp = 900000000;

		
	public Event(){};
	

	public String getDescription(){		
		return description;
	}
	public String getPlace(){
		return place;
	}
	public String getTitle(){
		return title;
	}
	public void setDescription(String des){
		description = des;
	}
	public void setPlace(String p){
		place = p;
	}
	public void setTitle(String t){
		title = t;
	}


	public int getLszzDown() {
		return lszzDown;
	}


	public void setLszzDown(int lszzDown) {
		this.lszzDown = lszzDown;
	}


	public int getLsxxDown() {
		return lsxxDown;
	}


	public void setLsxxDown(int lsxxDown) {
		this.lsxxDown = lsxxDown;
	}


	public int getJkDown() {
		return jkDown;
	}


	public void setJkDown(int jkDown) {
		this.jkDown = jkDown;
	}


	public int getSlDown() {
		return slDown;
	}


	public void setSlDown(int slDown) {
		this.slDown = slDown;
	}


	public int getMyDown() {
		return myDown;
	}


	public void setMyDown(int myDown) {
		this.myDown = myDown;
	}


	public int getLscbDown() {
		return lscbDown;
	}


	public void setLscbDown(int lscbDown) {
		this.lscbDown = lscbDown;
	}


	public int getPopuDown() {
		return popuDown;
	}


	public void setPopuDown(int popuDown) {
		this.popuDown = popuDown;
	}


	public int getLszzUp() {
		return lszzUp;
	}


	public void setLszzUp(int lszzUp) {
		this.lszzUp = lszzUp;
	}


	public int getLsxxUp() {
		return lsxxUp;
	}


	public void setLsxxUp(int lsxxUp) {
		this.lsxxUp = lsxxUp;
	}


	public int getJkUp() {
		return jkUp;
	}


	public void setJkUp(int jkUp) {
		this.jkUp = jkUp;
	}


	public int getMyUp() {
		return myUp;
	}


	public void setMyUp(int myUp) {
		this.myUp = myUp;
	}


	public int getPopuUp() {
		return popuUp;
	}


	public void setPopuUp(int popuUp) {
		this.popuUp = popuUp;
	}


	public int getLscbUp() {
		return lscbUp;
	}


	public void setLscbUp(int lscbUp) {
		this.lscbUp = lscbUp;
	}


	public int getSlUp() {
		return slUp;
	}


	public void setSlUp(int slUp) {
		this.slUp = slUp;
	}
	public boolean inspectUpIsBiggerThanDown(){
		if(this.lscbDown > this.lscbUp)
			return false;
		if(this.lszzDown > this.lszzUp)
			return false;
		if(this.lsxxDown > this.lsxxUp)
			return false;
		if(this.jkDown > this.jkUp)
			return false;
		if(this.slDown > this.slUp)
			return false;
		if(this.slDown > this.slUp)
			return false;
		if(this.slDown > this.slUp)
			return false;
		
		return true;
	}
}
