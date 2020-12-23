import java.util.Scanner;

public class Input {
	
	
	Student input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("학번 : ");
		String hakbun = scan.next();
		
		System.out.println("이름 : ");
		String name = scan.next();
		
		System.out.println("국어 : ");
		int kor = scan.nextInt();
		
		System.out.println("영어 : ");
		int eng = scan.nextInt();
		
		System.out.println("수학 : ");
		int mat = scan.nextInt();
		
		Student stu = new Student(hakbun, name, kor, eng, mat);
		return stu;
	}	
}
