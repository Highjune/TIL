import java.util.Scanner;

public class Input {
		
	public Student input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("학번을 입력하세요 : ");
		String hakbun = scan.next();
		
		System.out.println("이름을 입력하세요 : ");
		String name = scan.next();
		
		System.out.println("국어점수를 입력하세요 : ");
		int kor = scan.nextInt();
		
		System.out.println("영어점수를 입력하세요 : ");
		int eng = scan.nextInt();
		
		System.out.println("수학점수를 입력하세요 : ");
		int mat = scan.nextInt();

		Student s = new Student(hakbun, name, kor, eng, mat);
		return s;		
	}	
}
