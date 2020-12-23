package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatterEx {
	public static void main(String[] args) {
		// 형식화(Formatting)와 관련된 클래스들은 java.time.format패키지에 들어있는데, 이 중에서 DateTimeFormatter가 핵심
	
		//날짜와 시간의 형식화에는 아래와 같이 format()이 사용되는데, 이 메서드는 DateTimeFormatter뿐만 아니라 LocalDate나 Localtime같은 클래스에도 있다.
		LocalDate date = LocalDate.of(2016, 1, 2);
		String yyyymmdd = DateTimeFormatter.ISO_LOCAL_DATE.format(date); //"2016-01-02"
		String yyyymmdd1 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); //"2016-01-02"
		
		
		
	}
}
