
public class Output {
	
	public void output(Student s) {
		System.out.println("---------your's info----------");
		System.out.println("hakbun	name	kor	eng	mat	tot	avg	grade");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c", 
				s.getHakbun(), s.getName(), s.getKor(), s.getEng(), s.getMat(), s.getTot(), s.getAvg(), s.getGrade());		
		
	}
}
