package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class LoginForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		//로그인 실패
		//로그인 성공
		return "member/loginForm.tiles";
	}

}
