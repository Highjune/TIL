import java.util.Scanner;

public class Student {
	String hakbun, name;
	int kor, eng, mat, tot;
	double avg;
	char grade;
	void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("학번 : ");    hakbun = scan.next();
		System.out.print("이름 : ");    name = scan.next();
		System.out.print("국어 : ");    kor = scan.nextInt();
		System.out.print("영어 : ");    eng = scan.nextInt();
		System.out.print("수학 : ");    mat = scan.nextInt();
	}
	void calc() {
		tot = kor + eng + mat;
		avg = tot / 3.;
		grade = (avg >= 90) ? 'A' : 
						(avg >= 80) ? 'B' :
							(avg >= 70) ? 'C' :
								(avg >= 60) ? 'D' : 'F';
	}
	void output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n", 
				hakbun, name, kor, eng, mat, tot, avg, grade);
	}
}
