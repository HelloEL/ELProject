package crisisAndEvent;

import java.io.*;

public class CrisisLoader {

	public static void loadCrisis() {
		// TODO 自动生成的方法存根
		
//		To load the file to create crisis
		File file = new File("Crisis.txt");
		String encoding="GBK";
		try{
			if(file.isFile() && file.exists()){
			
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
			}
/*		以下用中文伪码写就
        当（读一行，且次行不为空时）
               若第一个是数字而不是汉字
                     （ 那么表明这个事件是由前面数字所指代的option所触发的）
              搜索所有option的identifier，找到合适的那个option，找不到就报错
              那么我们将option的nextCrisis这个引用（原本初始设为null）设到新创建的这个对象
                    然后新创建一个crisis对象
                    然后读取空格以后的内容，|前的设为crisis对象的kind，第一个|后的设为其description
                    第三个|后的设为option的description,然后再解析之后的代码，不再一一详述
        否则，
              新建一个crisis对象，并将isAutomaticlyHappen设为true，表示这个crisis可以自发进行
		
	
*/
		}catch(Exception ex){ System.out.println("读取文件内容出错");ex.printStackTrace();}
	}

}
