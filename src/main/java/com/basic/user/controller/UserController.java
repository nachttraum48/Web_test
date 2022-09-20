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

	@Autowired
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
		System.out.println("UserController Account map = " + map);
		ModelAndView mv = new ModelAndView();
		System.out.println("유저 컨트롤러 - 회원가입 입력 함수 도착");
		userService.account(map);
		System.out.println("유저 컨트롤러 - 회원가입 입력 완료 함수 도착");
		mv.setViewName("redirect:/User/UserList");
		return mv;
	}

	@RequestMapping("/UserList")
	public ModelAndView userList() {
		ModelAndView mv = new ModelAndView();
		System.out.println("유저 컨트롤러 - 회원목록 조회 함수 도착");

		// DB에서 리스트를 가져온다.
		List<UserVo> userList = userService.list();
		System.out.println("유저 컨트롤러 - 회원목록 조회 후 리스트에 입력");

		// 가져온 리스트를 화면에 전달한다.
		mv.addObject("userList", userList);
		mv.setViewName("user/userList");
		System.out.println("유저 컨트롤러 - 회원목록 리스트 화면 전달");
		return mv;
	}

	@RequestMapping("/DetailUser")
	public ModelAndView detailUser(@RequestParam HashMap<String, Object> map) {
		System.out.println("유저 컨트롤러 - 회원 상세정보 함수 도착");
		System.out.println("detail map = " + map);
		ModelAndView mv = new ModelAndView();
		
		// DB에서 map를 가져온다.
		HashMap<String, Object> detailUser = userService.detail(map);
		System.out.println("유저 컨트롤러 - 회원 상세정보 조회 후 map에 입력");
		System.out.println(detailUser);
		
		// 가져온 map를 화면에 전달한다.
		mv.addObject("detailUser", detailUser);
		mv.setViewName("user/detailUser");
		System.out.println("유저 컨트롤러 - 회원 상세정보 화면 전달");
		return mv;
	}
	
	@RequestMapping("/DeleteUser")
	public ModelAndView deleteUser(@RequestParam HashMap<String, Object> map) {
		System.out.println("유저 컨트롤러 - 회원탈퇴 함수 도착");
		System.out.println("delete map = " + map);
		ModelAndView mv = new ModelAndView();
		userService.delete(map);
		mv.setViewName("redirect:/User/UserList");
		return mv;
	}
	
	@RequestMapping("/UpdateUserForm")
	public ModelAndView updateUserForm(@RequestParam HashMap<String, Object> map) {
		System.out.println("유저 컨트롤러 - 회원정보 수정 함수 도착");
		System.out.println("update map = " + map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("updateUser", map);
		mv.setViewName("user/updateUser");
		return mv;
	}
	
	@RequestMapping("/UpdateUser")
	public ModelAndView updateUser(@RequestParam HashMap<String, Object> map) {
		System.out.println("update map = " + map);
		System.out.println("유저 컨트롤러 - 회원정보 수정 완료 함수 도착");
		ModelAndView mv = new ModelAndView();
		userService.update(map);
		mv.setViewName("redirect:/User/UserList");
		return mv;
	}
	
}
