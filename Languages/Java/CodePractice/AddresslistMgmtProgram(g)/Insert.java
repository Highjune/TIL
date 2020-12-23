import java.util.ArrayList;
import java.util.Scanner;

public class Insert {
	private ArrayList<Person> list;
	private Scanner scan;
	
	public Insert(ArrayList<Person> list, Scanner scan) { //������. ���� ������� �������� scanner�� ~ 
		this.list = list; //���� list�� �ּҺ���
		this.scan = scan; //���� scanner���� �ּҺ���
	}
	public void insert() {
		System.out.print("ȸ�� ��ȣ : ");
		int number = this.scan.nextInt();
		this.scan.nextLine();   //enter key ������. ���ۿ� �����ִ� ����Ű�� ������ ����. 
		System.out.print("�̸� : ");
		String name = this.scan.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String tel = this.scan.next();
		this.scan.nextLine();   //enter key ������(���ͳ������� �� ������)
		System.out.print("�ּ� : ");
		String address = this.scan.nextLine();
		Person person = new Person(number, name, tel, address);
		this.list.add(person);
	}
}
 