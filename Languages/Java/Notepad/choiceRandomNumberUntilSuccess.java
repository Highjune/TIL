package test;

import java.util.Scanner;

public class choiceRandomNumberUntilSuccess {
	public static void main(String[] args) {
		
		//1~100 숫자중에맞힐때까지.
		int input = 0;
		int answer = 0;
		Scanner scan = new Scanner(System.in);
		
		answer = (int)(Math.random()*6  + 1);    		
		System.out.println(answer);
		
		do {
			System.out.println("1~100 사이의 임의의 숫자를 맞춰보세요");
			input = scan.nextInt();
			
			if(input > answer) {
				System.out.println("정답보다 더 큰 숫자를 입력했습니다. 더 작은 숫자를 입력해보세요");
			}else if(input < answer){
				System.out.println("정답보다 더 작은 숫자를 입력했습니다. 더 작은 숫자를 입력해보세요");
			}
		}while(input != answer);
			System.out.println("오 정답입니다. 축하합니다.");
		
	}
}
