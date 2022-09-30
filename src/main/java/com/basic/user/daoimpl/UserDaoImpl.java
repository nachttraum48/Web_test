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
		System.out.println("회원가입 - Dao 바티스 전");
		sqlSession.insert("User.account", map);
		System.out.println("회원가입 - Dao 바티스 후");
	}
	
	@Override
	public boolean idcheck(String userid) {
		System.out.println("id 중복 체크 - Dao 바티스 전");
		int count = sqlSession.selectOne("User.idcheck", userid);
		System.out.println("id 중복 체크 - Dao 바티스 후");
		boolean result = false;
		
		// id가 중복일 때 - 바티스에서 같은 id 값이 검출되었을 때
		if (count == 1) {
			result = false;
			
		// id가 중복이 아닐 때
		} else {
			result = true;
		}
		
		return result;
	}

	@Override
	public List<UserVo> list() {
		System.out.println("회원목록 조회 - Dao 바티스 전");
		List<UserVo> list = sqlSession.selectList("User.list");
		System.out.println("회원목록 조회 - Dao 바티스 후");
		System.out.println(list);
		return list;
	}

	@Override
	public UserVo detail(String userid) {
		System.out.println("회원 상세정보 조회 - Dao 바티스 전");
		UserVo detail = sqlSession.selectOne("User.detail", userid);
		System.out.println("회원 상세정보 조회 - Dao 바티스 후");
		System.out.println(detail);
		return detail;
	}

	@Override
	public void delete(String userid) {
		System.out.println("회원탈퇴 - Dao 바티스 전");
		sqlSession.delete("User.delete", userid);
		System.out.println("회원탈퇴 - Dao 바티스 후");
	}

	@Override
	public void update(HashMap<String, Object> map) {
		System.out.println("회원정보 수정 - Dao 바티스 전");
		sqlSession.update("User.update", map);
		System.out.println("회원정보 수정 - Dao 바티스 후");		
	}
	
}
