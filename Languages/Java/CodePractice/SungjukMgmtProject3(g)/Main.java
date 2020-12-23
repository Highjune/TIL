
public class Main {
	public static void main(String[] args) {
		Input input = new Input();
		Student student = input.input();
		
		Calc calc = new Calc();
		calc.calc(student);
		
		Output output = new Output();
		output.output(student);
	}
}


