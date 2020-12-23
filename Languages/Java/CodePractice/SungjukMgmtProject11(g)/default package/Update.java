import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.example.libs.DBClose;
import com.example.libs.DBConnection;

public class Update {
	private Connection conn;
	private Scanner scan;
	public Update(Scanner scan) { //�Ź� scanner�� ������ ���� �̷��� ���ο��� ���� scan�� �Ѱܹ޾Ƽ� ��� ���� ��!
		this.scan = scan;
		this.conn = DBConnection.getConnection("mariadb.properties");  //3.
	}
	public void update(Student s) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();   //4.
			System.out.println("�й� : " + s.getHakbun() + "(" + s.getName() + ")");
			
			System.out.print("���� : " + s.getKor());
			System.out.print("������ ���� ���� : " );
			int kor = this.scan.nextInt();
			s.setKor(kor);
			
			System.out.print("���� : " + s.getEng());
			System.out.print("������ ���� ���� : " );
			int eng = this.scan.nextInt();
			s.setEng(eng);
			
			System.out.print("���� : " + s.getMat());
			System.out.print("������ ���� ���� : " );
			int mat = this.scan.nextInt();
			s.setMat(mat);
			
			Calc calc = new Calc();
			calc.calc(s);
			
			//�Ʒ�ó�� sql���� ������ �ϱ� �Ǵٸ� stored procedure����ϸ� ��. (�̸� ����صδ� ���̱⿡ ���ϰ� �ڵ幮�� ��������� �ʰ�) 
			String sql = "UPDATE project.Student SET kor = " + kor + ", " + 
			                 "eng = " + eng + ", mat = " + mat + ", " + 
					         "tot = " + s.getTot() + ", avg = " + s.getAvg() + ", " +
			                 "grade = '" + String.valueOf(s.getGrade()) + "' " +  //getGrade()�� char�̹Ƿ� String���� �ٲ���� �ȴ�.
			                 "  WHERE hakbun = '" + s.getHakbun() + "' ";
			int row = stmt.executeUpdate(sql);
			if(row == 1) System.out.println("Update Success.");
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			DBClose.close(conn, stmt);//6.
		}
	}
}
