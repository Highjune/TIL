//import java.util.Scanner;
//import java.io.*;
import java.sql.*; //1. import

public class ExceptionDemo1 {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("읽고 싶은 파일 경로 : ");
//		String path = scan.next();
//		try {
//			FileReader fr = new FileReader(path); //FileReader는 checked exception이다. try catch 안 쓰면 에러 뜬다.
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			System.out.println("못 찾겠습니다. File의 경로를 다시 확인해 주세요.");	
//		}  //runtime 오류가 아니다. 


		//2. Driver installation
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Install Success.");
		}catch(ClassNotFoundException e) {
			System.out.println("driver Not Found");
		}
		//3. DB Connection
		Connection conn = null;		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "scott", "tiger"); //DB마다 다 다르다. cf) localhost는 나를 지칭하는 대명사 아이피
			System.out.println("Connection Success");
		} catch (SQLException e) {
			System.out.println("Connection Failure");
		} 
		
		//4. Statement 객체 생성 (SQL문을 돌리기 위한)
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Error");
		}
		
		
		//5. Query를 실행한다.
		
		ResultSet rs = null;
		String sql = "SELECT TO_CHAR(sysdate, 'YYYY-MM-DD') FROM dual";
		try {
			rs = stmt.executeQuery(sql);
			rs.next(); // 커서를 내려야 다음 레코드를 읽으니까!
			System.out.println(rs.getString(1)); //JDBC만 인덱스가 1부터 시작.
		} catch (SQLException e) {
			System.out.println("SQL 구문 Error");
		}
		
		//6. Close
		try {
			conn.close();
			System.out.println("Close Success");
		} catch (SQLException e) {
			System.out.println("Close Failure");
		}			
	}
}

///위의 과정들 다시 재정리한 것 참고해서 넣기.
//그런데 한번에 다 정리하면 안 좋은 점 : exception을 한번에 다 묶으면 정확히 어디서 예외가 발생했는지 잘 모르기 때문에.









