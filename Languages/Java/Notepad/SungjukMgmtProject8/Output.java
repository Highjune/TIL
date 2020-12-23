import java.util.Vector;

public class Output {
	private Vector<Student> vector;

	public Output(Vector<Student> vector) {
		this.vector = vector;
	}
	
	public void output() { 
		printlabel();
		for(Student s : this.vector) {
			System.out.println(s.toString());
			//
			
		}
	}
	private void printlabel() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("------------------------------Sungjukmgmt------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("hakbun	name	kor	eng	mat	edp	tot	avg	grade");
		System.out.println("----------------------------------------------------------------------------");
		

	
	}
	
}
