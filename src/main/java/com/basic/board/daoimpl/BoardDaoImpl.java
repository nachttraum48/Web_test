package com.basic.board.daoimpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.board.dao.BoardDao;
import com.basic.board.vo.BoardVo;
import com.basic.menu.vo.MenuVo;
import com.basic.user.vo.UserVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserVo userInfo(String userid) {
		UserVo loginUser = sqlSession.selectOne("Board.userInfo", userid);
		return loginUser;
	}

	@Override
	public List<MenuVo> menuList() {
		List<MenuVo> menuList = sqlSession.selectList("Board.menuList");
		return menuList;
	}
	
	@Override
	public List<BoardVo> boardList(String menuname) {
		List<BoardVo> boardList = sqlSession.selectList("Board.boardList", menuname);
		return boardList;
	}
	
	@Override
	public List<BoardVo> search(String searchType, String searchText) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("searchText", searchText);
		
		List<BoardVo> searchList = sqlSession.selectList("Board.search", map);
		return searchList;
	}

	@Override
	public BoardVo detail(String boardidx) {
		BoardVo detail = sqlSession.selectOne("Board.detail", boardidx);
		return detail;
	}
	
	@Override
	public void readCount(String newcount, String boardidx) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("newcount", newcount);
		map.put("boardidx", boardidx);
		
		sqlSession.update("Board.readCount", map);
	}

	@Override
	public void update(HashMap<String, Object> map) {
		sqlSession.update("Board.update", map);
	}

	@Override
	public void delete(String boardidx) {
		sqlSession.delete("Board.delete", boardidx);
	}

	@Override
	public void write(HashMap<String, Object> map) {
		sqlSession.insert("Board.write", map);
	}
	
}
