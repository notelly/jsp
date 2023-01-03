package co.yedam.book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.service.impl.BookServiceImpl;
import co.yedam.book.service.impl.BookServiceImplMybatis;
import co.yedam.book.vo.BookVO;
import co.yedam.common.Command;

public class InsertBook implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		BookVO vo =  new BookVO();
		
		String bc = req.getParameter("bookCode");
		String bt = req.getParameter("bookTitle");
		String ba = req.getParameter("bookAuth");
		String bpress = req.getParameter("bookPress");
		String bprice = req.getParameter("bookPrice");
		
		vo.setBookCode(bc);
		vo.setBookTitle(bt);
		vo.setBookAuthor(ba);
		vo.setBookPress(bpress);
		vo.setBookPrice(Integer.parseInt(bprice));
		
		BookService service = new BookServiceImplMybatis();
		service.insertBook(vo);
		
		return "bookList.do";
	}

}
