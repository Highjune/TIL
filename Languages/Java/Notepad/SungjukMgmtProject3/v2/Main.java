
public class Main {
	public static void main(String[] args) {
		Input input = new Input();
		Student kkk = input.input();
		
		Calc calc = new Calc();
		calc.calc(kkk);
		
		Output output = new Output();
		output.output(kkk);
		
		
	}
}
