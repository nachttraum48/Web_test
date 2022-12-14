package com.basic.menu.service;

import java.util.List;

import com.basic.menu.vo.MenuVo;

public interface MenuService {
	
	// 메뉴목록
	List<MenuVo> list();

	// 메뉴 정보조회
	MenuVo menuInfo(String menuname);

	// 메뉴생성
	void create(String menuname);

	// 메뉴수정
	void update(String menuname, String newname);

	// 메뉴삭제
	void delete(String menuname);
	
}
