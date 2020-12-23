import java.util.ArrayList;
import java.util.Scanner;

public class Insert {
	private ArrayList<Person> list;
	private Scanner scan;
	
	public Insert(ArrayList<Person> list, Scanner scan) { //생성자. 새로 만드느니 만들어놓은 scanner로 ~ 
		this.list = list; //나의 list에 주소복사
		this.scan = scan; //나의 scanner에게 주소복사
	}
	public void insert() {
		System.out.print("회원 번호 : ");
		int number = this.scan.nextInt();
		this.scan.nextLine();   //enter key 날리기. 버퍼에 남아있는 엔터키를 날리는 역할. 
		System.out.print("이름 : ");
		String name = this.scan.nextLine();
		System.out.print("전화번호 : ");
		String tel = this.scan.next();
		this.scan.nextLine();   //enter key 날리기(엔터남아있을 수 있으니)
		System.out.print("주소 : ");
		String address = this.scan.nextLine();
		Person person = new Person(number, name, tel, address);
		this.list.add(person);
	}
}
 