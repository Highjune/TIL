import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("몇명 받을래?");
		int k = scan.nextInt();	
		Student[] array = new Student[k];
		
		Input input = new Input(array);
		input.input();
		
		Calc calc = new Calc(array);
		calc.calc();
		
		Sort sort = new Sort(array);
		sort.bubblesort();
		
		Output output = new Output(array);
		output.output();	
		
	}
}
