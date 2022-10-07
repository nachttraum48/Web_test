package com.basic.board.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.board.dao.BoardDao;
import com.basic.board.vo.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardVo> list() {
		System.out.println("메뉴목록 - Dao 바티스 전");
		List<BoardVo> list = sqlSession.selectList("Board.list");
		System.out.println("메뉴목록 - Dao 바티스 후");
		return list;
	}
	
}
