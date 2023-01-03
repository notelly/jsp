package co.yedam.book.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.book.mapper.BookMapper;
import co.yedam.book.service.BookService;
import co.yedam.book.vo.BookVO;
import co.yedam.common.DataSource;

public class BookServiceImplMybatis implements BookService{
	public BookServiceImplMybatis() {
		System.out.println("Mybatis 실행 중");
	}
	
	SqlSession session = DataSource.getInstance().openSession(true);
	BookMapper mapper = session.getMapper(BookMapper.class);
	
	
	@Override
	public int insertBook(BookVO vo) {
		return mapper.insertBook(vo);
	}
	@Override
	public List<BookVO> bookList() {
		// TODO Auto-generated method stub
		return mapper.bookList();
	}
	@Override
	public BookVO searchBook(String bookCode) {
		// TODO Auto-generated method stub
		return mapper.searchBook(bookCode);
	}

	
	
	
	
	
}
