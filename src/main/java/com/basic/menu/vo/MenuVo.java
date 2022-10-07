package com.basic.menu.vo;

public class MenuVo {
	
	private String menuidx;
	private String menuname;
	private String menuindate;
	private String menuupdate;
	
	public MenuVo() {}

	public MenuVo(String menuidx, String menuname, String menuindate, String menuupdate) {
		super();
		this.menuidx = menuidx;
		this.menuname = menuname;
		this.menuindate = menuindate;
		this.menuupdate = menuupdate;
	}

	public String getMenuidx() {
		return menuidx;
	}

	public void setMenuidx(String menuidx) {
		this.menuidx = menuidx;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenuindate() {
		return menuindate;
	}

	public void setMenuindate(String menuindate) {
		this.menuindate = menuindate;
	}

	public String getMenuupdate() {
		return menuupdate;
	}

	public void setMenuupdate(String menuupdate) {
		this.menuupdate = menuupdate;
	}

	@Override
	public String toString() {
		return "MenuVo [menuidx=" + menuidx + ", menuname=" + menuname + ", menuindate=" + menuindate + ", menuupdate="
				+ menuupdate + "]";
	}
	
}
