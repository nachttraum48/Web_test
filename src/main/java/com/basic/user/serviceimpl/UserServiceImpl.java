package com.basic.user.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.user.dao.UserDao;
import com.basic.user.service.UserService;
import com.basic.user.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void account(HashMap<String, Object> map) {
		userDao.account(map);
	}
	
	@Override
	public boolean idcheck(String userid) {
		boolean result = userDao.idcheck(userid);
		return result;
	}

	@Override
	public List<UserVo> list() {
		List<UserVo> list = userDao.list();
		return list;
	}

	@Override
	public UserVo detail(String userid) {
		UserVo detail = userDao.detail(userid);
		return detail;
	}

	@Override
	public void delete(String userid) {
		userDao.delete(userid);
	}

	@Override
	public void update(HashMap<String, Object> map) {
		userDao.update(map);
	}
	
}
