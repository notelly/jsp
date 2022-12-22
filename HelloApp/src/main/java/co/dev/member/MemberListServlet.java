package co.dev.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet{

	@Override//doget 목록을 조회하거나 하는 형태에서 사용함
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//응답 페이지를 html로 설정해주고
		String result = ""; //받아올 변수를 이렇게 설정한다.
		MemberDAO dao = MemberDAO.getInstance();
		List<Member> list = dao.getMemberList();
		StringBuilder sb = new StringBuilder();
		sb.append("<h3>회원목록</h3>");
		sb.append("<table border = \"1\">");//새로운 인스턴스를 만들어주고 하면 효율이 떨어진다. 효율 좋게 하는 방법
		sb.append("<thead><tr><th>ID</th><th>PW</th><th>Phone</th><th>Addr</th><th>Rank</th></tr>");
		sb.append("<tbody>");
		for(Member vo : list) { //ul태그 하위에 li를 만들어준다.
			sb.append("<tr>");
			sb.append("<td><a href = 'getMember?id=" + vo.getMemberId() + "'>"+vo.getMemberId()+"</a></th>");
			sb.append("<td>" + vo.getMemberPw() + "</td>");
			sb.append("<td>" + vo.getMemberPhone() + "</td>");
			sb.append("<td>" + vo.getMemberAddr() + "</td>");
			sb.append("<td>" + vo.getMemberRank() + "</td>");
			sb.append("</tr>");
		}
		sb.append("</tbody>");
		sb.append("</table>");
		
		sb.append("<a href = 'index.jsp'>첫페이지</a>"); //하이퍼링크걸어주는거.
		result = sb.toString();
		resp.getWriter().print(result);
	} 
}
