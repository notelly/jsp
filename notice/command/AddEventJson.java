package co.yedam.notice.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;

public class AddEventJson implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		//파라메터 처리 : 값을 가지고 오니까
		//key value
		String title = req.getParameter("title");
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		map.put("start", start);
		map.put("end", end);
		
		NoticeService service = new NoticeServiceImplMybatis();
		if(service.addEvent(map)>0) {
			return "{\"retCode\":\"Success\"}.ajax";
		}else {
			return "{\"retCode\":\"Fail\"}.ajax";
		}
		
	}

}
