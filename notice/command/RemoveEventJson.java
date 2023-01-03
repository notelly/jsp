package co.yedam.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;

public class RemoveEventJson implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
				
		NoticeService service = new NoticeServiceImplMybatis();
		int result = service.removeEvent(req.getParameter("title"));
		
		if(result > 0) {
			return "{\"retCode\":\"Success\"}.ajax";
		}else {
			return "{\"retCode\":\"Fail\"}.ajax";
		}
	}

}
