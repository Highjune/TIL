package com.gym.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class MembershipDao {
	
	

	public int login(int userid, String passwd) throws SQLException{
		Connection conn = DBConnection.getConnection("config/oracle.properties"); //3.
	    String sql = "{ call member_login_sp(?, ?)  }";
	    CallableStatement cstmt = conn.prepareCall(sql);  
	    cstmt.setInt(1, userid);
	    cstmt.registerOutParameter(2, OracleTypes.CURSOR);
	    cstmt.execute();    
	    ResultSet rs = (ResultSet)cstmt.getObject(2);
	    int number = -2;
	    if(!rs.next()) {  //�׷� ���̵� �ƿ� ���������� �ʴ´�.
	        number = -1;
	    }else {   //���̵� �´� passwd�������� ���
	        String dbPwd = rs.getString("passwd").trim();
	        if(dbPwd.equals(passwd)) {
	        	number=0;  //�α��μ���    
	        }	        	
	        else number = 1;  // ��й�ȣ Ʋ���� 1       	           	
	    }
	    DBClose.close(conn, cstmt, rs);  //7.
		
		return number;
	}
	 public boolean logout(String userid) throws SQLException {
	        
	        return false;
	    }

	
}

