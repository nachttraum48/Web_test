package com.basic.menu.service;

import java.util.List;

import com.basic.menu.vo.MenuVo;

public interface MenuService {
	// 메뉴목록
	List<MenuVo> list();
	// 메뉴삭제
	void delete(String menuname);
}
