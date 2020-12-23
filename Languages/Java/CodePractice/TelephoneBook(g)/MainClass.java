import java.util.Scanner;

public class MainClass {
	//바로 밑은 전역변수처럼 쓰기 위해서 미리 설정
	private Scanner scan;
	private Friend [] array;
	private int count;
	public MainClass() {  //생성자가 하는 일? 멤버변수 초기화(scanner, array, count 초기화 함)
		this.scan = new Scanner(System.in);
		this.array = new Friend[10];
		this.count = 0;
	}
	public static void main(String[] args) {
		MainClass mc = new MainClass(); //주소 만듬 => 위의 생성자 호출. 어짜치 객체 만들어야 되니깐, new로 만들면서 위에서 초기화 작업까지 동시에.
		outer:  // 라벨붙여놓고.
		do {
			int choice = mc.showMenu();
			switch(choice) {
				case 1 : mc.add(); break;
				case 2 : mc.search(); break;
				case 3 : mc.printList(); break;
				default : break outer;
			}
		}while(true); //무한루프
	}
	
	int showMenu() {
		System.out.println("****Menu****");
		System.out.println("1. 추가");
		System.out.println("2. 검색");
		System.out.println("3. 목록보기");
		System.out.print("메뉴를 선택하세요 : ");    
		return this.scan.nextInt();  //받은 번호를 리턴, 이 번호를 위에서 choice가 받음
	}
	void add() {
		System.out.print("이름 : ");    String name = this.scan.next();
		System.out.print("전화번호 : ");  String tel = this.scan.next();
		System.out.print("관계 : ");     String relation = this.scan.next();
		this.array[count] = new Friend(name, tel, relation);   count++; //0번째에 친구정보 넣고,그다음 +1 한 후에 ~ 다시.
	}
	void search() {
		System.out.print("Keyword : ");  String keyword = this.scan.next();
		boolean flag = false;
		for(int i = 0 ; i < this.count ; i++) { //모든 친구를 검색하는 것이 아니라, 현재 count까지만 찾는것.
			if(this.array[i].getName().equals(keyword) ||
				this.array[i].getTel().equals(keyword) ||
				this.array[i].getRelation().equals(keyword)) {
				System.out.println(this.array[i]);     
				flag = true;  // 찾았으면 true
			}
		}
		if(!flag)  System.out.println("Not Found");//for문을 벗어났는데도 여전히 false라면~ 
		
	}  //검색
	void printList() {
		for(int i = 0; i <this.count ; i++) {
			System.out.println(this.array[i]);
		}
	} //목록
	//위 4개들은 다 멤버, 그래서 주소가 필요.
}