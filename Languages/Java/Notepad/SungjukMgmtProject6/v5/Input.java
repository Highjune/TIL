import java.util.Scanner;
import java.util.Vector;

public class Input {
	private Vector<Student> vector;
	private Scanner scan;
	
	public Input(Vector<Student> vector) {
		this.vector = vector;
		this.scan = new Scanner(System.in);
	}
	
	public void input() {
		String y_n = null;
		
		do {
			System.out.println("hakbun ? :");
			String hakbun = scan.next();
			
			System.out.println("name ? : ");
			String name = scan.next();
			
			System.out.println("kor ? : ");
			int kor = scan.nextInt();
			
			System.out.println("eng ? : ");
			int eng = scan.nextInt();
			
			System.out.println("mat ? : ");
			int mat = scan.nextInt();
			
			Student st = new Student(hakbun, name, kor, eng, mat);
			this.vector.add(st);
			
			System.out.println("Again(y/n) ? ");
			y_n = scan.next();		
			
		}while(y_n.toUpperCase().equals("Y"));
	}
}
