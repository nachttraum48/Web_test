package com.basic.menu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.menu.dao.MenuDao;
import com.basic.menu.service.MenuService;
import com.basic.menu.vo.MenuVo;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<MenuVo> list() {
		List<MenuVo> list = menuDao.list();
		return list;
	}
	
	@Override
	public MenuVo menuInfo(String menuname) {
		MenuVo menuInfo = menuDao.menuInfo(menuname);
		return menuInfo;
	}

	@Override
	public void create(String menuname) {
		menuDao.create(menuname);
	}
	
	@Override
	public void update(String menuname, String newname) {
		menuDao.update(menuname, newname);
	}
	
	@Override
	public void delete(String menuname) {
		menuDao.delete(menuname);
	}
	
}
