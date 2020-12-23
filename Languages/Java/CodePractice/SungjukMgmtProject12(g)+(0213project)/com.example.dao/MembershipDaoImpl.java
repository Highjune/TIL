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

	//-1:ID없음., 0:ID는 있으나 비밀번호 불일치, 1:ID도 있고, 비밀번호도 일치 	
	
	@Override
	public int login(String userid, String passwd) throws SQLException {
		Connection conn = DBConnection.getConnection("config/oracle.properties"); //3.
		String sql = "{ call member_login_sp(?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4.
		cstmt.setString(1, userid);
		cstmt.registerOutParameter(2, OracleTypes.CURSOR); //CURSOR는 오라클만 쓰기 때문에 JDBC가 갖고 있는 TYPE이 없다. 그래서 ORACLE LIBRARY 안에 있는 type. 그래서 어떤 관점에서 보면 오라클을 위한 로그인이라고 할 수 있다.
		cstmt.execute();      //매우 중요.   5.
		ResultSet rs = (ResultSet)cstmt.getObject(2);
		int number = -2;
		if(!rs.next()) {  //그런 아이디가 아예 존재하지도 않는다. next가 안된다는 말은 그런 데이터가 아예 존재하지 않는다는 말.
			number = -1;
		}else {   //아이디에 맞는 passwd가져왔을 경우. 조건에 맞는 레코드가 딱 1개.
			String dbPwd = rs.getString("passwd").trim(); //db에서 갖고 온 passwrd. trim()은 passwd에 공백을 넣거나 하는 사람들 있으니 혹시 몰라서 양쪽 whitespace(공백)다 짜름
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
