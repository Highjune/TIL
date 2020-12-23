import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	
	public Output(Vector<Student> vector) {
		this.vector = vector;
	}
	
	public void output() {
		this.printLabel();
		for(Student s : this.vector) {
			System.out.println(s);
		}
	}
	private void printLabel() {
		System.out.println("         <<Grade Management Project5>>			");
		System.out.println("계급		학번		이름	국어	영어	수학	총점	평균	등급		");
		System.out.println("------------------------------------------------");
	}
}
