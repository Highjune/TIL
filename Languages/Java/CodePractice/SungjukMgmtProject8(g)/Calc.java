import java.util.Vector;

class Calc {
	private Vector<Student> vector;  //member  variable
	
	public Calc(Vector<Student> vector) {
		this.vector = vector;
	}

	public void calc() {
		for(Student s : this.vector) {
			int tot = s.getKor() + s.getEng() + s.getMat() + s.getEdp();
			double avg = tot / 4.;
			char grade = (avg >= 90) ? 'A' : 
									(avg >= 80) ? 'B' :
										(avg >= 70) ? 'C' :
											(avg >= 60) ? 'D' : 'F';
			s.setTot(tot);    
			s.setAvg(avg);
			s.setGrade(grade);
		}
	}
}
