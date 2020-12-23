import java.util.Scanner;

public class Student {
	String hakbun, name;
	int kor, eng, mat, tot;
	double avg;
	char grade;
	
	void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("학번 : ");
		hakbun = scan.next();
		
		System.out.println("이름 : ");
		name = scan.next();
		
		System.out.println("국어 : ");
		kor = scan.nextInt();
				
		System.out.println("영어 : ");
		eng = scan.nextInt();
		
		System.out.println("수학 : ");
		mat = scan.nextInt();
	}
	
	void calc() {
		tot = kor + eng + mat;
		avg = tot / 3.;
		grade = (avg>=90) ? 'A' : 
						(avg>80) ? 'B' :
							(avg>=70) ? 'C' :
								(avg>=60) ? 'D' : 'F';
	}
	
	
	void output() {
		System.out.println("니가 입력한 " + name + "의 모든 것은~~");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n", 
				hakbun, name, kor, eng, mat, tot, avg, grade);
	}
	
}
