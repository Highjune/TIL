import java.util.Scanner;
import java.util.Vector;

public class MainClass {
	private Vector<Salary> vector;
	private Scanner scan;
	
	public MainClass() {
		this.vector = new Vector<Salary>(1,1);
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
			case 2: search();  break;
			//case 3: update();  break;
			case 4: output();  break;
		}
	}
	void search() {
		System.out.print("검색할 사원번호 : ");
		String sabun = this.scan.next();
		boolean flag = false;
		for(int i = 0 ; i < this.vector.size(); i++) {
			Salary sal = this.vector.get(i);
			if(sal.getSabun().equals(sabun)) {
				flag = true;
				System.out.println(sal.toString());
			}
		}
		if(!flag)  System.out.println("Not Found");
	}
	void input() {
		Input input = new Input(this.vector);    input.input();
		Calc calc = new Calc(this.vector);    calc.calc();
	}
	void output() {
		Sort sort = new Sort(this.vector);     sort.sort();
		Output output = new Output(this.vector);  output.output();
	}
	int showMenu() {
		System.out.println("***********Menu**********");
		System.out.println("1. 입력");
		System.out.println("2. 검색");
		System.out.println("3. 수정");
		System.out.println("4. 출력");
		System.out.println("5. 종료");
		System.out.print("선택 >> : ");  
		return this.scan.nextInt();
	}
}
