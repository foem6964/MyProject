package kr.co.service.Notice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.co.domain.ServiceCenter.*;

import kr.co.domain.UsersDTO;
import kr.co.persistence.Notice.*;
import kr.co.persistence.Notice.*;


@Service
public class QnABoardServiceImpl implements QnABoardService{
	@Autowired
	private QnABoardDAO qDao;
	@Autowired
	private QnABoardReplyDAO rDao;
	@Override
	public void insert(QnABoardVO vo) {
		qDao.insert(vo);
		
	}
	@Override
	public QnaBoardPageTO<QnABoardVO> list(QnaBoardPageTO<QnABoardVO> to) {
		
		return qDao.list(to);
	}
	@Override
	public QnABoardVO read(int bno) {
		qDao.increaseViewcnt(bno);
		return qDao.read(bno);
	}
	@Override
	public QnABoardVO updateUI(int bno) {
		
		return qDao.updateUI(bno);
	}
	@Override
	public void update(QnABoardVO vo) {
		qDao.update(vo);
		qDao.deleteByBno(vo.getBno());
		
		
	}
	@Override
	public void delete(int bno) {
	rDao.deleteByBno(bno);
	qDao.deleteByBno(bno);
	qDao.delete(bno);
	
	}
	@Override
	public List<QnABoardVO> searchlist(String searchType, String keyword) {
		// TODO Auto-generated method stub
		return qDao.searchlist(searchType,keyword);
	}
}
