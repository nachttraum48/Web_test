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

@Controller // 어노테이션이 주입되었다.
@RequestMapping("User")
public class UserController {

	@Autowired   // import 하고 나머지 만들기 의존성을 주입한다.
	private UserService userService;
	
	@RequestMapping("/AccountForm") // ModelAndView 역할 MAV 컨트롤 스페이스바 마브
	public ModelAndView userAccountForm() {
		ModelAndView mv = new ModelAndView();
		System.out.println("유저 컨트롤러 - 회원가입 함수 도착");
		mv.setViewName("user/accountForm");
		return mv;
	}

	@RequestMapping("/Account") // ModelAndView 역할 : MAV 컨트롤 스페이스바 마브, @RequestParam이 해시맵 형식으로 받는 것
	public ModelAndView userAccount(@RequestParam HashMap<String, Object> map) {
		System.out.println("account map = " + map);
		ModelAndView mv = new ModelAndView();
		System.out.println("유저 컨트롤러 - 회원가입 입력 함수 도착");
		userService.account(map);
		System.out.println("유저 컨트롤러 - 회원가입 입력 완료 함수 도착");
		mv.setViewName("redirect:/Login/LoginForm");
		return mv;
	}

	@RequestMapping("/List")
	public ModelAndView userList() {
		ModelAndView mv = new ModelAndView();
		System.out.println("유저 컨트롤러 - 회원목록 조회 함수 도착");

		// DB에서 리스트를 가져온다.
		List<UserVo> list = userService.list();
		System.out.println("유저 컨트롤러 - 회원목록 조회 후 리스트에 입력");

		// 가져온 리스트를 화면에 전달한다.
		mv.addObject("list", list);
		mv.setViewName("user/list");
		System.out.println("유저 컨트롤러 - 회원목록 리스트 화면 전달");
		return mv;
	}

	@RequestMapping("/Detail")
	public ModelAndView detailUser(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 회원 상세정보 함수 도착");
		System.out.println("detail userid = " + userid);
		ModelAndView mv = new ModelAndView();
		
		// DB에서 정보를 가져온다.
		UserVo detail = userService.detail(userid);
		System.out.println("유저 컨트롤러 - 회원 상세정보 조회 후 map에 입력");
		System.out.println(detail);
		
		// 가져온 정보를 화면에 전달한다.
		mv.addObject("detail", detail);
		mv.setViewName("user/detail");
		System.out.println("유저 컨트롤러 - 회원 상세정보 화면 전달");
		return mv;
	}
	
	@RequestMapping("/UpdateForm")
	public ModelAndView updateUserForm(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 회원정보 수정 함수 도착");
		System.out.println("update userid = " + userid);
		ModelAndView mv = new ModelAndView();
		
		// DB에서 정보를 가져온다.
		UserVo updateUser = userService.detail(userid);
		System.out.println("유저 컨트롤러 - 회원 상세정보 조회 후 map에 입력");
		System.out.println(updateUser);
		
		// 가져온 정보를 화면에 전달한다.
		mv.addObject("update", updateUser);
		mv.setViewName("user/updateForm");
		return mv;
	}
	
	@RequestMapping("/Update")
	public ModelAndView updateUser(@RequestParam HashMap<String, Object> map) {
		System.out.println("update map = " + map);
		System.out.println("유저 컨트롤러 - 회원정보 수정 완료 함수 도착");
		ModelAndView mv = new ModelAndView();
		userService.update(map);
		mv.setViewName("redirect:/User/List");
		return mv;
	}
	
	// 일반 유저 - 탈퇴하기
	@RequestMapping("/Delete")
	public ModelAndView deleteUser(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 회원탈퇴 함수 도착");
		System.out.println("일반 유저 탈퇴 id = " + userid);
		ModelAndView mv = new ModelAndView();
		userService.delete(userid);
		mv.setViewName("redirect:/Login/LoginForm");
		return mv;
	}
	
	// 관리자 - 유저 추방하기
	@RequestMapping("/DeleteAdmin")
	public ModelAndView deleteAdmin(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 회원탈퇴 함수 도착");
		System.out.println("관리자 회원 추방 id = " + userid);
		ModelAndView mv = new ModelAndView();
		userService.delete(userid);
		mv.setViewName("redirect:/User/List");
		return mv;
	}
	
}
