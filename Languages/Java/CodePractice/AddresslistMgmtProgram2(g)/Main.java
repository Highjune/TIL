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
		main.list = init.init();    //ArrayList<Person>을 새로 만들었거나, 기존의 객체를 가져왔거나
		
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
				System.out.println("원 전화번호 : " + person1.getTel());
				System.out.print("수정할 전화번호 : ");
				String tel = this.scan.nextLine();
				person1.setTel(tel);
				int idx = this.list.indexOf(person1);
				this.list.set(idx, person1);
				break;
		}
	}
	private Person search() {
		this.scan.nextLine();   //enter key 날리기
		Search search = new Search(this.list, this.scan);
		return search.search();
	}
	private int showMenu() {
		System.out.println("[ 회원 주소록 ]");
		System.out.println("1. 전체 회원 보기");
		System.out.println("2. 회원 정보 등록");
		System.out.println("3. 회원 정보 검색");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 회원 정보 수정");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 번호 선택 >> ");
		return this.scan.nextInt();
	}
}
