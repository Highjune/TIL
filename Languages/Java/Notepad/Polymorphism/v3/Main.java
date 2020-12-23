import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		while(true) {
			m.showMenu();
			int choice = m.input();
			if(choice==5) {
				System.out.println("Bye~ 다시 하고 싶으면 f11 눌러 주세요");
				break;
			}
			else if (choice < 1 || choice > 5) {
				System.out.println("1부터 6사이의 번호가 아닙니다. 다시 입력해주세요");
				continue;
			}
			else {
				m.output(choice);
			}
			
			
		}
	}
	
	
	public void showMenu() {
		System.out.println("듣고 싶은 번호를 클릭하세요");
		System.out.println("1. Korean");
		System.out.println("2. American");
		System.out.println("3. Cat");
		System.out.println("4. Dog");
		System.out.println("5. 나가기");
	}
	
	
	
	
	public int input() {
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		return choice;		
	}
	
	
	public void output(int choice) {
		Mammal m = null;
		
		switch(choice) {
		//중요한 포인트는 부모의 주소로 가리키고 있는 자식의 종류에 따라 호출되는(Override된) 메서드의 종류가 다르다는 것.
			case 1 : m = new Korean();
			m.shouting();
			break;
		
			case 2 : m = new American();
			m.shouting();
			break;
			
			case 3 : m = new Cat();
			m.shouting();
			break;
			
			case 4 : m = new Dog();
			m.shouting();
			break;
		}
		
	}
}
