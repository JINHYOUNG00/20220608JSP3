package co.jin.study.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 실행 인터페이스
public interface Command {
	public String exec(HttpServletRequest req, HttpServletResponse resp);
}
