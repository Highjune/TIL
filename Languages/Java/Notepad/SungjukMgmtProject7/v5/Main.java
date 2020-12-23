import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		Vector<Student> vector = new Vector<Student>(1, 1);
		
		Input input = new Input(vector);
		input.Input();
		
		Calc calc = new Calc(vector);
		calc.calc();
		
		Sort sort = new Sort(vector);
		sort.sort();
		
		Output output = new Output(vector);
		output.output();	
		
	}
}
