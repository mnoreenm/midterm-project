package libraryterminal;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LibraryWriter  {

	Path filePath = null;

	public LibraryWriter(String filePathString) {
		this.filePath = Paths.get(filePathString);
	}

	private void deleteContent() {
// calls this funtion to delete file contents  
		final File file = filePath.toFile();//file open
		PrintWriter writer;   //
		try {
			writer = new PrintWriter(file);  // instance with file path

			writer.print("");  //write line with empty string. way to delete content  
			writer.close();

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeBooks(final List<Book> allBooks) {

		try {
			if (!Files.exists(filePath)) {
				Files.createFile(filePath);
			} else {
				deleteContent();
			}

			final List<Book> bookList = allBooks;
			final File file1 = filePath.toFile();
			final PrintWriter writer = new PrintWriter(new BufferedWriter(
					new FileWriter(file1, true)));

			final StringBuilder sb = new StringBuilder();

			for (final Book bookObj : bookList) {
				sb.append(bookObj.getBookId() + "," + bookObj.getBookTitle()
						+ "," + bookObj.getBookAuthor() + ",");

				if (bookObj.getBookDueDate() != null
						&& bookObj.getBookDueDate().trim() != "") {
					sb.append("Y," + bookObj.getBookDueDate());
				} else {
					sb.append("N");
				}
				sb.append("\n");
			}
			writer.println(sb);

			writer.close();

		} catch (final IOException ex) {
			// IOException is a checked exception (I have to handle it)
			// RuntimeException is an unchecked exception (I don't have to
			// handle it)
			throw new RuntimeException("unable to write country list");
		}

	}

}

