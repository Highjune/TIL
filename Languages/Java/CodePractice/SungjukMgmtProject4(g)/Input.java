import java.util.Scanner;

public class Input {
	private Scanner scan;
	private Student [] array;
	
	public Input(Student [] array) {   //Constructor (초기화)
		this.scan = new Scanner(System.in);
		this.array = array;
	}
	
	public void input() {
		for(int i = 0 ; i < this.array.length ;i++) {
			System.out.print("학번 : ");  String hakbun = scan.next();
			System.out.print("이름 : ");  String name = scan.next();
			System.out.print("국어 : ");  int kor = scan.nextInt();
			System.out.print("영어 : ");  int eng = scan.nextInt();
			System.out.print("수학 : ");  int mat = scan.nextInt();
			array[i] = new Student(hakbun, name, kor, eng ,mat);
		}
	}
}
