package com.basic.page.vo;

public class PageVo {
	
	private int listSize = 10;   // 한 페이지당 보여질 게시글의 개수
	private int rangeSize = 10;  // 한 범위에 보여질 페이지의 개수
	private int page;            // 현재 페이지 번호
	private int range;           // 각 범위의 갯수 ( 1~10 1개, 11~20 1개, ... )
	private int listCnt;         // 전체 게시물의 개수
	private int pageCnt;         // 전체 페이지의 개수
	private int startPage;       // 각 페이지 범위 시작 번호
	private int endPage;         // 각 페이지 범위 끝 번호
	private int startList;       // 게시글의 시작 index 설정
	private int endList;         // 게시글의 마지막 index 설정
	private boolean prev;        // 이전 페이지 여부
	private boolean next;        // 다음 페이지 여부
	
	public PageVo() {}

	public PageVo(int listSize, int rangeSize, int page, int range, int listCnt, int pageCnt, int startPage,
			int startList, int endPage, int endList, boolean prev, boolean next) {
		super();
		this.listSize = listSize;
		this.rangeSize = rangeSize;
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		this.pageCnt = pageCnt;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startList = startList;
		this.endList = endList;
		this.prev = prev;
		this.next = next;
	}
	
	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public int getStartList() {
		return startList;
	}
	
	public void setStartList(int startList) {
		this.startList = startList;
	}

	public int getEndList() {
		return endList;
	}

	public void setEndList(int endList) {
		this.endList = endList;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "PageVo [listSize=" + listSize + ", rangeSize=" + rangeSize + ", page=" + page + ", range=" + range
				+ ", listCnt=" + listCnt + ", pageCnt=" + pageCnt + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startList=" + startList + ", endList=" + endList + ", prev=" + prev + ", next=" + next + "]";
	}

	public void pageInfo(int page, int range, int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		
		// 전체 페이지수
		double pageCount = (double) listCnt/listSize;
		this.pageCnt = (int) Math.ceil(pageCount);
		
		// 시작 페이지
		this.startPage = (range - 1) * rangeSize + 1 ;
		
		// 끝 페이지
		this.endPage = range * rangeSize;
		
		// 게시글 시작번호
		this.startList = (page - 1) * listSize + 1;
		
		// 게시글 마지막번호
		this.endList = startList + listSize - 1;
		
		// 이전 버튼 상태
		this.prev = range == 1 ? false : true;
		
		// 다음 버튼 상태
		this.next = endPage >= pageCnt ? false : true;
		
		if (this.endPage >= this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
		
	}

}
