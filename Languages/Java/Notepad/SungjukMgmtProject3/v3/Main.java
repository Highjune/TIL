
public class Main {
	public static void main(String[] args) {
		
		Input input = new Input();
		Student ss = input.input();
		
		Calc calc = new Calc();
		calc.calc(ss);
		
		Output output = new Output();
		output.output(ss);
	}
}