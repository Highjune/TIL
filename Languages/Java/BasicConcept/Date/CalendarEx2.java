package practice;

import java.util.Calendar;

//자바의 정석 p531
public class CalendarEx2 {
	public static void main(String[] args) {
		// 요일은 1부터 시작하기 대문에, DAY_OF_WEEK[0]은 비워둠
		
		final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		// 원하는 날자나 시간으로 설정하려면 set메서드 사용하면 됨
		// month의 경우 0부터 시작하기 때문에 8월인 경우, 7로 지정해야 된다. 그래서 (2015, 8-1, 15)로 지정하기도 함
		date1.set(2015, 7, 15); // 2015년 8월 15일로 설정 
		System.out.println("data1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고, ");
		System.out.println("오늘(date2)은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다. ");
		
		// 두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야 한다.
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("그 날(date1)부터 지금(date2)까지 "  + difference + "초가 지났습니다.");
		System.out.println("일(day)로 계산하면 " + difference/(24*60*60) + "일입니다." ); // 1일 = 24 * 60 * 60		
		}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";  
	}
}
