package co.yedam.book.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class BookVO {
	/*BOOK_CODE   NOT NULL VARCHAR2(10)  
	BOOK_TITLE  NOT NULL VARCHAR2(100) 
	BOOK_AUTHOR NOT NULL VARCHAR2(100) 
	BOOK_PRESS  NOT NULL VARCHAR2(100) 
	BOOK_PRICE           NUMBER */
	private String bookCode;
	private String bookTitle;
	private String bookAuthor;
	private String bookPress;
	private int bookPrice;
	
	
	
}
