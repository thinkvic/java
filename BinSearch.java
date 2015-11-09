

/* sorting and binarySearch for collection */

package Collec;

import java.util.ArrayList;
import java.util.Collections;

public class BinSearch {

	public static void main(String[] args) {
	  ArrayList arrayList = new ArrayList();

	  arrayList.add("1");
	  arrayList.add("4");
	  arrayList.add("2");
	  arrayList.add("5");
	  arrayList.add("3");
	 
//first sorting
	  Collections.sort(arrayList);
	  System.out.println("Sorted ArrayList contains : " + arrayList);
	 
//then searching
	  int index = Collections.binarySearch(arrayList,"4");
	 
	  System.out.println("Element found at : " + index);
    }
}
