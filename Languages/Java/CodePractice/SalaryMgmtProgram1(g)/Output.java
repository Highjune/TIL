import java.util.Vector;

public class Output {
	private Vector<Salary> vector;

	public Output(Vector<Salary> vector) {
		this.vector = vector;
	}
	
	public void output() {
		//printLabel();
		for(Salary sal : this.vector) {
			System.out.println(sal);  //sal.toString()
		}
	}
	private void printLabel() {}
}
