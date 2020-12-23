import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Update {
	Connection conn;
	Scanner scan;
	
	public Update(Scanner scan) {
		this.scan = scan;
		this.conn = DBConnection.getConnection("mysql.properties");
	}
	
	public void update(Student s) {
		Statement stmt = null;
		
		try {
				stmt = this.conn.createStatement();
				System.out.println("학번 : " + s.getHakbun() + "(" + s.getName() + ")");
				
				System.out.print("국어 : " + s.getKor());
				System.out.print("  수정할 국어 점수 : ");
				int kor = this.scan.nextInt();
				s.setKor(kor);
				
				System.out.print("영어 : " + s.getEng());
				System.out.print("  수정할 영어 점수 : ");
				int eng = this.scan.nextInt();
				s.setEng(eng);
				
				System.out.print("수학 : " + s.getMat());
				System.out.print("  수정할 수학 점수 : ");
				int mat = this.scan.nextInt();
				s.setMat(mat);
				
				Calc calc = new Calc();
				calc.calc(s);
				
				String sql = "UPDATE practice.sungjukmgmt SET kor = " + kor + ", " + "eng = " + eng + ", " + "mat = " + mat + ", " + "tot = " + s.getTot() + ", avg = " + s.getAvg() + ", grade = '" + String.valueOf(s.getGrade()) +  "' " +
						" WHERE hakbun = '" + s.getHakbun() + "';";
				System.out.println(sql);
				int row = stmt.executeUpdate(sql);
				if(row==1) System.out.println("update Success.");
		
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt);
		}
		
	}
}
