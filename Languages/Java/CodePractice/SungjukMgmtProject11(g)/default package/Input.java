import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Input {
	private Scanner scan;
	private Connection conn;
	private Calc calc;
	
	public Input() {
		this.scan = new Scanner(System.in);
		this.conn = DBConnection.getConnection("mariadb.properties");
		this.calc = new Calc();
	}
	
	public void input() {
		String y_n = null;
		Statement stmt = null;
		try{
			stmt = this.conn.createStatement();  //4. 
			do {
				System.out.print("hakbun : ");  String hakbun = scan.next();
				System.out.print("name : ");  String name = scan.next();
				System.out.print("kor : ");  int kor = scan.nextInt();
				System.out.print("eng : ");  int eng = scan.nextInt();
				System.out.print("mat : ");  int mat = scan.nextInt();
			
				Student s = new Student(hakbun, name, kor, eng, mat);
				this.calc.calc(s);
					
				String sql = "INSERT INTO project.Student(" +
			                 "hakbun, name, kor, eng, mat, tot, avg, grade) " +
		                     "VALUES ('" + hakbun + "', '" + name + "', " + kor + ", " +
				             eng + ", " + mat + ", " + s.getTot() + ", " + 
		                     s.getAvg() + ", '" + s.getGrade() + "')";
				//System.out.println(sql);
				int row = stmt.executeUpdate(sql);
				if(row == 1) System.out.println("Insert Success");
				System.out.print("Again(y/n) ? : "); 
				y_n = this.scan.next(); 
			}while(y_n.toUpperCase().equals("Y"));
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt);
		}
	}
}
