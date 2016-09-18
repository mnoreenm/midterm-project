package libraryterminal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BookTextFile {

	private Path filePath;
	/**
	 * 
	 * @param filePathString
	 */
		
	public BookTextFile(String filePathString){
		this.filePath = Paths.get(filePathString);
	}
	/**
	 * 
	 */
	public BookTextFile(){
		this("C:/Users/Administrator/workspace/midterm-project/src/libraryterminal/BookTextFile.java");
	}
	/**
	 * 
	 * @return
	 */
	public List<String> readBooks(){
		List<String> books = new ArrayList<>();
		if(!Files.exists(filePath)){
			return books;
			/**
			 * 
			 */
		}
		try {
			File file = filePath.toFile();
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = reader.readLine();
			while (line != null){
				books.add(line);
				line = reader.readLine();
			}
			reader.close();
			return books;
	/**
	 * 		
	 */
			
		}catch (IOException ex) {
			throw new RuntimeException("Unable to read books.", ex);
		}
		
	}	
	/**
	 * 
	 * @param books
	 */
		
	public void saveBooks(List<String> books) {
		try {
			if (!Files.exists(filePath)) {
				Files.createFile(filePath);
			}
			
			File file = filePath.toFile();
			PrintWriter writer = new PrintWriter(
			                     new BufferedWriter(
			                     new FileWriter(file, true))); 
			
			for (String book : books) {
				writer.println(book);
				
			}
			
			writer.close();
		} catch (IOException ex) { // IOException is a checked exception (I have to handle it)
			// RuntimeException is an unchecked exception (I don't have to handle it)
			throw new RuntimeException("Unable to save books.", ex);
		}
	}

	public void saveBooks(String ch) {
		// TODO Auto-generated method stub
		
	}
		
			
		
		

}