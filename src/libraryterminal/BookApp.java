package libraryterminal;

import java.io.IOException;
import java.util.ArrayList;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		List<Book> bookname = new ArrayList<>();
		BookTextFile booktextfile = new BookTextFile(
				"C:/Users/Pappu/workspace/midterm-project/src/libraryterminal/booklist.txt");
		BookDueDate bookduedate = new BookDueDate();
		Book book = new Book();
		String bookstatus = null;
		int userInput = 0;
		Book cust;
		int id;
		System.out.println("***********************************");
		System.out.println("Welcome to the PBS Library Terminal");
		System.out.println("***********************************");
		do {
			System.out.println("Choose one of the options below:");

			System.out.println("1.See the list of Books");
			System.out.println("2.Do you want to search for a book by author?");
			System.out.println("3.Do you want to search for a book by Keyword");
			System.out.println("4.Checkout Book");
			System.out.println("5.Return a Book");
			System.out.println("6.Quit");
			try {
				userInput = sc.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Invalid input.Please try again");
				sc.next();
			}

			switch (userInput) {
			case 1:
				bookname = booktextfile.saveBooks();
				for (Book name : bookname) {
					System.out.println(name);
				}
				break;

			case 2:
				System.out.println("Enter Author name");
				String AuthorInput = sc.next();
				bookname = booktextfile.saveBooks();
				for (Book ba : bookname) {
					if (AuthorInput.equalsIgnoreCase(ba.getBookAuthor())) {
						System.out.println(ba.getBookTitle());

					}
				}
				break;
			case 3:
				System.out.println("Enter a keyword to search for the Title of a book");
				sc.nextLine();
				String keyInput = sc.nextLine();
				bookname = booktextfile.saveBooks();
				for (Book b : bookname) {
					if (b.getBookTitle().toLowerCase().contains(keyInput.toLowerCase())) {
						System.out.println(b.getBookTitle() + ":" + b.getBookStatus());
					}
				}
				break;
			case 4:
				for (Book b : bookname) {
					System.out.println(b.getBookId() + "   " + b.getBookTitle());
				}
				System.out.println("Select the book you want to check out");
				sc = new Scanner(System.in);
				id = sc.nextInt();
				cust = bookname.get((id - 1));
				bookstatus = cust.getBookStatus();
				if (bookstatus == "Checked Out") {
					System.out.println("Selected book is not available for checkout");
				} else {
					cust.setBookStatus(" Checked Out: ");
					sc.nextLine();
					cust.setBookDueDate(bookduedate.date1());
					System.out.println(cust.getBookStatus() + " " + cust.getBookDueDate());

					booktextfile.removeCopy();
					booktextfile.writeBooks(bookname);
				}
				break;

			case 5:
				for (Book b : bookname) {
					System.out.println(b.getBookId() + "   " + b.getBookTitle());
				}
				System.out.println("Enter the book you want to Return");
				sc = new Scanner(System.in);
				id = sc.nextInt();
				cust = bookname.get((id - 1));
				System.out.println(cust.getBookTitle() + ":" + bookstatus);
				cust.setBookStatus("OnShelf");
				cust.setBookDueDate("");
				System.out.println(cust.getBookStatus() + cust.getBookDueDate());
				booktextfile.removeCopy();
				booktextfile.writeBooks(bookname);
				break;

			case 6:
				choice = "n";
				System.out.println("Thanks for using our library system. Bye..");
				break;
			}
		} while (choice.equals("y"));
	}
}
