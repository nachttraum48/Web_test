package com.basic.user.vo;

public class UserVo {
	
	private String useridx;
	private String username;
	private String userid;
	private String userpw;
	private String userindate;
	private String userupdate;
	private String adminToken;

	public UserVo() {}

	public UserVo(String useridx, String username, String userid, String userpw, String userindate, String userupdate,
			String adminToken) {
		super();
		this.useridx = useridx;
		this.username = username;
		this.userid = userid;
		this.userpw = userpw;
		this.userindate = userindate;
		this.userupdate = userupdate;
		this.adminToken = adminToken;
	}

	public String getUseridx() {
		return useridx;
	}

	public void setUseridx(String useridx) {
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

	public String getAdminToken() {
		return adminToken;
	}

	public void setAdminToken(String adminToken) {
		this.adminToken = adminToken;
	}

	@Override
	public String toString() {
		return "UserVo [useridx = " + useridx + ", username = " + username + ", userid = " + userid + ", userpw = " + userpw
				+ ", userindate = " + userindate + ", userupdate = " + userupdate + ", adminToken = " + adminToken + "]\n";
	}
	
}
