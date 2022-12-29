package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.impl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberAddAjax implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");

		MemberVO vo = new MemberVO();
		vo.setMemberId(id);
		vo.setMemberName(name);
		vo.setMemberPw(pass);
		vo.setMemberPhone(phone);
		vo.setMemberAddr(addr);

		MemberService service = new MemberServiceImpl();
		int r = service.insertMember(vo);
		String json = "";
		if (r > 0) {
			json = "{\"retCode\": \"Success\"}";
		} else {
			json = "{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}
}
