import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//DB�� �ִ� ���� �� ���ͼ� ȭ�鿡 ���(������ �Է��ߴ� ��� �͵� ��)
public class Output {
	private Connection conn;
	
	public Output() {
		try {  //2. step
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
		}
		try {  //3. step
			this.conn = DriverManager.getConnection(
					"jdbc:mariadb://192.168.56.2:3306:world", "root", "javamariadb");
		} catch (SQLException e) {
			System.out.println("Connection Failure.");
		}
	}
	
	public void output() {
		this.printLabel();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = this.conn.createStatement();  //4. 
			String sql = "SELECT * FROM world.Student ORDER BY tot DESC";
			rs = stmt.executeQuery(sql);  //5. 
			while(rs.next()) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", 
						rs.getString("hakbun"), rs.getString("name"),
						rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"),
						rs.getInt("tot"), rs.getDouble("avg"), rs.getString("grade")); //DB���� char, varchar2, varchar2�̵� ���� �ڹٿ����� �� String��.
			}
		}catch (SQLException e) {
			System.out.println("Connection Failure.");
		}finally {
			try {
				if(rs != null) rs.close();   //7. 
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}
	private void printLabel() {
		System.out.println("            <<�ֿ����б� �����������α׷�>>");
		System.out.println("�й�    �̸�    ����    ����    ����   ����   ���    ����");
		System.out.println("------------------------------------------------");
	}
}
