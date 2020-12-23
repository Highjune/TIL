package com.example.service;

import com.example.vo.MemberVO;

public interface MembershipService {
	int register(MemberVO member);
	int login(String userid, String passwd);
	boolean logout(String userid);
}
