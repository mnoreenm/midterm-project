package libraryterminal;

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
