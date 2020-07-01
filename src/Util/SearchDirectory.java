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
import java.util.Scanner;

public class SearchDirectory {

	public static void main(String[] args) {
		Scanner sc2=new Scanner(System.in);
 		System.out.println("Enter search String..");
		String srchstr=sc2.next();
		int occTaskN=0;
		SearchDirectory sc=new SearchDirectory();
		List<String> lists=sc.textFiles("C:\\Users\\lenovo\\eclipse-workspace\\MyDictionary");
	//	TaskModel model=new TaskModel();
		
		
		for(String la:lists)
		{
		
		 occTaskN=sc.numOfOccName(srchstr,la);
		
		if(occTaskN>0)
		{
			System.out.println("Number of occurances of "+srchstr+" as taskName in Category = "+la+" :5"+ + occTaskN);
			List<TaskBean> tasksname=sc.searchTaskName(srchstr,la);
			for(TaskBean td:tasksname)
			{
				System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
			}	
			
		}
		}
	/*	for(String li:lists)
		{
		occTaskN=model.numOfOccAsDescription(srchstr,li);
		System.out.println("Number of occurances of "+srchstr+"as Description= "+occTaskN);
		if(occTaskN>0)
		{
			List<TaskBean> tasksdesc=model.searchDescription(srchstr,li);
			for(TaskBean td:tasksdesc)
			{
				System.out.println("Name :"+td.getTaskName()+" Description :"+td.getDesc()+" Tags :"+td.getTags()+" StartDate :"+sdf.format(td.getCr_dt())+" End Date :"+sdf.format(td.getEnd_dt())+"Status :"+td.getStatus()+" Priority :"+td.getPriority());
			}	
			
		}
		}*/
		
		

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
	
	


public int numOfOccName( String srchstr,String catName )
{
	File f=new File(catName);
	if(f.exists()&&f.isFile())
	{
		BufferedReader br=null;
		String line;
		int count=0;
		try
		{
			br=new BufferedReader(new FileReader(f));
			while((line=br.readLine())!=null)
			{
				String[] s=line.split(":");
				if(s[0].equals(srchstr))
				{
					count++;
				}
			}
			return count;
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return 0;
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
		}
	}
	else
	{
		return 0;
	}
}
public List<TaskBean> searchTaskName(String taskName,String catName)
{
	File f=new File(catName);
	TaskBean bean;
	if(f.exists())
	{
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try
		{
			String line;
			List<TaskBean> tasks=new ArrayList<TaskBean>();
			br=new BufferedReader(new FileReader(f));
			while((line=br.readLine())!=null)
			{
				String[] str=line.split(":");
				if(str[0].equals(taskName))
				{
					
				
					bean=new TaskBean(str[0],str[1],str[2]);
					tasks.add(bean);
				}
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

public int numOfMeaning( String srchstr,String catName )
{
	File f=new File(catName);
	if(f.exists()&&f.isFile())
	{
		BufferedReader br=null;
		String line;
		int count=0;
		try
		{
			br=new BufferedReader(new FileReader(f));
			while((line=br.readLine())!=null)
			{
				String[] s=line.split(":");
				if(s[1].equals(srchstr))
				{
					count++;
				}
			}
			return count;
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return 0;
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
		}
	}
	else
	{
		return 0;
	}
}
}

