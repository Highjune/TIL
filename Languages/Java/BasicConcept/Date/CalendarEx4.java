package practice;

import java.util.Calendar;

// 특정 date날에 날짜를 추가 또는 제거
// add(), roll()
// roll()은 다른 필드에 영향을 끼치지 않는다.

public class CalendarEx4 {
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.set(2015, 7, 31); // 2015년 8월 31일
		
		System.out.println(toString(date));
		System.out.println("= 1일 후 =");
		date.add(Calendar.DATE, 1); // Calendar.DATE 필드에 1증가시킴
		System.out.println(toString(date));

		System.out.println(toString(date));
		System.out.println("= 6달 전=");
		date.add(Calendar.MONTH, -6); // Calendar.DATE 필드에 1증가시킴
		System.out.println(toString(date));
		
		System.out.println(toString(date));
		System.out.println("= 31일 후(roll) =");
		date.roll(Calendar.DATE, 31); // Calendar.DATE 필드에 1증가시킴
		System.out.println(toString(date));

		System.out.println(toString(date));
		System.out.println("= 31일 후(add) =");
		date.add(Calendar.DATE, 31); // Calendar.DATE 필드에 1증가시킴
		System.out.println(toString(date));
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일";  
	}
}
