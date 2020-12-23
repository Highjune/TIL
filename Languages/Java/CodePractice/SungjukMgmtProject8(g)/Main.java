import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		Vector<Student> vector = new Vector<Student>(1, 1); //메모리를 효율적으로는 쓰자는 차원에서 1, 1이지 속도느는 느린편.
		
		Input input = new Input(vector);
		input.input();
		
		Calc calc = new Calc(vector);  
		calc.calc();
		
		Sort sort = new Sort(vector);  
		sort.sort();
		
		Output output = new Output(vector);   
		output.output();
	}
}





