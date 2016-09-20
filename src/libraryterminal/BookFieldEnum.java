package libraryterminal;

public enum BookFieldEnum {

	ID(0, "Book id"),
	
	TITLE(1, "Book Title"),
	
	AUTHOR(2, "Book Author"),
	
	STATUS(3, "Book Status"),
	
	DUE_DATE(4, "Book Due on");
	
	
	
	private int fieldPosition;
	private String fieldDesc;
	
	private BookFieldEnum(int fieldPosition, String fieldDesc){
		this.fieldPosition = fieldPosition;
		this.fieldDesc=fieldDesc;
		
	}


	public int getFieldPosition() {
		return fieldPosition;
	
	}
	}
