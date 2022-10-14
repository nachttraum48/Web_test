package com.basic.reply.daoimpl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.reply.dao.ReplyDao;
import com.basic.reply.vo.ReplyVo;

@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(HashMap<String, Object> map) {
		sqlSession.insert("Reply.write", map);
	}
	
	@Override
	public ReplyVo detail(String replyidx) {
		ReplyVo replyInfo = sqlSession.selectOne("Reply.detail", replyidx);
		return replyInfo;
	}
	
	@Override
	public void update(String replyidx, String replycontent) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("replyidx", replyidx);
		map.put("replycontent", replycontent);
		
		sqlSession.update("Reply.update", map);
	}

	@Override
	public void delete(String replyidx) {
		sqlSession.delete("Reply.delete", replyidx);
	}
	
}
