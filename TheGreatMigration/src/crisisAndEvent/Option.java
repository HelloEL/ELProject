package crisisAndEvent;

import java.util.ArrayList;

import gameMainGUI.GUICommander;
import maincontroller.GameMainBody;
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
	
	private Crisis nextCrisis;
	
	Option(){
		nextEvOrCrList = new ArrayList<Integer>();
		nextCrisis = null;
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

	public void setSFChange(int parseInt) {
		// TODO �Զ����ɵķ������
		sfChange = parseInt;
	}
	public void setLSZZChange(int parseInt) {
		// TODO �Զ����ɵķ������
		lszzChange = parseInt;
	}
	public void setLSCBChange(int parseInt) {
		// TODO �Զ����ɵķ������
		lscbChange = parseInt;
	}
	public void setLSXXChange(int parseInt) {
		// TODO �Զ����ɵķ������
		lsxxChange = parseInt;
	}
	public void setPOPUChange(int parseInt) {
		// TODO �Զ����ɵķ������
		popuChange = parseInt;
	}
	public void setSLChange(int parseInt) {
		// TODO �Զ����ɵķ������
		slChange = parseInt;
	}
	public void setMYChange(int parseInt) {
		// TODO �Զ����ɵķ������
		myChange = parseInt;
	}
	public void setJKChange(int parseInt) {
		// TODO �Զ����ɵķ������
		jkChange = parseInt;
	}
	
	public int getSFChange() {
		// TODO �Զ����ɵķ������
		return sfChange ;
	}
	public int getJKChange() {
		// TODO �Զ����ɵķ������
		return jkChange ;
	}
	public int getPOPUChange() {
		// TODO �Զ����ɵķ������
		return popuChange ;
	}
	public int getSLChange() {
		// TODO �Զ����ɵķ������
		return slChange ;
	}
	public int getLSCBChange() {
		// TODO �Զ����ɵķ������
		return lscbChange ;
	}
	public int getLSZZChange() {
		// TODO �Զ����ɵķ������
		return lszzChange ;
	}
	public int getLSXXChange() {
		// TODO �Զ����ɵķ������
		return lsxxChange ;
	}
	public int getMYChange() {
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
