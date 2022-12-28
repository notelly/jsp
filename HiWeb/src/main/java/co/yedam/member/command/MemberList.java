package co.yedam.member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.impl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;


public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = dao.memberList();
		req.setAttribute("memberList", list);
		
		
		
		return "member/memberList.tiles";
	}

}
