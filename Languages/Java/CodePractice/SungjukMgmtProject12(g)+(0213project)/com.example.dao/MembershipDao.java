package com.example.dao;

import java.sql.SQLException;

import com.example.vo.MemberVO;

public interface MembershipDao {
	int register(MemberVO member) throws SQLException;
	int login(String userid, String passwd) throws SQLException; //-1 0 1�� ����
	boolean logout(String userid) throws SQLException; // Ư�� ������ �����ϴ°��̴ϱ� �Ķ���ʹ� id
}
