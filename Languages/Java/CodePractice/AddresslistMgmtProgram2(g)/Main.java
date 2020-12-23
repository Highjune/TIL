import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private Scanner scan;
	private ArrayList<Person> list;
	
	public Main() {
		this.scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		Init init = new Init();
		main.list = init.init();    //ArrayList<Person>�� ���� ������ų�, ������ ��ü�� �����԰ų�
		
		System.out.println("Program Loading Success.");
		
		int choice = 0;
		while(true) {
			choice = main.showMenu();
			main.process(choice);
		}
	}
	private void process(int choice) {
		switch(choice) {
			case 0 : 
				Save save = new Save(this.list);
				save.save();
				System.out.println("Bye!!. Data Save Success.");
				System.exit(0);  break; 
			case 1 : 
				List mylist = new List(this.list);
				mylist.printList();
				break;
			case 2 : 
				Insert insert = new Insert(this.list, this.scan);
				insert.insert();
			    break;
			case 3:
				Person person = this.search();
				if(person == null) System.out.println("Not Found");
				else System.out.println(person);
				break;
			case 4 : break;
			case 5 :
				Person person1 = this.search();
				System.out.println("�� ��ȭ��ȣ : " + person1.getTel());
				System.out.print("������ ��ȭ��ȣ : ");
				String tel = this.scan.nextLine();
				person1.setTel(tel);
				int idx = this.list.indexOf(person1);
				this.list.set(idx, person1);
				break;
		}
	}
	private Person search() {
		this.scan.nextLine();   //enter key ������
		Search search = new Search(this.list, this.scan);
		return search.search();
	}
	private int showMenu() {
		System.out.println("[ ȸ�� �ּҷ� ]");
		System.out.println("1. ��ü ȸ�� ����");
		System.out.println("2. ȸ�� ���� ���");
		System.out.println("3. ȸ�� ���� �˻�");
		System.out.println("4. ȸ�� ����");
		System.out.println("5. ȸ�� ���� ����");
		System.out.println("0. ���α׷� ����");
		System.out.print("�޴� ��ȣ ���� >> ");
		return this.scan.nextInt();
	}
}
