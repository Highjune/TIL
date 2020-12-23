
public class Main {
	public static void main(String[] args) {
		Student[] array = new Student[3];
		
		Input input = new Input(array);
		input.input();
		
		Calc calc = new Calc(array);  
		calc.calc();
		
		Sort sort = new Sort(array);  
		sort.bubbleSort();
		
		Output output = new Output(array);   
		output.output();
	}
}






