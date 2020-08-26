package kr.co.persistence.Notice;

import kr.co.domain.ServiceCenter.QnABoardVO;
import kr.co.domain.ServiceCenter.QnaBoardPageTO;
import kr.co.domain.ServiceCenter.Notice.NoticeboardVO;

public interface NoticeBoardDAO {

	void insert(NoticeboardVO vo);

	QnaBoardPageTO<NoticeboardVO> list(QnaBoardPageTO<NoticeboardVO> to);

	void increaseViewcnt(int bno);

	NoticeboardVO read(int bno);

	NoticeboardVO updateUI(int bno);

	void update(NoticeboardVO vo);

	void delete(int bno);

}
