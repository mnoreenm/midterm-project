package libraryterminal;

<<<<<<< HEAD
public class Book {

	private String booktitle;
	private String bookauthor;
	private String bookstatus;
	private String duedate;
	private int id;

	public Book() {
		this.id = id;
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
		this.bookstatus = bookstatus;
		this.duedate = duedate;
	}

	public void setBookTitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public void setBookAuthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public void setBookStatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}

	public String getBookTitle() {
		return booktitle;
	}

	public String getBookAuthor() {
		return bookauthor;
	}

	public String getBookStatus() {
		return bookstatus;
	}

	public void setBookId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return id;
	}

	public void setBookDueDate(String duedate) {
		this.duedate = duedate;
	}

	public String getBookDueDate() {
		return duedate;
	}

	@Override
	public String toString() {
		return "Book [booktitle=" + booktitle + ", bookauthor=" + bookauthor + ", bookstatus=" + bookstatus + "]";
	}

}
=======

public class Book {

	private String bookTitle;
	private String bookAuthor;
	private String bookStatus;
	private String dueDate;

	public Book(String bookTitle, String bookAuthor, String bookStatus,String dueDate) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookStatus = bookStatus;
		this. dueDate = dueDate;

	}

	public void setBooktitle(String booktitle) {
		this.bookTitle = booktitle;
	}

	public void setBookauthor(String bookauthor) {
		this.bookAuthor = bookauthor;
	}

	public void setBookstatus(String bookstatus) {
		this.bookStatus = bookstatus;
	}

	public String getbookTitle() {
		return bookTitle;
	}

	public String getbookAuthor() {
		return bookAuthor;
	}

	public String getbookStatus() {
		return bookStatus;
	}

	public String getdueDate() {
		return dueDate;
	}

	public void setdueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {   //use override with to String 
		return "Title= " + bookTitle + ", Author= " + bookAuthor + ", Status= " + bookStatus + " Due On " + dueDate;
	}

}
>>>>>>> 174fd646cbd5975c6120f7199588309894388af7
