import java.util.Scanner;

public class Input {
		
	public Student input(Student s) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�й��� �Է��ϼ��� : ");
		s.hakbun = scan.next();
		
		System.out.println("�̸��� �Է��ϼ��� : ");
		s.name = scan.next();
		
		System.out.println("���������� �Է��ϼ��� : ");
		s.kor = scan.nextInt();
		
		System.out.println("���������� �Է��ϼ��� : ");
		s.eng = scan.nextInt();
		
		System.out.println("���������� �Է��ϼ��� : ");
		s.mat = scan.nextInt();
		
		return s;
	}
	
	
}
