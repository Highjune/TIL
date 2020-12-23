
public class Calc {
	
	public Student calc(Student s) {
		s.tot = s.kor + s.eng + s.mat;
		s.avg = s.tot / 3.;
		s.grade = (s.avg >= 90) ? 'A' :
					(s.avg >= 80) ? 'B' :
						(s.avg >= 70) ? 'C' :
							(s.avg >= 60) ? 'D' : 'F';		
		return s;
	}
}
