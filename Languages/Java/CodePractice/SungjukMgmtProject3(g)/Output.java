
public class Output {
	public void output(Student s) {
		this.printLabel();
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n",
				s.getHakbun(), s.getName(), s.getKor(), s.getEng()
				, s.getMat(), s.getTot(), s.getAvg(), s.getGrade());
	}
	private void printLabel() {
		System.out.println("------------------------성적관리프로젝트3-------------------------");
		System.out.println("학번	이름	국어	영어	수학	총점	평균	등급");
		System.out.println("-------------------------------------------------------------");
	}
}
