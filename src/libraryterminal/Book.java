package libraryterminal;

public class Book {

	private String booktitle;
	private String bookauthor;
	private boolean checkedOut;
	private String duedate;
	private int id;

	public Book(String booktitle, String bookauthor, boolean checkedOut,
			String duedate, int id) {
		this.id = id;
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
		this.checkedOut = false;
		this.duedate = duedate;
	}

	public Book() {

	}

	public void setBookTitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookTitle() {
		return booktitle;
	}

	public void setBookAuthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getBookAuthor() {
		return bookauthor;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public boolean isCheckedOut() { //for boolean is instead of get
		return checkedOut;
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

	public String humanFriendlyCheckOutStatus() {
		return this.checkedOut ? "Checked Out" : "Available";
	}// if checkedout is y then checkout else available

	@Override
	public String toString() {
		
	System.out.println(	"");
			
		return "Book [booktitle=" + booktitle + ", bookauthor=" + bookauthor
				+ ", bookstatus="  + humanFriendlyCheckOutStatus() + "]";
	}
}
