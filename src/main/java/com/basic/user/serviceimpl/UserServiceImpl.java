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
		System.out.println("회원가입 - Service 바티스 전");
		userDao.account(map);
		System.out.println("회원가입 - Service 바티스 후");
	}
	
	@Override
	public boolean idcheck(String userid) {
		System.out.println("id 중복 체크 - Service 바티스 전");
		boolean result = userDao.idcheck(userid);
		System.out.println("id 중복 체크 - Service 바티스 후");
		return result;
	}

	@Override
	public List<UserVo> list() {
		System.out.println("회원목록 조회 - Service 바티스 전");
		List<UserVo> list = userDao.list();
		System.out.println("회원목록 조회 - Service 바티스 후");
		return list;
	}

	@Override
	public UserVo detail(String userid) {
		System.out.println("회원 상세정보 조회 - Service 바티스 전");
		UserVo detail = userDao.detail(userid);
		System.out.println("회원 상세정보 조회 - Service 바티스 후");
		return detail;
	}

	@Override
	public void delete(String userid) {
		System.out.println("회원탈퇴 - Service 바티스 전");
		userDao.delete(userid);
		System.out.println("회원탈퇴 - Service 바티스 후");
	}

	@Override
	public void update(HashMap<String, Object> map) {
		System.out.println("회원정보 수정 - Service 바티스 전");
		userDao.update(map);
		System.out.println("회원정보 수정 - Service 바티스 후");		
	}
	
}
