package maincontroller;

public class Parameter {

	private static int score = 0;//����ʮ���ֵ����ϼ�
	private static int foodReserve = 10000;
	private static int foodIncreaseRate = 1250;
	private static int foodDecreaseRate = 1050;
	private static int population = 12500;//��λ������Ϊ������
	private static int averageHealth = 95;//�ٷ���
	private static int degreeOfChaos = 2;//when it comes to 100,game over
	private static int averageSatisfaction = 80;//������͵�һ���̶�ʱ�����ǻ��Ҷ�����
	private static int day = 0;//count time
	private static int timeInDay = 80;//0 <= timeInDay <= SECOND_PER_DAY����Ҳ���ǵ��������������������ˣ�ܳ
	private static int migrationSpeed = 80;//Ǩ���ٶȣ�ÿ�����Ӷ���ȥӰ��population��̫���ʹ����ۻ�
	
	
	
	public static void inspection() {//ÿ������Բ飬���ڴ����¼�
		// TODO �Զ����ɵķ������
		//inspect whether a parameter touches the brim
		//and thus cause an event
	}

	public static void update(int sfChange, int lszzChange, int lsxxChange,
			int jkChange, int slChange, int myChange) {//��option��������Ĳ����ı�
		// TODO �Զ����ɵķ������
		
		
	}


}
