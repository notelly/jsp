package co.dev.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateMemberServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("add");
		
		
				
		Member vo = new Member();
		vo.setMemberId(id);
		vo.setMemberPw(pw);
		vo.setMemberPhone(phone);
		vo.setMemberAddr(addr);
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.updateMember(vo); // 원래 jdbc 에서 int result = MemberDAO.getInstance().UpdateMember(vo); 하는걸 이렇게 적어줌
		//update를 해줘야 db에 반영된다.
		
		req.setAttribute("memberInfo", vo);
		
		req.getRequestDispatcher("updateMemberResult.jsp").forward(req, resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}

}
