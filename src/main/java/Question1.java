package main.java;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Question1 
{
	//Question1: Part a) Method to verify whether file exists in provided path
	static Boolean doesFileExist(String path)
	{
		File tempFile = new File(path); 
		try
		{ 
			if(tempFile.exists()==false) //checks and returns exception if file does not exists
			{
				throw new FileNotFoundException();
			}
			else 
			{
				System.out.println("The inpiut file exists"); // assert file exists
				return true;	
			}
		}
	    catch (FileNotFoundException ex) 
		{
    	    System.err.println("The file does not exists");
    	    ex.getStackTrace();
    	    return false;    	  
        }
	}

	public static void main(String[] a) throws InterruptedException
	{
		String path = "src/resources/input.txt";
		//Question1) Part b) Checks if file exists, if exists then prints the word and its meanings
		if(doesFileExist(path))
	    {
			try 
			{
				//Question2 
				File tempFile = new File(path); //pass the file path to file object
				BufferedReader br = new BufferedReader(new FileReader(tempFile)); //reads text from file
				for (String line = br.readLine(); line != null; line = br.readLine()) //traverse and read all the lines in a file
			    {
					String[] line1 = line.split("-"); //splits the line on '-'
				    String word = line1[0].trim(); //trim extra spaces on word 
					System.out.println(word); 
					String[] temp = line1[1].split(","); //splits the meanings on ','
					for (String j : temp) //traverse through all the meanings for a given word
					{
						String meaning = j.trim(); //trim extra spaces
						System.out.println(meaning);
					}
				}
			br.close();
		    }
		    catch (Exception ex)	
		    {
		    	ex.getStackTrace();
		    }
        }
    }
}
