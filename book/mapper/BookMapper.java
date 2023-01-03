package co.yedam.book.mapper;

import java.util.List;

import co.yedam.book.vo.BookVO;

public interface BookMapper {
	
	public int insertBook(BookVO vo);

	public BookVO searchBook(String bookCode);

	public List<BookVO> bookList();
}
