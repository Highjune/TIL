import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	private ArrayList<Member> list;
	private Scanner scan;
	
	public MainClass() {
		this.list = new ArrayList<Member>();  //Member [] array = new Member[10];
		this.scan = new Scanner(System.in);
	}
	public static void main(String[] args) {
		MainClass mc = new MainClass();
		
		while(true) {
			int choice = mc.showMenu();
			if(choice >= 1 && choice <= 4 ) mc.process(choice);
			else break;
		}
		System.out.println("Program is over...");
	}
	void process(int choice) {
		
		switch(choice) {
			case 1: input();  break;
			case 2: output();  break;
			case 3: search();  break;
			case 4: delete();  break;
		}
	}
	
	void delete() {
		System.out.print("삭제할 멤버 이름 : ");
		String name = this.scan.next();
		boolean flag = false;
		for(int i = 0 ; i < this.list.size(); i++) {
			Member member = this.list.get(i);
			if(member.getName().equals(name)) {
				flag = true;
				this.list.remove(i);
				System.out.println("Delete Success.");
			}
		}
		if(!flag)  System.out.println("Not Found");
	}
	
	void search() {
		System.out.print("검색할 이름 : ");
		String name = this.scan.next();
		boolean flag = false;
		for(int i = 0 ; i < this.list.size(); i++) {
			Member member = this.list.get(i);
			if(member.getName().equals(name)) {
				flag = true;
				System.out.println(member.toString());
			}
		}
		if(!flag)  System.out.println("Not Found");
	}
	void input() {
		Input input = new Input(this.list);    input.input();
	}
	void output() {
		Sort sort = new Sort(this.list);     sort.sort();
		Output output = new Output(this.list);  output.output();
	}
	int showMenu() {
		System.out.println("***********Menu**********");
		System.out.println("1. 입력     2. 출력         3. 검색(이름으로)        4. 삭제         5. 종료");
		System.out.print("선택 >> : ");  
		return this.scan.nextInt();
	}
}
