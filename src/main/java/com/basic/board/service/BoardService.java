package com.basic.board.service;

import java.util.List;

import com.basic.board.vo.BoardVo;
import com.basic.menu.vo.MenuVo;
import com.basic.user.vo.UserVo;

public interface BoardService {
	
	// 로그인 유저 확인
	UserVo userInfo(String userid);
	
	// 메뉴 조회
	List<MenuVo> menuList();
	
	// 게시글 조회
	List<BoardVo> boardList();
	
	// 메뉴별 게시글 조회
	List<BoardVo> selectList(String menuname);
	
}
