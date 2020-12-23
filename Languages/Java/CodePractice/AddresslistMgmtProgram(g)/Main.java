import java.util.ArrayList;
import java.util.Scanner;
//메인은 짧을수록 좋다(모든 것은 다 call by reference임)

public class Main {
	private Scanner scan;
	private ArrayList<Person> list;
	private static final String PATH;   //static 상수 선언
	
	static {//static initialize block.메모리에 올라올 때 딱 1번만 세팅된 후 부를 방법 없다. (왜냐하면 이름이 없기에)
		PATH = "C:/temp/addresslist.ser";   //static 상수 초기화, 이 path는 바뀌어야 되지 않아야 하기 때문에 final
	}
	
	public Main() {
		this.scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		String path = "";
		Main main = new Main(); //여기서 scan초기화
		
		Init init = new Init(PATH); 
		main.list = init.init();    //ArrayList<Person>을 새로 만들었거나(null), 기존의 객체를 가져왔거나
		
		System.out.println("Program Loading Success.");
		
		int choice = 0;
		while(true) {
			choice = main.showMenu();
			main.process(choice);
		}
	}
	 
	private void process(int choice) {
		switch(choice) {
			case 0 : //0이면 종료하면서 저장함(파일과 싱크맞춤)
				Save save = new Save(this.list, PATH);
				save.save();
				System.out.println("Bye!!. Data Save Success.");
				System.exit(0);  break; 
			case 1 : 
				List mylist = new List(this.list); //singleton패턴이나 다른 방식을 써야 하는데, 이렇게 쓰면 사실 안 좋다. 왜냐하면 case 1마다 게속 new list가 생성되기 때문에 안 메모리소모가 크다.
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
			case 4 : break; //delete인데 나중에 만들어보기
			
			case 5 : // 게시판 수정임.
				Person person1 = this.search(); //일단 찾아야지 수정하니까 먼저 찾는다. case3의 person과 지역변수가 같아서 다른 것으로~.
				System.out.println("원 전화번호 : " + person1.getTel()); //바꾸기 전의 전화번호 먼저 보여주고
				System.out.print("수정할 전화번호 : ");
				String tel = this.scan.nextLine();
				person1.setTel(tel);
				int idx = this.list.indexOf(person1); //찾은 사람의 index
				this.list.set(idx, person1); //idx에 person1을 덮어씀.
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
