package functions;
import java.util.*;

public class Encoding
{
   public static Set<String> morseCodes(int m, int n)
   {
      Set<String> returnValue = new TreeSet<>();
      if(m!=0&&n!=0)
      {
    	  for (String str : morseCodes(m-1,n))
          {
        	  returnValue.add(str+".");
          }
          for (String str : morseCodes(m,n-1))
          {
        	  returnValue.add(str+"-");
          }
      }
      else if (m==n&&n==0)
      {
    	   returnValue.add("");
      }
      else if (m==0)
      {
    	  for (String str : morseCodes(m,n-1))
          {
        	  returnValue.add(str+"-");
          }
      }
      else
      {
    	  for (String str : morseCodes(m-1,n))
          {
        	  returnValue.add(str+".");
          }
      }
      return returnValue;
   }
}