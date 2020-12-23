import java.util.Scanner;
import java.util.Vector;

public class Input {
	private Vector<Student> vector;
	private Scanner scan;
	
	public Input(Vector<Student> vector) {
		this.vector = vector;
		scan = new Scanner(System.in);
	}
	
	public void input() {
		String y_n = null;
		
		do {
			
			System.out.println("your hakbun : ");
			String hakbun = scan.next();
			
			System.out.println("your name : ");
			String name = scan.next();
			
			System.out.println("your kor : ");
			int kor = scan.nextInt();
			
			System.out.println("your eng : ");
			int eng = scan.nextInt();
			
			System.out.println("your mat : ");
			int mat = scan.nextInt();
			
			Student stu = new Student(hakbun, name, kor, eng, mat);
			this.vector.add(stu);
			
			System.out.println("Again?(y/n)");
			y_n = scan.next();
			
		}while(y_n.toUpperCase().equals("Y"));
	}
}
