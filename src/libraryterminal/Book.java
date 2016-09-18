package libraryterminal;


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