package libraryterminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		List<Book> bookname = new ArrayList<>();
		BookTextFile booktextfile = new BookTextFile("C:/Users/Pappu/workspace/midterm-project/src/libraryterminal/booklist.txt");
		BookDueDate bookduedate = new BookDueDate();
		Book book = new Book();
		String bookstatus = null;
		int userInput;
		Book user;
		int id;
		System.out.println("Welcome to the PBS Library Terminal");
		do{
		System.out.println("Choose one of the options below:");
		System.out.println("1.See the list of Books");
		System.out.println("2.Do you want to search for a book by author?");
		System.out.println("3.Do you want to search for a book by Keyword");
		System.out.println("4.Checkout Book");
		System.out.println("5.Return a Book");
		userInput = sc.nextInt();
		switch (userInput) {
		case 1:
			bookname =  booktextfile.readBooks();
			for (Book name : bookname) {
				System.out.println(name);
			}
				break;
		
		case 2:
			System.out.println("Enter Author name");
			String AuthorInput = sc.next();
			bookname = booktextfile.readBooks();
			for (Book ba : bookname) {
				if (AuthorInput.equalsIgnoreCase(ba.getBookAuthor())){
					System.out.println(ba.getBookTitle());

				}
			}
			break;
		case 3:
			System.out.println("Enter a keyword to search for the Title of a book");
			sc.nextLine();
			String keyInput = sc.nextLine();
			bookname = booktextfile.readBooks();
			for (Book b : bookname) {
				if (b.getBookTitle().toLowerCase().contains(keyInput.toLowerCase())) {
					System.out.println(b.getBookTitle() + ":" +  b.getBookStatus());
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
	
			user = bookname.get((id -1));
			
			bookstatus=user.getBookStatus();
			
			
			
			if (bookstatus.equals("Checked Out")){
				System.out.println(" Book has been checked out");
				
			}
			else{
				user.setBookStatus("Checked Out");
				user.setBookDueDate(bookduedate.date1());
				System.out.println(user.getBookStatus() +"\t" + user.getBookDueDate());
			
				booktextfile.deleteContent();
				booktextfile.writeBooks(bookname);
				

			}break;
			
		case 5:
			//bookname = booktextfile.readBooks();

			//System.out.println(bookname.size() + "\t" + "List of all Books");

			for (Book b : bookname) {
				System.out.println(b.getBookId() + "   " + b.getBookTitle());
			}
			
			System.out.println("Enter the book you want to Return");
			
			
		    sc = new Scanner(System.in);
			id = sc.nextInt();
			

			user = bookname.get((id -1));
			
			bookstatus=user.getBookStatus();
			
			System.out.println(user.getBookAuthor() + bookstatus);
			
			
				user.setBookStatus("On Shef");
				
				user.setBookDueDate("");
				
				System.out.println(user.getBookStatus() + user.getBookDueDate());
				booktextfile.deleteContent();
				booktextfile.writeBooks(bookname);
			
			break;
		
	}
	
		}while(choice.equals("y"));
}
}
