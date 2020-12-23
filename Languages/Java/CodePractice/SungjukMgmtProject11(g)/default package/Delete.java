import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Delete {
	private Connection conn;
	
	public Delete() {
		this.conn = DBConnection.getConnection("mariadb.properties");  //3. 
	}
	public void delete(Student s) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();   //4.
			String sql = "DELETE FROM project.Student " + 
			                 "WHERE hakbun = '" + s.getHakbun() + "' ";
			int row = stmt.executeUpdate(sql);    //5.
			if(row == 1) System.out.println("Delete Success."); //�����Ǹ� ������ 1���� ������(primary key�� �˻��� ���̴ϱ�)
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt);
		}
	}
}
 