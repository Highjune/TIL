import java.util.Scanner;
public class IfDemo1{
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	System.out.println("�й�: ");
	int number = scan.nextInt();
	System.out.println("�й� = " + number);
	
	System.out.println("�̸�: ");
	String name = scan.next();
	System.out.println("�̸� =" + name);
	
	System.out.println("����: ");
	int kor = scan.nextInt();
	System.out.println("���� =" + kor);
	
	System.out.println("����: ");
	int eng = scan.nextInt();
	System.out.println("����" + eng);
	
	System.out.println("����: ");
	int math = scan.nextInt();
	System.out.println("����" + math);
	
	int total = (kor + eng + math);
	
	double avg = (kor + eng + math)/3.0 ;

	System.out.printf("%s(%d), %d   %d   %d  %d  %d", number, name, kor, eng, math); 
}
}



