import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		
		String path = "C:/temp/sungjuklist.ser";
		
		Init init = new Init(path);
		Vector<Student> vector = init.init(); 
		
		Input input = new Input(vector);
		input.input();
		
		Calc calc = new Calc(vector);
		calc.calc();
		
		Sort sort = new Sort(vector);
		sort.sort();
		
		Output output = new Output(vector, path);
		output.output();
		
		
	}
}
