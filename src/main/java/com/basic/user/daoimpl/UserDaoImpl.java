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
		sqlSession.insert("User.account", map);
	}
	
	@Override
	public boolean idcheck(String userid) {
		int count = sqlSession.selectOne("User.idcheck", userid);
		boolean result = false;
		
		// id가 중복일 때 -> 바티스에서 같은 id 값이 검출되었을 때
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
		List<UserVo> list = sqlSession.selectList("User.list");
		return list;
	}

	@Override
	public UserVo detail(String userid) {
		UserVo detail = sqlSession.selectOne("User.detail", userid);
		return detail;
	}

	@Override
	public void delete(String userid) {
		sqlSession.delete("User.delete", userid);
	}

	@Override
	public void update(HashMap<String, Object> map) {
		sqlSession.update("User.update", map);
	}
	
}
