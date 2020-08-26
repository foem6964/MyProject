package com.naver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("pay")
public class PayController {

	@RequestMapping(value = "kakaopay", method = RequestMethod.GET)
	public void kakaopay(String result,Model model) {
		model.addAttribute("result",result);
		
		
		
	}
	@RequestMapping(value = "payco",method = RequestMethod.GET)
	public void Payco() {
		
	}
	@RequestMapping(value = "naverpay",method = RequestMethod.GET)
	public void Naverpay() {
		
	}
	@RequestMapping(value = "payresult",method = RequestMethod.GET)
	public void payresult() {
		
	}
}
