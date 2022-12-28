package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.impl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;


public class InsertMember implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		MemberVO vo = new MemberVO();
		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memPw");
		String memName = req.getParameter("memName");
		String memNum = req.getParameter("memNum");
		String memAddr = req.getParameter("memAddr");
		
		vo.setMemberId(memId);
		vo.setMemberPw(memPw);
		vo.setMemberName(memName);
		vo.setMemberPhone(memNum);
		vo.setMemberAddr(memAddr);
		
		MemberService service = new MemberServiceImpl();
		service.insertMember(vo);
		
		
		return "noticeList.do";
	}

}
