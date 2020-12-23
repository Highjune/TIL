
public class Main {
	public static void main(String[] args) {
		Student[] array = new Student[5];
		
		Input input = new Input(array);
		input.input();
		
		Calc calc = new Calc();
		calc.calc(array);
		
		Sort sort = new Sort();
		sort.sort(array);
		
		Output output = new Output();
		output.output(array);		
		
	}
}
