package co.dev.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/getMemberServlet","/getMember"}) //여러 주소를 적어줄 때  ?id=user1 를 뒤에 넣으면 값을 넣어주는 거임
												// id라는 파라메터를 받아와서 값에 따라 달라진다.
												//String id = req.getParameter("id"); 여기에 ?id = user1 값을 넣어주는 거임
public class GetMemberServlet extends HttpServlet {

    										//resp로 하고 싶으면 request 변수를 resp로 바꿔주면 된다.
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//회원아이디로 정보를 조회하는 페이지
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("id"); //아이디를 주면
		MemberDAO dao = MemberDAO.getInstance();
		Member vo = dao.getMember(id); //vo 참조변수
		
		req.setAttribute("memberInfo", vo); //주소값을 참조변수값으로 넘겨서 받아오도록?
		 
		
		req.getRequestDispatcher("searchMemberResult.jsp").forward(req, resp);
		
		
		//서블릿에서 html생성해주는 이전기능 : 사용안함
//		StringBuilder sb = new StringBuilder();
//		sb.append("<h3>회원정보</h3>");
//		sb.append("<table border = \"1\">");
//		sb.append("<tbody>");
//
//			sb.append("<tr><th>아이디</th><td>" + vo.getMemberId() + "</td></tr>");
//			sb.append("<tr><th>비밀번호</th><td>" + vo.getMemberPw() + "</td></tr>");
//			sb.append("<tr><th>전화번호</th><td>" + vo.getMemberPhone() + "</td></tr>");
//			sb.append("<tr><th>주소</th><td>" + vo.getMemberAddr() + "</td></tr>");
//			sb.append("<tr><th>사용자 등급</th><td>" + vo.getMemberRank() + "</td></tr>");
//
//		sb.append("</tbody>");
//		sb.append("</table>");
//		
//		sb.append("<a href = 'index.jsp'>첫페이지</a>"); //하이퍼링크걸어주는거.
//		resp.getWriter().print(sb.toString());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
