package com.basic.user.vo;

public class UserVo {
	
	private int useridx;
	private String username;
	private String userid;
	private String userpw;
	private String userindate;
	private String userupdate;

	public UserVo() {}

	public UserVo(int useridx, String username, String userid, String userpw, String userindate, String userupdate) {
		super();
		this.useridx = useridx;
		this.username = username;
		this.userid = userid;
		this.userpw = userpw;
		this.userindate = userindate;
		this.userupdate = userupdate;
	}

	public int getUseridx() {
		return useridx;
	}

	public void setUseridx(int useridx) {
		this.useridx = useridx;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUserindate() {
		return userindate;
	}

	public void setUserindate(String userindate) {
		this.userindate = userindate;
	}

	public String getUserupdate() {
		return userupdate;
	}

	public void setUserupdate(String userupdate) {
		this.userupdate = userupdate;
	}

	@Override
	public String toString() {
		return "UserVo [useridx = " + useridx + ", username = " + username + ", userid = " + userid + ", userpw = " + userpw
				+ ", userindate = " + userindate + ", userupdate = " + userupdate + "]\n";
	}
	
}
