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

	public List<Book> readBooks() throws IOException {

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

				Book bookObj = new Book();
				String[] result = line.split(",");
				id = Integer.parseInt(result[0]);

				bookObj.setBookId(id);

				bookObj.setBookTitle(result[1]);
				bookObj.setBookAuthor(result[2]);

				bookObj.setBookStatus(result[3]);

				// If the next column is available(In case of check out date)
				if (result.length > 5) {
					bookObj.setBookDueDate(result[4]);
				}

				booklist.add((id - 1), bookObj);

			}

			return booklist;

		} catch (IOException ex) {
			throw new RuntimeException("unable to read the book list", ex);
		} finally {
			fileReader.close();
		}

	}

	public Set<Book> readBookAsSet() throws IOException {

		Set<Book> bookList = new HashSet<>();
		String line = null;
		FileReader fileReader = null;
		if (!Files.exists(filePath)) {
			return bookList;
		}

		try {
			File file = filePath.toFile();

			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Book bookObj = new Book();
				String[] result = line.split(",");
				bookObj.setBookId(Integer.parseInt(result[0]));
				bookObj.setBookTitle(result[1]);
				bookObj.setBookAuthor(result[2]);

				bookObj.setBookStatus(result[3]);
				if (result.length > 5) {
					bookObj.setBookDueDate(result[4]);
				}

				bookList.add(bookObj);
			}

			return bookList;

		} catch (IOException ex) {
			throw new RuntimeException("unable to read the book list", ex);
		} finally {
			fileReader.close();
		}

	}

	public void deleteContent() {

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

			for (Book bookObj : bookList) {
				sb.append(bookObj.getBookId() + "," + bookObj.getBookTitle() + "," + bookObj.getBookAuthor() + ","
						+ bookObj.getBookStatus());
				if (bookObj.getBookDueDate() != null && bookObj.getBookDueDate().trim() != "") {
					sb.append("," + bookObj.getBookDueDate());
				}
				sb.append("\n");

				// System.out.println("String Buffer" + sb.toString());
			}
			writer.println(sb);

			writer.close();

		} catch (IOException ex) {
			// IOException is a checked exception (I have to handle it)
			// RuntimeException is an unchecked exception (I don't have to
			// handle it)
			throw new RuntimeException("unable to write country list");
		}

	}

}