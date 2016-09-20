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
import java.util.ArrayList;
import java.util.List;

public class LibraryReader {

	public LibraryReader() {
	}

	public List<Book> readBooks(final String filePathString) throws IOException {

		Path filePath = Paths.get(filePathString);

		final List<Book> booklist = new ArrayList<Book>();
		String line = null;
		FileReader fileReader = null;
		int id;
		if (!Files.exists(filePath)) {
			return booklist;
		}

		try {
			final File file = filePath.toFile();

			fileReader = new FileReader(file);
			final BufferedReader bufferedReader = new BufferedReader(fileReader);
//while line is empty
			while ((line = bufferedReader.readLine()) != null) {

				if (line.trim().length() > 0) {
					final Book bookObj = new Book();
					final String[] result = line.split(",");

					id = Integer.parseInt(result[BookFieldEnum.ID
							.getFieldPosition()]);//calling enum to get Id

					bookObj.setBookId(id);

					bookObj.setBookTitle(result[BookFieldEnum.TITLE
							.getFieldPosition()]);
					bookObj.setBookAuthor(result[BookFieldEnum.AUTHOR
							.getFieldPosition()]);

					if (result[BookFieldEnum.STATUS.getFieldPosition()]
							.equalsIgnoreCase("Y")) {
						bookObj.setCheckedOut(true);
					} else {
						bookObj.setCheckedOut(false);
					}

					// if book is not checked out ,checkout date is null else it
					//will have a due date
					
					if (result.length > 5) {
						bookObj.setBookDueDate(result[BookFieldEnum.DUE_DATE
								.getFieldPosition()]);
					}

					booklist.add((id - 1), bookObj);
				}
			}

			return booklist;

		} catch (final IOException ex) {
			throw new RuntimeException("unable to read the book list", ex);
		} finally {
			fileReader.close();
		}

	}

}