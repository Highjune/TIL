import java.util.Scanner;
import java.util.Vector;

public class Input {
	private Scanner scan;
	private Vector<Student> vector;
	
	public Input(Vector<Student> vector) {
		this.scan = new Scanner(System.in);
		this.vector = vector; 
	}
	
	public void input() {
		String y_n = null;
		
		do {
			System.out.println("<<" + (this.vector.size() + 1) + "번째 학생 입력>>");
			
			System.out.println("hakbun"); 
			String hakbun = this.scan.next();
			
			System.out.println("name");
			String name = this.scan.next();
			
			System.out.println("kor");
			int kor = this.scan.nextInt();
			
			System.out.println("eng");
			int eng = this.scan.nextInt();
			
			System.out.println("mat");
			int mat = this.scan.nextInt();
			
			Student stu = new Student(hakbun, name, kor, eng, mat);
			this.vector.add(stu);
			
			System.out.println("Again?(y/n)");
			y_n = this.scan.next();
					
		}while(y_n.toUpperCase().equals("Y"));
		
	}
}
