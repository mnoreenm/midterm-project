package libraryterminal;

import static org.junit.Assert.*;

<<<<<<< HEAD
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
=======
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

>>>>>>> 6b91052def690888e9e5975619ef1ed09cc48543
import org.junit.Test;

import junit.framework.Assert;

public class BookTest {

<<<<<<< HEAD
//	private Book book;
//	@Test
//	public void BookbyAuthor() {
//		Book book = new Book ();
//		book.getBookAuthor();
//		book.getBookTitle();
//		Assert.assertEquals("David", "Bugs At The Beach");
//	}
//		
//	private Book book1;
//	@Test
//	public void bookbyAuthor() {
//		Book book = new Book ();
//		book.getBookAuthor();
//		book.getBookTitle();
//		Assert.assertEquals("Nathan", "The Nix");
//	}
//	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}

//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}

//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void testBook() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testSetBookTitle() {
//		
//	}

Book book = new Book();
	@Test
	public void testAuthorNameOrBookTitle() {
		String actualValue = book.getBookAuthor();
		String expectedValue = book.getBookTitle();	
		assertEquals(expectedValue, actualValue);
	}
//
	@Test
	public void testGetBookStatus() {
	String actualValue = book.getBookStatus();
	String expectedValue = null;
	assertEquals(expectedValue, actualValue);
	}
//
//	@Test
//	public void testSetBookId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetBookId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetBookDueDate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetBookDueDate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToString() {
//		fail("Not yet implemented");
	}
//
//}
=======
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
>>>>>>> 6b91052def690888e9e5975619ef1ed09cc48543
