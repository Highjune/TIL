package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.vo.MemberVO;

import oracle.jdbc.OracleTypes;

public class MembershipDaoImpl implements MembershipDao {

	@Override
	public int register(MemberVO member) throws SQLException {
		Connection conn = DBConnection.getConnection("config/oracle.properties"); //3
		String sql = "{   call  member_insert_sp(?, ?)   }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4. 
		cstmt.setString(1, member.getUserid());
		cstmt.setString(2, member.getPasswd());
		int row = cstmt.executeUpdate();
		DBClose.close(conn, cstmt);  //6.
		return row;
	}

	//-1:ID����., 0:ID�� ������ ��й�ȣ ����ġ, 1:ID�� �ְ�, ��й�ȣ�� ��ġ 	
	
	@Override
	public int login(String userid, String passwd) throws SQLException {
		Connection conn = DBConnection.getConnection("config/oracle.properties"); //3.
		String sql = "{ call member_login_sp(?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4.
		cstmt.setString(1, userid);
		cstmt.registerOutParameter(2, OracleTypes.CURSOR); //CURSOR�� ����Ŭ�� ���� ������ JDBC�� ���� �ִ� TYPE�� ����. �׷��� ORACLE LIBRARY �ȿ� �ִ� type. �׷��� � �������� ���� ����Ŭ�� ���� �α����̶�� �� �� �ִ�.
		cstmt.execute();      //�ſ� �߿�.   5.
		ResultSet rs = (ResultSet)cstmt.getObject(2);
		int number = -2;
		if(!rs.next()) {  //�׷� ���̵� �ƿ� ���������� �ʴ´�. next�� �ȵȴٴ� ���� �׷� �����Ͱ� �ƿ� �������� �ʴ´ٴ� ��.
			number = -1;
		}else {   //���̵� �´� passwd�������� ���. ���ǿ� �´� ���ڵ尡 �� 1��.
			String dbPwd = rs.getString("passwd").trim(); //db���� ���� �� passwrd. trim()�� passwd�� ������ �ְų� �ϴ� ����� ������ Ȥ�� ���� ���� whitespace(����)�� ¥��
			if(dbPwd.equals(passwd))   number = 1;
			else number = 0;
		}
		DBClose.close(conn, cstmt, rs);  //7.
		return number;
	}

	@Override
	public boolean logout(String userid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
