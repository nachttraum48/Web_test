package com.basic.user.daoimpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.user.dao.UserDao;
import com.basic.user.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public HashMap<String, Object> loginCheck(HashMap<String, Object> map) {
		System.out.println("로그인 정보 조회 - DAO 바티스 전");
		HashMap<String, Object> userInfo = sqlSession.selectOne("User.login", map);
		System.out.println("로그인 정보 조회 - DAO 바티스 후");
		System.out.println(userInfo);
		return userInfo;
	}

	@Override
	public void account(HashMap<String, Object> map) {
		// System.out.println("UserDaoImpl account response map = " + map);
		System.out.println("회원가입 - DAO 바티스 전");
		sqlSession.insert("User.accountUser", map);
		System.out.println("회원가입 - DAO 바티스 후");
	}
	
	@Override
	public List<UserVo> list() {
		System.out.println("회원목록 조회 - DAO 바티스 전");
		List<UserVo> userlist = sqlSession.selectList("User.userList");
		System.out.println("회원목록 조회 - DAO 바티스 후");
		System.out.println(userlist);
		return userlist;
	}

	@Override
	public HashMap<String, Object> detail(HashMap<String, Object> map) {
		System.out.println("회원 상세정보 조회 - DAO 바티스 전");
		HashMap<String, Object> detailUser = sqlSession.selectOne("User.detailUser", map);
		System.out.println("회원 상세정보 조회 - DAO 바티스 후");
		System.out.println(detailUser);
		return detailUser;
	}

	@Override
	public void delete(HashMap<String, Object> map) {
		System.out.println("회원탈퇴 - DAO 바티스 전");
		sqlSession.delete("User.deleteUser", map);
		System.out.println("회원탈퇴 - DAO 바티스 후");
	}

	@Override
	public void update(HashMap<String, Object> map) {
		System.out.println("회원정보 수정 - DAO 바티스 전");
		sqlSession.update("User.updateUser", map);
		System.out.println("회원정보 수정 - DAO 바티스 후");		
	}
	
}
