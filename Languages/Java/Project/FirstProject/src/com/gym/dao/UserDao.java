package com.gym.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.DBClose;
import com.gym.dao.DBConnection;
import com.gym.vo.GymVO;
import com.gym.vo.GymVO;

import oracle.jdbc.OracleTypes;

//내 신체정보 조회, 내 정보조회, 유저몸무게감량률 순위, 유저 출석률 순위


public class UserDao {
	//내 정보조회 user_selectall_sp
	public GymVO userSelectAll(int userid) throws SQLException{
		GymVO gym = null;
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{  call user_selectall_sp(?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1,userid);
		cstmt.registerOutParameter(2, OracleTypes.CURSOR);
		cstmt.execute();   
		ResultSet rs = (ResultSet)cstmt.getObject(2);
		
		if(rs.next()) {  	
			gym = new GymVO();
            gym.setName(rs.getString("name")); 
            gym.setGender(rs.getString("gender"));
            gym.setAge(rs.getInt("age"));
            gym.setPhone( rs.getString("phone")); 
            gym.setHeight(rs.getDouble("height")); 
            gym.setWeight(rs.getDouble("weight"));
            gym.setPeriod(rs.getString("period"));
            gym.setGoal(rs.getDouble("goal"));
            gym.setRate(rs.getString("rate")); 	
		}
		DBClose.close(conn, cstmt, rs);
		return gym;
	}


	//내 신체정보 조회 user_ranktchul_sp
	public List<GymVO> userSelectPhysic(int userid) throws SQLException{
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{    call USER_BODY_SELECT_SP(?,?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4. 
		cstmt.setInt(1,userid);
		cstmt.registerOutParameter(2, OracleTypes.CURSOR);
		cstmt.execute();  
		ResultSet rs = (ResultSet)cstmt.getObject(2);
		List<GymVO> list =new ArrayList<GymVO>();
		while(rs.next()) {
			GymVO gym = new GymVO();
			gym.setCheckday(rs.getString("checkday"));
			gym.setCweight(rs.getDouble("cweight"));
			gym.setReduce(rs.getDouble("reduce"));
			gym.setBmi(rs.getDouble("bmi"));
			list.add(gym);
//			(rs.getString("checkday"),
//                    rs.getDouble("cweight"), rs.getDouble("reduce"), rs.getDouble("bmi"));
//			list.add(gym);
		}		
		DBClose.close(conn, cstmt, rs);   //7.
		return list;
	}

		
	//유저출석률 순위

	public List<GymVO> rankVisit() throws SQLException{
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{    call user_ranktchul_sp(?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4. 	
		cstmt.registerOutParameter(1, OracleTypes.CURSOR);
		cstmt.execute();  
		ResultSet rs = (ResultSet)cstmt.getObject(1);
		List<GymVO> list =new ArrayList<GymVO>();
		while(rs.next()) {
			GymVO gym = new GymVO();
			gym.setNum(rs.getInt("num"));
			gym.setName(rs.getString("name"));
			gym.setTchul(rs.getInt("tchul"));
			gym.setGap(rs.getString("gap"));
			list.add(gym);
		}		
		DBClose.close(conn, cstmt, rs);   //7.
		return list;
	}

	


	
	
	//유저 감량률 순위
	
	
	
}	