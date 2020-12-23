import java.util.Scanner;
import java.util.Vector;

public class Input {
	private Vector<Salary> vector;
	private Scanner scan;
	
	public Input(Vector<Salary> vector) {
		this.vector = vector;
		this.scan = new Scanner(System.in);
	}
	
	public void input() { 
		System.out.print("�����ȣ : ");    String sabun = this.scan.next();
		System.out.print("����̸� : ");    String name = this.scan.next();
		System.out.print("�⺻�� : ");      int defSalary = this.scan.nextInt();
		System.out.print("�߰��ð� : ");    int nightHour = this.scan.nextInt();
		System.out.print("������ : ");       int family = this.scan.nextInt();
		Salary sal = new Salary(sabun, name, defSalary, nightHour, family);
		this.vector.add(sal);
	}
}
