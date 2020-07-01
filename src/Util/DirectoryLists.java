package Util;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DirectoryLists {

	public static void main(String[] args) {
		List<String> lists=new DirectoryLists().textFiles("C:\\Users\\lenovo\\eclipse-workspace\\MyDictionary");
		
		
		
		for(String la:lists)
		{
			System.out.println(la);
			System.out.println("..........................................................................");
			List<TaskBean> list=new DirectoryLists().listTask(la);
			for(TaskBean td:list)
			{
				System.out.println(td.toString());
				System.out.println();
				
				
			}
			System.out.println("..........................................................................");
			
			
		}
		
		
		 

	}
	public List<String> textFiles(String directory) {
		  List<String> textFiles = new ArrayList<String>();
		  File dir = new File(directory);
		  for (File file : dir.listFiles()) {
		    if (file.getName().endsWith((".tasks"))) {
		      textFiles.add(file.getName());
		    }
		  }
		  return textFiles;
		}
	


public List<TaskBean> listTask(String catName)
{
	File f=new File(catName);
	List<TaskBean> tasks=new ArrayList<TaskBean>();
	TaskBean bean;
	
	if(f.exists() && f.isFile())
	{
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try
		{
			String line;
			br=new BufferedReader(new FileReader(f));
			while((line=br.readLine())!=null)
			{
				String[] str=line.split(":");
				
					
					bean=new TaskBean(str[0],str[1],str[2]);
					tasks.add(bean);
				
			}
			return tasks;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
		
		finally
		{
			try
			{
				if(br!=null)
					br.close();
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
			try
			{
				if(bw!=null)
					bw.close();
			}
			catch(IOException e2)
			{
				e2.printStackTrace();
			}
		}
		
	}
	else
	{
		return null;
	}
}	
}

