package kr.co.persistence.Notice;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.ServiceCenter.QnABoardVO;
import kr.co.domain.ServiceCenter.QnaBoardPageTO;
import kr.co.domain.ServiceCenter.Notice.NoticeboardVO;
@Repository

public class NoticeBoardDAOImpl implements NoticeBoardDAO{
	@Inject 
	private SqlSession session;
	private final String NS = "b.a.o";
	@Override
	public void insert(NoticeboardVO vo) {
		Integer bno = session.selectOne(NS+".getBno");
	if(bno != null) {
		bno += 1;
		
	}else {
		bno  =1;
	}
	vo.setBno(bno);
	
	session.insert(NS + ".insert",vo);
		
	}
	@Override
	public QnaBoardPageTO<NoticeboardVO> list(QnaBoardPageTO<NoticeboardVO> to) {
		RowBounds rowBounds = new RowBounds(to.getStartNum() - 1, to.getPerPage());
		List<NoticeboardVO> list = session.selectList(NS + ".list", null, rowBounds);
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
	public void increaseViewcnt(int bno) {
		session.update(NS+".increaseViewcnt",bno);
		
	}
	@Override
	public NoticeboardVO read(int bno) {
		
		return session.selectOne(NS+".read", bno);
	}
	@Override
	public NoticeboardVO updateUI(int bno) {
	
		return session.selectOne(NS+".updateUI", bno);
	}
	@Override
	public void update(NoticeboardVO vo) {
		 session.update(NS+".update", vo);
		
	}
	@Override
	public void delete(int bno) {
		
		session.delete(NS+".delete",bno);
		
	}
}
	


