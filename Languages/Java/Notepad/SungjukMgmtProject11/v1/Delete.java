import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Delete {
	Connection conn;
	
	public Delete() {
		this.conn = DBConnection.getConnection("mysql.properties");
	}
	
	public void delete(Student s) {
		Statement stmt = null;
		
		try {
			stmt = this.conn.createStatement();
			String sql = "DELETE FROM practice.sungjukmgmt WHERE hakbun = '" + s.getHakbun() + "';";
			int row = stmt.executeUpdate(sql);
			if(row==1) 
				System.out.println("Delete Success");

		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt);
		}
	}
}
