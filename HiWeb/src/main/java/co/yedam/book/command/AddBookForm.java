package co.yedam.book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class AddBookForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {

		return "book/addBookForm.tiles";
	}

}
