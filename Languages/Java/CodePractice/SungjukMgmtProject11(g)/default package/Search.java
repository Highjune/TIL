import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Search { //1명의 학생을 찾는 것
	private Scanner scan;
	private Connection conn;
	
	//primary key(학번)으로 검색하는 것이니 1명이 나올 것.
	public Search(Scanner scan) { 
		this.scan = scan;
		this.conn = DBConnection.getConnection("mariadb.properties");  //3. 
	}
	
	public Student search() { //찾은 학생을 리턴
		Statement stmt = null; //지역변수 앞에는 private, public 등 못 넣음. 지역변수는 자동 private.
		ResultSet rs = null;
		Student s = null;
		try {
			stmt = this.conn.createStatement();    //4.
			System.out.print("찾으려는 학생의 학번 : ");
			String hakbun = this.scan.next();
			String sql = "SELECT hakbun, name, kor, eng, mat FROM project.Student " +
			                 "WHERE hakbun = '" + hakbun + "' ";
			rs = stmt.executeQuery(sql);   //5.  rs(Resultset)에 SELECT한 값들이 다 담겨있음.
			
			//학생을 찾았을 경우, 찾은 레코드의 줄 (한 줄에 hakbun, name, kor, eng, mat 다 들어있음) 바로 위에 커서가 위치해 있다.
			if(rs.next()) {  //학생을 찾았을 경우  //6.  // (rs!=null) 로 하면 안됨
				s = new Student(rs.getString("hakbun"), rs.getString("name"),
						              rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"));
			}else { //찾지 못했으면 레코드가 없을 것이고 그러면 커서가 next를 할 수 없다. 그러면 null이 넘어갈 것임. 원래 s는 null로 초기화했으니까.(위에서)
				System.out.println("조건에 맞는 학생을 찾지 못했습니다. 확인 후 다시 검색해 주세요.");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(this.conn, stmt, rs);
		}
		return s;
	}
}
