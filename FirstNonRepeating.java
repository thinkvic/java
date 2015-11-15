package Collec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeating {
	
	public static void main (String args[])
	{
		List<Integer> l2=new ArrayList<Integer>() ;
	    l2=nonRepeat();
	    for (Integer integer : l2) {
	    	System.out.println(integer);
		}

	}
	
	
	private static List<Integer> nonRepeat(){
		int[] arr={7,1,2,2,3,3,3};
		int e=0;
	    Map<Integer, Integer> h= new HashMap<Integer, Integer>();
		List<Integer> l= new ArrayList<Integer>();
	
		for (int i=0; i<arr.length; i++)
		{
			e=arr[i];
			
			if (! (h.containsKey(e) )  )
			{
				h.put(e, 1);
			}
			else {
				int v=0;
				v=h.get(e);    // rewrite the value for a certain key!
				v=v+1;
				h.put(e, v);
			}
		}
		

		Iterator<Entry<Integer, Integer>> it = h.entrySet().iterator();
		while (it.hasNext()){
			Map.Entry<Integer, Integer> pair= (Map.Entry<Integer, Integer>) it.next();
			if (pair.getValue() == 1)
			{l.add(pair.getKey());}
		
		}
		
		
		return l;
	}

}
