import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Output { //query 따지면 select임. 불러와서 보여줘야 되는 것이므로
	private Connection conn;
	public Output() {
		this.conn = DBConnection.getConnection("mariadb.properties"); //3.
	}
	
	public void output1() {  //백업하는 output1
		ObjectOutputStream oos = null;
		ArrayList<Student> list = null; //내보낼 객체(Student)가 들어있는 ArrayList
		Statement stmt = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<Student>(); //방 10개부터 시작
			oos = new ObjectOutputStream(
					new FileOutputStream(new File("C:/temp/backup.ser")));
			stmt = this.conn.createStatement();   //4.
			String sql = "SELECT * FROM project.Student";
			rs = stmt.executeQuery(sql);            //5.
			while(rs.next()) {
				Student s = new Student(rs.getString("hakbun"), rs.getString("name"),
						rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat")); 
				//위의 생성자로는 5개밖에 못 담으니까 나머지는 이렇게 
				s.setTot(rs.getInt("tot"));
				s.setAvg(rs.getDouble("avg"));
				s.setGrade(rs.getString("grade").charAt(0));//데이터베이스에서는 다 문자열이므로 일단 getString으로 들고 온 후 Grade의 타입인 char로 변환.
				list.add(s); //select해서 나온 student 데이터를 1명씩 다 담음
			}
			//여러 명의 student 데이터(select해서 나온)가 다 담겨있는 list 
			oos.writeObject(list); //파일로 내보낼 때의 최종목적은 writeObject이다.
			System.out.println("File Save Success.");
		}catch(IOException ex) {
			System.out.println(ex);
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt, rs);
			if(oos != null)
				try {
					oos.close(); 
				} catch (IOException e) {}
		}
	}
	
	public void output() { //화면에 출력하는 output
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = this.conn.createStatement();   //4.
			String sql = "SELECT * FROM project.Student ORDER BY tot DESC";
			rs = stmt.executeQuery(sql);   //5.
			while(rs.next()) {   //6.
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", 
						rs.getString("hakbun"), rs.getString("name"),
						rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"),
						rs.getInt("tot"), rs.getDouble("avg"), rs.getString("grade"));
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt, rs);   //7. 
		}
	}
}
