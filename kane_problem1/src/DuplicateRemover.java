import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateRemover {
	
	//collection of unique words
	private ArrayList<String> uniqueWords = new ArrayList<String>();
	
	//method to fill unique words arraylist
	public void remove (String dataFile) {
		
		try {
			
			//create new file object to be scanned for input
			File file = new File(dataFile);
			Scanner in = new Scanner(file);
			
			//declare current word and count of word in file 
			String currentWord;
			int currentWordCount;
			
			//loop until no words remain
			while(in.hasNext()) {
				
				//set current word and rest count
				currentWord = in.next();
				currentWordCount = 0;
				
				//loop to check and count duplicates in arraylist 
				for (int i = 0; i < uniqueWords.size(); i++) {
					
					if (currentWord.equalsIgnoreCase(uniqueWords.get(i))) {
						
						currentWordCount++;
						
					}
					
				}
				
				//adds word if no duplicates found in arraylist
				if (currentWordCount == 0) {
					
					uniqueWords.add(currentWord);
					
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
				
				out.write(uniqueWords.get(i) + " ");
				
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
