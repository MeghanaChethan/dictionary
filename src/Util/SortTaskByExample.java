package Util;




import java.util.Comparator;

public class SortTaskByExample implements Comparator{
	public int compare(Object o1,Object o2)
	{
		if(o1 instanceof TaskBean && o2 instanceof TaskBean)
		{
			TaskBean s1=(TaskBean )o1;
			TaskBean s2=(TaskBean )o2;
			return s1.getExample().compareTo(s2.getExample());
		}
		throw new IllegalArgumentException();
	}

}

