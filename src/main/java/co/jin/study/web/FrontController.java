package co.jin.study.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.study.comm.Command;
import co.jin.study.home.HomeCommand;
import co.jin.study.notice.command.NoticeSelect;
import co.jin.study.notice.command.NoticeSelectList;
import co.jin.study.student.command.Login;
import co.jin.study.student.command.LoginForm;
import co.jin.study.student.command.Logout;

@WebServlet("*.do") // .do => 모든요청을 처리하겠다.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String,Command> map = new HashMap<String, Command>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
			map.put("/home.do", new HomeCommand()); // 홈 페이지
			map.put("/noticeSelectList.do", new NoticeSelectList()); // 공지사항목록
			map.put("/noticeSelect.do", new NoticeSelect()); // 세부내역 보기
			map.put("/loginForm.do", new LoginForm()); // 로그인폼
			map.put("/login.do", new Login()); // 로그인 처리
			map.put("/logout.do", new Logout()); // 로그아웃 처리
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page); 
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {     // viewResolve
//			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			viewPage = viewPage + ".tiles";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
