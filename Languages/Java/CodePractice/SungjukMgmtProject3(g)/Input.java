import java.util.Scanner;

public class Input {
	public Student input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("학번 : ");  String hakbun = scan.next();
		System.out.print("이름 : ");  String name = scan.next();
		System.out.print("국어 : ");  int kor = scan.nextInt();
		System.out.print("영어 : ");  int eng = scan.nextInt();
		System.out.print("수학 : ");  int mat = scan.nextInt();
		Student student = new Student(hakbun, name, kor, eng ,mat);
		return student;
	}
}


