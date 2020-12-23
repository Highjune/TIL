import java.util.Vector;

public class Calc {
	private Vector<Student>vector;
	
	public Calc(Vector<Student> vector) {
		this.vector = vector;		
	}
	
	public void calc() {
		for(Student s : this.vector) {
			int tot = s.getKor() + s.getEng() + s.getMat();
			double avg = tot / 3.;
			char grade = (avg >= 90) ? 'A' :
							(avg >= 90) ? 'B' :
								(avg >= 90) ? 'C' :
									(avg >= 90) ? 'D' : 'F';
			s.setTot(tot);
			s.setAvg(avg);
			s.setGrade(grade);							
		}
	}
}
