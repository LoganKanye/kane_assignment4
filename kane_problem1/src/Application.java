//testing application for DuplicateRemover Class
public class Application {

	public static void main(String[] args) {
		
		DuplicateRemover test = new DuplicateRemover();
		test.remove("problem1.txt");
		test.write("unique_words.txt");
		
	}

}
