import java.util.Scanner;

public class Student {
	private String hakbun, name;
	private int kor, eng, mat, tot;
	private double avg;
	private char grade;	
	
	public Student() {
		
	}
	
	public Student(String hakbun,String name,int kor,int eng,int mat) {
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	void input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("yout student code? : ");
		hakbun = scan.next();
		
		System.out.println("What's your name? : ");
		name = scan.next();
		
		System.out.println("your kor's score? : ");
		kor = scan.nextInt();
		
		System.out.println("your eng's score? : ");
		eng = scan.nextInt();
		
		System.out.println("your mat's score? : ");
		mat = scan.nextInt();
		
		Student stu = new Student(hakbun, name, kor, eng, mat);
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
		System.out.println("----------------June's info------------------");
		System.out.println("hakbun	name	kor	eng	mat	tot	avg	grade");
		System.out.println("--------------------------------------------");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n", hakbun, name, kor, eng, mat, tot, avg, grade);
	}
	
}
