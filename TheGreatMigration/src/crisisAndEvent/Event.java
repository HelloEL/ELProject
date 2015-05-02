package crisisAndEvent;

public class Event {

	String description;
	
	int lszzDown;
	int lsxxDown;
	int jkDown;
	int slDown;
	int myDown;
	int frDown;
	int popuDown;
	
	int lszzUp;
	int lsxxUp;
	int jkUp;
	int slUp;
	int myUp;
	int frUp;
	int popuUp;
	
	//增加参数，表示某些事件会引起参数变化，比如粮仓大火会降低粮食储备
	int sfChange;//失分
	int lscbChange;//粮食储备
	int lszzChange;//粮食增长
	int lsxxChange;//粮食消耗
	int jkChange;//健康
	int slChange;//骚乱
	int myChange;//满意
	int popuChange;//人口
	
	
	
}
