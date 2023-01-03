package co.yedam.book.service.impl;

import java.util.List;

import co.yedam.book.dao.BookDAO;
import co.yedam.book.service.BookService;
import co.yedam.book.vo.BookVO;

public class BookServiceImpl implements BookService{
	BookDAO dao = BookDAO.getInstance();
		
	@Override
	public int insertBook(BookVO vo) {
		return dao.insertBook(vo);
	}

	@Override
	public List<BookVO> bookList() {
		return dao.BookList();
	}

	@Override
	public BookVO searchBook(String bookCode) {
		return dao.searchBook(bookCode);
	}



}
