import java.util.Scanner;
import java.util.Vector;

public class Input {
	public Vector<Student> vector;
	public Scanner scan;
	
	Input(Vector<Student> vector) {
		this.vector = vector;		
		this.scan = new Scanner(System.in);
	}
	
	void input() {
		String y_n = null;
		do {
			System.out.println("학번 : ");
			String hakbun = scan.next();		
			
			System.out.println("이름 : ");
			String name = scan.next();
			
			System.out.println("국어 : ");
			int kor = scan.nextInt();
			
			System.out.println("영어 : ");
			int eng = scan.nextInt();
			
			System.out.println("수학 : ");
			int mat = scan.nextInt();
			Student s = new Student(hakbun, name, kor, eng, mat);
			this.vector.add(s);
			
			System.out.println("더 입력하시겠습니까?(Y/N)");
			y_n = scan.next();
			
		}while(y_n.toUpperCase().equals("Y"));
		
	}
	
}
