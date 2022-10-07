package com.basic.board.vo;

public class BoardVo {
	
	private String boardidx;
	private String boardmenu;
	private String boardtitle;
	private String boardwriter;
	private String boardcontent;
	private String boardindate;
	private String boardupdate;
	private String readcount;
	
	public BoardVo() {}
	
	public BoardVo(String boardidx, String boardmenu, String boardtitle, String boardwriter, String boardcontent,
			String boardindate, String boardupdate, String readcount) {
		super();
		this.boardidx = boardidx;
		this.boardmenu = boardmenu;
		this.boardtitle = boardtitle;
		this.boardwriter = boardwriter;
		this.boardcontent = boardcontent;
		this.boardindate = boardindate;
		this.boardupdate = boardupdate;
		this.readcount = readcount;
	}

	public String getBoardidx() {
		return boardidx;
	}

	public void setBoardidx(String boardidx) {
		this.boardidx = boardidx;
	}

	public String getBoardmenu() {
		return boardmenu;
	}

	public void setBoardmenu(String boardmenu) {
		this.boardmenu = boardmenu;
	}

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardwriter() {
		return boardwriter;
	}

	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}

	public String getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}

	public String getBoardindate() {
		return boardindate;
	}

	public void setBoardindate(String boardindate) {
		this.boardindate = boardindate;
	}

	public String getBoardupdate() {
		return boardupdate;
	}

	public void setBoardupdate(String boardupdate) {
		this.boardupdate = boardupdate;
	}

	public String getReadcount() {
		return readcount;
	}

	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "BoardVo [boardidx=" + boardidx + ", boardmenu=" + boardmenu + ", boardtitle=" + boardtitle
				+ ", boardwriter=" + boardwriter + ", boardcontent=" + boardcontent + ", boardindate=" + boardindate
				+ ", boardupdate=" + boardupdate + ", readcount=" + readcount + "]";
	}
	
}
