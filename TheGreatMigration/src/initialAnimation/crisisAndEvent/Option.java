package crisisAndEvent;

import java.util.ArrayList;

import gameMainGUI.GUICommander;
import maincontroller.Parameter;

public class Option {

	private ArrayList<Integer> nextEvOrCrList;
	
	private String description;
	
	private int sfChange;//ʧ��
	private int lscbChange;//��ʳ����
	private int lszzChange;//��ʳ����
	private int lsxxChange;//��ʳ����
	private int jkChange;//����
	private int slChange;//ɧ��
	private int myChange;//����
	private int popuChange;//�˿�
	
	
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
//		��mainpanel�д���GameMainBodyʵ����Ȼ��������������ʵ��
//		GameMainBody.timeContinue();
		Parameter.update(sfChange,lszzChange,lsxxChange,jkChange,
				slChange,myChange);
		GUICommander.closeCrisisShown();
		GUICommander.updateParameter();
	}

	public void setDescription(String substring) {
		// TODO �Զ����ɵķ������
		description = substring;
	}

	public void setSfChange(int parseInt) {
		// TODO �Զ����ɵķ������
		sfChange = parseInt;
	}
	public void setLszzChange(int parseInt) {
		// TODO �Զ����ɵķ������
		lszzChange = parseInt;
	}
	public void setLscbChange(int parseInt) {
		// TODO �Զ����ɵķ������
		lscbChange = parseInt;
	}
	public void setLsxxChange(int parseInt) {
		// TODO �Զ����ɵķ������
		lsxxChange = parseInt;
	}
	public void setPopuChange(int parseInt) {
		// TODO �Զ����ɵķ������
		popuChange = parseInt;
	}
	public void setSlChange(int parseInt) {
		// TODO �Զ����ɵķ������
		slChange = parseInt;
	}
	public void setMyChange(int parseInt) {
		// TODO �Զ����ɵķ������
		myChange = parseInt;
	}
	public void setJkChange(int parseInt) {
		// TODO �Զ����ɵķ������
		jkChange = parseInt;
	}
	
	public int getSfChange() {
		// TODO �Զ����ɵķ������
		return sfChange ;
	}
	public int getJkChange() {
		// TODO �Զ����ɵķ������
		return jkChange ;
	}
	public int getPopuChange() {
		// TODO �Զ����ɵķ������
		return popuChange ;
	}
	public int getSlChange() {
		// TODO �Զ����ɵķ������
		return slChange ;
	}
	public int getLscbChange() {
		// TODO �Զ����ɵķ������
		return lscbChange ;
	}
	public int getLszzChange() {
		// TODO �Զ����ɵķ������
		return lszzChange ;
	}
	public int getLsxxChange() {
		// TODO �Զ����ɵķ������
		return lsxxChange ;
	}
	public int getMyChange() {
		// TODO �Զ����ɵķ������
		return myChange ;
	}
	

	public ArrayList<Integer> getNextEvOrCrList() {
		// TODO �Զ����ɵķ������
		return nextEvOrCrList;
	}

	public String getDescription() {
		// TODO �Զ����ɵķ������
		return description;
	}
}
