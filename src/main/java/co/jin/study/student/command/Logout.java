package co.jin.study.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jin.study.comm.Command;

public class Logout implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate(); // 세션 객체를 완전히 삭제
		req.setAttribute("message", "정상적으로 로그아웃이 되었습니다.");
		return "student/logout";
	}

}
