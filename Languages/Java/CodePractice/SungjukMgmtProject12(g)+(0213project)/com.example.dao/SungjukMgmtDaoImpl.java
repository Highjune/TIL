package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.vo.StudentVO;

import oracle.jdbc.OracleTypes;

public class SungjukMgmtDaoImpl implements SungjukMgmtDao {
	//아래의 코드는 나중에 게시판 만들때에도 사용한다. 
	//DB를 연동하는 것은 무조건 다 CRRUD
	
	@Override
	public int insertStudent(StudentVO student) throws SQLException{
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{ call student_insert_sp(?,?,?,?,?,?) }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4.
		//아래의 파라미터중 해당하는 것들은 미리 만든 stored procedure의 파라미터 순서에 맞게.
		cstmt.setString(1, student.getHakbun());
		cstmt.setString(2, student.getName());
		cstmt.setInt(3, student.getKor());
		cstmt.setInt(4, student.getEng());
		cstmt.setInt(5, student.getMat());
		cstmt.setInt(6, student.getEdp());
		int row = cstmt.executeUpdate();
		DBClose.close(conn, cstmt);
		return row;
	}

	@Override
	public StudentVO selectStudent(String hakbun) throws SQLException{
		//cursor안쓰고 하는 방법(번거로움)
		/*
		StudentVO student = null;
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{  call student_select_sp(?, ?, ?, ?, ?, ?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, hakbun); 
		cstmt.registerOutParameter(2, Types.CHAR); //학번 
		cstmt.registerOutParameter(3, Types.VARCHAR); //이름
		cstmt.registerOutParameter(4, Types.NUMERIC); //국어 
		cstmt.registerOutParameter(5, Types.NUMERIC); //영어 
		cstmt.registerOutParameter(6, Types.NUMERIC); //수학 
		cstmt.registerOutParameter(7, Types.NUMERIC); //전산 
		cstmt.execute();
		StudentVO student = new StudentVO(cstmt.getString(2), cstmt.getString(3),
				cstmt.getInt(4), cstmt.getInt(5), cstmt.getInt(6), cstmt.getInt(7));
		DBClose.close(conn, cstmt, rs);
		return student;
		*/
		
		
		//커서 사용1
		StudentVO student = null;
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{  call student_select_sp(?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, hakbun); //들어가는 것(primary key)
		//아래의 cursor는 오라클만 쓰기 때문에 oracleTypes라고 하는 오라클 ojdbc.jar에서 들고와야 된다.(위의 import)
		cstmt.registerOutParameter(2, OracleTypes.CURSOR); //나오는 것은 무조건 registerOutParameter
		cstmt.execute();   //매우 중요함.(select이지만 execute임. executeQuery아님)
		ResultSet rs = (ResultSet)cstmt.getObject(2);//오라클은 cursor라는 타입을 쓰지만 자바는 커서라는 타입이 없어서 getobject로 받는다.
		if(rs.next()) {  //찾고자 하는 학생이 발견됐을 때만
			student = new StudentVO(rs.getString("hakbun"), rs.getString("name"),
					 rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"), rs.getInt("edp"));
		}
		DBClose.close(conn, cstmt, rs);
		return student;
	}

	@Override
	public List<StudentVO> selectAllStudent() throws SQLException{
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{    call student_selectall_sp(?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4. 
		cstmt.registerOutParameter(1, OracleTypes.CURSOR); // 나오는 것은 registerOutParameter
		cstmt.execute();   //매우 중요함.   5.
		ResultSet rs = (ResultSet)cstmt.getObject(1); //자바는 cursor형이 없기 때문에 object로 받아야 한다. object로 받고 나서 resultset으로 형변환. .(점)이 최우선 연산자이므로 단항연산자인 (RsultSet)보다 순서가 더 빠름.
		List<StudentVO> list = new ArrayList<StudentVO>();
		while(rs.next()) {
			StudentVO student = new StudentVO(rs.getString("hakbun"), 
					rs.getString("name"), rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"),
					rs.getInt("edp"), rs.getInt("tot"), rs.getDouble("avg"), 
					rs.getString("grade"));
			list.add(student);
		}
		DBClose.close(conn, cstmt, rs);   //7.
		return list;
	}

	@Override
	public int updateStudent(StudentVO student)  throws SQLException {
		int row = -1;
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{ call student_update_sp(?, ?, ?, ?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);  //4.
		cstmt.setInt(1, student.getKor());   //국어
		cstmt.setInt(2, student.getEng());   //영어
		cstmt.setInt(3, student.getMat());   //수학
		cstmt.setInt(4, student.getEdp());   //전산
		cstmt.setString(5, student.getHakbun());   //학번
		row = cstmt.executeUpdate();   //5.
		DBClose.close(conn, cstmt);  //6.
		return row;
	}
	
	
	@Override
	public int deleteStudent(String hakbun) throws SQLException {
		int row = -1;
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{ call student_delete_sp(?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);  //4.
		cstmt.setString(1, hakbun);
		row = cstmt.executeUpdate();
		DBClose.close(conn, cstmt);  //6.
		return row;
	}
}
