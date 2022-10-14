package com.basic.reply.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.basic.reply.service.ReplyService;
import com.basic.reply.vo.ReplyVo;

@Controller
@RequestMapping("Reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	@RequestMapping("/Write")
	public ModelAndView write(@RequestParam HashMap<String, Object> map) {
		System.out.println("댓글 컨트롤러 - 댓글 입력 함수 도착");
		ModelAndView mv = new ModelAndView();
		
		replyService.write(map);

		// detail()에 매개변수 전달
		String userid = (String) map.get("userid");
		String boardidx = (String) map.get("boardidx");

		mv.addObject("userid", userid);
		mv.addObject("boardidx", boardidx);
		mv.setViewName("redirect:/Board/Detail");
		return mv;
	}

	@RequestMapping("/UpdateForm")
	public ModelAndView updateForm(@RequestParam String replyidx) {
		System.out.println("댓글 컨트롤러 - 댓글 수정 함수 도착");
		System.out.println("수정 댓글 idx : " + replyidx);
		ModelAndView mv = new ModelAndView();
		
		// 댓글 정보 확인
		ReplyVo replyInfo = replyService.detail(replyidx);
		
		mv.addObject("update", replyInfo);
		mv.setViewName("reply/updateForm");
		return mv;
	}

	@RequestMapping("/Update")
	public ModelAndView update(@RequestParam String replyidx, String replycontent) {
		System.out.println("댓글 컨트롤러 - 댓글 수정 완료 함수 도착");
		ModelAndView mv = new ModelAndView();
		
		replyService.update(replyidx, replycontent);
		
		// 댓글 정보 확인 후 detail()에 매개변수 전달
		ReplyVo replyInfo = replyService.detail(replyidx);
		System.out.println(replyInfo);
		
		String userid = replyInfo.getReplywriter();
		String boardidx = replyInfo.getBoardidx();
		
		mv.addObject("userid", userid);
		mv.addObject("boardidx", boardidx);
		mv.setViewName("redirect:/Board/Detail");
		return mv;
	}

	@RequestMapping("/Delete")
	public ModelAndView delete(@RequestParam String replyidx) {
		System.out.println("댓글 컨트롤러 - 댓글 삭제 함수 도착");
		System.out.println("삭제 댓글 idx : " + replyidx);
		ModelAndView mv = new ModelAndView();
		
		// 댓글 정보 확인 후 detail()에 매개변수 전달
		ReplyVo replyInfo = replyService.detail(replyidx);
		System.out.println(replyInfo);
		
		String userid = replyInfo.getReplywriter();
		String boardidx = replyInfo.getBoardidx();
		
		replyService.delete(replyidx);
		
		mv.addObject("userid", userid);
		mv.addObject("boardidx", boardidx);
		mv.setViewName("redirect:/Board/Detail");
		return mv;
	}

}
