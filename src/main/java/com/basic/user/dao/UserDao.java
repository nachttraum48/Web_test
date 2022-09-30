package com.basic.user.dao;

import java.util.HashMap;
import java.util.List;

import com.basic.user.vo.UserVo;

public interface UserDao {
	
	void account(HashMap<String, Object> map);
	
	boolean idcheck(String userid);
	
	List<UserVo> list();
	
	UserVo detail(String userid);
	
	void delete(String userid);
	
	void update(HashMap<String, Object> map);
}
