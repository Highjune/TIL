package practice;

import java.util.Scanner;

//랜덤으로 던지는 컴퓨터의 주사위와 내가 입력하는 주사위의 수를 비교
public class Dice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int comp_dice = (int)(Math.random()*6) + 1;
		int user_dice = 0;
		
		while(true) {
			System.out.println("원하시는 숫자를 입력하세요(1~6)");
			
			user_dice = scan.nextInt();
			if(user_dice < 1 || user_dice > 6) {
				System.out.println("유효한 숫자(1~6)을 선택한 것이 아닙니다. 다시 입력하세요");
				continue;
			} else {
				break;
			}
		}
		
		if(user_dice == comp_dice) {
			System.out.println("비겼습니다.");
		} else  if(user_dice > comp_dice) {
			System.out.println("당신이 이겼습니다. You Win");
		} else {
			System.out.println("당신이 졌습니다. You Lose");
		}
				
	}
}
