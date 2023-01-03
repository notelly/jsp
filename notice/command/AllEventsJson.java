package co.yedam.notice.command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;

public class AllEventsJson implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		NoticeService service = new NoticeServiceImplMybatis();
		//이벤트가 반환하는 값은 List<map<String, Object>>
		List<Map<String, Object>> list =service.allEvents();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return json + ".ajax";
	}

}
