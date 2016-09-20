package libraryterminal;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class BookDueDate extends Book {

	int id;
	String booktitle;
	String bookauthor;
	String bookstatus;
	String duedate;

	public BookDueDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String date1() {
		Calendar c = new GregorianCalendar();
		java.util.Date currentDate = c.getTime();
		c.add(Calendar.DATE, 14);
		java.util.Date nextDate = c.getTime();
		System.out.println("Checkout date " + currentDate);
		String date2 = ("Due date " + nextDate);
		return date2;
	}

}
