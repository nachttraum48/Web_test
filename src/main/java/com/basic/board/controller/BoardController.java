package com.basic.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.basic.board.service.BoardService;
import com.basic.board.vo.BoardVo;
import com.basic.menu.vo.MenuVo;
import com.basic.user.vo.UserVo;

@Controller
@RequestMapping("Board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/List")
	public ModelAndView list(@RequestParam String userid) {
		System.out.println("보드 컨트롤러 - 전체 게시글 조회 함수 도착");
		ModelAndView mv = new ModelAndView();

		// 로그인 유저 확인
		UserVo loginUser = boardService.userInfo(userid);

		// 관리자 예외처리
		if (loginUser.getUserid().equals("admin")) {
			loginUser.setAdminToken("1");
			System.out.println("로그인한 계정은 관리자입니다.");
		} else if (!loginUser.getUserid().equals("admin")) {
			loginUser.setAdminToken("0");
			System.out.println("로그인한 계정은 일반 유저입니다.");
		}
		
		mv.addObject("user", loginUser);

		// 메뉴 조회하기
		List<MenuVo> menuList = boardService.menuList();
		mv.addObject("menu", menuList);

		// 게시글 조회하기
		List<BoardVo> boardList = boardService.boardList();
		mv.addObject("board", boardList);

		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping("/SelectList")
	public ModelAndView selectList(@RequestParam String userid, String menuname) {
		System.out.println("보드 컨트롤러 - 메뉴별 게시글 조회 함수 도착");
		ModelAndView mv = new ModelAndView();
		
		// 로그인 유저 확인
		UserVo loginUser = boardService.userInfo(userid);
		
		// 관리자 예외처리
		if (loginUser.getUserid().equals("admin")) {
			loginUser.setAdminToken("1");
			System.out.println("로그인한 계정은 관리자입니다.");
		} else if (!loginUser.getUserid().equals("admin")) {
			loginUser.setAdminToken("0");
			System.out.println("로그인한 계정은 일반 유저입니다.");
		}
		
		mv.addObject("user", loginUser);
		
		// 메뉴 조회하기
		List<MenuVo> menuList = boardService.menuList();
		mv.addObject("menu", menuList);
		
		// 메뉴별 게시글 조회하기
		List<BoardVo> selectList = boardService.selectList(menuname);
		mv.addObject("board", selectList);
		
		mv.setViewName("board/list");
		return mv;
	}

}
