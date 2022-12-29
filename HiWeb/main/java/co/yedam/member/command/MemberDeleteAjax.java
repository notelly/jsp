package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.impl.MemberServiceImpl;

public class MemberDeleteAjax implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id"); //여기 id는 ajasForm.jsp의 파라메터 'deleteMemberAjax.do?id=' + this 이것임
		MemberService service = new MemberServiceImpl();
		int r = service.deleteMember(id);
		String json = "";
		//지워졌는지 판단하게 해주는 것
		if (r > 0) {
			json = "{\"retCode\": \"Success\"}"; 
		}else {
			json = "{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}

}
