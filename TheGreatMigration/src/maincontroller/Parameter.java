package maincontroller;

public class Parameter {

	private static int score = 0;//几分十几分地往上加
	private static int foodReserve = 10000;
	private static int foodIncreaseRate = 1250;
	private static int foodDecreaseRate = 1050;
	private static int population = 12500;//单位不妨设为：万人
	private static int averageHealth = 95;//百分制
	private static int degreeOfChaos = 2;//when it comes to 100,game over
	private static int averageSatisfaction = 80;//这个降低到一定程度时，会是混乱度增加
	private static int day = 0;//count time
	private static int timeInDay = 80;//0 <= timeInDay <= SECOND_PER_DAY，我也不记得这个参数是用来干嘛的了，艹
	private static int migrationSpeed = 80;//迁移速度，每三秒钟都会去影响population，太快会使玩家眼花
	
	
	
	public static void inspection() {//每秒参数自查，用于触发事件
		// TODO 自动生成的方法存根
		//inspect whether a parameter touches the brim
		//and thus cause an event
	}

	public static void update(int sfChange, int lszzChange, int lsxxChange,
			int jkChange, int slChange, int myChange) {//由option方法引起的参数改编
		// TODO 自动生成的方法存根
		
		
	}


}
