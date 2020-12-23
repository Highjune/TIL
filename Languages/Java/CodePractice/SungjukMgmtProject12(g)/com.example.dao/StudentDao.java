package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.view.Student;     //q) 그런데 디펄트 패키지를 IMPORT할수는 없나

//하나로 다 만들기. 그럴수밖에 없음.
//DB와 연동하는 주체.

public class StudentDao { 
	//new 안 쓰기 위해서 static
	
	public static Student select(String hakbun) throws SQLException{ //예외를 다 던짐 - service쪽에서 처리하도록.
		Student s = null;
		Connection conn = DBConnection.getConnection("mariadb.properties"); //3.
		String sql = "SELECT * FROM project.Student WHERE hakbun = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql); //4.
		pstmt.setString(1, hakbun);
		ResultSet rs = pstmt.executeQuery(); //5.
		if(rs.next()) { //학생이 있다면 (없을수도 있으니 조건문으로)
			//primary key(hakbun)으로 검색했기에 무조건 1명만 나올 것이다. 그래서 next()는 무한루프가 아니라 1번만.
			s = new Student(rs.getString("hakbun"), rs.getString("name"),
						rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"));	
			s.setTot(rs.getInt("tot"));
			s.setAvg(rs.getDouble("avg"));
			s.setGrade(rs.getString("grade").charAt(0)); //String을 char로 바꿈(Database에서 들고올 때는 문자열, 즉 string이므로 char로 바꿔줘야 된다)	 
		}
		DBClose.close(conn, pstmt, rs); //7. select이므로 3개 다 닫아야 됨
		return s;
		//		}else { //찾는 학생이 없는 경우임. 그런데 위에서 Student s = null; 있어서 안 써도 됨. 왜냐하면 어차피 학생이 없다면 null이므로
	}
	
	public static int insert(Student s) throws SQLException{ //파라미터는 계산까지 끝난 Student
		Connection conn = DBConnection.getConnection("mariadb.properties"); //3
		//이렇게 문장을 만드는 처음에만 문법검사, 개체검사를 하면 된다. 값만 바꿔주면 됨.(preparedstatment)
		String sql = "INSERT INTO project.Student(hakbun, name, kor, eng, mat"
				+ ", tot, avg, grade) VALUES(?,?,?,?,?,?,?,?)"; //preparedstatement를 위한. ?~. 좋은 점 : '"" 뭐 이런 거 안 써도 된다.?만 넣으면 되니까
		PreparedStatement pstmt = conn.prepareStatement(sql); //4. 이 떄 이미 ?가 들어있는 sql문이 작성되어 있어야 한다.
		//?에 값들을 넣어야 하니까 다 set
		pstmt.setString(1, s.getHakbun()); //JDBC에서만 index가 1부터 시작
		pstmt.setString(2, s.getName());   
		pstmt.setInt(3, s.getKor());   
		pstmt.setInt(4, s.getEng());   
		pstmt.setInt(5, s.getMat());   
		pstmt.setInt(6, s.getTot());   
		pstmt.setDouble(7, s.getAvg());   
		pstmt.setString(8, String.valueOf(s.getGrade()));
		int row = pstmt.executeUpdate(); //5. insert의 성공여부를 말해주는 row의 갯수. row가 1개면 성공
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




