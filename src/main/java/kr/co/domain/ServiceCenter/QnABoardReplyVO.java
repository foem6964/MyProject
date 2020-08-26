package kr.co.domain.ServiceCenter;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class QnABoardReplyVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int rno;
	private int bno;
	private String replyer;
	private String replytext;
	private String regdate;
	private String updatedate;
	public QnABoardReplyVO() {
		// TODO Auto-generated constructor stub
	}
	public QnABoardReplyVO(int rno, int bno, String replyer, String replytext, String regdate, String updatedate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.replyer = replyer;
		this.replytext = replytext;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QnABoardReplyVO other = (QnABoardReplyVO) obj;
		if (bno != other.bno)
			return false;
		return true;
	}
	
	
	

}
