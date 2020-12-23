
public class Main {
	public static void main(String[] args) {
		Student[] array = new Student[4];
		
		Input input = new Input(array);
		input.input();
		
		Calc calc = new Calc(array);
		calc.calc(array);
		
		Sort sort = new Sort(array);
		sort.sort(array);
		
		Output output = new Output(array);
		output.output(array);		
	}
}
 
