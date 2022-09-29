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
		ModelAndView mv = new ModelAndView();
		System.out.println("로그인 컨트롤러 - 로그인 함수 도착");
		mv.setViewName("login/login");
		return mv;
	}
	
	@RequestMapping("Login")
	public ModelAndView login(String userid, String userpw) {   // 파라미터
		System.out.println("로그인 컨트롤러 입력 값 - userid : " + userid + ", userpw : " + userpw);
		ModelAndView mv = new ModelAndView();
		
		UserVo userInfo = loginService.login(userid, userpw);   // 아규먼트
		System.out.println("로그인 컨트롤러 들고온 값 - userid : " + userid + ", userpw : " + userpw);
		System.out.println("로그인 컨트롤러 - 유저 상세정보");
		System.out.println(userInfo);
		
		// id, pw 잘못 입력했을 시 오류메시지 설정
		String msg = "";
		
		// id, pw 잘못 입력하는 것 예외처리
		if (userInfo != null) {
			
			// 관리자 예외처리
			if (userInfo.getUserid().equals("admin")) {
				userInfo.setAdminToken("1");
				System.out.println("로그인한 계정은 관리자입니다.");
			} else if (!userInfo.getUserid().equals("admin")) {
				userInfo.setAdminToken("0");
				System.out.println("로그인한 계정은 일반 유저입니다.");
			}
			
			// 토큰 값 테스트로 문구 출력
			String adminTest = "";
			if (userInfo.getAdminToken().equals("1")) {
				adminTest = "관리자";
				System.out.println("로그인 계정 정보 - userid = " + userInfo.getUserid() + ", userpw = " + userInfo.getUserpw());
				System.out.println("권한 : " + adminTest + "입니다.");
			} else {
				System.out.println("일반 유저입니다.");
			}
			
			mv.addObject("user", userInfo);
			mv.setViewName("board/boardFirst");
		
		// id, pw 잘못 입력했을 때
		} else if (userInfo == null) {
			
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
		ModelAndView mv = new ModelAndView();
		System.out.println("로그인 컨트롤러 - 로그아웃 함수 도착");
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
