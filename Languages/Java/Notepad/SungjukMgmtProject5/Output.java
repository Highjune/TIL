import java.util.Vector;

public class Output {
	public Vector<Student> vector;
	
	public Output(Vector<Student> vector) {
		this.vector = vector;
	}
	
	public void output() {
		printlabel();
		for(Student s : this.vector) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n",
					s.getHakbun(), s.getName(), s.getKor(), s.getEng(), s.getMat(), s.getTot(), s.getAvg(), s.getGrade());
		}
	}	
	
	public void printlabel() {
		System.out.println("-------------------------------------------------------");
		System.out.println("학번	이름	국어	영어	수학	총점	평균	등급");
		System.out.println("-------------------------------------------------------");
	}
	
}
