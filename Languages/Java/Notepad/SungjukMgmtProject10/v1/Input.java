import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Input {
	private Scanner scan;
	private Connection conn;
	private Calc calc;
	
	public Input() {
		this.scan = new Scanner(System.in);
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver Founded");
		} catch (ClassNotFoundException e) {
				System.out.println("Class Not Found");
				e.printStackTrace();
		}
		
//		String url = "jdbc:mysql://localhost:3306:practice"; //practice 데이터베이스
		String url = "jdbc:mysql://localhost/practice?useSSL=FALSE"; //practice 데이터베이스
		
		try {
				this.conn = DriverManager.getConnection(url, "root", "admin");
				System.out.println("연결 성공");
		} catch (SQLException e) {
				System.out.println("연결 실패");
				e.printStackTrace();
		}
		
			this.calc = new Calc();			
		
	}
	
	public void input() {
		
		String y_n = null;
		Statement stmt = null;
		
		try {
					stmt = this.conn.createStatement();
			do {
					System.out.println("hakbun?"); 
					String hakbun = this.scan.next();
					
					System.out.println("name?");
					String name = this.scan.next();
					
					System.out.println("kor?");
					int kor = this.scan.nextInt();
					
					System.out.println("eng?");
					int eng = this.scan.nextInt();
					
					System.out.println("mat?");
					int mat = this.scan.nextInt();
					
					Student stu = new Student(hakbun, name, kor, eng, mat);
					
					this.calc.calc(stu);			
					
					String sql = "INSERT INTO practice.sungjuk(hakbun, name, kor, eng, mat, tot, avg, grade) VALUES('" + hakbun + "', '" + name + "', " + kor + ", " + eng + ", " + mat + 
							", " + stu.getTot() + ", " +  stu.getAvg() +  ", '" + stu.getGrade() + "');";
					System.out.println(sql);
					
					int row = stmt.executeUpdate(sql);
					
					if(row==1) {
						System.out.println("Insert Success");
					}
					
					System.out.println("Again(y/n) ? ");
					y_n = this.scan.next();
					
				}while(y_n.toUpperCase().equals("Y"));
					if(stmt!=null) {
						stmt.close();
					}
					if(conn!=null) {
						conn.close();
					}
					
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}
	
}
