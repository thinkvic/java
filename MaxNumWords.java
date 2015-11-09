

/*String Manipulation Example, this will return the max number of words of a series of sentences  punctuated by .?! */

public class MaxNumWords {
	
	  public static void main (String[] args){
		    
		  String a="We test coders.  Give us a try      ?";
		  int b=solution(a);
		  System.out.println(b);
		  
	  }
	
	private static int solution(String s) 
	{
        int max=0;
        int begin=0;
        int end=0;
        
        for (int i=0; i<s.length(); i++)
        {
        	
        	char c=s.charAt(i);
        	if ((c=='.') || (c=='?') || (c=='!'))
        	{
        		end=i;
        		String sub=s.substring(begin, end).trim();
        		String[] words=sub.split(" ");
        		int current=words.length;
        		if (current>max)
        		{
        			max = current;
        		}
        		begin=i+1;    		
        	}
        	
        
        	if (i==s.length()-1 && c!='.' && c!='?' && c!='!');
        	{
        		end=i+1;
        		String sub=s.substring(begin,end).trim();
        		String[] words=sub.split(" ");
        		int current=words.length;
        		if (current > max)
        		{
        			max = current;
        		}
        	}
        	
        	
        }
		
		return max;
    }

}
