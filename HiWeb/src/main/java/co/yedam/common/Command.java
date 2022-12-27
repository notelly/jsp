package co.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public String exec (HttpServletRequest req, HttpServletResponse resp);
	//이걸 받는 걸 FrontController에 만들어준다.
}
