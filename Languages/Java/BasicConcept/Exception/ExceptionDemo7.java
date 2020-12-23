//try catch ������� ���� �� = throws

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class ExceptionDemo3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Oracle Driver Installation
//		Class.forName("OracleDriver") //�̷��� �ص� �ǰ�(��� ���� import oracle.jdbc.driver.OracleDriver) ����� �ǰ�
		Class.forName("oracle.jdbc.driver.OracleDriver"); //�̷��� �ϸ� ������ exceptionó�� ����ߵǴµ� �׷��� ������ throws~ 
		
		//2. DB Connection
		String url = "jdbc:oracle:thin:@localhost:1521/ORCL"; 
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
		
		//3. Statement ��ü ����
		Statement stmt = conn.createStatement(); //���⼭ ���� �� �ߴ� ������ ������ SQLException������. 
		
		//4. Query �� ���� �� �����ϱ�
		String sql = "SELECT COUNT(*) FROM emp";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		System.out.println("������ : " + rs.getInt(1));
		conn.close(); //throws�� ������ ���⼭ ������ �� ����. ������ �����׷��� �� ���� �ֱ⿡ ��Ȯ�� ������ �𸥴�.

	} 
}




