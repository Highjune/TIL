import java.util.Scanner;

public class Input {
		
	public Student input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�й��� �Է��ϼ��� : ");
		String hakbun = scan.next();
		
		System.out.println("�̸��� �Է��ϼ��� : ");
		String name = scan.next();
		
		System.out.println("���������� �Է��ϼ��� : ");
		int kor = scan.nextInt();
		
		System.out.println("���������� �Է��ϼ��� : ");
		int eng = scan.nextInt();
		
		System.out.println("���������� �Է��ϼ��� : ");
		int mat = scan.nextInt();

		Student s = new Student(hakbun, name, kor, eng, mat);
		return s;		
	}	
}
