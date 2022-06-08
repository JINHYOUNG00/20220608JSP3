package co.jin.study.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jin.study.notice.vo.NoticeVO;

public interface NoticeMapper {
	
	List<NoticeVO> noticeSelectList();
	
	// 일반 인터페이스와의 차이점.
	// Mapper interface에서 전달인자가 두개 이상일때는 반드시 아래와 같이 써야함. 
	// @Param("전달인자") 타입 변수명
	List<NoticeVO> noticeSearchList(@Param("key")String key,@Param("val") String val);
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeHitUpdate(int id);    // 조회수 증가 메소드

}
