package crisisAndEvent;

import java.util.ArrayList;

public class CrisisEngenderingEvent extends Event{

	private int id;
	private boolean automaticlyHappen = false;
	//���Ӳ�������ʾĳЩ�¼�����������仯���������ִ��ή����ʳ����
	private int sfChange;//ʧ��
	private int lscbChange;//��ʳ����
	private int lszzChange;//��ʳ����
	private int lsxxChange;//��ʳ����
	private int jkChange;//����
	private int slChange;//ɧ��
	private int myChange;//����
	private int popuChange;//�˿�
	
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
