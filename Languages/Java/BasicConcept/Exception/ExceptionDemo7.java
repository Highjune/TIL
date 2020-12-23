//try catch 대용으로 쓰는 것 = throws

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class ExceptionDemo3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Oracle Driver Installation
//		Class.forName("OracleDriver") //이렇게 해도 되고(대신 위에 import oracle.jdbc.driver.OracleDriver) 해줘야 되고
		Class.forName("oracle.jdbc.driver.OracleDriver"); //이렇게 하면 단점은 exception처리 해줘야되는데 그래서 위에서 throws~ 
		
		//2. DB Connection
		String url = "jdbc:oracle:thin:@localhost:1521/ORCL"; 
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
		
		//3. Statement 객체 생성
		Statement stmt = conn.createStatement(); //여기서 에러 안 뜨는 이유는 위에서 SQLException던졌음. 
		
		//4. Query 문 생성 후 실행하기
		String sql = "SELECT COUNT(*) FROM emp";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		System.out.println("사원명수 : " + rs.getInt(1));
		conn.close(); //throws를 썼으니 여기서 에러가 안 난다. 단점은 뭉퉁그려서 다 갖고 있기에 정확한 에러를 모른다.

	} 
}




