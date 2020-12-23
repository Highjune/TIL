
public class Main {
	public static void main(String[] args) {
		Student stu = new Student();
			
		Input input = new Input();
		input.input(stu);
		
		Calc calc = new Calc();
		calc.calc(stu);
		
		Output output = new Output();
		output.output(stu);	
		
	}
}
