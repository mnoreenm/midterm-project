package libraryterminal;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
// All functions on books are done here
public class LibraryOperation {

	public boolean checkout(Book book) {
		Calendar c = new GregorianCalendar();
		c.add(Calendar.DATE, 14);// set checkout to true when called
		java.util.Date nextDate = c.getTime();

		book.setBookDueDate("Due date " + nextDate);
		book.setCheckedOut(true);
		return true;

	}

	public void displayFullDetail(List<Book> libraryContent) {
		for (Book book : libraryContent) {
			System.out.println(book);
		}//print the list of books,author ,Title

	}

	public void searchAuthor(String authorName, List<Book> libraryContent) {
		boolean found = false;
		for (Book book : libraryContent) {
			if (book.getBookAuthor().toLowerCase().contains(authorName.toLowerCase())) {
				System.out.println(book.getBookTitle());
				found = true;
			}// search for author name ,print book Title
		}

		if (!found) {// if author not found ,display
			System.out.println("Sorry. No book by this author was found.");
		}
	}

	public void searchTitle(String keyInput, List<Book> libraryContent) {
		boolean found = false;
		for (Book book : libraryContent) {
			if (book.getBookTitle().toLowerCase()
					.contains(keyInput.toLowerCase())) {
				System.out.println(book.getBookTitle() + ":"
						+ book.humanFriendlyCheckOutStatus());
				found = true;//search book by title and display 
			}// if not found display message 
		}
		if (!found) {
			System.out.println("Sorry. No book by this title was found.");
		}

	}

	public void displayPartialDetail(List<Book> libraryContent) {
		for (Book book : libraryContent) {
			System.out.println(book.getBookId() + ": " + book.getBookTitle());
		}//this function is called for checkout list option
//display book id and title
	}

	public Book getBookById(String checkOutBookId, List<Book> libraryContent) {
		if (!checkOutBookId.matches("\\d*")) {
			throw new IllegalArgumentException();
		}//at checkout  throw error if user enter anything except a number 

		for (Book book : libraryContent) {
			if (book.getBookId() == Integer.parseInt(checkOutBookId)) {
				return book;
			}//returns whole line from list
		}
		throw new IllegalArgumentException();

	}

	public void checkIn(Book book) {
		book.setCheckedOut(false);
		book.setBookDueDate("");
	}
}
