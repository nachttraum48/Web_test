package com.basic.reply.service;

import java.util.HashMap;

import com.basic.reply.vo.ReplyVo;

public interface ReplyService {
	
	// 댓글 작성
	void write(HashMap<String, Object> map);
	
	// 댓글 정보 조회
	ReplyVo detail(String replyidx);
	
	// 댓글 수정
	void update(String replyidx, String replycontent);
	
	// 댓글 삭제
	void delete(String replyidx);
	
}
