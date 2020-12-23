package com.example.service;

import java.sql.SQLException;

import com.example.dao.MembershipDao;
import com.example.dao.MembershipDaoImpl;
import com.example.vo.MemberVO;

public class MembershipServiceImpl implements MembershipService {
	private MembershipDao dao;
	
	public MembershipServiceImpl() {
		this.dao = new MembershipDaoImpl();
	}
	
	@Override
	public int register(MemberVO member) {
		int row = -1;
		try {
			row = this.dao.register(member);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}

	@Override
	public int login(String userid, String passwd) {
		int number = -2;
		try {
			number= this.dao.login(userid, passwd);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return number;
	}

	@Override
	public boolean logout(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

}
