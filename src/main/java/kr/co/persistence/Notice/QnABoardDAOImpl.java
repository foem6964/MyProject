package kr.co.persistence.Notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import kr.co.domain.ServiceCenter.*;


@Repository
public class QnABoardDAOImpl implements QnABoardDAO {
	@Inject
	private SqlSession session;
	private final String NS = "b.o.a";

	@Override
	public void insert(QnABoardVO vo) {
		Integer bno = session.selectOne(NS + ".getBno");
		if (bno != null) {
			bno += 1;

		} else {
			bno = 1;
		}
		vo.setBno(bno);

		session.insert(NS + ".insert", vo);

	}

	@Override
	public QnaBoardPageTO<QnABoardVO> list(QnaBoardPageTO<QnABoardVO> to) {
		RowBounds rowBounds = new RowBounds(to.getStartNum() - 1, to.getPerPage());
		List<QnABoardVO> list = session.selectList(NS + ".list", null, rowBounds);
		to.setList(list);

		Integer amount = session.selectOne(NS + ".getAmount");
		if (amount != null) {
			to.setAmount(amount);

		} else {
			to.setAmount(0);
		}
		return to;
	}

	@Override
	public QnABoardVO read(int bno) {
		
		return session.selectOne(NS +".read",bno);
	}
	
	@Override
	public QnABoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".updateUI",bno);
	}

	@Override
	public void update(QnABoardVO vo) {
		session.update(NS+".update",vo);
		
	}
	@Override
	public void increaseViewcnt(int bno) {
		session.update(NS+".increaseViewcnt",bno);
		
	}
	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		session.delete(NS+".delete",bno);
	}
	@Override
	public List<QnABoardVO> searchlist(String searchType, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("keyword",keyword);
		
		return session.selectList(NS+".searchlist", map);
	}
	@Override
	public void deleteByBno(int bno) {
		session.delete(NS+".deleteByBno", bno);
		
	}
	
}
