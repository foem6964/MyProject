package kr.co.persistence.Notice;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import kr.co.domain.ServiceCenter.*;

@Repository

public class QnABoardReplyDAOImpl implements QnABoardReplyDAO{
	@Inject
	private SqlSession session;
	
	private final String NS = "r.e.p";
	private final String NS1 = "m.e.m";

	@Override
	public List<QnABoardReplyVO> list(int bno) {
		
		return session.selectList(NS+".list", bno);
	}

	@Override
	public int insert(QnABoardReplyVO vo) {
		Integer rno = session.selectOne(NS+".getRno");
		vo.setRno(rno);
		
		return session.insert(NS+".insert",vo);
	}

	@Override
	public int update(QnABoardReplyVO vo) {
		
		return session.update(NS+"update", vo);
	}

	@Override
	public int delete(QnABoardReplyVO vo) {
		
		return session.delete(NS+".delete",vo);
	}

	@Override
	public void deleteByBno(int bno) {
		session.delete(NS+".deleteByBno", bno);
		
	}
	

}
