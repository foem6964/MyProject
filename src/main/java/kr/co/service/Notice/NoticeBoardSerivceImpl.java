package kr.co.service.Notice;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.ServiceCenter.QnABoardVO;
import kr.co.domain.ServiceCenter.QnaBoardPageTO;
import kr.co.domain.ServiceCenter.Notice.NoticeboardVO;
import kr.co.persistence.Notice.NoticeBoardDAO;

@Service
public class NoticeBoardSerivceImpl implements NoticeBoardSerivce{
	@Inject
	public NoticeBoardDAO ndao;

	@Override
	public void insert(NoticeboardVO vo) {
		ndao.insert(vo);
		
	}

	@Override
	public QnaBoardPageTO<NoticeboardVO> list(QnaBoardPageTO<NoticeboardVO> to) {
		// TODO Auto-generated method stub
		return ndao.list(to);
	}

	@Override
	public NoticeboardVO read(int bno) {
		ndao.increaseViewcnt(bno);
		return ndao.read(bno);
	}

	@Override
	public NoticeboardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return ndao.updateUI(bno);
	}

	@Override
	public void update(NoticeboardVO vo) {
		ndao.update(vo);
		
	}
	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		ndao.delete(bno);
	}
	

}
