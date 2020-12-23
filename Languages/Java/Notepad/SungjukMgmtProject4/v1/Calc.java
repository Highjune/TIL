
public class Calc {
	
	void calc(Student[] array) {
		for(int i=0; i<array.length ; i++) {
			int tot = array[i].getKor() + array[i].getEng() + array[i].getMat();
			double avg = tot / 3.;
			char grade = (avg >= 90) ? 'A' : 
									(avg >= 80) ? 'B' :
										(avg >= 70) ? 'C' :
											(avg >= 60) ? 'D' : 'F';
			array[i].setTot(tot);
			array[i].setAvg(avg);
			array[i].setGrade(grade);		
	}
}
}



