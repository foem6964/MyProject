package kr.co.service.Notice;

import java.util.List;

import kr.co.domain.ServiceCenter.*;

public interface QnABoardReplyService {

	
	List<QnABoardReplyVO> list(int bno);
	
	int insert(QnABoardReplyVO vo);
	
	int update(QnABoardReplyVO vo);
	
	int delete(QnABoardReplyVO vo);
}
