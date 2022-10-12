package com.basic.board.controller;

import java.util.HashMap;
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

	@RequestMapping("/First")
	public ModelAndView first(@RequestParam String userid) {
		System.out.println("보드 컨트롤러 - 로그인 후 메인화면 함수 도착");
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
		mv.setViewName("board/first");
		return mv;
	}
	
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
		List<BoardVo> selectList = boardService.selectMenu(menuname);
		mv.addObject("board", selectList);

		mv.setViewName("board/list");
		return mv;
	}

	@RequestMapping("/Search")
	public ModelAndView search(@RequestParam String userid, String searchType, String searchText) {
		System.out.println("보드 컨트롤러 - 게시글 검색 함수 도착");
		System.out.println("타입 : " + searchType + ", 검색어 : " + searchText);
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

		// 검색한 게시글 조회하기
		List<BoardVo> searchList = boardService.search(searchType, searchText);
		mv.addObject("board", searchList);

		mv.setViewName("board/list");
		return mv;
	}

	@RequestMapping("/Detail")
	public ModelAndView detail(@RequestParam String userid, String boardidx) {
		System.out.println("보드 컨트롤러 - 게시글 상세 페이지 함수 도착");
		System.out.println("게시글 idx : " + boardidx);
		ModelAndView mv = new ModelAndView();

		// 로그인 유저 확인
		UserVo loginUser = boardService.userInfo(userid);
		mv.addObject("user", loginUser);

		// 게시글 정보 확인
		BoardVo detail = boardService.detail(boardidx);

		// 조회수 체크
		String countInfo = detail.getReadcount();
		int readcount = Integer.parseInt(countInfo);
		
		readcount = readcount + 1;
		String newcount = String.valueOf(readcount);
		detail.setReadcount(newcount);
		
		// 조회수 체크 후 DB 수정
		boardService.readCount(newcount, boardidx);

		mv.addObject("detail", detail);
		mv.setViewName("board/detail");
		return mv;
	}

	@RequestMapping("UpdateForm")
	public ModelAndView updateForm(@RequestParam String userid, String boardidx) {
		System.out.println("보드 컨트롤러 - 게시글 수정 함수 도착");
		ModelAndView mv = new ModelAndView();

		// 로그인 유저 확인
		UserVo loginUser = boardService.userInfo(userid);
		mv.addObject("user", loginUser);

		// 메뉴 조회하기
		List<MenuVo> menuList = boardService.menuList();
		mv.addObject("menu", menuList);

		// 기존의 보드 정보를 보여주기 위한 보드 정보조회
		BoardVo updateBoard = boardService.detail(boardidx);
		mv.addObject("update", updateBoard);
		mv.setViewName("board/updateForm");

		return mv;
	}

	@RequestMapping("Update")
	public ModelAndView update(@RequestParam HashMap<String, Object> map) {
		System.out.println("보드 컨트롤러 - 게시글 수정 입력 함수 도착");
		ModelAndView mv = new ModelAndView();

		boardService.update(map);

		// detail()에 매개변수 userid 전달
		String userid = (String) map.get("userid");
		mv.addObject("userid", userid);

		// detail()에 매개변수 boardidx 전달
		String boardidx = (String) map.get("boardidx");
		mv.addObject("boardidx", boardidx);

		mv.setViewName("redirect:/Board/Detail");
		return mv;
	}

	@RequestMapping("/Delete")
	public ModelAndView delete(@RequestParam String userid, String boardidx) {
		System.out.println("보드 컨트롤러 - 게시글 삭제 함수 도착");
		System.out.println("삭제 메뉴 이름 : " + boardidx);
		ModelAndView mv = new ModelAndView();

		boardService.delete(boardidx);

		// list()에 매개변수 userid 전달
		mv.addObject("userid", userid);
		mv.setViewName("redirect:/Board/List");
		return mv;
	}

	@RequestMapping("/WriteForm")
	public ModelAndView writeForm(@RequestParam String userid) {
		System.out.println("보드 컨트롤러 - 게시글 작성 함수 도착");
		ModelAndView mv = new ModelAndView();

		// 로그인 유저 확인
		UserVo loginUser = boardService.userInfo(userid);
		mv.addObject("user", loginUser);
		
		// 메뉴 조회하기
		List<MenuVo> menuList = boardService.menuList();
		mv.addObject("menu", menuList);

		mv.setViewName("board/writeForm");
		return mv;
	}

	@RequestMapping("/Write")
	public ModelAndView write(@RequestParam HashMap<String, Object> map) {
		System.out.println("보드 컨트롤러 - 게시글 작성 완료 함수 도착");
		ModelAndView mv = new ModelAndView();

		boardService.write(map);

		// list()에 매개변수 userid 전달
		String userid = (String) map.get("boardwriter");
		mv.addObject("userid", userid);
		mv.setViewName("redirect:/Board/List");
		return mv;
	}

}
