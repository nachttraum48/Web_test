package com.basic.board.daoimpl;

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
	public List<BoardVo> boardList() {
		List<BoardVo> boardList = sqlSession.selectList("Board.boardList");
		return boardList;
	}

	@Override
	public List<BoardVo> selectList(String menuname) {
		List<BoardVo> selectList = sqlSession.selectList("Board.selectList", menuname);
		return selectList;
	}
	
}
