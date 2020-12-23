
public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Student stu = main.input();
		main.calc(stu);
		main.output(stu);
	}
	
	public Student input() {
		Student s = new Student();
		s.hakbun = "2011-01";
		s.name = "june";
		s.kor = 90;
		s.eng = 80;
		s.mat = 90;	
		return s;
	}
	
	public void calc(Student s) {
		s.tot = s.kor + s.eng + s.mat;
		s.avg = s.tot / 3.;
		s.grade = (s.avg >= 90) ? 'A' :
					(s.avg >= 80) ? 'B' :
						(s.avg >= 70) ? 'C' :
							(s.avg >= 60) ? 'D' : 'F';		
	}
	
	public void output(Student s) {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("june의 성적은~~");
		System.out.println("학번	이름	국어	영어	수학	총점	평균	등급");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c", s.hakbun, s.name, s.kor, s.eng, s.mat, s.tot, s.avg, s.grade);
		
	}
}
