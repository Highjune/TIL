package practice;

import java.util.Scanner;

public class LeapYearCalculation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("윤년인지 검색하고자 하는 년도를 입력하세요");
		int year = -1;
		System.out.println("year : ");
		
		year = scan.nextInt();
		
		if(year % 400 ==0 | ((year % 4 ==0) && (year % 100 != 0))) {
			System.out.println("윤년입니다");
		} else {
			System.out.println("윤년이 아닙니다.");
		}
	}
}
