package com.basic.user.service;

import java.util.HashMap;
import java.util.List;

import com.basic.user.vo.UserVo;

public interface UserService {
	// 회원가입
	void account(HashMap<String, Object> map);
	// 회원조회
	List<UserVo> list();
	// 회원 상세정보
	UserVo detail(String userid);
	// 회원탈퇴
	void delete(String userid);
	// 회원수정
	void update(HashMap<String, Object> map);
}
