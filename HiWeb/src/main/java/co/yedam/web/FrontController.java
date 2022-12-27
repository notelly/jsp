package co.yedam.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.common.MainDo;
import co.yedam.member.command.LogOut;
import co.yedam.member.command.LoginCheck;
import co.yedam.member.command.LoginForm;
import co.yedam.notice.command.AddNotice;
import co.yedam.notice.command.InsertNotice;
import co.yedam.notice.command.NoticeList;
import co.yedam.notice.command.SearchNotice;
import co.yedam.notice.command.UpdateNotice;

@WebServlet("*.do")
public class FrontController extends HttpServlet{
	//control 객체를 만들어줘야한다.
	HashMap<String, Command> map;
	public FrontController() {
		map = new HashMap<>(); //생성자를 map이라는 것을 할당시켜줌
	}
	
	@Override
	public void init() throws ServletException {
		//페이지 등록
		map.put("/main.do", new MainDo());
		map.put("/noticeList.do", new NoticeList()); //"/noticeList.do"이걸 입력하면 new NoticeList()의 return 값을 리턴해줌.
		map.put("/searchNotice.do", new SearchNotice()); //오타났엇음 / 꼭 써주기
		map.put("/updateNotice.do", new UpdateNotice());
		map.put("/addNotice.do", new AddNotice());
		map.put("/insertNotice.do", new InsertNotice());
		//회원관련
		map.put("/loginForm.do", new LoginForm());
		map.put("/loginCheck.do", new LoginCheck());
		map.put("/logOut.do", new LogOut());
	}
	
	//NoitceList 에서 넘어옴
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8"); //한글 깨지는 것 때문에
		String uri = req.getRequestURI(); // /HelloWeb/hello.do
		String context = req.getContextPath();	// /HelloWeb
		String page = uri.substring(context.length()); //hello.do
		System.out.println("==> " + page);
		
		//map이가지고 있는 get이라는 것에 page값을 넘겨준다.
		Command command = map.get(page);
		//page = "notice/noticeList.jsp" 넘겨준 값
		String viewPage = command.exec(req, resp); //exec 메소드를 실행 dir/file.jsp 가 넘어오도록
													// main/main.tiles
		
		
		//페이지 요청이 .tiles인지 .do 인지 구분해서 처리를 다르게함.
		if(viewPage.endsWith(".do")) { //endsWith 끝단어가 뭐로 끝나는지
			resp.sendRedirect(viewPage); //포워드 하면 새로 페이지를 만들어와야함.
			
		}else if (viewPage.endsWith(".tiles")) {
			//포워딩 view 페이지로 포워딩하려는 과정
			RequestDispatcher rd = req.getRequestDispatcher(viewPage); //디렉토리 이름이랑 열어줄 페이지가 들어왔을 거임
			rd.forward(req, resp);
		}
		
		
	}
	
}