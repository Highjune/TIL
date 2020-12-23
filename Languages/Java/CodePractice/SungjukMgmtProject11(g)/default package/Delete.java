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
			if(row == 1) System.out.println("Delete Success."); //삭제되면 무조건 1개만 삭제됨(primary key로 검색한 것이니까)
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt);
		}
	}
}
 