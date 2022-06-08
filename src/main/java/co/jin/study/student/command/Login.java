package co.jin.study.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jin.study.comm.Command;
import co.jin.study.student.service.StudentService;
import co.jin.study.student.serviceImpl.StudentServiceImpl;
import co.jin.study.student.vo.StudentVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		StudentService dao = new StudentServiceImpl();
		HttpSession session = req.getSession();     // 세션객체의 황용을 위헤 생성.
		StudentVO vo = new StudentVO();
		vo.setStudentId(req.getParameter("studentId"));
		vo.setPassword(req.getParameter("password"));
		
		vo = dao.studentSelect(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getStudentId());  // 아이디
			session.setAttribute("name", vo.getName());	// 이름
			session.setAttribute("author", vo.getAuthor()); 	// 권한
			req.setAttribute("message", vo.getName()+"님 환영합니다.");
		} else {
			req.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			
		}
		return "student/login";
	}

}
