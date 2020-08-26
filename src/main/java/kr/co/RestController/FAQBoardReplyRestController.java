package kr.co.RestController;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.ServiceCenter.*;

import kr.co.service.Notice.*;

@RestController
public class FAQBoardReplyRestController {
	@Inject
	private QnABoardReplyService qSerivce;
	
	@RequestMapping(value="/replies",method = RequestMethod.DELETE)
	public String delete(@RequestBody QnABoardReplyVO vo) {
		int i = qSerivce.delete(vo);
		if(i==1) {
			return "success";
			
		}
		return "fail";
	}
	
	@RequestMapping(value = "/replies/{rno}",method = RequestMethod.PUT)
	public String update(@PathVariable("rno")int rno,@RequestBody QnABoardReplyVO vo) {
		vo.setRno(rno);
		int i = qSerivce.update(vo);
		if(i==1) {
			return "success";
		}
		return "fail";
	}
	@RequestMapping(value = "/replies/all/{bno}",method = RequestMethod.GET)
	public List<QnABoardReplyVO> list(@PathVariable("bno")int bno){
		List<QnABoardReplyVO> list = qSerivce.list(bno);
		return list;
		
	}
	@RequestMapping(value = "/replies", method = RequestMethod.POST)
	public String insert(@RequestBody QnABoardReplyVO vo) {
		int i = qSerivce.insert(vo);
		if(i==1) {
			return "success";
		}else {
			return "fali";
			
		}
	}
	
	

}