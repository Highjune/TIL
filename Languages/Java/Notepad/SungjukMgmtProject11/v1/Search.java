import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Search {
	private Connection conn;

	private Scanner scan;
	
	public Search(Scanner scan) {
		this.conn = DBConnection.getConnection("mysql.properties");
		this.scan = scan; // 메인에서 넘겨주는 scan 재활용
	}
	
	public Student search() { //지역변수는 자동 private. 
		Statement stmt = null;
	    ResultSet rs = null;
		Student s = null;
		
		try {
				stmt = this.conn.createStatement();
				
				System.out.println("원하는 학생의 학번을 입력하세요 : ");
				String hakbun = this.scan.next();		
				String sql = "SELECT * FROM practice.sungjukmgmt WHERE hakbun = '" + hakbun + "';";
				rs = stmt.executeQuery(sql);
				if(rs.next()) { // rs!=null 로 하면 안됨.
					s = new Student(rs.getString("hakbun"), rs.getString("name"), rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"));
				}else {
					System.out.println("입력하신 학번과 일치하는 학생을 찾지 못했습니다. 다시 검색해 주세요");		
				}
				
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt, rs);
		}
			return s;		
	}
}
