package Util;



import java.util.Comparator;

public class SortTaskByName implements Comparator{
	public int compare(Object o1,Object o2)
	{
		if(o1 instanceof TaskBean && o2 instanceof TaskBean)
		{
			TaskBean s1=(TaskBean )o1;
			TaskBean s2=(TaskBean )o2;
			return s1.getTaskName().compareTo(s2.getTaskName());
		}
		throw new IllegalArgumentException();
	}

}

