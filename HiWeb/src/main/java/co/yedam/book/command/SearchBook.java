package co.yedam.book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.service.impl.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.Command;

public class SearchBook implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String bookCode = req.getParameter("bookCode");
		
		req.setAttribute("bookCode", bookCode);
		
		System.out.println(bookCode);
		BookService service = new BookServiceImpl();
		BookVO vo = service.searchBook(bookCode);
		
		req.setAttribute("vo", vo);
		
		return "book/searchBook.tiles";
	}

}
