package libraryterminal;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class BookTest {

	Book book = new Book();

	@Test
	public void testBookTitle() {
		book.setBookTitle("The Nix");
		assertEquals("The Nix", book.getBookTitle());
	}

	@Test
	public void testAuthorName() {
		book.setBookAuthor("David");
		assertEquals("David", book.getBookAuthor());
	}

	@Test
	public void testBookDueDate() {
		book.setBookDueDate("09/30/15");
		assertEquals("09/30/15", book.getBookDueDate());
	}
		@Test
	public void testBookIDNumber() {
		book.setBookId(11);
		assertEquals(11, book.getBookId());
	}

	@Test
	public void testuserinput1_case1() {
		int userInput = 1;
		assertEquals(1, userInput);
	}

	@Test
	public void testuserinput2_case2() {
		int userInput = 2;
		assertEquals(2, userInput);
	}

	@Test
	public void testuserinput3_case3() {
		int userInput = 3;
		assertEquals(3, userInput);
	}

	@Test
	public void testwhenauthor_title() throws IOException {
		List<Book> bookname = new ArrayList<>();
		BookTextFile booktextfile = new BookTextFile();
		bookname = booktextfile.saveBooks();
		String AuthorInput = "David";
		String title = null;
		for (Book name : bookname) {
			if (AuthorInput.equalsIgnoreCase(name.getBookAuthor())) {
				title = name.getBookTitle();
			}
			assertEquals("Bugs At The Beach", title);
		}
	}

}