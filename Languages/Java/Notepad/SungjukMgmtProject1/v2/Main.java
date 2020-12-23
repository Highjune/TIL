
public class Main {
	public static void main(String[] args) {
		
		Main m = new Main();
		Student kkk = m.input();
		m.calc(kkk);
		m.output(kkk);		
	}
	
	Student input() {
		Student june = new Student();
		june.hakbun = "2011-01";
		june.name = "허강준";
		june.kor = 90;
		june.eng = 96;
		june.mat = 66;
		return june;		
	}
	
	void calc(Student s) {
		s.tot = s.kor + s.eng + s.mat;
		s.avg = s.tot / 3.;
		s.grade = (s.avg >= 90) ? 'A' :
						(s.avg >= 80) ? 'B' :
							(s.avg >= 70) ? 'C' :
								(s.avg >= 60) ? 'D' : 'F';	
	}
	
	void output(Student s) {
		System.out.println("허강준의 성적은~~~~~~~~~");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c", 
										s.hakbun, s.name, s.kor, s.eng, s.mat, s.tot, s.avg, s.grade);
	}
	
	
}
