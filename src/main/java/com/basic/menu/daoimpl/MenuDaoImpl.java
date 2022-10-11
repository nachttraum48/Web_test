package com.basic.menu.daoimpl;

import java.util.HashMap;
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
		List<MenuVo> list = sqlSession.selectList("Menu.list");
		return list;
	}
	
	@Override
	public MenuVo menuInfo(String menuname) {
		MenuVo menuInfo = sqlSession.selectOne("Menu.info", menuname);
		return menuInfo;
	}

	@Override
	public void create(String menuname) {
		sqlSession.insert("Menu.create", menuname);
	}
	
	@Override
	public void update(String menuname, String newname) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("menuname", menuname);
		map.put("newname", newname);
		
		sqlSession.update("Menu.update", map);
	}

	@Override
	public void delete(String menuname) {
		sqlSession.delete("Menu.delete", menuname);
	}
	
}
