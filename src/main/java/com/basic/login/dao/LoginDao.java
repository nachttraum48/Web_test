package com.basic.login.dao;

import com.basic.user.vo.UserVo;

public interface LoginDao {

	UserVo login(String userid, String userpw);
	
}
