package com.basic.reply.vo;

public class ReplyVo {
	
	private String replyidx;
	private String boardidx;
	private String replywriter;
	private String replycontent;
	private String replyindate;
	private String replyupdate;
	
	public ReplyVo() {}

	public ReplyVo(String replyidx, String boardidx, String replywriter, String replycontent, String replyindate,
			String replyupdate) {
		super();
		this.replyidx = replyidx;
		this.boardidx = boardidx;
		this.replywriter = replywriter;
		this.replycontent = replycontent;
		this.replyindate = replyindate;
		this.replyupdate = replyupdate;
	}

	public String getReplyidx() {
		return replyidx;
	}

	public void setReplyidx(String replyidx) {
		this.replyidx = replyidx;
	}

	public String getBoardidx() {
		return boardidx;
	}

	public void setBoardidx(String boardidx) {
		this.boardidx = boardidx;
	}

	public String getReplywriter() {
		return replywriter;
	}

	public void setReplywriter(String replywriter) {
		this.replywriter = replywriter;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public String getReplyindate() {
		return replyindate;
	}

	public void setReplyindate(String replyindate) {
		this.replyindate = replyindate;
	}

	public String getReplyupdate() {
		return replyupdate;
	}

	public void setReplyupdate(String replyupdate) {
		this.replyupdate = replyupdate;
	}

	@Override
	public String toString() {
		return "ReplyVo [replyidx=" + replyidx + ", boardidx=" + boardidx + ", replywriter=" + replywriter
				+ ", replycontent=" + replycontent + ", replyindate=" + replyindate + ", replyupdate=" + replyupdate
				+ "]";
	}
	
}
