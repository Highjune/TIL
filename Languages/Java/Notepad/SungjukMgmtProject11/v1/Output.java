import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Output {
	private Connection conn;
	public Output() {
		this.conn = DBConnection.getConnection("mysql.properties");
	}
	
	
	public void output1() { //DB에 있는 것 백업하는 output1s
		ObjectOutputStream oos = null;
		ArrayList<Student> list = null;
		Statement stmt = null;
		ResultSet rs = null;	
		
		try {
		list = new ArrayList<Student>();
		oos = new ObjectOutputStream(new FileOutputStream(new File("C:/temp/sungjukmgmt10.ser")));
		stmt = this.conn.createStatement();
		String sql = "SELECT * FROM practice.sungjukmgmt;";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Student s = new Student(rs.getString("hakbun"), rs.getString("name"), rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"));
			s.setTot(rs.getInt("tot"));
			s.setAvg(rs.getDouble("avg"));
			s.setGrade(rs.getString("grade").charAt(0));
			list.add(s);
		}
		oos.writeObject(list);
		System.out.println("File save Success");
		}catch(IOException e) {
			System.out.println(e);
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt, rs);
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public void output() { //DB에 있는 것 화면출력 output
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
				stmt = this.conn.createStatement();
				String sql = "SELECT * FROM practice.sungjukmgmt ORDER BY tot DESC";
				
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t\n",
							rs.getString("hakbun"), rs.getString("name"), rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"), 
							rs.getInt("tot"), rs.getDouble("avg"), rs.getString("grade")
							);
				}
				
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt, rs);
		}
		
		
	}
	
}
