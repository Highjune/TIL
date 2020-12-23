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
	//�Ʒ��� �ڵ�� ���߿� �Խ��� ���鶧���� ����Ѵ�. 
	//DB�� �����ϴ� ���� ������ �� CRRUD
	
	@Override
	public int insertStudent(StudentVO student) throws SQLException{
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{ call student_insert_sp(?,?,?,?,?,?) }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4.
		//�Ʒ��� �Ķ������ �ش��ϴ� �͵��� �̸� ���� stored procedure�� �Ķ���� ������ �°�.
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
		//cursor�Ⱦ��� �ϴ� ���(���ŷο�)
		/*
		StudentVO student = null;
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{  call student_select_sp(?, ?, ?, ?, ?, ?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, hakbun); 
		cstmt.registerOutParameter(2, Types.CHAR); //�й� 
		cstmt.registerOutParameter(3, Types.VARCHAR); //�̸�
		cstmt.registerOutParameter(4, Types.NUMERIC); //���� 
		cstmt.registerOutParameter(5, Types.NUMERIC); //���� 
		cstmt.registerOutParameter(6, Types.NUMERIC); //���� 
		cstmt.registerOutParameter(7, Types.NUMERIC); //���� 
		cstmt.execute();
		StudentVO student = new StudentVO(cstmt.getString(2), cstmt.getString(3),
				cstmt.getInt(4), cstmt.getInt(5), cstmt.getInt(6), cstmt.getInt(7));
		DBClose.close(conn, cstmt, rs);
		return student;
		*/
		
		
		//Ŀ�� ���1
		StudentVO student = null;
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
		String sql = "{  call student_select_sp(?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, hakbun); //���� ��(primary key)
		//�Ʒ��� cursor�� ����Ŭ�� ���� ������ oracleTypes��� �ϴ� ����Ŭ ojdbc.jar���� ���;� �ȴ�.(���� import)
		cstmt.registerOutParameter(2, OracleTypes.CURSOR); //������ ���� ������ registerOutParameter
		cstmt.execute();   //�ſ� �߿���.(select������ execute��. executeQuery�ƴ�)
		ResultSet rs = (ResultSet)cstmt.getObject(2);//����Ŭ�� cursor��� Ÿ���� ������ �ڹٴ� Ŀ����� Ÿ���� ��� getobject�� �޴´�.
		if(rs.next()) {  //ã���� �ϴ� �л��� �߰ߵ��� ����
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
		cstmt.registerOutParameter(1, OracleTypes.CURSOR); // ������ ���� registerOutParameter
		cstmt.execute();   //�ſ� �߿���.   5.
		ResultSet rs = (ResultSet)cstmt.getObject(1); //�ڹٴ� cursor���� ���� ������ object�� �޾ƾ� �Ѵ�. object�� �ް� ���� resultset���� ����ȯ. .(��)�� �ֿ켱 �������̹Ƿ� ���׿������� (RsultSet)���� ������ �� ����.
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
		cstmt.setInt(1, student.getKor());   //����
		cstmt.setInt(2, student.getEng());   //����
		cstmt.setInt(3, student.getMat());   //����
		cstmt.setInt(4, student.getEdp());   //����
		cstmt.setString(5, student.getHakbun());   //�й�
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
