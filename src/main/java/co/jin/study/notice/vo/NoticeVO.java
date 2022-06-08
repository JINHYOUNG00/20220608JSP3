package co.jin.study.notice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {

	private int id;
	private String Writer;
	private String title;
	private String subject;
	private Date Wdate;
	private int hit;
}
