package functions;

public class Strings
{
   public static String uniqueLetters(String str)
   {
	  String returnString = ""; 
		String ch;
		str = str.toLowerCase();
		boolean repeats = false;
	    for(int i=0; i<str.length();i++) {
	       repeats = false;
	    	 ch = str.substring(i, i+1);
	    	 for(int j=0;j<str.length();j++) {
	    		 if(j==i) continue;
	    		 if(ch.equals(str.substring(j, j+1))) {
	    			 repeats = true;
	    			 break;
	    		 }
	    	 }
	    	 if(repeats==false)
	    		 returnString += ch;
	    }
	    return returnString;
   }
}


