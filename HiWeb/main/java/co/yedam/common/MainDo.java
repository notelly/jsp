package co.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainDo implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		return "main/main.tiles"; //이걸 안쓰고 안된다고 함.
	}

}
