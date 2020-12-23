package practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Local_Date_LocalDate_ZonedDateTime {
	public static void main(String[] args) {
		//java.time 패키지에 속한 클래스의 객체를 생성하는 가장 기본적인 방법은 now() of(), 둘 다 static메서드
		LocalDate date = LocalDate.now();
		System.out.println(date); //2020-11-06
		
		LocalTime time = LocalTime.now();
		System.out.println(time); //17:51:58.007
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime); //2020-11-06T17:51:58.007
		
		ZonedDateTime datetimeInKr = ZonedDateTime.now();
		System.out.println(datetimeInKr); //2020-11-06T17:51:58.008+09:00[Asia/Seoul]
		
		//of()는 단순히 해당 필드의 값을 순서대로 지정해 주기만 하면 된다.
		LocalDate date1 = LocalDate.of(1989, 02, 13);
		System.out.println(date1); //1989-02-13
		
		LocalTime time1 = LocalTime.of(23,  59, 59);
		System.out.println(time1); //23:59:59
		
		// LocalDate와 LocalTime을 합쳐 놓은 것이 LocalDateTime이고, LocalDateTime에 시간대(time zone)을 추가한 것이 ZonedDateTime이다.
		
		
		
		

		
	}
}
