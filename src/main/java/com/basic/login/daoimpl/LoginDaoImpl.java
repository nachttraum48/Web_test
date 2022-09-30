package com.basic.login.daoimpl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.login.dao.LoginDao;
import com.basic.user.vo.UserVo;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserVo login(String userid, String userpw) {
		
		System.out.println("로그인 Dao 바티스 전");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		
		UserVo loginUser = sqlSession.selectOne("Login.loginUser", map);
		
		System.out.println("로그인 Dao 바티스 후");
		return loginUser;
	}
	
}
