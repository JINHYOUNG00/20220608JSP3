package co.jin.study.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.study.comm.Command;
import co.jin.study.notice.service.NoticeService;
import co.jin.study.notice.serviceImpl.NoticeServiceImpl;
import co.jin.study.notice.vo.NoticeVO;

public class NoticeSelectList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		//공지사항목록
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		notices = dao.noticeSelectList();
		
		req.setAttribute("notices", notices);
		
		return "notice/noticeSelectList";
	}

}
