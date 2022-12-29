package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.impl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class LoginCheck implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		//세선 session 
		HttpSession session = req.getSession(true); //세션값이 있으면 true그걸 쓰고 없으면 새로 세션을 만들어준다.
		
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pw");
		
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = service.loginCheck(id, pass);
		String message = "";
		if(vo == null) {//vo가 널이면 다시 로그인화면으로
			message = "아이디와 비밀번호를 확인하세요.";
			req.setAttribute("msg", message);//이건 포워딩
			return "member/loginForm.tiles";
		} else { //괜찮으면 리스트로 넘어가게
			message="환영합니다.";
			session.setAttribute("msg", message); //message를 "msg"라고 부르겠다.
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("name", vo.getMemberName());
			session.setAttribute("rank", vo.getMemberGrade());
			
			//어느 객체에서 쓰던지 쓸수 있다.
			return "noticeList.do";
		}

	}

}
