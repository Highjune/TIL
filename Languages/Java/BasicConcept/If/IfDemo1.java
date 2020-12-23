import java.util.Scanner;
public class IfDemo1{
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	System.out.println("학번: ");
	int number = scan.nextInt();
	System.out.println("학번 = " + number);
	
	System.out.println("이름: ");
	String name = scan.next();
	System.out.println("이름 =" + name);
	
	System.out.println("국어: ");
	int kor = scan.nextInt();
	System.out.println("국어 =" + kor);
	
	System.out.println("영어: ");
	int eng = scan.nextInt();
	System.out.println("영어" + eng);
	
	System.out.println("수학: ");
	int math = scan.nextInt();
	System.out.println("수학" + math);
	
	int total = (kor + eng + math);
	
	double avg = (kor + eng + math)/3.0 ;

	System.out.printf("%s(%d), %d   %d   %d  %d  %d", number, name, kor, eng, math); 
}
}



