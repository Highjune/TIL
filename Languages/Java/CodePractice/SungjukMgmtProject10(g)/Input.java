import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//1. mport

public class Input {
	private Scanner scan;
	private Connection conn;
	private Calc calc; //학번, 이름, 국어, 영어, 수학을 입력받자마자 바로 insert하면 안되고 총점, 평균, 등급을 구하고(calc)하고 나서 db에 저장해야 되니까 여기에서 계산.
	
	public Input() {   //Constructor
		this.scan = new Scanner(System.in);
		try {
			//2
			Class.forName("org.mariadb.jdbc.Driver"); //이 프로젝트 우클릭 - build path 로 driver추가해줬음.
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
		}
		try { //3
			this.conn = DriverManager.getConnection(
					"jdbc:mariadb://192.168.56.2:3306:world", "root", "javamariadb"); // world : database임(우리가 접근하려고 하는 테이블의 database명). cf) 오라클은 sid를 쓰고, mysql과 mariadb는 database를 쓴다.
		} catch (SQLException e) {
			System.out.println("Connection Failure.");
		}
		this.calc = new Calc();
	}
	
	public void input() {
		String y_n = null;
		Statement stmt = null; //4
		try{
			stmt = this.conn.createStatement();
			do {
				System.out.print("학번 : ");  String hakbun = scan.next();
				System.out.print("이름 : ");  String name = scan.next();
				System.out.print("국어 : ");  int kor = scan.nextInt();
				System.out.print("영어 : ");  int eng = scan.nextInt();
				System.out.print("수학 : ");  int mat = scan.nextInt();
			
				Student s = new Student(hakbun, name, kor, eng, mat);
				this.calc.calc(s); //계산
					
				//calc다녀와서 계산이 끝나있는 상태
				String sql = "INSERT INTO world.Student(" +
			                 "hakbun, name, kor, eng, mat, tot, avg, grade) " +
		                     "VALUES ('" + hakbun + "', '" + name + "', " + kor + ", " +
				             eng + ", " + mat + ", " + s.getTot() + ", " +  //Tot, Avg, Grade는 Calc를 다녀온 후에 setTot, setAvg, setGrade되어있으니 이 값들을 get으로 가져오는 것임.
		                     s.getAvg() + ", '" + s.getGrade() + "')"; //날짜와 문자형은 '' 
				//System.out.println(sql); //이렇게 항상 실행전에 sql문이 제대로 되어있나 확인해봐야된다.
				int row = stmt.executeUpdate(sql); //5
				if(row == 1) System.out.println("Insert Success"); //insert할 때 insert한 레코드의 수(row 갯수)는 1개여야 한다.
				System.out.print("Again(y/n) ? : "); 
				y_n = this.scan.next();
			}while(y_n.toUpperCase().equals("Y"));
			if(stmt != null) stmt.close(); //6 닫기
			if(conn != null) conn.close(); 
		}catch(SQLException ex) {
			System.out.println(ex);
		}
	}
}
