package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.view.Student;     //q) �׷��� ����Ʈ ��Ű���� IMPORT�Ҽ��� ����

//�ϳ��� �� �����. �׷����ۿ� ����.
//DB�� �����ϴ� ��ü.

public class StudentDao { 
	//new �� ���� ���ؼ� static
	
	public static Student select(String hakbun) throws SQLException{ //���ܸ� �� ���� - service�ʿ��� ó���ϵ���.
		Student s = null;
		Connection conn = DBConnection.getConnection("mariadb.properties"); //3.
		String sql = "SELECT * FROM project.Student WHERE hakbun = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql); //4.
		pstmt.setString(1, hakbun);
		ResultSet rs = pstmt.executeQuery(); //5.
		if(rs.next()) { //�л��� �ִٸ� (�������� ������ ���ǹ�����)
			//primary key(hakbun)���� �˻��߱⿡ ������ 1�� ���� ���̴�. �׷��� next()�� ���ѷ����� �ƴ϶� 1����.
			s = new Student(rs.getString("hakbun"), rs.getString("name"),
						rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"));	
			s.setTot(rs.getInt("tot"));
			s.setAvg(rs.getDouble("avg"));
			s.setGrade(rs.getString("grade").charAt(0)); //String�� char�� �ٲ�(Database���� ���� ���� ���ڿ�, �� string�̹Ƿ� char�� �ٲ���� �ȴ�)	 
		}
		DBClose.close(conn, pstmt, rs); //7. select�̹Ƿ� 3�� �� �ݾƾ� ��
		return s;
		//		}else { //ã�� �л��� ���� �����. �׷��� ������ Student s = null; �־ �� �ᵵ ��. �ֳ��ϸ� ������ �л��� ���ٸ� null�̹Ƿ�
	}
	
	public static int insert(Student s) throws SQLException{ //�Ķ���ʹ� ������ ���� Student
		Connection conn = DBConnection.getConnection("mariadb.properties"); //3
		//�̷��� ������ ����� ó������ �����˻�, ��ü�˻縦 �ϸ� �ȴ�. ���� �ٲ��ָ� ��.(preparedstatment)
		String sql = "INSERT INTO project.Student(hakbun, name, kor, eng, mat"
				+ ", tot, avg, grade) VALUES(?,?,?,?,?,?,?,?)"; //preparedstatement�� ����. ?~. ���� �� : '"" �� �̷� �� �� �ᵵ �ȴ�.?�� ������ �Ǵϱ�
		PreparedStatement pstmt = conn.prepareStatement(sql); //4. �� �� �̹� ?�� ����ִ� sql���� �ۼ��Ǿ� �־�� �Ѵ�.
		//?�� ������ �־�� �ϴϱ� �� set
		pstmt.setString(1, s.getHakbun()); //JDBC������ index�� 1���� ����
		pstmt.setString(2, s.getName());   
		pstmt.setInt(3, s.getKor());   
		pstmt.setInt(4, s.getEng());   
		pstmt.setInt(5, s.getMat());   
		pstmt.setInt(6, s.getTot());   
		pstmt.setDouble(7, s.getAvg());   
		pstmt.setString(8, String.valueOf(s.getGrade()));
		int row = pstmt.executeUpdate(); //5. insert�� �������θ� �����ִ� row�� ����. row�� 1���� ����
		DBClose.close(conn, pstmt);  //6.
		return row;	
	}	
	
	public static ArrayList<Student> selectAll() throws SQLException{
		Connection conn = DBConnection.getConnection("mariadb.properties"); //3
		ArrayList<Student> list = new ArrayList<Student>();
		Statement stmt = conn.createStatement(); //4.
		String sql = "SELECT * FROM project.Student ORDER BY tot DESC";
		ResultSet rs = stmt.executeQuery(sql); //5.
		while(rs.next()) {//6.
			Student s = new Student(rs.getString("hakbun"), rs.getString("name"), 
					rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"));
			s.setTot(rs.getInt("tot"));
			s.setAvg(rs.getDouble("avg"));
			s.setGrade(rs.getString("grade").charAt(0));
			list.add(s);
		}
		DBClose.close(conn, stmt, rs);  //7.
		return list;
	}
	
}




