
public class Main {
	public static void main(String[] args) {
		Input input = new Input();
		Product p = input.input();
		
		Calc calc = new Calc(p);      calc.calc();
		Output output = new Output(p);   output.output();
	}
}
