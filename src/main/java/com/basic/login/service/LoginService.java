package com.basic.login.service;

import com.basic.user.vo.UserVo;

public interface LoginService {

	UserVo login(String userid, String userpw);
	
}
