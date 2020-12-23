public class Main {
	public static void main(String[] args) {
		Employee [] array = new Employee[5];
		Input input = new Input(array);
		int count = input.input();
		
		Calc calc = new Calc(array, count);
		calc.calc();
		
		Sort sort = new Sort(array, count);
		sort.selectionSort();
		
		Output out = new Output(array, count);
		out.display();
	}
}
