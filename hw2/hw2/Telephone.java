import java.util.Scanner;

/**
   A telephone that takes simulated keystrokes and voice input
   from the user and simulates spoken text.
*/
public class Telephone
{
   /**
      Construct phone object.
      @param aScanner that reads text from a character-input stream
   */
   public Telephone(Scanner aScanner)
   {
      scanner = aScanner;
   }

   /**
      Speak a message to System.out.
      @param output the text that will be "spoken"
   */
   public void speak(String output)
   {
      System.out.println(output);
   }

   /**
      Loops reading user input and passes the input to the
      Connection object's methods dial, record or hangup.
      @param c the connection that connects this phone to the
      voice mail system
   */
   public void run(Connection c)
   {
      boolean more = true;
      int lineCount = 1;
      while (more)
      {
         String input = scanner.nextLine();
         if (input.equalsIgnoreCase("H"))
             c.hangup();
         if (input == null) return;
         if(input.length()==0) {
        	 	System.out.println("Invalid entry");
       		c.resetConnection();
       		more = false;
         }
         else if("1234567890#".contains(input) == false ) {
      		System.out.println("Invalid entry");
      		c.resetConnection();
      		more = false;
         }
         else if( input.equals("#") && lineCount == 1) {
     		System.out.println("Invalid entry");
     		c.resetConnection();
     		more = false;
         }
         else if (input.length() == 1
            && "1234567890#".contains(input))
        		//&& "#".contains(input) && lineCount > 1)
         c.dial(input); 
         else
            c.record(input);
         lineCount++;
      }
   }

   private Scanner scanner;
}
