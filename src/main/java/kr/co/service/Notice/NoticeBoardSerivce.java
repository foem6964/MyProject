package kr.co.service.Notice;


import kr.co.domain.ServiceCenter.QnaBoardPageTO;
import kr.co.domain.ServiceCenter.Notice.NoticeboardVO;

public interface NoticeBoardSerivce {

	void insert(NoticeboardVO vo);

	QnaBoardPageTO<NoticeboardVO> list(QnaBoardPageTO<NoticeboardVO> to);

	NoticeboardVO read(int bno);

	NoticeboardVO updateUI(int bno);


	void update(NoticeboardVO vo);

	void delete(int bno);

}
