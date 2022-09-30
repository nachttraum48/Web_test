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
	public void account(HashMap<String, Object> map) {
		// System.out.println("UserDaoImpl account response map = " + map);
		System.out.println("회원가입 - DAO 바티스 전");
		sqlSession.insert("User.account", map);
		System.out.println("회원가입 - DAO 바티스 후");
	}
	
	@Override
	public List<UserVo> list() {
		System.out.println("회원목록 조회 - DAO 바티스 전");
		List<UserVo> list = sqlSession.selectList("User.list");
		System.out.println("회원목록 조회 - DAO 바티스 후");
		System.out.println(list);
		return list;
	}

	@Override
	public UserVo detail(String userid) {
		System.out.println("회원 상세정보 조회 - DAO 바티스 전");
		UserVo detail = sqlSession.selectOne("User.detail", userid);
		System.out.println("회원 상세정보 조회 - DAO 바티스 후");
		System.out.println(detail);
		
		// 관리자 예외처리
		if (detail.getUserid().equals("admin")) {
			detail.setAdminToken("1");
			System.out.println("로그인한 계정은 관리자입니다.");
		} else if (!detail.getUserid().equals("admin")) {
			detail.setAdminToken("0");
			System.out.println("로그인한 계정은 일반 유저입니다.");
		}
		
		return detail;
	}

	@Override
	public void delete(String userid) {
		System.out.println("회원탈퇴 - DAO 바티스 전");
		sqlSession.delete("User.delete", userid);
		System.out.println("회원탈퇴 - DAO 바티스 후");
	}

	@Override
	public void update(HashMap<String, Object> map) {
		System.out.println("회원정보 수정 - DAO 바티스 전");
		sqlSession.update("User.update", map);
		System.out.println("회원정보 수정 - DAO 바티스 후");		
	}
	
}
