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
		int userInput;
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
			for (Book b : bookname) {
				if (b.getBookTitle().toLowerCase().contains(keyInput.toLowerCase())) {
					System.out.println(b.getBookTitle() + ":" +  b.getBookStatus());
				}
			}
			break;
		case 4:
			
		
	}
		}while(choice.equals("y"));
}
}

