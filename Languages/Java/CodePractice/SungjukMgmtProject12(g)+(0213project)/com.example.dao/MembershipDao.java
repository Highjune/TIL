package com.example.dao;

import java.sql.SQLException;

import com.example.vo.MemberVO;

public interface MembershipDao {
	int register(MemberVO member) throws SQLException;
	int login(String userid, String passwd) throws SQLException; //-1 0 1을 리턴
	boolean logout(String userid) throws SQLException; // 특정 계정을 리턴하는것이니까 파라미터는 id
}
