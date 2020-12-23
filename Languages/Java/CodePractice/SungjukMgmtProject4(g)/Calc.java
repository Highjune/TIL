
public class Calc {
	private Student [] array;  //member  variable
	
	public Calc(Student[] array) { //Constructor
		this.array = array;
	}

	public void calc() {
		for(Student s : this.array) {
			int tot = s.getKor() + s.getEng() + s.getMat();
			double avg = tot / 3.;
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
