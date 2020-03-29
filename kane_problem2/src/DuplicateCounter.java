import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateCounter {
	
	//collection of unique words
	private ArrayList<String> uniqueWords = new ArrayList<String>();
	private ArrayList<Integer> uniqueWordCount = new ArrayList<Integer>();
	
	//method to fill unique words arraylist
	public void count (String dataFile) {
		
		try {
			
			//create new file object to be scanned for input
			File file = new File(dataFile);
			Scanner in = new Scanner(file);
			
			//declare current word and count of word in file 
			String currentWord;
			int currentWordCount;
			int index;
			
			//loop until no words remain
			while(in.hasNext()) {
				
				//set current word and rest index
				currentWord = in.next();
				currentWordCount = 0;
				
				//loop to check and count duplicates in arraylist 
				for (index = 0; index < uniqueWords.size(); index++) {
					
					if (currentWord.equalsIgnoreCase(uniqueWords.get(index))) {
						
						currentWordCount++;
						break;
						
					}
					
				}
				
				//adds word and starts count if no duplicates found in arraylist
				if (currentWordCount == 0) {
					
					uniqueWords.add(currentWord);
					uniqueWordCount.add(1);
					
				}
				
				//updates word count for index the word is located 
				else {
					
					uniqueWordCount.set(index, uniqueWordCount.get(index) + 1);
					
				}
				
				
			}
			
			//close in scanner
			in.close();
			
		}
		
		//catch file not found exceptions
		catch (FileNotFoundException error) {
			
			System.out.println("No Input File Exists in Project Directory.");
			
		}
		
	}
	
	//method to write unique word arraylist to output file 
	public void write (String outputFile) {
		
		try {
			
			//create output file object and writer
			File file = new File(outputFile);
			FileWriter out = new FileWriter(file);
			
			//loop to print arraylist
			for (int i = 0; i < uniqueWords.size(); i++) {
				
				out.write(uniqueWords.get(i) + ": " + uniqueWordCount.get(i) + " | ");
				
			}
			
			//close writer
			out.close();
			
		}
		
		//catch IO exceptions
		catch(IOException error) {
			
			System.out.println("File Generation Failed: " + error);
			
		}
		
	}

}

