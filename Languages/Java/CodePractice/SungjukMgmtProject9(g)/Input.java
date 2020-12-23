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
			System.out.println("<<" + (this.vector.size() + 1) + "��° �л� �Է�>>"); 
			//size�� ������ ����. ���� 3���� ����Ǿ��ִٸ� size()�� 3�̰�, 4��° ������ ������.
			System.out.print("�й� : ");  String hakbun = scan.next();
			System.out.print("�̸� : ");  String name = scan.next();
			System.out.print("���� : ");  int kor = scan.nextInt();
			System.out.print("���� : ");  int eng = scan.nextInt();
			System.out.print("���� : ");  int mat = scan.nextInt();
			Student s = new Student(hakbun, name, kor, eng, mat);
			this.vector.add(s);
			System.out.print("Again(y/n) ? : ");     
			y_n = this.scan.next();
		}while(y_n.toUpperCase().equals("Y"));
	}
}


