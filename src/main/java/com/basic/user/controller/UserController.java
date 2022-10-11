package com.basic.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.basic.user.service.UserService;
import com.basic.user.vo.UserVo;

@Controller   // 어노테이션이 주입되었다.
@RequestMapping("User")
public class UserController {

	@Autowired   // import 하고 나머지 만들기 의존성을 주입한다.
	private UserService userService;
	
	@RequestMapping("/AccountForm")
	public ModelAndView accountForm() {
		System.out.println("유저 컨트롤러 - 회원가입 함수 도착");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/accountForm");
		return mv;
	}
	
//	@RequestParam HashMap<K,V> -> jsp에서 보낸 값을 해시맵 형식으로 받아오겠다는 것을 의미
	@RequestMapping("/Account")
	public ModelAndView account(@RequestParam HashMap<String, Object> map) {
		System.out.println("유저 컨트롤러 - 회원가입 입력 함수 도착");
		System.out.println("회원가입 유저 정보 = " + map);
		ModelAndView mv = new ModelAndView();
		
		// id 중복 체크
		String userid = (String) map.get("userid");
		boolean result = userService.idcheck(userid);
		System.out.println("id 체크 결과 : " + result);
		
		// id 중복 시 오류메시지 설정
		String msg = "";
		
		// id가 중복이 아닐 때
		if (result == true) {
			userService.account(map);
			System.out.println("회원가입 성공");
			mv.setViewName("redirect:/Login/LoginForm");
			
		// id가 중복일 때
		} else if (result == false) {
			System.out.println("id 중복! 회원가입 실패");
			msg = "중복된 ID입니다. 다른 ID를 입력해주세요";
			mv.addObject("msg", msg);
			mv.setViewName("user/accountForm");
		}
		
		return mv;
	}

	@RequestMapping("/List")
	public ModelAndView list() {
		System.out.println("유저 컨트롤러 - 회원목록 조회 함수 도착");
		ModelAndView mv = new ModelAndView();

		List<UserVo> list = userService.list();
		mv.addObject("list", list);
		mv.setViewName("user/list");
		
		return mv;
	}
	
	@RequestMapping("/Detail")
	public ModelAndView detail(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 일반 유저기준 상세정보 함수 도착");
		System.out.println("상세정보 id : " + userid);
		ModelAndView mv = new ModelAndView();
		
		UserVo detail = userService.detail(userid);
		System.out.println(detail);
		
		// 일반 유저임을 나타내기 위한 토큰 발급
		detail.setAdminToken("0");
		System.out.println("로그인한 계정은 일반 유저입니다.");
		
		mv.addObject("detail", detail);
		mv.setViewName("user/detail");
		return mv;
	}
	
	@RequestMapping("/DetailAdmin")
	public ModelAndView detailAdmin(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 관리자 기준 상세정보 함수 도착");
		System.out.println("상세정보 id : " + userid);
		ModelAndView mv = new ModelAndView();
		
		UserVo detail = userService.detail(userid);
		System.out.println(detail);
		
		// 관리자임을 나타내기 위한 토큰 발급
		detail.setAdminToken("1");
		System.out.println("로그인한 계정은 관리자입니다.");
		
		mv.addObject("detail", detail);
		mv.setViewName("user/detail");
		return mv;
	}
	
	@RequestMapping("/UpdateForm")
	public ModelAndView updateForm(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 회원정보 수정 함수 도착");
		System.out.println("userid 값 : " + userid);
		ModelAndView mv = new ModelAndView();
		
		UserVo updateUser = userService.detail(userid);
		System.out.println(updateUser);
		
		mv.addObject("update", updateUser);
		mv.setViewName("user/updateForm");
		return mv;
	}
	
	@RequestMapping("/Update")
	public ModelAndView update(@RequestParam HashMap<String, Object> map) {
		System.out.println("유저 컨트롤러 - 회원정보 수정 완료 함수 도착");
		System.out.println("수정 유저 정보 = " + map);
		ModelAndView mv = new ModelAndView();
		
		userService.update(map);
		
		// Detail에 매개변수 전달
		String userid = (String) map.get("userid");
		mv.addObject("userid", userid);
		mv.setViewName("redirect:/User/Detail");
		
		return mv;
	}
	
	@RequestMapping("/Delete")
	public ModelAndView delete(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 일반 유저기준 탈퇴 함수 도착");
		System.out.println("탈퇴 id : " + userid);
		ModelAndView mv = new ModelAndView();
		
		userService.delete(userid);
		mv.setViewName("redirect:/Login/LoginForm");
		return mv;
	}
	
	@RequestMapping("/DeleteAdmin")
	public ModelAndView deleteAdmin(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 관리자 기준 추방 함수 도착");
		System.out.println("추방 id : " + userid);
		ModelAndView mv = new ModelAndView();
		
		userService.delete(userid);
		mv.setViewName("redirect:/User/List");
		return mv;
	}
	
}
