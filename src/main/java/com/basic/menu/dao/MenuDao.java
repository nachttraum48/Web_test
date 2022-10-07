package com.basic.menu.dao;

import java.util.List;

import com.basic.menu.vo.MenuVo;

public interface MenuDao {
	
	List<MenuVo> list();
	
	void delete(String menuname);
}
