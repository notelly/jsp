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

public class ProductList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		NoticeService service =  new NoticeServiceImplMybatis();
		List<Map<String, Object>> list = service.productList();
		
		ObjectMapper mapper =new ObjectMapper();
		String json = "";
		
		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return json + ".ajax";
	}

}
