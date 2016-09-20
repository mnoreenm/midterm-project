package libraryterminal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class BookTest {

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
