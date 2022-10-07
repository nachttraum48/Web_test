package com.basic.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.basic.menu.service.MenuService;
import com.basic.menu.vo.MenuVo;

@Controller
@RequestMapping("Menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/List")
	public ModelAndView menuList() {
		System.out.println("메뉴 컨트롤러 - 메뉴목록 함수 도착");
		ModelAndView mv = new ModelAndView();
		
		List<MenuVo> list = menuService.list();
		System.out.println("메뉴 컨트롤러 - 메뉴목록 조회 후 리스트에 입력");
		
		mv.addObject("list", list);
		mv.setViewName("menu/list");
		System.out.println("메뉴 컨트롤러 - 메뉴목록 리스트 화면 전달");
		return mv;
	}
	
	@RequestMapping("/Delete")
	public ModelAndView menuDelete(@RequestParam String menuname) {
		System.out.println("메뉴 컨트롤러 - 메뉴삭제 함수 도착");
		System.out.println("삭제 메뉴 이름 : " + menuname);
		ModelAndView mv = new ModelAndView();
		menuService.delete(menuname);
		mv.setViewName("redirect:/Menu/List");
		return mv;
	}
	
}
