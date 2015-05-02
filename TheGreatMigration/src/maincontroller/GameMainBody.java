package maincontroller;

import java.util.ArrayList;

import mainPanel.MainPanel;
import crisisAndEvent.Crisis;
import crisisAndEvent.LoaderController;
import finalAnimation.FinalAnimation;

public class GameMainBody {

	static final int SECOND_PER_DAY = 3;//游戏中每天等于现实中的几秒
	static final long TIME_OF_GAME = 10000;//总游戏时间，以毫秒为单位，感觉这个参数很差，迟早撤掉
	static long timePassed;//纪录游戏中已经度过的时间，以毫秒为单位
	static int day;//游戏中已经度过的天数，当到达365时，游戏结束
	
	private ArrayList<Crisis>crisisList;
	
	private MainThread mainThread;//用于纪录时间，作为一个timer
	LoaderController loaderController;
	
	public ArrayList<Crisis> getCrisisList(){
		return crisisList;
	}
	
	public GameMainBody() {
		crisisList = new ArrayList<Crisis>();
	}
	
	void gameMainThread(){

		loaderController = new LoaderController();//这里将event和crisis都一起包装导入
		loaderController.loadCrisisAndEvent();
		
		//time begin to pass
		mainThread = new MainThread();
		mainThread.start();
	
		//游戏结束后，播放结束动画
		FinalAnimation.starts();
	}

	private class MainThread implements Runnable{
		//创建了一个线程
		Thread thread;
		private boolean flag = true;//用于控制游戏暂停或继续，如果设为false则暂停
		
		public MainThread() {//构造方法
			thread = new Thread(this);
		}
		@Override
		public void run() {
			
			// 获得当前的时间，毫秒为单位
			long beginTime = System.currentTimeMillis();
			// 定义已过去的时间
			timePassed = 0;
			
			while(flag){
//				the thing what to do per second
//				Parameter.inspection();
//				set a random choice to determine if there is a event.
//				also influenced by parameter inspection
				
//				show new time
//				MainPanel.updateTimeShown(time); 
				
				beginTime += timePassed % 1000;//这是开始的时间
				timePassed = System.currentTimeMillis() - beginTime;//已度过的时间
				day = (int) (timePassed/1000)/SECOND_PER_DAY + 1 ;
				try {
					Thread.sleep(1000);//使此线程一秒后再继续，即一秒钟循环一次
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
		
		public void start(){
			thread.start();//使线程开始，其中一直循环
			try {
				Thread.sleep(TIME_OF_GAME);//此时游戏结束
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag = false;// 把flag设成false，则在run中的while循环就会停止循环
		}
		
		// 这里是暂停的方法，暂停线程
		public void Pause() {
			try {
				thread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 这里是继续的方法,唤醒线程
		public void Resume() {
			thread.notifyAll();
		}
		
	}
	public void timeContinue() {
		// TODO 自动生成的方法存根
		mainThread.Resume();
	}

	public void timePause() {
		// TODO 自动生成的方法存根
		mainThread.Pause();
	}

}
