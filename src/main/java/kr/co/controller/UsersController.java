package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.constant.SnsUrlGroup;
import kr.co.domain.UsersDTO;
import kr.co.service.UsersService;

@Controller
@RequestMapping("users")
public class UsersController {

   @Autowired
   private UsersService usersService;

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public void login(Model model) throws Exception {
      for (SnsUrlGroup snsName : SnsUrlGroup.values())
         model.addAttribute(snsName.toString().toLowerCase() + "_url",
               SnsUrlGroup.valueOf(snsName.toString()).getAuthorizationUrl());
   }

   @RequestMapping(value = "/auth/{snsName}/callback", method = { RequestMethod.GET, RequestMethod.POST })
   public String snsLoginCallback(@PathVariable String snsName, Model model, @RequestParam String code,
         HttpSession session) throws Exception {
      // OAuth2
      String userId = usersService.createUserId(snsName, code);
      UsersDTO dto = usersService.readUser(userId);

      if (dto == null) {
         usersService.createUser(userId);
         Integer u_no = usersService.getU_noById(userId);
         session.setAttribute("user", u_no);
         return "users/join";
      } else if (dto.getName() == null) {
         Integer u_no = usersService.getU_noById(dto.getId());
         session.setAttribute("user", u_no);
         return "users/join";
      } else {
         model.addAttribute("result", dto.getName() + "님 반갑습니다.");
         session.setAttribute("loginUser", dto);
      }
      return "redirect:/product/productList";
   }

   @RequestMapping(value = "/join", method = RequestMethod.GET)
   public void join() {
   }
   
   @RequestMapping(value = "/join", method = RequestMethod.POST)
   public String join(String name,String address, Model model, HttpSession session) {
      Integer u_no =(Integer) session.getAttribute("user");
      UsersDTO dto = new UsersDTO(u_no, null, name,address);
      usersService.updateName(dto);
      session.invalidate();
      model.addAttribute("result", "다시한번 로그인 해주세요");
      return "redirect:/users/login";
   }
   //test
   @RequestMapping(value = "/loginResult", method = RequestMethod.GET)
   public void loginResult() {
   }
   
   @RequestMapping(value = "/logout", method = RequestMethod.GET)
   public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response)
         throws Exception {
      session.invalidate();
      // 로그아웃 버튼주소들
      String kakaologoutURL = "https://developers.kakao.com/logout";
      String naverlogoutURL = "https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com";
      //home 으로 가야함
      return "redirect:/users/login";
   }

}