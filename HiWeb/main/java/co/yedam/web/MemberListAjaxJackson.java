package co.yedam.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.impl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberListAjaxJackson implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = new MemberServiceImpl();
		
		List<MemberVO> list = service.memberList();
		
		
		//jackson라이브러리를 활용해서 편하게 json포맷을 만들어보겠다.
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(list);  //제이슨타입으로 바꿀 객체를 넣어준다.
			return json + ".ajax";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
