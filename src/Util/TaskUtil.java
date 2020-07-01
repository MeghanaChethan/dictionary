package Util;

import java.util.Date;

public class TaskUtil {

	public static boolean isValidName(String catName)
	{
		if(catName == null)
		return false;
		if(catName.trim().equals(""))
			return false;
		if(!(Character.isLetter(catName.charAt(0))))
				return false;
		for(int i=0;i<catName.length();i++)
		{
			if(!(Character.isLetter(catName.charAt(i))|| Character.isDigit(catName.charAt(i))))
				return false;
		}
		return true;
		
	}
	
	//...............Validate example............................
		public static boolean isValidTagName(String tagName)
		{
			String[] s=tagName.split(",");
			boolean b;
			for(String str:s)
			{
				b=TaskUtil.isValidName(str);
				if(!b)
				{
					return false;
				}
			}
			return true;
			
		}
}
		