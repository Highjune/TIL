package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 자바의 정석 546
//Carlendar -> Date -> SimpleDateformat으로 원하는 형식 뽑아냄
public class DateFormatEx2 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2005,  9, 3); 
		
		//Calendar를 Date로 변환.
		//Date인스턴스만 format메서드에 사용될 수 있으므로
		Date day = cal.getTime();
		
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yy-MM-dd E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		System.out.println(sdf1.format(day));
		System.out.println(sdf2.format(day));
		System.out.println(sdf3.format(day));
		System.out.println(sdf4.format(day));		
		
	}
}
