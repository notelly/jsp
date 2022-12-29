package co.yedam.book.service;

import java.util.List;

import co.yedam.book.vo.BookVO;

public interface BookService {
	
	public int insertBook(BookVO vo);
	
	public List<BookVO> bookList();
	
	public BookVO searchBook(String bookCode);
	
	public int updateBook(BookVO vo);
}
