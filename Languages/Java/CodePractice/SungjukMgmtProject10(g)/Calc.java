class Calc {
	public Calc() {
	}

	public void calc(Student s) {
		int tot = s.getKor() + s.getEng() + s.getMat();
		double avg = tot / 3.;
		char grade = (avg >= 90) ? 'A' : 
								(avg >= 80) ? 'B' :
									(avg >= 70) ? 'C' :
										(avg >= 60) ? 'D' : 'F';
		s.setTot(tot); //계산한 것들을 입력
		s.setAvg(avg);
		s.setGrade(grade);
	}
} 
