package com.basic.menu.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.menu.dao.MenuDao;
import com.basic.menu.vo.MenuVo;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MenuVo> list() {
		System.out.println("메뉴목록 - Dao 바티스 전");
		List<MenuVo> list = sqlSession.selectList("Menu.list");
		System.out.println("메뉴목록 - Dao 바티스 후");
		return list;
	}

	@Override
	public void delete(String menuname) {
		System.out.println("메뉴삭제 - Dao 바티스 전");
		sqlSession.delete("Menu.delete", menuname);
		System.out.println("메뉴삭제 - Dao 바티스 후");
	}
	
}
