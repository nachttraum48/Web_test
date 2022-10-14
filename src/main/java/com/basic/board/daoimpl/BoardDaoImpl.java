package com.basic.board.daoimpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.board.dao.BoardDao;
import com.basic.board.vo.BoardVo;
import com.basic.menu.vo.MenuVo;
import com.basic.page.vo.PageVo;
import com.basic.reply.vo.ReplyVo;
import com.basic.user.vo.UserVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserVo userInfo(String userid) {
		UserVo loginUser = sqlSession.selectOne("User.detail", userid);
		return loginUser;
	}

	@Override
	public List<MenuVo> menuList() {
		List<MenuVo> menuList = sqlSession.selectList("Menu.list");
		return menuList;
	}
	
	@Override
	public List<BoardVo> boardList(String menuname, PageVo pagination, String searchType, String searchText) {
		
		int startList = pagination.getStartList();
		int endList = pagination.getEndList();
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("menuname", menuname);
		map.put("startList", startList);
		map.put("endList", endList);
		map.put("searchType", searchType);
		map.put("searchText", searchText);
		
		List<BoardVo> boardList = sqlSession.selectList("Board.list", map);
		return boardList;
	}
	
	@Override
	public int listCnt(String menuname, String searchType, String searchText) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("menuname", menuname);
		map.put("searchType", searchType);
		map.put("searchText", searchText);
		
		int listCnt = sqlSession.selectOne("Board.listCnt", map);
		return listCnt;
	}
	
	@Override
	public BoardVo detail(String boardidx) {
		BoardVo detail = sqlSession.selectOne("Board.detail", boardidx);
		return detail;
	}

	@Override
	public List<ReplyVo> reply(String boardidx) {
		List<ReplyVo> reply = sqlSession.selectList("Reply.list", boardidx);
		return reply;
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
