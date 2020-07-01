package Util;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Uttara.Logger;

public class TaskModel {

	//...........................CHECK IF CATEGORY EXISTS........................................
	public boolean checkIfCategoryExists(String catName)
	{
		return new File(catName+".tasks").exists();

	}
	// ...............................CREATE CATEGORY.......................................................
	public String createCategory(String catName)
	{
		BufferedWriter bw=null;
		try
		{
			bw=new BufferedWriter(new FileWriter(catName+".tasks"));
			return Constants.SUCCESS;
		}
		catch (IOException e)
		{
			return "Oops something bad happened!!!"+e.getMessage();
		}
	}

	//........................ADD TASKS.......................................................
	public String addTask(TaskBean bean,String catName)
	{
		BufferedWriter bw=null;
		String line;
		
		try
		{
			bw=new BufferedWriter(new FileWriter(catName+".tasks",true));
			line=bean.getTaskName()+":"+bean.getMeaning()+":"+bean.getExample();
			bw.write(line);
			bw.newLine();
			Logger.getInstance().log("adding task "+"Name: "+bean.getTaskName()+" Meaning :"+bean.getMeaning()+" Example :"+bean.getExample());
			return Constants.SUCCESS;
	}
		catch(IOException e)
		{
			return " Something went wrong!!!!!!!!task was not added "+e.getMessage();
		}
		finally
		{
			try
			{
				if(bw!=null)
				{
					bw.close();
				}
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
//...................................REMOVE TASK................................................
	}
		public String removeTask(String taskName,String catName)
		{
			File f=new File(catName+".tasks");
			List<TaskBean> tasks=new ArrayList<TaskBean>();
			TaskBean bean;
			
			
			if(f.exists())
			{
				BufferedReader br=null;
				BufferedWriter bw=null;
				String line;
				try
				{
					br=new BufferedReader(new FileReader(f));
					while((line=br.readLine())!=null)
					{
							String[] str=line.split(":");
							if(!(str[0].equals(taskName)))
							{
								

								bean=new TaskBean(str[0],str[1],str[2]);
								tasks.add(bean);
						}
					}
					bw=new BufferedWriter(new FileWriter(f));
					for(TaskBean tb:tasks)
					{
						line=tb.getTaskName()+":"+tb.getMeaning()+":"+tb.getExample();
						bw.write(line);
						bw.newLine();
					}
					return Constants.SUCCESS;




				}
				catch(IOException e)
				{
					return "Oops Something Bad Happened!!!"+e.getMessage();
				}
				
				finally
				{
					try
					{
						if(br!=null)
							br.close();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					try
					{
						if(bw!=null)
							bw.close();
					}
					catch(IOException e1)
					{
						e1.printStackTrace();
					}
				}




			}
			else
			{
				return "File Doesn't exist";
			}




		}
		//..........................GetTask...................................................
		public List<TaskBean> getTask(String taskName,String catName)
		{
			File f=new File(catName+".tasks");
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
//...........................change description............................................
		public String changeMeaning(String newMeaning,String taskName,String catName)
		{
				File f=new File(catName+".tasks");
				List<TaskBean> tasks=new ArrayList<TaskBean>();
				TaskBean bean;
				
				
				if(f.exists() && f.isFile())
				{
					BufferedReader br=null;
					BufferedWriter bw=null;
					String line;
					try {

						br=new BufferedReader(new FileReader(f));
						while((line=br.readLine())!=null)
						{
							String[] str=line.split(":");
								
								if(str[0].equals(taskName))
								{
									str[1]=newMeaning;
									bean=new TaskBean(str[0],str[1],str[2]);
									tasks.add(bean);
								}
								else
								{
									bean=new TaskBean(str[0],str[1],str[2]);
									tasks.add(bean);
								}
						}
						bw=new BufferedWriter(new FileWriter(f));
						for(TaskBean tb:tasks)
						{
							line=tb.getTaskName()+":"+tb.getMeaning()+":"+tb.getExample();

							bw.write(line);
							bw.newLine();

						}
						return Constants.SUCCESS;
					}
					catch (Exception e) {

						return e.getMessage();

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
					return "file doesn't exist!!!";
				}
		}
//................................................Update example...........................................
		public String updateExample(String example,String taskName,String catName)
		{
			File f=new File(catName+".tasks");
			List<TaskBean> tasks=new ArrayList<TaskBean>();
			TaskBean bean;
			
			if(f.exists() && f.isFile())
			{
				BufferedReader br=null;
				BufferedWriter bw=null;
				String line;
				try {

					br=new BufferedReader(new FileReader(f));
					while((line=br.readLine())!=null)
					{
						String[] str=line.split(":");
							
							if(str[0].equals(taskName))
							{
								str[2]=example;
								bean=new TaskBean(str[0],str[1],str[2]);
								tasks.add(bean);
							}
							else
							{

								bean=new TaskBean(str[0],str[1],str[2]);
								tasks.add(bean);
							}
					}
					bw=new BufferedWriter(new FileWriter(f));
					for(TaskBean tb:tasks)
					{
						line=tb.getTaskName()+":"+tb.getMeaning()+":"+tb.getExample();

						bw.write(line);
						bw.newLine();

					}
					return Constants.SUCCESS;
				}
				catch (Exception e) {

					return e.getMessage();

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
				return "file doesn't exist!!!";



		}


		}

//.................................List Tasks.......................................................
		public List<TaskBean> listTasks(String catName)
		{
			File f=new File(catName+".tasks");
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

			public List<TaskBean> getTasksByName(String catName)
			{
				File f=new File(catName+".tasks");
				if(f.exists() && f.isFile())
				{
					List<TaskBean> tasks=new TaskModel().listTasks(catName);
					SortTaskByName stbn=new SortTaskByName();
					Collections.sort(tasks,stbn);
					return  tasks;
				}
				else
				{
					throw new IllegalArgumentException();
				}

			}
			
			
			public List<TaskBean> getTasksByMeaning(String catName)
			{
				File f=new File(catName+".tasks");
				if(f.exists() && f.isFile())
				{
					List<TaskBean> tasks=new TaskModel().listTasks(catName);
					SortTaskByMeaning stbm=new SortTaskByMeaning();
					Collections.sort(tasks,stbm);
					return  tasks;
				}
				else
				{
					throw new IllegalArgumentException();
				}

			}
			
			
			public List<TaskBean> getTasksByExample(String catName)
			{
				File f=new File(catName+".tasks");
				if(f.exists() && f.isFile())
				{
					List<TaskBean> tasks=new TaskModel().listTasks(catName);
					SortTaskByExample stbe=new SortTaskByExample();
					Collections.sort(tasks,stbe);
					return  tasks;
				}
				else
				{
					throw new IllegalArgumentException();
				}

			}

			
		
			
			
			
			
			
			
			
			
			
			//...................................Number of Occurrences..................................
			public int numOfOccAsName( String srchstr,String catName )
			{
				File f=new File(catName+".tasks");
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
			public int numOfOccAsMeaning( String srchstr,String catName )
			{
				File f=new File(catName+".tasks");
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
//..........................Search meaning.......................................................
			public List<TaskBean> searchMeaning(String srchstr,String catName)
			{
				File f=new File(catName+".tasks");
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
							if(str[1].equals(srchstr))
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
			public List<List>[] listTasks()
			{
					File f=new File("C:\\Users\\lenovo\\eclipse-workspace\\MyDictionary");

					File[] fa=f.listFiles();
					List<List>[] lists=new ArrayList[fa.length];
					TaskModel model=new TaskModel();
					int i=0;

					for(File fs:fa)
					{
						if(fs.exists() && fs.isFile() && fs.getName().endsWith(".tasks"))
						{
							List<TaskBean> la = model.listTasks(fs.getName());
							lists[i].add(la);
							i++;
						}
					}
					return lists;


			}

//..................List of files ending with .tasks.......................
public List<String> taskFiles()
{
	String path="C:\\Users\\lenovo\\eclipse-workspace\\MyDictionary";
	  List<String> taskFiles = new ArrayList<String>();
	  File dir = new File(path);
	  try
	  {
	  if(dir.isDirectory())
	  {
		  for (File file : dir.listFiles()) {
			  if (file.getName().endsWith((".tasks"))) {
				  taskFiles.add(file.getName());
	    }
	  }

	  }
	  return taskFiles;
	  }
	  catch(Exception e)
	  {
		  return null;
	  }
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
		catch(ParseException e1)
		{
			e1.printStackTrace();
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
		catch(ParseException e1)
		{
			e1.printStackTrace();
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
public List<TaskBean> searchDescrip(String srchstr,String catName)
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
				if(str[1].equals(srchstr))
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
		catch(ParseException e1)
		{
			e1.printStackTrace();
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

