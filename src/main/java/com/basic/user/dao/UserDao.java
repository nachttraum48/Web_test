package com.basic.user.dao;

import java.util.HashMap;
import java.util.List;

import com.basic.user.vo.UserVo;

public interface UserDao {
	
	void account(HashMap<String, Object> map);
	
	List<UserVo> list();
	
	HashMap<String, Object> detail(HashMap<String, Object> map);
	
	void delete(HashMap<String, Object> map);
	
	void update(HashMap<String, Object> map);
}
