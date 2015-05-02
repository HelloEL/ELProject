package maincontroller;

import java.util.ArrayList;

import mainPanel.MainPanel;
import crisisAndEvent.Crisis;
import crisisAndEvent.CrisisEngenderingEvent;
import crisisAndEvent.RandomEvent;
import crisisAndEvent.loader.LoaderController;
import finalAnimation.FinalAnimation;

public class GameMainBody {

	public static final int SECOND_PER_DAY = 3;//��Ϸ��ÿ�������ʵ�еļ���
	public static final long TIME_OF_GAME = 10000;//����Ϸʱ�䣬�Ժ���Ϊ��λ���о���������ܲ���糷��
	static long timePassed;//��¼��Ϸ���Ѿ��ȹ���ʱ�䣬�Ժ���Ϊ��λ
	static int day;//��Ϸ���Ѿ��ȹ���������������365ʱ����Ϸ����
	
	private ArrayList<Crisis> crisisList;
	private ArrayList<RandomEvent> randomEventList;
	private ArrayList<CrisisEngenderingEvent> crisisEngenderingEventList;
	
	private MainThread mainThread;//���ڼ�¼ʱ�䣬��Ϊһ��timer
	LoaderController loaderController;
	
	public ArrayList<Crisis> getCrisisList(){
		return crisisList;
	}
	public ArrayList<RandomEvent> getRandomEventList() {
		return randomEventList;
	}
	public ArrayList<CrisisEngenderingEvent> getCrisisEngenderingEventList() {
		return crisisEngenderingEventList;
	}
	
	public GameMainBody() {
		crisisList = new ArrayList<Crisis>();
		randomEventList = new ArrayList<RandomEvent>();
		crisisEngenderingEventList = new ArrayList<CrisisEngenderingEvent>();
	}
	
	
	
	
	
	public void gameMainThread(){//mainPanel Ӧ���ڴ������������֮������������

		loaderController = new LoaderController();//���ｫevent��crisis��һ���װ����
		loaderController.loadCrisisAndEvent();
		
		//time begin to pass
		mainThread = new MainThread();
		mainThread.start();
	
		//��Ϸ�����󣬲��Ž�������
		FinalAnimation.starts();
	}

	
	
	
	
	
	private class MainThread implements Runnable{
		//������һ���߳�
		Thread thread;
		private boolean flag = true;//���ڿ�����Ϸ��ͣ������������Ϊfalse����ͣ
		
		public MainThread() {//���췽��
			thread = new Thread(this);
		}
		@Override
		public void run() {
			
			// ��õ�ǰ��ʱ�䣬����Ϊ��λ
			long beginTime = System.currentTimeMillis();
			// �����ѹ�ȥ��ʱ��
			timePassed = 0;
			
			while(flag){
//				the thing what to do per second
//				Parameter.inspection();
//				set a random choice to determine if there is a event.
//				also influenced by parameter inspection
				
//				show new time
//				MainPanel.updateTimeShown(time); 
				
				beginTime += timePassed % 1000;//���ǿ�ʼ��ʱ��
				timePassed = System.currentTimeMillis() - beginTime;//�Ѷȹ���ʱ��
				day = (int) (timePassed/1000)/SECOND_PER_DAY + 1 ;
				try {
					Thread.sleep(1000);//ʹ���߳�һ����ټ�������һ����ѭ��һ��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
		
		public void start(){
			thread.start();//ʹ�߳̿�ʼ������һֱѭ��
			try {
				Thread.sleep(TIME_OF_GAME);//��ʱ��Ϸ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag = false;// ��flag���false������run�е�whileѭ���ͻ�ֹͣѭ��
		}
		
		// ��������ͣ�ķ�������ͣ�߳�
		public void Pause() {
			try {
				thread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// �����Ǽ����ķ���,�����߳�
		public void Resume() {
			thread.notifyAll();
		}
		
	}
	public void timeContinue() {
		// TODO �Զ����ɵķ������
		mainThread.Resume();
	}

	public void timePause() {
		// TODO �Զ����ɵķ������
		mainThread.Pause();
	}


}
