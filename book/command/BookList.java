package co.yedam.book.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.service.impl.BookServiceImpl;
import co.yedam.book.service.impl.BookServiceImplMybatis;
import co.yedam.book.vo.BookVO;
import co.yedam.common.Command;

public class BookList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		BookService dao = new BookServiceImplMybatis();
		List<BookVO> list = dao.bookList();
		req.setAttribute("bookList", list);
		
		
		return "book/bookList.tiles";
	}

}
