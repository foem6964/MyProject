package kr.co.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.domain.CartDTO;
import kr.co.domain.UsersDTO;
import kr.co.service.CartService;

@Controller
@RequestMapping(value = "cart")
public class CartController {
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/add/{productCode}", method = RequestMethod.GET)
	public String additem(HttpSession session, @PathVariable String productCode) {
		UsersDTO user = (UsersDTO) session.getAttribute("loginUser");
		if (user == null) {
			return "redirect:/users/login";
		}
		Integer u_no = user.getU_no();
		cartService.getCartDTOfrom11st(productCode, u_no);
		return "redirect:/cart/list";
	
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpSession session, Model model,String result) {
		UsersDTO user = (UsersDTO) session.getAttribute("loginUser");
		if(user==null)
			return "redirect:/users/login";
		List<CartDTO> list = new ArrayList<CartDTO>();
		list.addAll(cartService.selectList(user.getU_no()));
		model.addAttribute("cartList", list);
		model.addAttribute("loginUser",user);
		return "/cart/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String update(HttpSession session, @RequestBody Map<String, Object> map) {
		// dto.count와 dto.c_no 만 사용+ user.u_no
		Integer c_no = (Integer) map.get("c_no");
		System.out.println(c_no);
		String count = (String) map.get("count");
		System.out.println(count);
		UsersDTO user = (UsersDTO) session.getAttribute("loginUser");
		if (user == null)
			return "fail";
		Integer u_no = user.getU_no();
		cartService.update(c_no, count, u_no);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{c_no}", method = RequestMethod.DELETE)
	public String delete(HttpSession session, @PathVariable("c_no") int c_no) {
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		if (dto == null)
			return "fail";
		Integer u_no = dto.getU_no();
		cartService.delete(c_no, u_no);
		return "success";
	}

}
