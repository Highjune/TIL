import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Update {
	private Connection conn;
	private Scanner scan;
	public Update(Scanner scan) { //매번 scanner를 만드지 말고 이렇게 메인에서 만든 scan을 넘겨받아서 계속 쓰는 것!
		this.scan = scan;
		this.conn = DBConnection.getConnection("mariadb.properties");  //3.
	}
	public void update(Student s) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();   //4.
			System.out.println("학번 : " + s.getHakbun() + "(" + s.getName() + ")");
			
			System.out.print("국어 : " + s.getKor());
			System.out.print("수정할 국어 점수 : " );
			int kor = this.scan.nextInt();
			s.setKor(kor);
			
			System.out.print("영어 : " + s.getEng());
			System.out.print("수정할 영어 점수 : " );
			int eng = this.scan.nextInt();
			s.setEng(eng);
			
			System.out.print("수학 : " + s.getMat());
			System.out.print("수정할 수학 점수 : " );
			int mat = this.scan.nextInt();
			s.setMat(mat);
			
			Calc calc = new Calc();
			calc.calc(s);
			
			//아래처럼 sql문을 일일이 하기 실다면 stored procedure사용하면 됨. (미리 등록해두는 것이기에 편하고 코드문도 노출되지도 않고) 
			String sql = "UPDATE project.Student SET kor = " + kor + ", " + 
			                 "eng = " + eng + ", mat = " + mat + ", " + 
					         "tot = " + s.getTot() + ", avg = " + s.getAvg() + ", " +
			                 "grade = '" + String.valueOf(s.getGrade()) + "' " +  //getGrade()는 char이므로 String으로 바꿔줘야 된다.
			                 "  WHERE hakbun = '" + s.getHakbun() + "' ";
			int row = stmt.executeUpdate(sql);
			if(row == 1) System.out.println("Update Success.");
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt);//6.
		}
	}
}
