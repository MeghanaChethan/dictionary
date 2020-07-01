package Uttara;







import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//import org.omg.Messaging.SyncScopeHelper;

import Util.Constants;
import Util.DirectoryLists;
import Util.TaskBean;
import Util.TaskModel;
import Util.TaskUtil;


public class Application{

	public static void main(String[] args) {
		try
		{
	
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		Scanner sc3=new Scanner(System.in);
		int ch1=0;
		int ch2=0;
		String catName;
		boolean result;
		String message;	
		String taskName;
		String meaning;
		String example;
		String s;
		
		String noun;
		String pronoun; 
		String verb;
		String adverb;
		String adjective;
		String conjunction;
		String preposition;
		String interjunction; 
		
		
	
		TaskModel model=new TaskModel();
		
		
		while(ch1!=3)
		{
			System.out.println("Press 1 to Create Dictionary");
			System.out.println("Press 2 to Load Dictionary");
			System.out.println("Press 3 to Exit");
			System.out.println("Enter your Choice");
			 
			 while(!sc1.hasNextInt())
				{
					System.out.println("Enter integer input only boss!!!");
					sc1.next();
				}
			 ch1=sc1.nextInt();
			 
			 
			 switch(ch1)
			 {
			 //.......................................CREATE CATEGORY.................................
			 case 1:System.out.println("Enter Dictionary Name");
			 		Logger.getInstance().log("choice entered "+ch1);
			 		Logger.getInstance().log(".............Creating Dictionary................");
			 		catName=sc2.next();
			 		
			 		result=TaskUtil.isValidName(catName);
			 		while(!result)
			 		{
			 			System.out.println("Dictionary name must be a single word,must starts with letter,no splecial characters allowed");
						System.out.println("Enter valid Category  name ");
						catName=sc3.next();
						Logger.getInstance().log("Dictionary name entered= "+catName);
						result=TaskUtil.isValidName(catName);
			 		}
			 		
					System.out.println("Creating Dictionary....");
					result=model.checkIfCategoryExists(catName);
					while(result)
					{
						System.out.println("Dictionary name with the same name already exists please try with a new category name");
						catName=sc3.next();
						result=model.checkIfCategoryExists(catName);
					}
					message=model.createCategory(catName);
					if(message.equals(Constants.SUCCESS))
					{
						while(ch2!=5)
						{
							System.out.println("Press 1 to add Word");
							System.out.println("Press 2 to Edit Word");
							System.out.println("Press 3 to list Word");
							System.out.println("Press 4 to Search");
							System.out.println("Press 5 to go back");
							 while(!sc2.hasNextInt())
								{
									System.out.println("Enter integer input only boss!!!");
									sc2.next();
								}
							ch2=sc2.nextInt();
							
						 
							switch(ch2)
							{
							//..............ADD TASK...................
								case 1:System.out.println(".........Adding word............");
								Logger.getInstance().log("choice entered "+ch2);
								Logger.getInstance().log("...........Adding word...........");
								System.out.println("Enter Dictionaryword");
								taskName=sc1.next();
								result=TaskUtil.isValidName(taskName);
								while(!result)
								{
									System.out.println("Dictionary name must be a single word,must starts with letter,no splecial characters allowed");
									taskName=sc1.next();
									result=TaskUtil.isValidName(taskName);
								}
								int ch3=0;
								while(ch3!=9)
								{
									System.out.println("Press 1 to Enter a Noun");
									System.out.println("Press 2 to Enter Pronoun");
									System.out.println("Press 3 to enter verb");
									System.out.println("Press 4 to enter adverb");
									System.out.println("Press 5 to enter adjective");
									System.out.println("Press 6 to enter conjunction");
									System.out.println("Press 7 to enter preposition");
									System.out.println("Press 8 to enter interjunction");
									System.out.println("Press 9 to go back");
									System.out.println("Enter your choice");
									 while(!sc2.hasNextInt())
										{
											System.out.println("Enter integer input only boss!!!");
											sc2.next();
										}
									ch3=sc2.nextInt();
									switch(ch3)
									{
									//..............noun...................
									
										case 1:System.out.println("Enter  Noun");
										noun=sc2.next();
										result=TaskUtil.isValidName(noun);
										while(!result)
										{
											System.out.println("Noun must be a single word,must starts with letter,no splecial characters allowed");
											noun=sc2.next();
											result=TaskUtil.isValidName(noun);
										}
										break;
										
										case 2:	System.out.println("Enter  Pronoun");
										pronoun=sc3.next();
										result=TaskUtil.isValidTagName(pronoun);
										while(!result)
										{
											System.out.println(" Pronoun must be a single word,must starts with letter,no splecial characters allowed");
											pronoun=sc3.next();
											result=TaskUtil.isValidName(pronoun);
										}
										break;
										
										case 3:System.out.println("Enter  Verb");
										verb=sc1.next();
										result=TaskUtil.isValidTagName(verb);
										while(!result)
										{
											System.out.println("Verb must be a single word,must starts with letter,no splecial characters allowed");
											verb=sc1.next();
											result=TaskUtil.isValidName(verb);
										}
										break;
										
										case 4:System.out.println("Enter  Adverb");
										adverb=sc1.next();
										result=TaskUtil.isValidTagName(adverb);
										while(!result)
										{
											System.out.println(" Adverb must be a single word,must starts with letter,no splecial characters allowed");
											adverb=sc1.next();
											result=TaskUtil.isValidName(adverb);
										}
										break;
										
										case 5:System.out.println("Enter  Adjective");
										adjective=sc1.next();
										result=TaskUtil.isValidTagName(adjective);
										while(!result)
										{
											System.out.println("Adjective must be a single word,must starts with letter,no splecial characters allowed");
											adjective=sc1.next();
											result=TaskUtil.isValidName(adjective);
										}
										break;
										case 6:System.out.println("Enter  Conjunction");
										conjunction=sc1.next();
										result=TaskUtil.isValidTagName(conjunction);
										while(!result)
										{
											System.out.println("Conjunction must be a single word,must starts with letter,no splecial characters allowed");
											conjunction=sc1.next();
											result=TaskUtil.isValidName(conjunction);
										}
										break;
										case 7:System.out.println("Enter  Preposition");
										preposition=sc1.next();
										result=TaskUtil.isValidTagName(preposition);
										while(!result)
										{
											System.out.println("Preposition must be a single word,must starts with letter,no splecial characters allowed");
											preposition=sc1.next();
											result=TaskUtil.isValidName(preposition);
										}
										break;
										case 8:System.out.println("Enter  Interjunction");
										interjunction=sc1.next();
										result=TaskUtil.isValidTagName(interjunction);
										while(!result)
										{
											System.out.println("Interjunction must be a single word,must starts with letter,no splecial characters allowed");
											interjunction=sc1.next();
											result=TaskUtil.isValidName(interjunction);
										}
										break;
					        
										case 9:System.out.println("Going back to  adding menu");
										break;
									}	
									
								}
								 
								
								
								
								
								System.out.println("Enter  word meaning");
								meaning=sc2.next();
								result=TaskUtil.isValidName(meaning);
								while(!result)
								{
									System.out.println("Meaning must be a single word,must starts with letter,no splecial characters allowed");
									meaning=sc2.next();
									result=TaskUtil.isValidName(meaning);
								}
								System.out.println("Enter   examples(Comma Seperated Values)");
								example=sc3.next();
								result=TaskUtil.isValidTagName(example);
								while(!result)
								{
									System.out.println("example must be  Comma seperated values");
									example=sc3.next();
									result=TaskUtil.isValidName(example);
								}
								
									TaskBean bean=new TaskBean(taskName,meaning,example);
									message=model.addTask(bean,catName);
									if(message.equals(Constants.SUCCESS))
									{
										Logger.getInstance().log("Task Name: "+bean.getTaskName()+" Meaning :"+bean.getMeaning()+" Example: "+bean.getExample());
										System.out.println("words added successfully");
									}
									else
									{
										System.out.println(message);
									}
								
								
								break;
//.........................................Edit Dictionary word...................................................
							
								case 2:System.out.println("..........Edit words...........");
										Logger.getInstance().log("Choice selected in Dictionary menu edit...."+ch2);
										int ch4=0;
										while(ch4!=3)
										{
											System.out.println("Press 1 to remove entire Dictionary word");
											System.out.println("Press 2 to edit Individual word information");
											System.out.println("Press 3 to go back");
											 while(!sc2.hasNextInt())
												{
													System.out.println("Enter integer input only boss!!!");
													sc2.next();
												}
											ch4=sc2.nextInt();
											
										 
											switch(ch4)
											{
											//............Remove entire task........................
												case 1:System.out.println("Enter name of the Dictionary word to be removed");
												Logger.getInstance().log("Choice entered in edit menu=1 remove entire word");
												taskName=sc1.next();
												result=TaskUtil.isValidName(taskName);
												while(!result)
												{
													System.out.println("Dictionary word name must be a single word,must starts with letter,no splecial characters allowed");
													taskName=sc2.next();
													result=TaskUtil.isValidName(taskName);
												}
												
												message=model.removeTask(taskName,catName);
												if(message.equals(Constants.SUCCESS))
												{
													System.out.println("Task Removed Successfully");
												}
												else
												{
													System.out.println(message);
												}
												break;
												//...........Edit menu=2..........................
												case 2:Logger.getInstance().log("Choice entered in edit menu=2 edit individual info..");
												System.out.println("Enter name of the word to be edited");
												taskName=sc3.next();
												result=TaskUtil.isValidName(taskName);
												while(!result)
												{
													System.out.println("Dictionary word name must be a single word,must starts with letter,no splecial characters allowed");
													taskName=sc1.next();
													result=TaskUtil.isValidName(taskName);
												}
												List<TaskBean> task=model.getTask(taskName, catName);
												for(TaskBean td:task)
												{
													System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
												}
												int ch5=0;
												while(ch5!=3)
												{
													
													System.out.println("Press 1 to Change Meaning");
												    System.out.println("Press 2 to Change example");
													System.out.println("Press 3 to go back to edit menu");
													System.out.println("Enter your choice ");
													 while(!sc2.hasNextInt())
														{
															System.out.println("Enter integer input only boss!!!");
															sc2.next();
														}
													ch5=sc2.nextInt();
													
												 
													switch(ch5)
													{//...............change Meaning.............
														case 1:Logger.getInstance().log("change Meaning");
															System.out.println("Enter new Meaning");
															String newMeaning=sc2.next();
															result=TaskUtil.isValidName(newMeaning);
															while(!result)
															{
																System.out.println("meaning must be a single word,must starts with letter,no splecial characters allowed");
																newMeaning=sc2.next();
																result=TaskUtil.isValidName(newMeaning);
															}
															
														message=model.changeMeaning(newMeaning,taskName, catName);
														if(message.equals(Constants.SUCCESS))
														{
															System.out.println("Meaning Updated Successfully");
														}
														else
														{
															System.out.println(message);
														}
														break;
														
														case 2://...........change example.................
															System.out.println("Enter  example(Comma Seperated Values) to be Updated ");
															example=sc2.next();
															result=TaskUtil.isValidTagName(example);
															while(!result)
															{
																System.out.println("example must be  Comma seperated values");
																example=sc2.next();
																result=TaskUtil.isValidName(example);
															}
															message=model.updateExample(example,taskName,catName);
															if(message.equals(Constants.SUCCESS))
															{
																System.out.println("Example Updated Successfully");
															}
															else
															{
																System.out.println(message);
															}		
																							
															break;
															
															case 3:System.out.println("Going back to  edit menu");
														
														break;
														
													}
												}
												break;
												case 3:System.out.println("Going back.... menu");
												break;
												
											
											  
											
											
											
											}
										}
								
								
								
								break;
//...........................................List Tasks.....................................................
								
								
								case 3:System.out.println("..........List of Tasks in "+catName+".name............");
								List<TaskBean> tasks=model.listTasks(catName);
								for(TaskBean td:tasks)
								{
									System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
								}		
								int ch6=0;
								while(ch6!=4)
								{
									System.out.println("Press 1 to sort tasks based on taskName");
									System.out.println("Press 2 to sort tasks based on meaning");
									System.out.println("Press 3 to sort tasks based on example");
								     System.out.println("Press 4 to go back");
									System.out.println("Enter your choice");
									 while(!sc1.hasNextInt())
										{
											System.out.println("Enter integer input only boss!!!");
											sc1.next();
										}
									ch6=sc1.nextInt();
									
									
									switch(ch6)
									{	case 1:Logger.getInstance().log("choice entered "+ch6);
										System.out.println("List of tasks sorted based on taskName");
										
									List<TaskBean> task=model.getTasksByName(catName);
										for(TaskBean td:task)
										{
											System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
										}		
										break;
																		
									case 2:Logger.getInstance().log("choice entered "+ch6);
										System.out.println("List of tasks sorted based on meaning");
										
									List<TaskBean> mtasks=model.getTasksByMeaning(catName);
										for(TaskBean td:mtasks)
										{
											System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
										}		
										break;
										
									case 3:Logger.getInstance().log("choice entered "+ch6);
									System.out.println("List of tasks sorted based on example");
									
								List<TaskBean> etasks=model.getTasksByExample (catName);
									for(TaskBean td:etasks)
									{
										System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
									}		
									break;
								
										case 4:Logger.getInstance().log("choice entered "+ch6);
											System.out.println("Going back to List menu");
											break;
									}
								}
								break;
								
								
//...........................................search task.................................................................
								case 4:System.out.println("..........Search Task............");
								
								System.out.println("Enter search String..");
								String srchstr=sc2.next();
								int occTaskN=model.numOfOccAsName(srchstr,catName);
								System.out.println("Number of occurances of "+srchstr+"as taskName= "+occTaskN);
								if(occTaskN>0)
								{
									List<TaskBean> tasksname=model.getTask(srchstr,catName);
									for(TaskBean td:tasksname)
									{
										System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
									}	
									
								}
								occTaskN=model.numOfOccAsMeaning(srchstr,catName);
								System.out.println("Number of occurances of "+srchstr+"as Meaning= "+occTaskN);
								if(occTaskN>0)
								{
									List<TaskBean> tasksmeaning=model.searchMeaning(srchstr,catName);
									for(TaskBean td:tasksmeaning)
									{
										System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
									}	
									
								}
								
								
								break;
								case 5:System.out.println("...........Going back to Category Menu........");
								break;
								default:System.out.println("...........Option Not Yet Supported.............");
								break;
							}
						}
					}
					
					
			 
			 break;
			 case 2:
			
		 		Logger.getInstance().log("choice entered "+ch1);
		 		Logger.getInstance().log(".............Creating category................");
		 		 System.out.println("Enter Category Name");
		 		catName=sc2.next();
		 		
		 		result=TaskUtil.isValidName(catName);
		 		while(!result)
		 		{
		 			System.out.println("Category name must be a single word,must starts with letter,no splecial characters allowed");
					System.out.println("Enter valid Category  name ");
					catName=sc3.next();
					Logger.getInstance().log("category name entered= "+catName);
					result=TaskUtil.isValidName(catName);
		 		}
		 		
				System.out.println("Loading category....");
				result=model.checkIfCategoryExists(catName);
				while(!result)
				{
					System.out.println("Category does not exist please create category and then load");
					catName=sc3.next();
					result=model.checkIfCategoryExists(catName);
				}
				
					while(ch2!=5)
					{
						System.out.println("Press 1 to add Dictionary");
						System.out.println("Press 2 to Edit Dictionary");
						System.out.println("Press 3 to list Dictionary");
						System.out.println("Press 4 to Search");
						System.out.println("Press 5 to go back");
						System.out.println("Enter your choice");
						ch2=sc2.nextInt();
						
					 
						switch(ch2)
						{
						//..............ADD Dictionary...................
							case 1:System.out.println(".........Adding Task............");
							Logger.getInstance().log("choice entered "+ch2);
							Logger.getInstance().log("...........Adding Task...........");
							System.out.println("Enter Dictionaryname");
							taskName=sc2.next();
							result=TaskUtil.isValidName(taskName);
							while(!result)
							{
								System.out.println("Dictionary name must be a single word,must starts with letter,no splecial characters allowed");
								taskName=sc2.next();
								result=TaskUtil.isValidName(taskName);
							}
							System.out.println("Enter  Meaning");
							meaning=sc1.next();
							result=TaskUtil.isValidName(meaning);
							while(!result)
							{
								System.out.println("meaning must be a single word,must starts with letter,no splecial characters allowed");
								meaning=sc2.next();
								result=TaskUtil.isValidName(meaning);
							}
							System.out.println("Enter  example(Comma Seperated Values)");
							example=sc1.next();
							result=TaskUtil.isValidTagName(example);
							while(!result)
							{
								System.out.println("Tags must be  Comma seperated values");
								example=sc2.next();
								result=TaskUtil.isValidName(example);
							}
								TaskBean bean=new TaskBean(taskName,meaning,example);
								message=model.addTask(bean,catName);
								if(message.equals(Constants.SUCCESS))
								{
									Logger.getInstance().log("Task Name: "+bean.getTaskName()+" Meaning :"+bean.getMeaning()+" Example: "+bean.getExample());
									System.out.println("Task added successfully");
								}
								else
								{
									System.out.println(message);
								}
							
							
							break;
//.........................................Edit Task...................................................
						
							case 2:System.out.println("..........Edit Dictionary...........");
									Logger.getInstance().log("Choice selected in Dictionary menu edit...."+ch2);
									int ch4=0;
									while(ch4!=3)
									{
										System.out.println("Press 1 to remove entire Dictionary");
										System.out.println("Press 2 to edit Individual Dictionary information");
										System.out.println("Press 3 to go back");
										 while(!sc2.hasNextInt())
											{
												System.out.println("Enter integer input only boss!!!");
												sc2.next();
											}
										ch4=sc2.nextInt();
										
									 
										switch(ch4)
										{//............Remove entire task........................
											case 1:System.out.println("Enter name of the Dictionary word to be removed");
											Logger.getInstance().log("Choice entered in edit menu=1 remove entire Dictionary");
											taskName=sc1.next();
											result=TaskUtil.isValidName(taskName);
											while(!result)
											{
												System.out.println("Dictionary name must be a single word,must starts with letter,no splecial characters allowed");
												taskName=sc2.next();
												result=TaskUtil.isValidName(taskName);
											}
											
											message=model.removeTask(taskName,catName);
											if(message.equals(Constants.SUCCESS))
											{
												System.out.println("Dictionary Removed Successfully");
											}
											else
											{
												System.out.println(message);
											}
											break;
											//...........Edit menu=2..........................
											case 2:Logger.getInstance().log("Choice entered in edit menu=2 edit individual info..");
											System.out.println("Enter name of the word to be edited");
											taskName=sc3.next();
											result=TaskUtil.isValidName(taskName);
											while(!result)
											{
												System.out.println("word name must be a single word,must starts with letter,no splecial characters allowed");
												taskName=sc1.next();
												result=TaskUtil.isValidName(taskName);
											}
											List<TaskBean> task=model.getTask(taskName, catName);
											for(TaskBean td:task)
											{
												System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
											}
											int ch5=0;
											while(ch5!=3)
											{
												System.out.println("Press 1 to Change Meaning");
						                 		System.out.println("Press 2 to Change Example");
												System.out.println("Press 3 to go back to edit menu");
												System.out.println("Enter your choice ");
												 while(!sc2.hasNextInt())
													{
														System.out.println("Enter integer input only boss!!!");
														sc2.next();
													}
												ch5=sc2.nextInt();
												
											 
												switch(ch5)
												{//...............change Meaning.............
													case 1:Logger.getInstance().log("change Meaning");
														System.out.println("Enter new Meaning");
														String newMeaning=sc2.next();
														result=TaskUtil.isValidName(newMeaning);
														while(!result)
														{
															System.out.println("Dictionary must be a single word,must starts with letter,no splecial characters allowed");
															newMeaning=sc2.next();
															result=TaskUtil.isValidName(newMeaning);
														}
														
													message=model.changeMeaning(newMeaning,taskName, catName);
													if(message.equals(Constants.SUCCESS))
													{
														System.out.println("Meaning Updated Successfully");
													}
													else
													{
														System.out.println(message);
													}
													break;
																										
													case 2://...........change example.................
														System.out.println("Enter  Example(Comma Seperated Values) to be Updated ");
														example=sc2.next();
														result=TaskUtil.isValidTagName(example);
														while(!result)
														{
															System.out.println("example must be  Comma seperated values");
															example=sc2.next();
															result=TaskUtil.isValidName(example);
														}
														message=model.updateExample(example,taskName,catName);
														if(message.equals(Constants.SUCCESS))
														{
															System.out.println("example Updated Successfully");
														}
														else
														{
															System.out.println(message);
														}		
																						
														break;
													
													case 3:System.out.println("Going back to  edit menu");
													
													break;
													
												}
											}
											break;
											case 3:System.out.println("Going back....");
											break;
											
										
										
										
										
										
										}
									}
							
							
							
							break;
//...........................................List Tasks.....................................................
							case 3:System.out.println("..........List of Tasks in "+catName+".tasks............");
							List<TaskBean> tasks=model.listTasks(catName);
							for(TaskBean td:tasks)
							{
								System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
							}		
							int ch7=0;
							while(ch7!=4)
							{
								System.out.println("Press 1 to sort tasks based on taskName");
								System.out.println("Press 2 to sort tasks based on meaning");
								System.out.println("Press 3 to sort tasks based on example");
							     System.out.println("Press 4 to go back");
								System.out.println("Enter your choice");
								 while(!sc1.hasNextInt())
									{
										System.out.println("Enter integer input only boss!!!");
										sc1.next();
									}
								ch7=sc1.nextInt();
								
							 
								
								switch(ch7)
								{	
								   case 1:Logger.getInstance().log("choice entered "+ch7);
									System.out.println("List of tasks sorted based on dictionaryName");
									
								List<TaskBean> task=model.getTasksByName(catName);
									for(TaskBean td:task)
									{
										System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
									}		
									break;
									
								   case 2:Logger.getInstance().log("choice entered "+ch7);
									System.out.println("List of tasks sorted based on meaning");
									
								List<TaskBean> mtasks=model.getTasksByMeaning(catName);
									for(TaskBean td:mtasks)
									{
										System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
									}		
									break;
									
								   case 3:Logger.getInstance().log("choice entered "+ch7);
									System.out.println("List of tasks sorted based on Example");
									
								List<TaskBean> etasks=model.getTasksByExample(catName);
									for(TaskBean td:etasks)
									{
										System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
									}		
									break;
									
									
								   
																
																
									
																
									case 4:Logger.getInstance().log("choice entered "+ch7);
										System.out.println("Going back to List menu");
										break;
								}
							}
							break;
//...........................................search task.................................................................
							case 4:System.out.println("..........Search Task............");
							
							System.out.println("Enter search String..");
							String srchstr=sc2.next();
							int occTaskN=model.numOfOccAsName(srchstr,catName);
							System.out.println("Number of occurances of "+srchstr+" taskName= "+occTaskN);
							if(occTaskN>0)
							{
								List<TaskBean> tasksname=model.getTask(srchstr,catName);
								for(TaskBean td:tasksname)
								{
									System.out.println("Name :"+td.getTaskName()+" Meaning :"+td.getMeaning()+" Example :"+td.getExample());
								}	
								
							}
							occTaskN=model.numOfOccAsMeaning(srchstr,catName);
							System.out.println("Number of occurances of "+srchstr+ " Meaning= "+occTaskN);
							if(occTaskN>0)
							{
								List<TaskBean> tasksdesc=model.searchMeaning(srchstr,catName);
								for(TaskBean td:tasksdesc)
								{
									System.out.println("Name :"+td.getTaskName()+ " Meaning :"+td.getMeaning()+" Example :"+td.getExample());
								}	
								
							}
							
							break;
							
							case 5:System.out.println("...........Going back to Category Menu........");
							break;
							default:System.out.println("...........Option Not Yet Supported.............");
							break;
						}
					}
		
				
			     break;
		    
			 
			 
			 case 3:System.out.println("...........completed the task, bye bye ........");
				break;
			 
			 
			 }
			 
			 
		}
			 
		}
		catch(Exception t)
		{
			System.out.println("OOPs Something went wrong"+t.getMessage());
		}
		
		
		

	}

}
									 