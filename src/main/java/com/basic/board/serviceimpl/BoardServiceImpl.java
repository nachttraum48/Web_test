package com.basic.board.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.board.dao.BoardDao;
import com.basic.board.service.BoardService;
import com.basic.board.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<BoardVo> list() {
		System.out.println("메뉴목록 - Service 바티스 전");
		List<BoardVo> list = boardDao.list();
		System.out.println("메뉴목록 - Service 바티스 후");
		return list;
	}
	
}
