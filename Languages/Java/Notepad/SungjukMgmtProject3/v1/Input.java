import java.util.Scanner;

public class Input {
		
	public Student input(Student s) {
		Scanner scan = new Scanner(System.in);
		System.out.println("학번을 입력하세요 : ");
		s.hakbun = scan.next();
		
		System.out.println("이름을 입력하세요 : ");
		s.name = scan.next();
		
		System.out.println("국어점수를 입력하세요 : ");
		s.kor = scan.nextInt();
		
		System.out.println("영어점수를 입력하세요 : ");
		s.eng = scan.nextInt();
		
		System.out.println("수학점수를 입력하세요 : ");
		s.mat = scan.nextInt();
		
		return s;
	}
	
	
}
