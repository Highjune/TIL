import java.util.Scanner;

//선지에서 고르기(0번은 종료)
public class ContinuePractice1 {
	public static void main(String[] args) {
		int menu = 0;
		int num = 0;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) { //무한루프
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			
			System.out.println("원하는 메뉴(1~3)를 선택하세요. (종료:0)>");
			String tmp = scan.nextLine(); //화면에서 입력받은 내용을 tmp에 저장
			menu = Integer.parseInt(tmp); //문자열을 숫자로 변환
			
			if(menu==0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (!(1 <= menu && menu <=3)) {
				System.out.println("메뉴를 잘못 선택하셨습니다. (종료는 0)");
				continue;
//			} else { //이렇게 해도 됨.
//				System.out.println("메뉴를 잘못 선택하셨습니다. (종료는 0)");
//				continue;
			}
			System.out.println("선택하신 메뉴는 " + menu + "번입니다.");
		}		
	}
}
