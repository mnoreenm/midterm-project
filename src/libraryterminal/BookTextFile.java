package libraryterminal;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookTextFile {
	String bookTitle;
	String bookAuthor;
	String bookStatus;

	private Path filePath;

	public BookTextFile(String filePathString) {
		this.filePath = Paths.get(filePathString);
	}

	public BookTextFile() {
		this("C:/Users/Pappu/workspace/midterm-project/src/libraryterminal/booklist.txt");
	}

	public List<Book> saveBooks() throws IOException {

		List<Book> booklist = new ArrayList<>();
		String line = null;
		FileReader fileReader = null;
		int id;
		if (!Files.exists(filePath)) {
			return booklist;
		}

		try {
			File file = filePath.toFile();

			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				Book b = new Book();
				String[] result = line.split(",");
				id = Integer.parseInt(result[0]);

				b.setBookId(id);

				b.setBookTitle(result[1]);
				b.setBookAuthor(result[2]);

				b.setBookStatus(result[3]);

				if (result.length > 5) {
					b.setBookDueDate(result[4]);
				}

				booklist.add((id - 1), b);

			}

			return booklist;

		} catch (IOException ex) {
			throw new RuntimeException("unable to read the book list", ex);
		} finally {
			fileReader.close();
		}

	}

	public void removeCopy() {

		File file = filePath.toFile();
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);

			writer.print("");
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeBooks(List allBooks) {

		try {
			if (!Files.exists(filePath)) {
				Files.createFile(filePath);
			}

			List<Book> bookList = allBooks;
			File file1 = filePath.toFile();
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file1, true)));
			StringBuffer sb = new StringBuffer();

			for (Book obj : bookList) {
				sb.append(obj.getBookId() + "," + obj.getBookTitle() + "," + obj.getBookAuthor() + ","
						+ obj.getBookStatus());
				if (obj.getBookDueDate() != null && obj.getBookDueDate().trim() != "") {
					sb.append("," + obj.getBookDueDate());
				}
				sb.append("\n");
			}
			writer.print(sb);

			writer.close();

		} catch (IOException ex) {
			// IOException is a checked exception (I have to handle it)
			// RuntimeException is an unchecked exception (I don't have to
			// handle it)
			throw new RuntimeException("unable to write book list");
		}

	}

}