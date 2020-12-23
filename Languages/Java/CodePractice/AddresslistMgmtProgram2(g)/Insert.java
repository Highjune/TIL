import java.util.ArrayList;
import java.util.Scanner;
 
public class Insert {
	private  ArrayList<Person> list;
	private Scanner scan;
	
	public Insert(ArrayList<Person> list, Scanner scan) {
		this.list = list;
		this.scan = scan;
	}
	public void insert() {
		System.out.print("회원 번호 : ");
		int number = this.scan.nextInt();
		this.scan.nextLine();   //enter key 날리기
		System.out.print("이름 : ");
		String name = this.scan.nextLine();
		System.out.print("전화번호 : ");
		String tel = this.scan.next();
		this.scan.nextLine();   //enter key 날리기
		System.out.print("주소 : ");
		String address = this.scan.nextLine();
		Person person = new Person(number, name, tel, address);
		this.list.add(person);
	}
}
