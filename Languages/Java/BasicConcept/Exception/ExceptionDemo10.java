import java.sql.*;

public class ExceptionDemo6 {
	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@//localhost:1521/ORCL";

		try (Connection conn = DriverManager.getConnection(url, "scott", "tiger")){
			System.out.println(conn);  //conn�� tostring�� �ҷ���~
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
		
		
		
