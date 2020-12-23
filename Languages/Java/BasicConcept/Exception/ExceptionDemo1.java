//import java.util.Scanner;
//import java.io.*;
import java.sql.*; //1. import

public class ExceptionDemo1 {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("�а� ���� ���� ��� : ");
//		String path = scan.next();
//		try {
//			FileReader fr = new FileReader(path); //FileReader�� checked exception�̴�. try catch �� ���� ���� ���.
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			System.out.println("�� ã�ڽ��ϴ�. File�� ��θ� �ٽ� Ȯ���� �ּ���.");	
//		}  //runtime ������ �ƴϴ�. 


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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "scott", "tiger"); //DB���� �� �ٸ���. cf) localhost�� ���� ��Ī�ϴ� ���� ������
			System.out.println("Connection Success");
		} catch (SQLException e) {
			System.out.println("Connection Failure");
		} 
		
		//4. Statement ��ü ���� (SQL���� ������ ����)
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Error");
		}
		
		
		//5. Query�� �����Ѵ�.
		
		ResultSet rs = null;
		String sql = "SELECT TO_CHAR(sysdate, 'YYYY-MM-DD') FROM dual";
		try {
			rs = stmt.executeQuery(sql);
			rs.next(); // Ŀ���� ������ ���� ���ڵ带 �����ϱ�!
			System.out.println(rs.getString(1)); //JDBC�� �ε����� 1���� ����.
		} catch (SQLException e) {
			System.out.println("SQL ���� Error");
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

///���� ������ �ٽ� �������� �� �����ؼ� �ֱ�.
//�׷��� �ѹ��� �� �����ϸ� �� ���� �� : exception�� �ѹ��� �� ������ ��Ȯ�� ��� ���ܰ� �߻��ߴ��� �� �𸣱� ������.









