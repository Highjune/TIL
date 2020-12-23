//다형성 연습 (엄청 좋은 예시)
//부모(mammal) 와 자식들(dog, cat, american, korean)을 만들어서 ~
//어느 사람을 가리킬 때는 runtime 떄

import java.util.Scanner;
import javax.swing.JOptionPane;

public class PolymorphismDemo1 {
	public static void main(String[] args) {     //메인문 작성
		PolymorphismDemo1 pd = new PolymorphismDemo1();
		int choice = 0 ; //지역변수 초기화, 밖에 선언한 이유는 while에도 적용되어야 되기 때문에
		while(true) {
			pd.showMenu();
			choice = pd.input();
			if(choice == 5) break;
			else if(choice > 5 || choice <1) {
				JOptionPane.showMessageDialog(null, "잘못된 입력값 입니다.");
				continue; //
			}else {
				pd.output(choice);  //saysomething 처리
			}
		};
		
		
	}
	void showMenu(){	
		System.out.println("***Menu***");
		System.out.println("1. Dog");
		System.out.println("2. Cat");
		System.out.println("3. Korean");
		System.out.println("4. American");
		System.out.println("5. Exit");
	}
	
	int input(){ //선택하게 번호를 할 것이니까 반환값 존재
		Scanner scan = new Scanner(System.in);
		System.out.println("어느 종족 ? :"); 
		int choice = scan.nextInt(); //받고
		return choice; //받은 번호 넘겨주면 됨
		
	} 
	void output(int choice){ //선택한 번호를 넘기면 보여주고 끝
		Mammal m = null; //부모형 선언, 항상 지역변수는 초기화
		switch(choice) {
		case 1 : m = new Dog(); break;
		case 2 : m = new Cat(); break;
		case 3 : m = new Korean(); break;
		case 4 : m = new American(); break;
		}
		m.saySomething(); // 각각 자식들(dog, cat, korean, american) 에 맞는 언어를 할 것임.
		
		
	}
}
