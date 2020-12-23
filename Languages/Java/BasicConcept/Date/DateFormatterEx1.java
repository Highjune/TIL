package practice;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//자바의 정석 574
public class DateFormatterEx1 {
	public static void main(String[] args) {
		ZonedDateTime zdateTime = ZonedDateTime.now();
		
		String[] patternArr = {
				"yyyy-MM-dd HH:mm:ss",  //2020-11-06 18:25:35
				"''yy년 MMM dd일 E요일", //'20년 11월 06일 금요일
				"yyyy-MM-dd HH:mm:ss.SSS Z VV", //2020-11-06 18:25:35.911 +0900 Asia/Seoul 
				"yyyy-MM-dd hh:mm:ss a", //2020-11-06 06:25:35 오후
				"오늘은 올 해의 D번째 날입니다", //오늘은 올 해의 311번째 날입니다
				"오늘은 이 달의 d번째 날입니다.", //오늘은 이 달의 6번째 날입니다.
				"오늘은 올 해의 w번째 주입니다.", //오늘은 올 해의 45번째 주입니다.
				"오늘은 이 달의 W번째 주입니다.", //오늘은 이 달의 1번째 주입니다.
				"오늘은 이 달의 W번째 E요일입니다."//오늘은 이 달의 1번째 금요일입니다.
		};
		
		//DateTimeFormatter의 ofPattern()으로 원하는 출력형식을 직접 작성할 수도 있다. 
		for(String p : patternArr) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(formatter));			
		}
		
		
	}
}
