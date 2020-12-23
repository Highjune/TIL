
public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		Student s1 = m.input();
		m.calc(s1);
		m.output(s1);
	}
	
	Student input() {
		Student kangjune = new Student();
		kangjune.hakbun = "2011-01";
		kangjune.name = "허강준";
		kangjune.kor = 100;
		kangjune.eng = 97;
		kangjune.mat = 98;	
		return kangjune;
	}
	
	void calc(Student s) {
		s.tot = s.kor + s.eng + s.mat;
		s.avg = s.tot / 3. ; 
		s.grade = (s.avg >= 90) ? 'A' : 
					(s.avg >= 80) ? 'B' : 
						(s.avg >= 70) ? 'C' : 
							(s.avg >= 60) ? 'D' : 'F';
	}	
	void output(Student s) {
		System.out.println("===============허강준의 성적==============");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c",
				s.hakbun, s.name, s.kor, s.eng, s.mat, s.tot, s.avg, s.grade);
	}	
	
}

