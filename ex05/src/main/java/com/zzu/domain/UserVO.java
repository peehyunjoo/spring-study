package com.zzu.domain;

public class UserVO {
	private String uid;
	private String uname;
	private String upw;
	private String upoint;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUpoint() {
		return upoint;
	}
	public void setUpoint(String upoint) {
		this.upoint = upoint;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", uname=" + uname + ", upw=" + upw + ", upoint=" + upoint + "]";
	}
}	
