package co.yedam.member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.impl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberListAjax implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// {"id":"홍길동", "age":20, "phone": "010-1111-1111"}
		// 이런포맷의 정보를 가지고 오고 싶음
		MemberService service = new MemberServiceImpl();
		String json = "{\"id\":\"홍길동\", \"age\":20, \"phone\": \"010-1111-1111\"}";
		List<MemberVO> list = service.memberList();
		// json 포멧의 데이터 만들기
		// 건수만큼 돌면서 String json = ...같은 루틴의 정보를 불러와야함.
		json = "[";
		for (int i = 0; i < list.size(); i++) {
			json += "{\"memberId\":\"" + list.get(i).getMemberId() //
					+ "\",\"memberName\":\"" + list.get(i).getMemberName() //
					+ "\",\"memberAddr\":\"" + list.get(i).getMemberAddr() //
					+"\"}";
			if (i != list.size() - 1) {
				json += ",";
			}
		}
		json += "]";
		return json + ".ajax";

	}

}
