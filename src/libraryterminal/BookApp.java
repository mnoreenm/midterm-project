
package libraryterminal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * 
 * @author Pranavi Madadi
 *         Sadia Noreen
 *         Brent Collins III
 *
 */
public class BookApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		ArrayList<Book> bookname = new ArrayList<Book>();
		

		System.out.println("Welcome to the PBS Library Terminal");
		
		for (Book name : bookname) {
			System.out.println(name);
		}
		System.out.println("Choose one of the options below:");
		System.out.println("1.Do you want to search for a book by author?");
		System.out.println("2.Do you want to search for a book by Keyword");
		System.out.println("3.Checkout Book");
		System.out.println("4.Return a Book");
		String userInput = sc.next();
		
		switch (userInput) {
		case "1":
			System.out.println("Enter Author name");
			String AuthorInput = sc.next();
			for (Book book : bookname) {
				if (AuthorInput.equalsIgnoreCase(book.getbookAuthor())) {
					System.out.println(book.getbookTitle());

				}
			}
			break;
		case "2":
			System.out.println("Enter a keyword to search for the Title of a book");
			sc.nextLine();
			String keyInput = sc.nextLine();
			for (Book b : bookname) {
				if (b.getbookTitle().toLowerCase().contains(keyInput.toLowerCase())) {
					System.out.println(b.getbookTitle() + ":" + b.getbookStatus());
				}
			}
			break;

		case "3":
			System.out.println("Do you want to Checkout");
			String checkInput = sc.nextLine();
			for (Book co : bookname) {
				if (co.getbookStatus().toLowerCase().equalsIgnoreCase(checkInput.toLowerCase())) {
					System.out.println();
				}
				
				Calendar  c = new  GregorianCalendar();
				Date currentDate = c.getTime();
				c.add(Calendar.DATE,14);
				Date nextDate = c.getTime();
				System.out.println("Checkout date "+currentDate);
				System.out.println("Due date "+nextDate);
			}
		}
	}

}