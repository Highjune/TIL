package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

//자바의 정석 p546
//SimpledateFormat의 parse(String source)의 유용함 : String -> Date인스턴스로 변환
//날짜 데이터를 문자열로 입력받을 때, 입력받은 문자열을 날짜로 인식하기 위해서는 원래 substring메서드로 년, 월, 일을 뽑아내야 하는데 귀찮음. 
public class DateFormatEx3 {
	public static void main(String[] args) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df1.parse("1989년 2월 13일");
			System.out.println(df2.format(d));
		} catch(Exception e) {}
	}
}
