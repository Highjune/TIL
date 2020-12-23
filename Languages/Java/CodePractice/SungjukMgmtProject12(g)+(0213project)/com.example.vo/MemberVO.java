package com.example.vo;

//VO를 제일 먼저 만들어야 한다.
//실제 데이터를 갖고 있는 객체
public class MemberVO {
	private String userid;
	private String passwd;
	
	public MemberVO(String userid, String passwd) {
		this.userid = userid;
		this.passwd = passwd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return String.format("MemberVO [userid=%s, passwd=%s]", userid, passwd);
	}
	
}
