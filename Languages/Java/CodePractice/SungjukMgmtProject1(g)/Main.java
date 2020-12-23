
public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		Student chulsu = m.input();   
		m.calc(chulsu);
		m.output(chulsu);
	}
	
	Student input() {
		Student chulsu = new Student();
		chulsu.hakbun = "2019-01";
		chulsu.name = "허강준";
		chulsu.kor= 90;  chulsu.eng = 100;
		chulsu.mat = 79;
		return chulsu;
	}
	
	void calc(Student s){
		s.tot = s.kor + s.eng + s.mat;
		s.avg = s.tot / 3.;
		s.grade = (s.avg >= 90) ? 'A' :
							(s.avg >= 80) ? 'B' :
								(s.avg >= 70) ? 'C' :
									(s.avg >= 60) ? 'D' : 'F';
	}
	
	void output(Student s) {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n", 
				s.hakbun, s.name, s.kor, s.eng, s.mat, s.tot, s.avg, s.grade);
	}
}





