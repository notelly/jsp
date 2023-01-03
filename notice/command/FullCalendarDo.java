package co.yedam.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class FullCalendarDo implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "notice/select.tiles";
	}

}
