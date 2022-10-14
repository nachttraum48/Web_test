package com.basic.reply.serviceimpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.reply.dao.ReplyDao;
import com.basic.reply.service.ReplyService;
import com.basic.reply.vo.ReplyVo;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;

	@Override
	public void write(HashMap<String, Object> map) {
		replyDao.write(map);
	}
	
	@Override
	public ReplyVo detail(String replyidx) {
		ReplyVo replyInfo = replyDao.detail(replyidx);
		return replyInfo;
	}

	@Override
	public void update(String replyidx, String replycontent) {
		replyDao.update(replyidx, replycontent);
	}

	@Override
	public void delete(String replyidx) {
		replyDao.delete(replyidx);
	}
	
}
