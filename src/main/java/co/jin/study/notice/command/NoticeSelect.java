package co.jin.study.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.study.comm.Command;
import co.jin.study.notice.service.NoticeService;
import co.jin.study.notice.serviceImpl.NoticeServiceImpl;
import co.jin.study.notice.vo.NoticeVO;

public class NoticeSelect implements Command {
	
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 세부목록 보기
		
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.valueOf(req.getParameter("id"))); // 읽을 아이디값 담음 // 폼에서 넘어온 값을 읽는 방법 req.getParameter("??")
		vo = dao.noticeSelect(vo);
		req.setAttribute("notice", vo); // 노티스라는 객체에 vo를 담아준다.
		return "notice/noticeSelect";
	}

}
