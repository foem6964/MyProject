package com.naver.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.dto.LoginDTO;
import kr.co.domain.ServiceCenter.*;
import kr.co.domain.ServiceCenter.Notice.NoticeboardVO;

import kr.co.domain.UsersDTO;
import kr.co.service.Notice.*;

import kr.co.service.UsersService;

@Controller
@RequestMapping("/userpage")
@SessionAttributes({ "login" })
public class UserController {
	@Autowired
	private UsersService userService;
	@Inject
	private QnABoardService qboardserivce;
	@Inject
	private NoticeBoardSerivce nboardservice;

	//메인페이지
	@RequestMapping(value = "userpagehome", method = RequestMethod.GET)
	public String home(HttpSession session,Model model) {
		return "/userpage/userpagehome";

	}

	
	
	//FAQ 글 찾기
	@RequestMapping(value = "faqsearchlist")
	public String searchlist(Model model,String searchType,String keyword) {
		
		List<QnABoardVO> list = qboardserivce.searchlist(searchType,keyword);
		model.addAttribute("list",list);
		model.addAttribute("searchType",searchType);
		model.addAttribute("keyword",keyword);
		return "userpage/faqsearchlist";
	}
	//FAQ 글 삭제
	@RequestMapping(value = "delete/{bno}",method = RequestMethod.GET)
	public String delete(@PathVariable("bno")int bno) {
		qboardserivce.delete(bno);
		return "redirect:userpage/list";
	}
	//FAQ 글 수정
	@RequestMapping(value = "faqupdate",method = RequestMethod.POST)
	public String update(QnABoardVO vo) {
		
		qboardserivce.update(vo);
		return "redirect:/userpage/faqread/"+vo.getBno();
	}
	//FAQ 글 수정
	@RequestMapping(value = "faqupdate/{bno}",method = RequestMethod.GET)
	public String update(Model model,@PathVariable("bno") int bno) {
		
		QnABoardVO vo = qboardserivce.updateUI(bno);
		model.addAttribute("vo",vo);
		
		return "userpage/faqupdate";
		
	}
	//FAQ글 자세히보기 구현
	@RequestMapping(value = "faqread/{bno}",method =RequestMethod.GET)
	public String read(Model model,@PathVariable("bno")int bno,LoginDTO login, HttpSession session) {
		
		QnABoardVO vo = qboardserivce.read(bno);
		System.out.println(login);
		model.addAttribute("vo",vo);
		return "userpage/faqread";
	}

	//FAQ 리스트 구현
	@RequestMapping(value ="faq",method = RequestMethod.GET)
	public void list(Model model,String curPage) {
		int page = -1;
		if(curPage==null) {
			page = 1;
			
		}else {
			page = Integer.parseInt(curPage);
		}
		QnaBoardPageTO<QnABoardVO> to = new QnaBoardPageTO<QnABoardVO>(page);
		to = qboardserivce.list(to);
		model.addAttribute("to",to);
		model.addAttribute("list",to.getList());
		
	}


	//FAQ 글작성구현
	@RequestMapping(value ="faqinsert",method = RequestMethod.POST)
	public String insert(QnABoardVO vo) {
		qboardserivce.insert(vo);
		return "redirect:/userpage/faq";
	}


	@RequestMapping(value="faqinsert",method = RequestMethod.GET)
	public void qnaboardinsert() {
		
		
		
	}
	@RequestMapping(value ="Noticeboardread/{bno}",method =RequestMethod.GET)
	public String Noticeread(Model model,@PathVariable("bno")int bno,LoginDTO login, HttpSession session) {
		
		NoticeboardVO vo = nboardservice.read(bno);

		model.addAttribute("vo",vo);
		return "userpage/Noticeboardread";
	}
	
	
	@RequestMapping(value = "Noticeboarddelete/{bno}",method = RequestMethod.GET)
	public String Noticedelete(@PathVariable("bno")int bno) {
		nboardservice.delete(bno);
		return "redirect:/userpage/Noticeboardlist";
	}

	@RequestMapping(value = "Noticeboardupdate",method = RequestMethod.POST)
	public String noticeboardupdate(NoticeboardVO vo) {
		
		nboardservice.update(vo);
		return "userpage/Noticeboardread/"+vo.getBno();
	}

	@RequestMapping(value = "Noticeboardupdate/{bno}",method = RequestMethod.GET)
	public String noticeboardupdate(Model model,@PathVariable("bno") int bno) {
		
		NoticeboardVO vo = nboardservice.updateUI(bno);
		model.addAttribute("vo",vo);
		
		return "userpage/Noticeboardupdate";
		
	}
	
	
	@RequestMapping(value ="Noticeboardlist",method = RequestMethod.GET)
	public void noticelist(Model model,String curPage) {
		int page = -1;
		if(curPage==null) {
			page = 1;
			
		}else {
			page = Integer.parseInt(curPage);
		}
		QnaBoardPageTO<NoticeboardVO> to = new QnaBoardPageTO<NoticeboardVO>(page);
		to = nboardservice.list(to);
		model.addAttribute("to",to);
		model.addAttribute("list",to.getList());
		
	}
	
	@RequestMapping(value = "Noticeboardinsert",method = RequestMethod.POST)
	public String noticeinsert(NoticeboardVO vo) {
		
		nboardservice.insert(vo);
		return "redirect:/userpage/Noticeboardlist";
		
	}
	
	
	@RequestMapping(value ="Noticeboardinsert",method = RequestMethod.GET)
	public void noticeinsert() {
		
	}
	

}
