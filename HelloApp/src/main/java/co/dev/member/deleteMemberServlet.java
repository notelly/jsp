package co.dev.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteMemberServlet
 */
@WebServlet("/deleteMemberServlet")
public class deleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public deleteMemberServlet() {
    
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String id = req.getParameter("id");
		
		Member vo = new Member();
		vo.setMemberId(id);
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.deleteMember(id);
		
		req.setAttribute("id", vo);
		req.getRequestDispatcher("deleteMemberResult.jsp").forward(req, resp);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
