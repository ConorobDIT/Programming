import java.util.ArrayList;

/**************************************************
	 * 
	 * 
	 *  This class holds the main algorithm for deciding whether the message is an email or a text
	 *  Author: Conor O'Brien - C14733295
	 *  2016
	 *  
	 *  
	 ************************************************************************************/


	public class Algorithm
	{
	    private static String sentence;
	    private static String[] word;
	    private static String[] textwords = {"c", "txt" ,"lol", "haha", "u", "r", "k", "d", "n" ,"b", "l8r" } ;
	    protected static ArrayList<String> emails = new ArrayList<String>();
	    protected static ArrayList<String> texts = new ArrayList<String>();
	    private static ArrayList<String> messages = new ArrayList<String>();
	    protected static int emailcount = 0;
	    static int textcount = 0;
	    
		public Algorithm(){ 
	    	// read in the roles
	    	FileManager fm 	= new FileManager("textandemail.txt");
	    	fm.connectToFile();
	    	messages.addAll(fm.readFile());
	    	fm.closeReadFile();
			

	    	
	    	// check if the role exists in the file values in the file
	    	for (String sentence : messages)
	    	{
	    		int isEmail = 0;
	    		int totallength = 0;
	    		int length = 0;
	    		int average = 0;
	    		int textwordpoints = 0;
    			word = sentence.split(" ");
	    		for(int j=0; j<word.length ;j++ )
	    		{	
	    			length++;
	    			totallength += word[j].length();
		    		textwordpoints = 0;
	    			word[j].length();
	    			//start of algorithm to find if they are texts or emails
	    			for(int h=0; h<textwords.length;h++)
	    			{
	    				if(word[j]== textwords[h])
	    				{

	    					textwordpoints++;
	    				}
	    			}
	    		}
	    		average = totallength / length; 
	    		
	    		if(textwordpoints == 0)
	    		{
	    			isEmail++;
	    		}
	    		if(average > 6)
	    		{
	    			isEmail++;
	    		}
	    		if(length > 8)
	    		{
	    			isEmail++;
	    			
	    		}
	    		
	    		if(isEmail >=2)
	    		{
	    			emails.add(sentence);
	    			emailcount++;
	    		}
	    		else
	    		{
	    			texts.add(sentence);
	    			textcount++;
	    		}
	    	}
		}
		
	    	public static void results()
	    	{
		    	System.out.println("The number of Texts are:  "+ textcount);
		    	System.out.println("\nThe number of E-mails are:  "+ emailcount);
	
		    	System.out.println("\nThe texts are:  ");
		    	System.out.println("\n" +texts);
		    	
	
		    	System.out.println("\nThe emails are:  ");
		    	System.out.println("\n" +emails);
	    		
	    	}
			}

