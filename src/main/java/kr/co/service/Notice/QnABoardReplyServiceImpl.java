package kr.co.service.Notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.ServiceCenter.*;
import kr.co.persistence.Notice.*;

@Service
public class QnABoardReplyServiceImpl implements QnABoardReplyService{
@Autowired
public QnABoardReplyDAO rDao;
	@Override
	public List<QnABoardReplyVO> list(int bno) {
		
		return rDao.list(bno);
	}

	@Override
	public int insert(QnABoardReplyVO vo) {
		
		return rDao.insert(vo);
	}

	@Override
	public int update(QnABoardReplyVO vo) {
		
		return rDao.update(vo);
	}

	@Override
	public int delete(QnABoardReplyVO vo) {
		
		return rDao.delete(vo);
	}
	

}
