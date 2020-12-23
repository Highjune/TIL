//잔돈 구하는 법
import java.util.Scanner;

public class MethodDemo1 {
	public static void main(String[] args) {
		MethodDemo1 md = new MethodDemo1();
		Scanner scan = new Scanner(System.in); 
		String y_n = null; //지역변수는 반드시 초기화, string은 참조변수니 null로.
		do {
			int money = md.input(scan);
			md.output(money);
			System.out.print("Again(y/n) ? : ");
//			Scanner scan = new Scanner(System.in); 여기서 쓰면 loop돌 때 게속 써야 되니 위에 씀.
			y_n = scan.next();
		}while(y_n.equals("Y") || y_n.equals("y")); //equals는 멤버변수이기 때문에 주소로 접근. y_n에는 Y, N이 저장되어 있다. equals를 API에서 찾아보면 java.lang - String - equals 에서 보면 멤버변수임(static이 안 붙어서). 멤버변수니까 주소(y_n_로 접근
}
	
	int input(Scanner scan){  // static변수는 공유라서 웬만해선 안 쓰는 것이 좋다
		System.out.print("Money : ");
		return scan.nextInt();
}
	
	void output(int money){ //출력할거니깐 리턴X, 그래서 void.
		int [] array = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		for(int i = 0; i< array.length; i++) {
			System.out.println(array[i] + "원 : " + money/array[i] );
			money = money % array[i];
		}
	}
}








