package com.basic.board.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.board.dao.BoardDao;
import com.basic.board.service.BoardService;
import com.basic.board.vo.BoardVo;
import com.basic.menu.vo.MenuVo;
import com.basic.user.vo.UserVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public UserVo userInfo(String userid) {
		UserVo loginUser = boardDao.userInfo(userid);
		return loginUser;
	}

	@Override
	public List<MenuVo> menuList() {
		List<MenuVo> menuList = boardDao.menuList();
		return menuList;
	}
	
	@Override
	public List<BoardVo> boardList() {
		List<BoardVo> boardList = boardDao.boardList();
		return boardList;
	}

	@Override
	public List<BoardVo> selectList(String menuname) {
		List<BoardVo> selectList = boardDao.selectList(menuname);
		return selectList;
	}

}
