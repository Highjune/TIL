
public class Main {
	public static void main(String[] args) {
		Input input = new Input();
		Student s = input.input();
		
		Calc calc = new Calc();
		calc.calc(s);
		
		Output output = new Output();
		output.output(s);		
	}
}
