package com.basic.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.basic.login.service.LoginService;
import com.basic.user.vo.UserVo;

@Controller
@RequestMapping("Login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/LoginForm")
	public ModelAndView loginForm() {
		System.out.println("로그인 컨트롤러 - 로그인 함수 도착");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		return mv;
	}
	
	@RequestMapping("Login")
	public ModelAndView login(String userid, String userpw) {   // 파라미터
		System.out.println("로그인 id : " + userid + ", pw : " + userpw);
		ModelAndView mv = new ModelAndView();
		
		UserVo loginUser = loginService.login(userid, userpw);   // 아규먼트
		System.out.println(loginUser);
		
		// id, pw 잘못 입력했을 시 오류메시지 설정
		String msg = "";
		
		// id, pw 잘못 입력하는 것 예외처리
		if (loginUser != null) {
			
			// 관리자 예외처리
			if (loginUser.getUserid().equals("admin")) {
				loginUser.setAdminToken("1");
				System.out.println("로그인한 계정은 관리자입니다.");
			} else if (!loginUser.getUserid().equals("admin")) {
				loginUser.setAdminToken("0");
				System.out.println("로그인한 계정은 일반 유저입니다.");
			}
			
			mv.addObject("user", loginUser);
			mv.setViewName("board/first");
		
		// id, pw 잘못 입력했을 때
		} else if (loginUser == null) {
			
			// 오류메시지 출력 후 재 로그인 설정
			msg = "로그인 실패! 아이디와 비밀번호 확인해주세요.";
			System.out.println(msg);
			
			mv.addObject("msg", msg);
			mv.setViewName("login/login");
		}
		
		return mv;
	}
	
	@RequestMapping("/Logout")
	public ModelAndView logout() {
		System.out.println("로그인 컨트롤러 - 로그아웃 함수 도착");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
