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

public class Output { //query ������ select��. �ҷ��ͼ� ������� �Ǵ� ���̹Ƿ�
	private Connection conn;
	public Output() {
		this.conn = DBConnection.getConnection("mariadb.properties"); //3.
	}
	
	public void output1() {  //����ϴ� output1
		ObjectOutputStream oos = null;
		ArrayList<Student> list = null; //������ ��ü(Student)�� ����ִ� ArrayList
		Statement stmt = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<Student>(); //�� 10������ ����
			oos = new ObjectOutputStream(
					new FileOutputStream(new File("C:/temp/backup.ser")));
			stmt = this.conn.createStatement();   //4.
			String sql = "SELECT * FROM project.Student";
			rs = stmt.executeQuery(sql);            //5.
			while(rs.next()) {
				Student s = new Student(rs.getString("hakbun"), rs.getString("name"),
						rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat")); 
				//���� �����ڷδ� 5���ۿ� �� �����ϱ� �������� �̷��� 
				s.setTot(rs.getInt("tot"));
				s.setAvg(rs.getDouble("avg"));
				s.setGrade(rs.getString("grade").charAt(0));//�����ͺ��̽������� �� ���ڿ��̹Ƿ� �ϴ� getString���� ��� �� �� Grade�� Ÿ���� char�� ��ȯ.
				list.add(s); //select�ؼ� ���� student �����͸� 1�� �� ����
			}
			//���� ���� student ������(select�ؼ� ����)�� �� ����ִ� list 
			oos.writeObject(list); //���Ϸ� ������ ���� ���������� writeObject�̴�.
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
	
	public void output() { //ȭ�鿡 ����ϴ� output
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
