package co.dev.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addMemberServlet") //언어테이션 index에서 <form action = "addMemberServlet" method ="post"> 실행한다고 하면 호출해주는 것
public class AddMemberServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8"); //결과값이 닮긴 정보에 컨텐트에 담긴 정보가 ""입니다 하고 알려줌
		//↑지금 보여지는 페이지는 html 페이지라고 알려줌.
		
		System.out.println("do post");
		String id = req.getParameter("id"); //getParameter라는 걸로 name이라는 속성에 가서 id의 값을 가지고 오겠다. 그럼 value 값을 가지고 옴
		String pw = req.getParameter("pw");
		String phone = req.getParameter("phone");
		String add = req.getParameter("add");
		String rank = req.getParameter("rank");
		
		Member vo =  new Member();
		vo.setMemberId(id);
		vo.setMemberPw(pw);
		vo.setMemberPhone(phone);
		vo.setMemberAddr(add);
		vo.setMemberRank(rank);
		
	
		MemberDAO dao = MemberDAO.getInstance(); //싱글톤 값을 받아오는 방법
		dao.insertMember(vo); //>>vo의 각 속성들을 넣어준다.
		
		req.setAttribute("memberList", vo);
		req.getRequestDispatcher("addMemberResult.jsp").forward(req, resp);
		
		
//		List<Member> list = dao.getMemberList(); //list 라고 하는 맴버정보를 담고 있는 00에  
		
		
//		String result = "<h3> Sucess </h3>";
//		resp.getWriter().print(result); // resp(respond) 출력 스트림. 문자를 입력해주면 그게 화면에 보여진다.
		//응답정보를 처리해주는 sendRedirect() 실행후 다른 페이지로 넘어가겠습니다.
//		resp.sendRedirect("memberList"); addMemberServlet -> memberList//맴버리스트 페이지로 가겠습니다.
		//sendRedirect 값을 넘기지 않았다.
		//값을 넘기고 싶을때 addMemberServlet -> 회원목록을 출력하는 jsp 페이지를 만들어보자.
		//회원등록페이지 -> 회원목록페이지 (Servlet 페이지에서 데이터조회를 하고 처리결과를 html로 오전에는 자바창에서 html구현까지 다했음)
		//회원등록페이지(데이터조회) -> 회원목록페이지 (jsp페이지) 회원등록페이지의 값을 적절하게 넘기고 데이터건수만큼 목록에 보이게. 포워딩?
		//등록페이지에서 조회를 하고 목록페이지에서 보이게 첨에는 목록페이지에서 
		
		//addMemberServlet
//		req.setAttribute("userName", "lee"); //setAttribute 요청정보 username에 lee라는 값을 담아서 보냄
//		req.setAttribute("memberList", list);
//		req.getRequestDispatcher("addMemberResult.jsp").forward(req, resp); //HttpServletRequest req, HttpServletResponse resp 의 응답정보와 어쩌고저쩌고 포워딩
		
		
		
	}
}
