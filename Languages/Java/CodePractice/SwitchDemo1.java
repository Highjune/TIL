import java.util.Scanner;
// 주사위 던져서 컴터랑 붙기
//랜덤으로 던지는 컴퓨터의 주사위와 내가 입력하는 주사위의 수를 비교
public class SwitchDemo1 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int comp_rand = (int)(Math.random() * 6 + 1);
	System.out.print("Insert a value(1~6) : ");
	int user_rand = scan.nextInt();
	if(user_rand <1 || user_rand > 6) {
		System.out.println("잘못 입력하셨습니다.");
		System.exit(-1);                					///이까지 1~6까지 나올 수 있도록 필터링 했음.
	}
	System.out.printf("컴퓨터의 값 = %d, 유저의 값 = %d\n", comp_rand, user_rand);
	if(comp_rand > user_rand) {
		System.out.println("Computer Win.");
	}else if(comp_rand < user_rand) {
		System.out.println("You Win.");
	}else {
		System.out.println("Again...");
	}

	
	
}
}






