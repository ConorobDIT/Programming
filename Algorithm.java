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
		//Declaring all variables.
	    private static String sentence;
	    private static String[] word;
	    //This variable holds all of the words that are common in texts.
	    private static String[] textwords = {"c", "txt" ,"lol", "haha", "u", "r", "k", "d", "n" ,"b", "l8r" } ;
	    private static ArrayList<String> emails = new ArrayList<String>();
	    private static ArrayList<String> texts = new ArrayList<String>();
	    private static ArrayList<String> messages = new ArrayList<String>();
	    protected static int emailcount = 0;
	    static int textcount = 0;
	    
		public Algorithm(){ 
	    	// reads the file
	    	FileManager fm 	= new FileManager("textandemail.txt");
	    	fm.connectToFile();
	    	messages.addAll(fm.readFile());
	    	fm.closeReadFile();
		
	    	//Start of the check if the messages are texts or emails 
	    	for (String sentence : messages)
	    	{
	    		int isEmail = 0;
	    		int totallength = 0;
	    		int length = 0;
	    		int average = 0;
	    		int textwordpoints = 0;
	    		//Splits the setences into single words to compare against the text words
    			word = sentence.split(" ");
	    		for(int j=0; j<word.length ;j++ )
	    		{	
	    			length++; //Counting the word lengths 
	    			totallength += word[j].length();
		    		textwordpoints = 0;
	    			word[j].length();
	    			//start of algorithm to find if they are texts or emails
	    			for(int h=0; h<textwords.length;h++)
	    			{
	    				//If the word matches one of the text words we add 1 to the textwordpoints variable
	    				if(word[j]== textwords[h])
	    				{

	    					textwordpoints++;
	    				}
	    			}
	    		}
	    		//This is getting the average word length
	    		average = totallength / length; 
	    		/*
	    		 * The following code checks the results to what is usually in emails.
	    		 * If there is no text words, 1 is added to the isEmail variable
	    		 * 1 is also added if there is more than 6 letters on average in each word
	    		 * or if the length of the message is more than 8 words
	    		 * Texts are usually short and to the point so this gets most emails
	    		 * unless they are very text-like.
	    		 	*/
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
	    		//If the message is most likely an email, then it will be added to the emails list
	    		if(isEmail >=2)
	    		{
	    			emails.add(sentence);
	    			emailcount++;
	    		}
	    		//If the message is most likely a text, it will be added to the text list
	    		else
	    		{
	    			texts.add(sentence);
	    			textcount++;
	    		}
	    	}
		}
		//This method prints out how many texts and emails there were and it prints out 
		//All the texts and emails.
	    	public void results()
	    	{
		    	System.out.println("The number of Texts are:  "+ textcount);
		    	System.out.println("\nThe number of E-mails are:  "+ emailcount);
	
		    	System.out.println("\nThe texts are:  ");
		    	System.out.println("\n" +texts);
		    	
	
		    	System.out.println("\nThe emails are:  ");
		    	System.out.println("\n" +emails);
	    		
	    	}
			}

