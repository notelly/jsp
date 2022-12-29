package co.yedam.member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.impl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberModAjax implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String addr = req.getParameter("addr");
		String phone = req.getParameter("phone");
		MemberVO vo = new MemberVO();
		vo.setMemberId(id);
		vo.setMemberAddr(addr);
		vo.setMemberPhone(phone);
		
		//아까처럼 넘어가면 안된다. 화면에 그려줄 수 가 없음
		//가지고 온 값으로 
		//member수정하기 위해 값을 3개만 가지고옴
		//id를 하나 던저주면 그 아이디가 가지고 있는 정보를 모두 가지고 와서 그 정보를 던져주도록.
		Map<String, Object> resultMap = new HashMap<>();
		
		MemberService service = new MemberServiceImpl();
		if(service.updateMember(vo)>0) {
			//vo = service.searchMember(id);
			
			//반환되는 값 나중에 JSON으로 처리해줄 거임
			resultMap.put("retCode", "Success");
			resultMap.put("memberInfo", vo);
		} else {
			resultMap.put("retCode", "Fail");
		}
		
		// json포맷생성.
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(resultMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return json + ".ajax";
	}

}
