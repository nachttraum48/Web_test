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
	public HashMap<String, Object> loginCheck(HashMap<String, Object> map) {
		System.out.println("로그인 정보 조회 - Service 바티스 전");
		HashMap<String, Object> userInfo = userDao.loginCheck(map);
		System.out.println("로그인 정보 조회 - Service 바티스 후");
		System.out.println(userInfo);
		return userInfo;
	}

	@Override
	public void account(HashMap<String, Object> map) {
		// System.out.println("UserServiceImpl account response map = " + map);
		System.out.println("회원가입 - Service 바티스 전");
		userDao.account(map);
		System.out.println("회원가입 - Service 바티스 후");
	}
	
	@Override
	public List<UserVo> list() {
		System.out.println("회원목록 조회 - Service 바티스 전");
		List<UserVo> userlist = userDao.list();
		System.out.println("회원목록 조회 - Service 바티스 후");
		System.out.println(userlist);
		return userlist;
	}

	@Override
	public HashMap<String, Object> detail(HashMap<String, Object> map) {
		System.out.println("회원 상세정보 조회 - Service 바티스 전");
		HashMap<String, Object> detailUser = userDao.detail(map);
		System.out.println("회원 상세정보 조회 - Service 바티스 후");
		System.out.println(detailUser);
		return detailUser;
	}

	@Override
	public void delete(HashMap<String, Object> map) {
		System.out.println("회원탈퇴 - Service 바티스 전");
		userDao.delete(map);
		System.out.println("회원탈퇴 - Service 바티스 후");
	}

	@Override
	public void update(HashMap<String, Object> map) {
		System.out.println("회원정보 수정 - Service 바티스 전");
		userDao.update(map);
		System.out.println("회원정보 수정 - Service 바티스 후");		
	}
	
}
