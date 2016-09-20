package libraryterminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryUserStation  {

	public static void main(String[] args) throws IOException {

		String libraryFile = "C:/Users/Administrator/workspace/midterm-project/src/libraryterminal/booklist.txt";
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		List<Book> libraryContent = new ArrayList<Book>();
		LibraryReader reader = new LibraryReader();

		Book book = null;
		LibraryOperation libraryOperation = new LibraryOperation();

		do {
			createMenu();
			String userInput = sc.next();
			try {
				switch (userInput) {
				case "1":
					libraryContent = reader.readBooks(libraryFile);
					libraryOperation.displayFullDetail(libraryContent);
					break;

				case "2":
					System.out.println("Enter Author name");
					String authorName = sc.next();
					libraryContent = reader.readBooks(libraryFile);
					libraryOperation.searchAuthor(authorName, libraryContent);
					break;

				case "3":
					System.out
							.println("Enter a keyword to search for the Title of a book");
					sc.nextLine();
					String keyInput = sc.nextLine();
					libraryContent = reader.readBooks(libraryFile);
					libraryOperation.searchTitle(keyInput, libraryContent);
					break;

				case "4":
					libraryContent = reader.readBooks(libraryFile);
					libraryOperation.displayPartialDetail(libraryContent);

					System.out.println("Select the book you want to check out");

					sc = new Scanner(System.in);
					String checkOutBookId = sc.next();
					book = libraryOperation.getBookById(checkOutBookId,
							libraryContent);

					if (book.isCheckedOut()) {
						System.out
								.println(" Sorry another user has this booked already checked out.");

					} else {
						libraryOperation.checkout(book);

						System.out.println(book.humanFriendlyCheckOutStatus()
								+ "\t" + book.getBookDueDate());

						writeLibraryContent(libraryFile, libraryContent);

					}
					break;

				case "5":
					libraryContent = reader.readBooks(libraryFile);//funtion read books from reader
					libraryOperation.displayPartialDetail(libraryContent);

					System.out.println("Enter the book you want to Return");

					sc = new Scanner(System.in);
					String checkInBookId = sc.next();
					book = libraryOperation.getBookById(checkInBookId,
							libraryContent);
					if (!book.isCheckedOut()) {
						System.out
								.println("Sorry. This book is not checked out yet. Please try again");
						throw new IllegalArgumentException();
					}
					libraryOperation.checkIn(book);

					writeLibraryContent(libraryFile, libraryContent);

					System.out.println(book.getBookTitle()
							+ " has been checked in.");
					break;

				case "0":
					choice = "n";
					System.out
							.println("Thanks for using our library system. Bye..");
					break;
				default:
					throw new IllegalArgumentException();
				}

			} catch (Exception ex) {
				System.out.println("Invalid Selection. Try Again.");
			}

		} while (choice.equals("y"));

		try {
			sc.close();
		} finally {
			// eat exception
		}
	}

	private static void writeLibraryContent(String libraryFile,
			List<Book> libraryContent) {//
		LibraryWriter writer = new LibraryWriter(libraryFile);
		writer.writeBooks(libraryContent);
	}

	private static void createMenu() {
		System.out.println("\n************************************");
		System.out.println("Welcome to the PBS Library Terminal");
		System.out.println("************************************\n");
		System.out.println("Choose one of the options below:");
		System.out.println("1.See the list of Books");
		System.out.println("2.Do you want to search for a book by author?");
		System.out.println("3.Do you want to search for a book by Keyword");
		System.out.println("4.Checkout Book");
		System.out.println("5.Return a Book");
		System.out.println("0.Quit");
	}
}
