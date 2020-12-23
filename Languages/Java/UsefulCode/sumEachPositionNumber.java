package test;

import java.util.Scanner;

public class sumEachPositionNumber {
	public static void main(String[] args) {
		//입력받은 숫자의 각 자리의 합
		
		int number = 0;
		int sum = 0;
		Scanner scan = new Scanner(System.in);

		System.out.println("각 자리를 더하고자 하는 아무 숫자를 입력하세요");
		number = scan.nextInt();
				
		while(number != 0) {
			sum += number%10; // 10으로 나눈 첫 나머지를 더함
			
			System.out.printf("sum = %d , number = %d%n", sum, number);
			
			number /= 10; // 10으로 나눈 몫		
			
		}
		
	}
}
