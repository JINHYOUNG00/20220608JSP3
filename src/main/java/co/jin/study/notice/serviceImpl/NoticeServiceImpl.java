package co.jin.study.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jin.study.comm.DataSource;
import co.jin.study.notice.service.NoticeMapper;
import co.jin.study.notice.service.NoticeService;
import co.jin.study.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); // true라고 적어주지않으면 자동으로 커밋이 안됨.
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class); // 
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		
		return map.noticeSelectList();
	}

	@Override
	public List<NoticeVO> noticeSearchList(String key, String val) {
		
		return map.noticeSearchList(key, val);
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeHitUpdate(int id) {
		
		return map.noticeHitUpdate(id);
	}

}
