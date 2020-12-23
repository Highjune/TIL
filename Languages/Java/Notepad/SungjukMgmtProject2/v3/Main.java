import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Student june1 = new Student();
//		june1.input();
//		june1.calc();
//		june1.output();
//		
//		Student june2 = new Student();
//		june2.input();
//		june2.calc();
//		june2.output();
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("몇 명 받을래?");
		int k = scan.nextInt();
		Student[] array = new Student[k];
		
		for(int i=0 ; i<array.length ; i++) {
			array[i] = new Student();
			array[i].input();
			array[i].calc();
			array[i].output();		
		}
	}
}
