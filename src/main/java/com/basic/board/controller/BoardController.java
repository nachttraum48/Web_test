package com.basic.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.basic.board.service.BoardService;
import com.basic.board.vo.BoardVo;

@Controller
@RequestMapping("Board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/First")
	public ModelAndView first() {
		System.out.println("보드 컨트롤러 - 로그인 후 홈페이지 함수 도착");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/first");
		return mv;
	}
	
	@RequestMapping("/List")
	public ModelAndView listUser() {
		System.out.println("보드 컨트롤러 - 게시글 조회 함수 도착");
		ModelAndView mv = new ModelAndView();
		
		List<BoardVo> list = boardService.list();
		System.out.println("보드 컨트롤러 - 게시글 조회 조회 후 리스트에 입력");
		
		mv.addObject("list", list);
		mv.setViewName("board/list");
		System.out.println("보드 컨트롤러 - 게시글 조회 리스트 화면 전달");
		return mv;
	}
	
}
