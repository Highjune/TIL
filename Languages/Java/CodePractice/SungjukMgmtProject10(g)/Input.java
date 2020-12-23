import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//1. mport

public class Input {
	private Scanner scan;
	private Connection conn;
	private Calc calc; //�й�, �̸�, ����, ����, ������ �Է¹��ڸ��� �ٷ� insert�ϸ� �ȵǰ� ����, ���, ����� ���ϰ�(calc)�ϰ� ���� db�� �����ؾ� �Ǵϱ� ���⿡�� ���.
	
	public Input() {   //Constructor
		this.scan = new Scanner(System.in);
		try {
			//2
			Class.forName("org.mariadb.jdbc.Driver"); //�� ������Ʈ ��Ŭ�� - build path �� driver�߰�������.
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
		}
		try { //3
			this.conn = DriverManager.getConnection(
					"jdbc:mariadb://192.168.56.2:3306:world", "root", "javamariadb"); // world : database��(�츮�� �����Ϸ��� �ϴ� ���̺��� database��). cf) ����Ŭ�� sid�� ����, mysql�� mariadb�� database�� ����.
		} catch (SQLException e) {
			System.out.println("Connection Failure.");
		}
		this.calc = new Calc();
	}
	
	public void input() {
		String y_n = null;
		Statement stmt = null; //4
		try{
			stmt = this.conn.createStatement();
			do {
				System.out.print("�й� : ");  String hakbun = scan.next();
				System.out.print("�̸� : ");  String name = scan.next();
				System.out.print("���� : ");  int kor = scan.nextInt();
				System.out.print("���� : ");  int eng = scan.nextInt();
				System.out.print("���� : ");  int mat = scan.nextInt();
			
				Student s = new Student(hakbun, name, kor, eng, mat);
				this.calc.calc(s); //���
					
				//calc�ٳ�ͼ� ����� �����ִ� ����
				String sql = "INSERT INTO world.Student(" +
			                 "hakbun, name, kor, eng, mat, tot, avg, grade) " +
		                     "VALUES ('" + hakbun + "', '" + name + "', " + kor + ", " +
				             eng + ", " + mat + ", " + s.getTot() + ", " +  //Tot, Avg, Grade�� Calc�� �ٳ�� �Ŀ� setTot, setAvg, setGrade�Ǿ������� �� ������ get���� �������� ����.
		                     s.getAvg() + ", '" + s.getGrade() + "')"; //��¥�� �������� '' 
				//System.out.println(sql); //�̷��� �׻� �������� sql���� ����� �Ǿ��ֳ� Ȯ���غ��ߵȴ�.
				int row = stmt.executeUpdate(sql); //5
				if(row == 1) System.out.println("Insert Success"); //insert�� �� insert�� ���ڵ��� ��(row ����)�� 1������ �Ѵ�.
				System.out.print("Again(y/n) ? : "); 
				y_n = this.scan.next();
			}while(y_n.toUpperCase().equals("Y"));
			if(stmt != null) stmt.close(); //6 �ݱ�
			if(conn != null) conn.close(); 
		}catch(SQLException ex) {
			System.out.println(ex);
		}
	}
}
