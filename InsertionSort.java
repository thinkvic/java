

// this is basically insertion sort... O(n)


package stringPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class InsertionSort
{	
	
	public static void main (String[] args) {
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(4,8,6,3));
        int[] a = new int[4];
		int length=0;
		
		for (int i=0; i<4; i++)
		{
			int n= l.get(i);
			insertArray(a, length, n);
			length=length+1;
		}
		
		for (int i=0; i<4; i++)
		{
			System.out.println(a[i]);
		}
			
		
	}
	
	
// to use a separate function to do this has advantages!!!	

	private static void insertArray(int[] a, int length, int n){
				   int loc=length -1;
					
					while ( loc>=0 && n<a[loc] )
					{
						a[loc+1] = a[loc];
						loc= loc -1;		     // loop to move every elements!
					}
					a[loc+1]=n;          // finally insert to the right spot!!
					length=length+1;

	}
		
		
		
}