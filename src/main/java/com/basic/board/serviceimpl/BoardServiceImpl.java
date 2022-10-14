package com.basic.board.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.board.dao.BoardDao;
import com.basic.board.service.BoardService;
import com.basic.board.vo.BoardVo;
import com.basic.menu.vo.MenuVo;
import com.basic.reply.vo.ReplyVo;
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
	public List<BoardVo> boardList(String menuname) {
		List<BoardVo> boardList = boardDao.boardList(menuname);
		return boardList;
	}
	
	@Override
	public List<BoardVo> search(String searchType, String searchText) {
		List<BoardVo> searchList = boardDao.search(searchType, searchText);
		return searchList;
	}

	@Override
	public BoardVo detail(String boardidx) {
		BoardVo detail = boardDao.detail(boardidx);
		return detail;
	}
	
	@Override
	public List<ReplyVo> reply(String boardidx) {
		List<ReplyVo> reply = boardDao.reply(boardidx);
		return reply;
	}
	
	@Override
	public void readCount(String newcount, String boardidx) {
		boardDao.readCount(newcount, boardidx);
	}

	@Override
	public void update(HashMap<String, Object> map) {
		boardDao.update(map);
	}

	@Override
	public void delete(String boardidx) {
		boardDao.delete(boardidx);
	}

	@Override
	public void write(HashMap<String, Object> map) {
		boardDao.write(map);
	}

}
