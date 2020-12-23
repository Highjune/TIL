package practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//자바의 정석 p575
//문자열을 날짜와 시간으로 변환(파싱)
//static메서드 parse() 이용하기(날짜와 시간 표현하는데 사용되는 클래스에는 이 메서드가 거의 다 포함되어 있다)
public class DateFormatterEx2 {
	public static void main(String[] args) {
		LocalDate newYear = LocalDate.parse("1989-02-13", DateTimeFormatter.ISO_LOCAL_DATE); //1989-02-13
		
		LocalDate date = LocalDate.parse("2011-01-01"); //2011-01-01
		LocalTime time = LocalTime.parse("23:59:59"); //23:59:59
		LocalDateTime dateTime = LocalDateTime.parse("2001-01-01T23:59:59"); //2001-01-01T23:59:59
		
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime endOfYear = LocalDateTime.parse("2015-12-31 23:59:59", pattern); //2015-12-31T23:59:59
		
		System.out.println(newYear);
		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);
		System.out.println(endOfYear);
	}
}
