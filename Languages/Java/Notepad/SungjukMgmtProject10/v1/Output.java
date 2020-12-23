import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Output {

	private Connection conn;
	
	public Output() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Founded");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost/practice?useSSL=FALSE";
		
		try {
			this.conn = DriverManager.getConnection(url, "root", "admin");
			System.out.println("연결 성공");
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public void output() {
		
		this.printlabel();		
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			stmt = this.conn.createStatement();
			String sql = "SELECT * FROM practice.sungjuk ORDER BY tot DESC";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n",
						rs.getString("hakbun"), rs.getString("name"), rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"), rs.getInt("tot"), rs.getDouble("avg"), rs.getString("grade")
						);
			}
			
			}catch(SQLException e) {
				System.out.println("Output Failure");
			}finally {
				try {
					if(rs!=null) 	rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				}catch(SQLException e) {
					System.out.println(e);
				}
		}
	}
	
	
	private void printlabel() {
		System.out.println("----------------DB에서 꺼내는 것임-----------------");
		System.out.println("학번	이름	국어	영어	수학	총점	평균	등급");
		System.out.println("-----------------------------------------------------");
	}
	
	
}
