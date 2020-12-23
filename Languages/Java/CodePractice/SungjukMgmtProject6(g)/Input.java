import java.util.Scanner;
import java.util.Vector;

public class Input {
	private Scanner scan;
	private Vector<Student> vector;
	
	public Input(Vector<Student> vector) {   //Constructor
		this.scan = new Scanner(System.in);
		this.vector = vector;
	}
	
	public void input() {
		String y_n = null;
		do {
			System.out.print("hakbun : ");  String hakbun = scan.next();
			System.out.print("name : ");  String name = scan.next();
			System.out.print("kor : ");  int kor = scan.nextInt();
			System.out.print("eng : ");  int eng = scan.nextInt();
			System.out.print("mat : ");  int mat = scan.nextInt();
			Student s = new Student(hakbun, name, kor, eng, mat);
			this.vector.add(s);
			System.out.print("Again(y/n) ? : ");     
			y_n = this.scan.next();
		}while(y_n.toUpperCase().equals("Y"));
	}
}
