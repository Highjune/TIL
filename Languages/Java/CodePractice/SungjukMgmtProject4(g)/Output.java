
public class Output {
	private Student [] array;
	
	public Output(Student[] array) {
		this.array = array;
	}
	
	public void output() {
		this.printLabel();
		for(Student s : this.array) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n",
				s.getHakbun(), s.getName(), s.getKor(), s.getEng()
				, s.getMat(), s.getTot(), s.getAvg(), s.getGrade());
		}
	}
	private void printLabel() {
		System.out.println("           <<grade management project 4>> 			");
		System.out.println("학번	이름	국어	영어	수학	총점	평균	등급");
		System.out.println("----------------------------------------------------");
	}
}
