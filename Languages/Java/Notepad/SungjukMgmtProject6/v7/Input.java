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
			System.out.println("yout hakbun ?");
			String hakbun = scan.next();
			
			System.out.println("your name ? ");
			String name = scan.next();
			
			System.out.println("your kor's score ?");
			int kor = scan.nextInt();
			
			System.out.println("your eng's score ?");
			int eng = scan.nextInt();
			
			System.out.println("your mat's score ?");
			int mat = scan.nextInt();
			
			Student sss = new Student(hakbun, name, kor, eng, mat);
			this.vector.add(sss);
			
			System.out.println("Again?(Y/N?)");
			y_n = scan.next();
					
		}while(y_n.toUpperCase().equals("Y"));
		
	}
	
}





