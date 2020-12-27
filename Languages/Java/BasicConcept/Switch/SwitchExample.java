package practice;

public class SwitchExample {
	public static void main(String[] args) {
		int num = (int)(Math.random()*6) + 1;
		
		switch(num) {
		case 1 :
			System.out.println("주사위 숫자는 1입니다.");
			break;
		case 2 :
			System.out.println("주사위 숫자는 2입니다.");
			break;
		case 3 :
			System.out.println("주사위 숫자는 3입니다.");
			break;
		case 4 :
			System.out.println("주사위 숫자는 4입니다.");
			break;
		case 5 :
			System.out.println("주사위 숫자는 5입니다.");
			break;
		default :
			System.out.println("주사위 숫자는 6입니다.");
			break;
		}
	}
}
