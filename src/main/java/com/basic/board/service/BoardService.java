package com.basic.board.service;

import java.util.List;

import com.basic.board.vo.BoardVo;

public interface BoardService {
	// 게시글 조회
	List<BoardVo> list();
	
}
