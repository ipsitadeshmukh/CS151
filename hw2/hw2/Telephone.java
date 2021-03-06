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
      while (more)
      {
         String input = scanner.nextLine();
         if(c.getDidReset() == true)
         {
        	 if(input.equals("1")){
        		 speak(RECORD_MESSAGE_PROMPT);
        		 //change state to connected
        		 c.setState(1);
        		 c.setFirstInput(true);
        		 c.setDidReset(false);
        		 c.dial(input);
        	 }
        	 else if(input.equals("2")){
        		 speak(ACCESS_YOUR_MAILBOX_PROMPT);
        		 //enter the mailbox to access
        		 c.setState(7);
        		 c.setDidReset(false); 
        		 c.setFirstInput(true);
        		 c.dial(input);
        	 }
        	 else{
        		 speak("Invalid entry! Enter 1 or 2");
        	 }
         }
         
         else{
        	 	c.setFirstInput(false);
	         if (input == null) return;
	         if (input.equalsIgnoreCase("H"))
	            c.hangup();
	         if(!c.getMailboxNumberGiven()) //Checks if mailbox number is given yet
	         {
	        	   if("1234567890#".contains(input)==false) //if not, resets connection
	        	   {
	        		   System.out.println("Incorrect mailbox number. Please enter numbers properly. Connection will be reset");
	        		   c.resetConnection();
	        	   }
	        		   
	            else if (input.length() == 1 && "1234567890#".contains(input))
	            {
        	 			c.setMailboxNumberGiven(true);
        	 			c.dial(input);
	            }        
	        	 	else
	        	 		c.record(input);
	         }
	         else if (input.equalsIgnoreCase("Q"))
	            more = false;
	         else if (input.length() == 1
	            && "1234567890#".contains(input))
	            {
	        	 		c.setMailboxNumberGiven(true);
	        	 		c.dial(input);
	            } 
	         else
	            c.record(input);
         }
      }
   }

   private static final String RECORD_MESSAGE_PROMPT = 
	         "Enter mailbox number followed by #"; 
   private static final String ACCESS_YOUR_MAILBOX_PROMPT = 
		         "Please enter your passcode followed by #";
   private Scanner scanner;
}
