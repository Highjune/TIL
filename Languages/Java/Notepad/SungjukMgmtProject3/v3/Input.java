import java.util.Scanner;

public class Input {
	
//	private Scanner scan;
//	
//	public Input() {
//		scan = new Scanner(System.in);
//	}

	public Student input() {
		Scanner scan = new Scanner(System.in); //이렇게 해도 되고 위처럼 해도 된다.
		
		System.out.println("What's your student code?");
		String hakbun = scan.next();
		
		System.out.println("What's your name?");
		String name = scan.next();
		
		System.out.println("What's your kor?");
		int kor = scan.nextInt();
		
		System.out.println("What's your eng?");
		int eng = scan.nextInt();
		
		System.out.println("What's your mat?");
		int mat = scan.nextInt();
		
		Student newstu = new Student(hakbun, name, kor, eng, mat);
		return newstu;
	}
	
}

