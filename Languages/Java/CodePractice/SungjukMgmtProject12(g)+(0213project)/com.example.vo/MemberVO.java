package com.example.vo;

//VO�� ���� ���� ������ �Ѵ�.
//���� �����͸� ���� �ִ� ��ü
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
