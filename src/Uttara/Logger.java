package Uttara;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import Util.Constants;

public class Logger {

	
	
	private static Logger obj=null;

	private Logger()
	{
		
	}
	public static Logger getInstance()
	{
		if(obj== null)
			obj=new Logger();
		return obj;
	}
	
	public void log(final String data)
	{
		BufferedWriter  bw=null;
		new Thread(new Runnable()
		{
			@Override
				public void run() {
				
					BufferedWriter bw = null;
					try
					{
						bw = new BufferedWriter(new FileWriter(Constants.LOG_PATH,true));
						Date dt = new Date();
						bw.write(dt.toString()+":"+data);
						bw.newLine();
						if(Constants.LOG_MODE)
							System.out.println(data);
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					finally
					{
						if(bw!=null)
							try {
								bw.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

					}
				}

		}).start();
}

}




